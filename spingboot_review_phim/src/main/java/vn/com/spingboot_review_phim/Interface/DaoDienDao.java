package vn.com.spingboot_review_phim.Interface;

import vn.com.spingboot_review_phim.Model.DaoDien;

import java.util.List;

public interface DaoDienDao extends IHanhDong<DaoDien> {
    List<DaoDien> timKiemDaoDien(String tuKhoa);
//    List<DaoDienEntity> layDanhSachDaoDien(Integer id);
}
