package vn.com.spingboot_review_phim.Model;

import java.util.Date;

public class PhimView {
    public String tuKhoa;
    public Integer theLoai;
    public Integer daoDien;
    public Integer dienVien;
    public Integer quocGia;
    public Date startDate;
    public Date endDate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTuKhoa() {
        return tuKhoa;
    }

    public void setTuKhoa(String tuKhoa) {
        this.tuKhoa = tuKhoa;
    }

    public Integer getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(Integer theLoai) {
        this.theLoai = theLoai;
    }

    public Integer getDaoDien() {
        return daoDien;
    }

    public void setDaoDien(Integer daoDien) {
        this.daoDien = daoDien;
    }

    public Integer getDienVien() {
        return dienVien;
    }

    public void setDienVien(Integer dienVien) {
        this.dienVien = dienVien;
    }

    public Integer getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(Integer quocGia) {
        this.quocGia = quocGia;
    }
}
