package vn.com.spingboot_review_phim.Interface;


import vn.com.spingboot_review_phim.Model.PhimDienVien;
import vn.com.spingboot_review_phim.Model.PhimDienVienViewModel;

import java.util.List;

public interface PhimDienVienDao extends IHanhDong<PhimDienVien> {
    List<PhimDienVienViewModel> getAll();
    List<PhimDienVien> layPhimDienVienTheoPhimId(Integer phimId);
}
