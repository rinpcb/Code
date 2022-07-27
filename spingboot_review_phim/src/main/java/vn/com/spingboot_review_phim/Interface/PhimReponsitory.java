package vn.com.spingboot_review_phim.Interface;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import vn.com.spingboot_review_phim.Model.Phim;

import java.util.List;

public interface PhimReponsitory extends CrudRepository<Phim, Integer> {
    @Query("SELECT u FROM Phim u WHERE u.tenPhim LIKE %:tuKhoa%")
    List<Phim> timKiemPhim(@Param("tuKhoa") String tuKhoa);
}
