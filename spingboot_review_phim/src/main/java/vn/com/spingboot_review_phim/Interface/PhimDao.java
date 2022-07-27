package vn.com.spingboot_review_phim.Interface;


import org.springframework.data.domain.Page;
import vn.com.spingboot_review_phim.Model.Phim;
import vn.com.spingboot_review_phim.Model.PhimViewModel;

import java.util.Date;
import java.util.List;

public interface PhimDao extends IHanhDong<Phim>
{
    List<PhimViewModel>  layDanhSachPhimView();
    List<PhimViewModel> timKiemPhim(String tuKhoa, Integer theLoai, Integer daoDien,
                                    Integer dienVien, Integer quocGia, Date startDate, Date endDate);
    List<PhimViewModel> layDanhSachPhim();

    Page<Phim> phanTrang(int pageNumber);
}
