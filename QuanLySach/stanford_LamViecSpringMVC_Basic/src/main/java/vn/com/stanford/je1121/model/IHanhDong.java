package vn.com.stanford.je1121.model;

import java.util.List;

public interface IHanhDong<T> {
    public List<T> layDanhSach();
    T layChiTietTheoMa(Object id);
    boolean themMoi(T obj);
    boolean capNhat(T obj);
    boolean xoa(Object id);

}
