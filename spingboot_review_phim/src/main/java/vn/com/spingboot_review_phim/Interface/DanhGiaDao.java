package vn.com.spingboot_review_phim.Interface;

import vn.com.spingboot_review_phim.Model.DanhGia;
import vn.com.spingboot_review_phim.Model.DanhGiaViewModel;

import java.util.List;

public interface DanhGiaDao extends IHanhDong<DanhGia> {
    List<DanhGiaViewModel> layDanhSachView();
//    List<DanhGiaEntity> layDanhSachDanhGia(Integer id);

    List<DanhGiaViewModel> layDiemTheoPhimId(Integer id);
    DanhGia getNguoiDungAndPhim(Integer nguoiDung, Integer phim);
}
