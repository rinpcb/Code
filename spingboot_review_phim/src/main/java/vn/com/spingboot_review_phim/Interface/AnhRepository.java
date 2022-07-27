package vn.com.spingboot_review_phim.Interface;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import vn.com.spingboot_review_phim.Model.Anh;

import java.util.List;

public interface AnhRepository extends CrudRepository<Anh, Integer> {
    @Query("select u from Anh u where  u.phim = :phim")
    List<Anh> layAnhTheoPhimId(@Param("phim") int phim);

    Anh findByPhimAndTen(Integer phimId, String tenAnh);

}
