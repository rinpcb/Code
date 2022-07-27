package vn.com.spingboot_review_phim.Model;

public class PhimDienVienViewModel {
    private int id;
    private String vaiDien;
    private int phim;
    private String tenPhim;
    private int dienVien;
    private String tenDienVien;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVaiDien() {
        return vaiDien;
    }

    public void setVaiDien(String vaiDien) {
        this.vaiDien = vaiDien;
    }

    public int getPhim() {
        return phim;
    }

    public void setPhim(int phim) {
        this.phim = phim;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public int getDienVien() {
        return dienVien;
    }

    public void setDienVien(int dienVien) {
        this.dienVien = dienVien;
    }

    public String getTenDienVien() {
        return tenDienVien;
    }

    public void setTenDienVien(String tenDienVien) {
        this.tenDienVien = tenDienVien;
    }
}
