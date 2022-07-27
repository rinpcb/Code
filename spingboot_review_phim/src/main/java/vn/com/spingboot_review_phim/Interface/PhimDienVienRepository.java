package vn.com.spingboot_review_phim.Interface;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import vn.com.spingboot_review_phim.Model.PhimDienVien;

import java.util.List;

public interface PhimDienVienRepository extends CrudRepository<PhimDienVien, Integer> {
    @Query("select u from PhimDienVien u where  u.phimId = :phim")
    List<PhimDienVien> layPhimDienVienTheoPhimId(@Param("phim") int phim);
}
