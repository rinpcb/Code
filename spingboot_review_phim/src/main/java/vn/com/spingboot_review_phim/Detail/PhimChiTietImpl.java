package vn.com.spingboot_review_phim.Detail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import vn.com.spingboot_review_phim.Model.PhimViewModel;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("phimChiTietDao")
public class PhimChiTietImpl implements PhimChiTietDao {
    @Autowired
    EntityManager entityManager;
    @Override
    public List<PhimChiTietView> layDanhSach() {
       return null;
    }

    @Override
    public PhimChiTietView layChiTietTheoMa(Object id) {
        return null;
    }

    @Override
    public boolean themMoi(PhimChiTietView obj) {
        return false;
    }

    @Override
    public boolean capNhat(PhimChiTietView obj) {
        return false;
    }

    @Override
    public boolean xoa(Object id) {
        return false;
    }

    @Override
    public List<PhimChiTietView> getAll(Integer phimId) {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT p.id, p.Ten_Phim, p.Thoi_Luong, p.Ngay_Chieu , dv.ho_Ten as tenDienVien,dd.ho_Ten as tenDaoDien,tl.Ten_the_Loai, p.Noi_Dung, p.anh, p.TraiLer, p.Nam_San_Xuat, p.Mo_Ta \n");
        builder.append( "FROM Phim p JOIN Dien_Vien dv On p.Dien_Vien_Id = dv.id \n");
        builder.append("JOIN Dao_Dien dd On p.Dao_Dien_ID = dd.id \n");
        builder.append("JOIN The_Loai tl On p.The_Loai_ID = tl.id where p.Id = :phimId \n");

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("phimId", phimId);

        return jdbcTemplate.query(builder.toString(),params, new BeanPropertyRowMapper<>(PhimChiTietView.class));
    }

    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    public PhimChiTietImpl(NamedParameterJdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<PhimViewModel> getPhimByTheLoai(Integer theLoaiId, Integer dienVienId, Integer daoDienId) {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT p.ID,p.Anh, p.Ten_Phim,p.Mo_ta,p.Trang_Thai, p.Nam_San_Xuat,\n");
        builder.append("p.Thoi_Luong, p.Ngay_Chieu, dv.Ho_Ten as Ten_Dien_Vien,\n");
        builder.append("dd.ho_Ten as Ten_Dao_Dien, tl.ten_The_Loai,  \n");
        builder.append("(SELECT AVG(SUM(Diem)) FROM DANH_GIA where Phim_Id = p.id GROUP BY DIEM) as Diem From Phim p  \n");
        builder.append("LEFT JOIN The_Loai tl ON p.The_Loai_ID = tl.id \n");
        builder.append("LEFT JOIN Dao_Dien dd ON p.Dao_Dien_ID = dd.id \n");
        builder.append("LEFT JOIN Dien_Vien dv ON p.Dien_Vien_ID = dv.id  \n");
        if (theLoaiId != null) {
            builder.append("Where p.The_Loai_ID = :theLoaiId \n");
        }
        if (dienVienId != null) {
            builder.append("Where p.DIEN_VIEN_ID = :dienVienId \n");
        }
        if (daoDienId != null) {
            builder.append("Where p.DAO_DIEN_ID = :daoDienId \n");
        }

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("theLoaiId", theLoaiId);
        params.addValue("dienVienId", dienVienId);
        params.addValue("daoDienId", daoDienId);
        return jdbcTemplate.query(builder.toString(), params, new BeanPropertyRowMapper<>(PhimViewModel.class));
    }
}
