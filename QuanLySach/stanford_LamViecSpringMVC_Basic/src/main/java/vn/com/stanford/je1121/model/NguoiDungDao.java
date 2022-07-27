package vn.com.stanford.je1121.model;

public interface NguoiDungDao extends  IHanhDong<NguoiDung> {
    public NguoiDung layNguoiDungTheoTaiKhoan(String tenDN);
}
