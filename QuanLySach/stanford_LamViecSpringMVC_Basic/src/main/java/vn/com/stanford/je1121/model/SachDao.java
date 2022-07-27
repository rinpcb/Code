package vn.com.stanford.je1121.model;

import java.util.List;

public interface SachDao extends IHanhDong<Sach>{
    public List<Sach> laySachTheoChuDe(String maChuDe);
    List<Sach> timKiemSach(String tuKhoa, String maChuDe);
}
