package vn.com.spingboot_review_phim.Interface;

import org.springframework.data.repository.CrudRepository;
import vn.com.spingboot_review_phim.Model.PhimYeuThich;

import java.util.List;

public interface PhimYeuThichRepository extends CrudRepository<PhimYeuThich, Integer> {
    List<PhimYeuThich> getAllByNguoiDungAndPhim(int nguoiDung, int phim);
}
