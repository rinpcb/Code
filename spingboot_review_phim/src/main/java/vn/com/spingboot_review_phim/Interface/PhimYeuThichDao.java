package vn.com.spingboot_review_phim.Interface;

import vn.com.spingboot_review_phim.Model.PhimViewModel;
import vn.com.spingboot_review_phim.Model.PhimYeuThich;

import java.util.List;

public interface PhimYeuThichDao extends IHanhDong<PhimYeuThich> {
    List<PhimViewModel> getPhimYeuThichByNguoiDung(Integer nguoiDungId);
    List<PhimYeuThich> layIdTheoPhimId(Integer nguoiDungId, Integer phimId);
}
