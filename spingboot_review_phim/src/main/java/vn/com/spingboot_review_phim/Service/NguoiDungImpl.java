package vn.com.spingboot_review_phim.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import vn.com.spingboot_review_phim.Interface.NguoiDungDao;
import vn.com.spingboot_review_phim.Interface.NguoiDungRepository;
import vn.com.spingboot_review_phim.Model.NguoiDung;
import vn.com.spingboot_review_phim.Model.NguoiDungViewModel;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("nguoiDungDao")
public class NguoiDungImpl implements NguoiDungDao {
    @Autowired
    NguoiDungRepository nguoiDungRepository;
    @Override
    public List<NguoiDung> layDanhSach() {
        return (List<NguoiDung>)nguoiDungRepository.findAll();
    }

    @Override
    public NguoiDung layChiTietTheoMa(Object id) {
        NguoiDung objNguoiDung = null;
        try {
            objNguoiDung = nguoiDungRepository.findById(Integer.parseInt("" + id)).get();
        } catch (Exception ex) {
            System.out.println("Không lấy được người dùng. Chi tiết: " + ex.getMessage());
            objNguoiDung = null;
        }

        return objNguoiDung;
    }

    @Override
    public boolean themMoi(NguoiDung obj) {
        NguoiDung objNguoiDung = nguoiDungRepository.save(obj);

        if (objNguoiDung != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean capNhat(NguoiDung obj) {
        NguoiDung objNguoiDung = nguoiDungRepository.findById(obj.getId()).get();

        if (objNguoiDung != null) {

            objNguoiDung.setTenDangNhap(obj.getTenDangNhap());
            objNguoiDung.setMatKhau(obj.getMatKhau());
            objNguoiDung.setHoTen(obj.getHoTen());
            objNguoiDung.setDienThoai(obj.getDienThoai());
            objNguoiDung.setEmail(obj.getEmail());
            objNguoiDung.setDiaChi(obj.getDiaChi());
            objNguoiDung.setVaiTro(obj.getVaiTro());

            nguoiDungRepository.save(objNguoiDung);

            return true;

        }
        return false;
    }

    @Override
    public boolean xoa(Object id) {
        NguoiDung objNguoiDung = layChiTietTheoMa(id);

        if (objNguoiDung != null) {
            nguoiDungRepository.delete(objNguoiDung);

            return true;
        }
        return false;
    }


    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    public NguoiDungImpl(NamedParameterJdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<NguoiDungViewModel> timKiemNguoiDung(String tuKhoa, Integer vaiTro) {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT * FROM NGUOI_DUNG \n");
        builder.append("WHERE (HO_TEN LIKE '%' || :tuKhoa || '%' \n");
        builder.append("OR TEN_DANG_NHAP LIKE '%' || :tuKhoa || '%' \n ");
        builder.append("OR DIEN_THOAI LIKE '%' || :tuKhoa || '%' \n");
        builder.append("OR DIA_CHI LIKE '%' || :tuKhoa || '%') \n");
        if (vaiTro != null) {
            builder.append("AND VAI_TRO_ID = :vaiTro \n");
        }

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("tuKhoa", tuKhoa);
        params.addValue("vaiTro", vaiTro);

        return jdbcTemplate.query(builder.toString(), params, new BeanPropertyRowMapper<>(NguoiDungViewModel.class));
    }

    @Override
    public NguoiDung getUserByName(String tenDangNhap) {
        List<NguoiDung> lstUser = nguoiDungRepository.findByTenDangNhap(tenDangNhap);
        if (lstUser != null && lstUser.size() > 0) {
            return lstUser.get(0);
        }
        return null;
    }


    @Autowired
    EntityManager entityManager;
    @Override
    public List<NguoiDungViewModel> getAll() {
        List<NguoiDungViewModel> lstNguoiDung = new ArrayList<>();

        Query query = entityManager
                .createQuery("SELECT  u.id, u.tenDangNhap as tenDangNhap,u.hoTen,u.dienThoai,u.email,u.diaChi,u.ngayTao,vt.tenVaiTro from NguoiDung u JOIN VaiTro vt ON u.vaiTro=vt.id");

        List<Object[]> lstObject = query.getResultList();

        DateFormat f = new SimpleDateFormat("mm/dd/yyyy");
        for (Object[] r : lstObject) {
            NguoiDungViewModel objUser = new NguoiDungViewModel();

            objUser.setId(Integer.parseInt("" + r[0]));
            objUser.setTenDangNhap("" + r[1]);
            objUser.setHoTen("" + r[2]);
            objUser.setDienThoai("" + r[3]);
            objUser.setEmail("" + r[4]);
            objUser.setDiaChi("" + r[5]);
            objUser.setNgayTao((Date) r[6]);
            objUser.setTenVaiTro("" + r[7]);
            lstNguoiDung.add(objUser);
        }
        return lstNguoiDung;
    }
}
