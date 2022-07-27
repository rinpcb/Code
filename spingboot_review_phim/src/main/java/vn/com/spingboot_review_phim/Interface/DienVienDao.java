package vn.com.spingboot_review_phim.Interface;

import vn.com.spingboot_review_phim.Model.DienVien;

import java.util.List;

public interface DienVienDao extends IHanhDong<DienVien> {
    public List<DienVien> timKiemDienVien(String tuKhoa);
}
