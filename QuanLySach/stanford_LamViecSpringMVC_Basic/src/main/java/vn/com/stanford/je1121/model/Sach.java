package vn.com.stanford.je1121.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class Sach {
    @NotNull(message = "Bạn không được bỏ trống mã sách")
    @Length(min = 1, max = 10, message = "Bạn cần nhập mã sách trong khoảng 1-10 kí tự")
    private String maSach;

    @NotBlank(message = "bạn cần nhập tên sách")
    private String tenSach;
    private String moTa;
    private String anhSach;
    @NotNull(message = "bạn cần nhập giá sách")
    private double giaSach;
    @NotEmpty(message = "bạn cần nhập tên tác giả")
    private String tacGia;
    private Date ngayTao;
    private String maChuDe;


    public String getMaChuDe() {
        return maChuDe;
    }

    public void setMaChuDe(String maChuDe) {
        this.maChuDe = maChuDe;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getAnhSach() {
        return anhSach;
    }

    public void setAnhSach(String anhSach) {
        this.anhSach = anhSach;
    }

    public double getGiaSach() {
        return giaSach;
    }

    public void setGiaSach(double giaSach) {
        this.giaSach = giaSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

//    private ChuDe chuDe;
//    public ChuDe getChuDe()
//    {
//        return chuDe;
//    }
//
//    public void setChuDe(ChuDe chuDe) {
//        this.chuDe = chuDe;
//    }
}
