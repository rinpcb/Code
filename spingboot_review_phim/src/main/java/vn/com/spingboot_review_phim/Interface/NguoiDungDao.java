package vn.com.spingboot_review_phim.Interface;

import vn.com.spingboot_review_phim.Model.NguoiDung;
import vn.com.spingboot_review_phim.Model.NguoiDungViewModel;

import java.util.List;

public interface NguoiDungDao extends IHanhDong<NguoiDung>
{
    List<NguoiDungViewModel> timKiemNguoiDung(String tuKhoa, Integer vaiTro);
    public NguoiDung getUserByName(String tenDangNhap);
    List<NguoiDungViewModel> getAll();
}
