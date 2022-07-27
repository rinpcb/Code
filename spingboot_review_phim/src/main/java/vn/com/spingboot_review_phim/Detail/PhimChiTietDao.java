package vn.com.spingboot_review_phim.Detail;

import vn.com.spingboot_review_phim.Interface.IHanhDong;
import vn.com.spingboot_review_phim.Model.PhimViewModel;

import java.util.List;

public interface PhimChiTietDao extends IHanhDong<PhimChiTietView> {
        List<PhimChiTietView> getAll(Integer phimId);
        List<PhimViewModel> getPhimByTheLoai(Integer theLoaiId, Integer dienVienId, Integer daoDienId);
}
