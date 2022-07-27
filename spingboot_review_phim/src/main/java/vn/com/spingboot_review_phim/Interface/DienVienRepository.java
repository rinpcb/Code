package vn.com.spingboot_review_phim.Interface;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import vn.com.spingboot_review_phim.Model.DienVien;

import java.util.List;

public interface DienVienRepository extends CrudRepository<DienVien, Integer> {
    @Query("SELECT u FROM DienVien u WHERE u.hoTen LIKE %:tuKhoa%")
    List<DienVien> timKiemDienVien(@Param("tuKhoa") String tuKhoa);
}
