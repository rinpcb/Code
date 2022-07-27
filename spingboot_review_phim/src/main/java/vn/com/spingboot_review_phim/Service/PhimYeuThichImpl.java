package vn.com.spingboot_review_phim.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import vn.com.spingboot_review_phim.Interface.PhimYeuThichDao;
import vn.com.spingboot_review_phim.Interface.PhimYeuThichRepository;
import vn.com.spingboot_review_phim.Model.PhimViewModel;
import vn.com.spingboot_review_phim.Model.PhimYeuThich;

import java.util.List;

@Service("phimYeuThichDao")
public class PhimYeuThichImpl implements PhimYeuThichDao {

    @Autowired
    PhimYeuThichRepository phimYeuThichRepository;
    @Override
    public List<PhimYeuThich> layDanhSach() {
        return (List<PhimYeuThich>)phimYeuThichRepository.findAll();
    }

    @Override
    public PhimYeuThich layChiTietTheoMa(Object id) {
        PhimYeuThich objPhimYT = null;
        try {
            objPhimYT = phimYeuThichRepository.findById(Integer.parseInt("" + id)).get();
        } catch (Exception ex) {
            System.out.println("Lỗi không lấy phim yêu thích  có id: " + ex.getMessage());
        }
        return objPhimYT;
    }

    @Override
    public boolean themMoi(PhimYeuThich obj) {
        PhimYeuThich objPhimYT = phimYeuThichRepository.save(obj);
        if (objPhimYT != null)
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean capNhat(PhimYeuThich obj) {
        return false;
    }

    @Override
    public boolean xoa(Object id) {
        PhimYeuThich objPhimYT = layChiTietTheoMa(id);

        if (objPhimYT != null) {
            phimYeuThichRepository.delete(objPhimYT);
            return true;
        }
        return false;
    }

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public PhimYeuThichImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<PhimViewModel> getPhimYeuThichByNguoiDung(Integer nguoiDungId) {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT pv.ID as PhimYTID,p.id, p.Anh, p.Ten_Phim,p.Mo_ta,p.Trang_Thai, p.Nam_San_Xuat,\n");
        builder.append("p.Thoi_Luong, p.Ngay_Chieu, dv.Ho_Ten as Ten_Dien_Vien,\n");
        builder.append("dd.ho_Ten as Ten_Dao_Dien, tl.ten_The_Loai,  \n");
        builder.append("(SELECT AVG(SUM(Diem)) FROM DANH_GIA where Phim_Id = p.id GROUP BY DIEM) as Diem From phim_Yeu_Thich pv \n");
        builder.append("LEFT JOIN  Phim p on pv.Phim_Id = p.id  \n");
        builder.append("LEFT JOIN The_Loai tl ON p.The_Loai_ID = tl.id \n");
        builder.append("LEFT JOIN Dao_Dien dd ON p.Dao_Dien_ID = dd.id \n");
        builder.append("LEFT JOIN Dien_Vien dv ON p.Dien_Vien_ID = dv.id  \n");
        if (nguoiDungId != null) {
            builder.append("Where pv.nguoi_dung_id = :nguoiDungId \n");
        }


        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("nguoiDungId", nguoiDungId);
        return jdbcTemplate.query(builder.toString(), params, new BeanPropertyRowMapper<>(PhimViewModel.class));
    }

    @Override
    public  List<PhimYeuThich> layIdTheoPhimId(Integer nguoiDungId, Integer phimId) {
        return phimYeuThichRepository.getAllByNguoiDungAndPhim(nguoiDungId, phimId);
    }
}
