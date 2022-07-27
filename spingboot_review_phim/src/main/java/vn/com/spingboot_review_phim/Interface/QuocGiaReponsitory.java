package vn.com.spingboot_review_phim.Interface;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import vn.com.spingboot_review_phim.Model.QuocGia;

import java.util.List;

public interface QuocGiaReponsitory extends CrudRepository<QuocGia, Integer> {
    @Query("SELECT u FROM QuocGia u WHERE u.maQuocGia LIKE %:tuKhoa%"
            + " OR u.tenQuocGia LIKE %:tuKhoa%")
    List<QuocGia> timKiemQuocGia(@Param("tuKhoa") String tuKhoa);
}
