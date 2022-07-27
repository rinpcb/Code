package vn.com.spingboot_review_phim.Model;

import javax.persistence.Column;


public class DanhGiaViewModel {
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "NGUOI_DG_ID")
    private Integer nguoiDg;

    @Column(name = "DIEM")
    private Integer diem;

    @Column(name = "PHIM_ID")
    private Integer phim;

    @Column(name = "Ho_Ten", nullable = true)
    private String hoTen;

    @Column(name = "Ten_Phim", nullable = true)
    private String tenPhim;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNguoiDg() {
        return nguoiDg;
    }

    public void setNguoiDg(Integer nguoiDg) {
        this.nguoiDg = nguoiDg;
    }

    public Integer getDiem() {
        return diem;
    }

    public void setDiem(Integer diem) {
        this.diem = diem;
    }

    public Integer getPhim() {
        return phim;
    }

    public void setPhim(Integer phim) {
        this.phim = phim;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }
}
