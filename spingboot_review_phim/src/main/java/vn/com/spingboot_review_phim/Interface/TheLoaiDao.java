package vn.com.spingboot_review_phim.Interface;

import vn.com.spingboot_review_phim.Model.TheLoai;

import java.util.List;

public interface TheLoaiDao extends IHanhDong<TheLoai> {
    List<TheLoai> timKiemTheLoaiPhim(String tuKhoa);
}
