package vn.com.spingboot_review_phim.Interface;

import java.util.List;

public interface IHanhDong<T> {
    public List<T> layDanhSach();

    T layChiTietTheoMa(Object id);

    boolean themMoi(T obj);

    boolean capNhat(T obj);

    boolean xoa(Object id);
}
