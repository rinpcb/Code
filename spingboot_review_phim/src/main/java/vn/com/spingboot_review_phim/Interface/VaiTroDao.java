package vn.com.spingboot_review_phim.Interface;

import vn.com.spingboot_review_phim.Model.VaiTro;

import java.util.List;

public interface VaiTroDao extends IHanhDong<VaiTro> {
    public List<VaiTro> timKieVaiTro(String tuKhoa);
}
