package vn.com.spingboot_review_phim.Interface;

import vn.com.spingboot_review_phim.Model.QuocGia;

import java.util.List;

public interface QuocGiaDao extends IHanhDong<QuocGia> {
    List<QuocGia> timKiemQuocGia(String tuKhoa);
}
