package vn.com.spingboot_review_phim.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import vn.com.spingboot_review_phim.Interface.DanhGiaDao;
import vn.com.spingboot_review_phim.Interface.DanhGiaRepository;
import vn.com.spingboot_review_phim.Model.DanhGia;
import vn.com.spingboot_review_phim.Model.DanhGiaViewModel;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service("danhGiaDao")
public class DanhGiaImpl implements DanhGiaDao {
    @Autowired
    EntityManager entityManager;
    @Autowired
    DanhGiaRepository danhGiaRepository;

    @Override
    public List<DanhGiaViewModel> layDanhSachView() {
        List<DanhGiaViewModel> lstDanhGia = new ArrayList<>();

        Query query = entityManager
                .createQuery("SELECT dg.id,nd.hoTen, dg.diem,p.tenPhim FROM DanhGia dg "
                        +" INNER JOIN NguoiDung nd ON dg.nguoiDg = nd.id"
                        +" INNER JOIN Phim p ON dg.phim = p.id");

        List<Object[]> lstObject = query.getResultList();

        for (Object[] r : lstObject) {
            DanhGiaViewModel objDanhGia = new DanhGiaViewModel();

            objDanhGia.setId(Integer.parseInt("" + r[0]));
            objDanhGia.setHoTen("" + r[1]);
            objDanhGia.setDiem(Integer.parseInt("" + r[2]));
            objDanhGia.setTenPhim(""+ r[3]);

            lstDanhGia.add(objDanhGia);
        }
        return lstDanhGia;
    }

    @Override
    public List<DanhGia> layDanhSach() {
        return (List<DanhGia>)danhGiaRepository.findAll();
    }

    @Override
    public DanhGia layChiTietTheoMa(Object id) {
        DanhGia objDanhGia = null;
        try {
            objDanhGia = danhGiaRepository.findById(Integer.parseInt("" + id)).get();
        }
        catch(Exception ex)
        {
            System.out.println("Không lấy được người dùng. Chi tiết: " + ex.getMessage());
            objDanhGia = null;
        }

        return  objDanhGia;
    }

    @Override
    public boolean themMoi(DanhGia obj) {
        DanhGia objDanhGia = danhGiaRepository.save(obj);

        if(objDanhGia != null){

            return true;
        }
        return false;
    }

    @Override
    public boolean capNhat(DanhGia obj) {
        DanhGia objDanhGia = danhGiaRepository.findById(obj.getId()).get();

        if(objDanhGia != null){

            objDanhGia.setNguoiDg(obj.getNguoiDg());
            objDanhGia.setDiem(obj.getDiem());
            objDanhGia.setPhim(obj.getPhim());
            danhGiaRepository.save(objDanhGia);

            return true;
        }
        return false;
    }

    @Override
    public boolean xoa(Object id) {
        DanhGia objDanhGia = layChiTietTheoMa(id);
        if(objDanhGia != null){
            danhGiaRepository.delete(objDanhGia);
            return true;
        }
        return false;
    }

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public DanhGiaImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;}
    @Override
    public List<DanhGiaViewModel> layDiemTheoPhimId(Integer id) {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT  AVG(Sum(Diem)) as Diem FROM Danh_Gia dg  \n");
        builder.append("Where Phim_Id = :id GROUP BY Diem \n");

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return jdbcTemplate.query(builder.toString(),params, new BeanPropertyRowMapper<>(DanhGiaViewModel.class));
    }

    @Override
    public DanhGia getNguoiDungAndPhim(Integer nguoiDung, Integer phim) {
        return danhGiaRepository.getAllByNguoiDgAndAndPhim(nguoiDung, phim);
    }
}
