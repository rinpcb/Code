package vn.com.spingboot_review_phim.Interface;

import vn.com.spingboot_review_phim.Model.Anh;

import java.util.List;

public interface AnhDao extends IHanhDong<Anh> {
    public List<Anh> layDanhSachAnhTheoPhimId(Integer phimId);

    public List<Anh> timKiemAnh(String tuKhoa, Integer phimId);

    public List<Anh> layDanhSachView();

    Anh findByPhimAndTen(Integer phimId, String tenAnh);

    boolean xoaTheoPhimIDVaTen(Integer phimId, String tenAnh);
}
