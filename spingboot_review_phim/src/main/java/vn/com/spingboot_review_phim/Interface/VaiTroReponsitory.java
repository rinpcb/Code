package vn.com.spingboot_review_phim.Interface;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import vn.com.spingboot_review_phim.Model.VaiTro;

import java.util.List;

public interface VaiTroReponsitory extends CrudRepository<VaiTro, Integer> {
    @Query("SELECT u FROM VaiTro u WHERE u.tenVaiTro LIKE %:tuKhoa%")
    List<VaiTro> timKiemVaiTro(@Param("tuKhoa") String tuKhoa);
}
