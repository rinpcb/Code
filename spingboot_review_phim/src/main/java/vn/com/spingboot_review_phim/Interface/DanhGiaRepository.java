package vn.com.spingboot_review_phim.Interface;

import org.springframework.data.repository.CrudRepository;
import vn.com.spingboot_review_phim.Model.DanhGia;

import java.util.List;

public interface DanhGiaRepository extends CrudRepository<DanhGia, Integer> {
    DanhGia getAllByNguoiDgAndAndPhim(int nguoiDung, int phim);
}
