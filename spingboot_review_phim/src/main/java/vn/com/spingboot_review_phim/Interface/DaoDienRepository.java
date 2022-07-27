package vn.com.spingboot_review_phim.Interface;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import vn.com.spingboot_review_phim.Model.DaoDien;

import java.util.List;

public interface DaoDienRepository extends CrudRepository<DaoDien, Integer> {
    @Query("SELECT u FROM DaoDien u WHERE u.hoTen LIKE %:tuKhoa%")
    List<DaoDien> timKiemDaoDien(@Param("tuKhoa") String tuKhoa);
//    List<DaoDienEntity> findByIdPhim(Integer id);
}
