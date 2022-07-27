package vn.com.spingboot_review_phim.Interface;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import vn.com.spingboot_review_phim.Model.TheLoai;

import java.util.List;

public interface TheLoaiReponsitory extends CrudRepository<TheLoai, Integer> {
    @Query("SELECT u FROM TheLoai u WHERE u.tenTheLoai LIKE %:tuKhoa%")
    List<TheLoai> timKiemTheLoaiPhim(@Param("tuKhoa") String tuKhoa);
}
