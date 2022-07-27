package vn.com.spingboot_review_phim.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PHIM")
public class Phim {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_Phim")
    @SequenceGenerator(name = "SEQ_Phim", sequenceName = "SEQ_Phim", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "TEN_PHIM", nullable = false, length = 200)
    private String tenPhim;

    @Column(name = "MO_TA", nullable = true, length = 1000)
    private String moTa;

    @Column(name = "NAM_SAN_XUAT", nullable = true)
    private Date namSanXuat;

    @Column(name = "THOI_LUONG", nullable = true)
    private Integer thoiLuong;

    @Column(name = "NGAY_CHIEU", nullable = true)
    private Date ngayChieu;


    @Column(name = "QUOC_GIA_ID", unique = true)
    private Integer quocGia;


    @Column(name = "DIEN_VIEN_ID", nullable = true)
    private Integer dienVien;

    @Column(name = "DAO_DIEN_ID", nullable = true)
    private Integer daoDien;


    @Column(name = "THE_LOAI_ID", nullable = true)
    private Integer theLoai;

    @Column(name = "NGAY_DUYET", nullable = true)
    private Date ngayDuyet;

    @Column(name = "TRANG_THAI", nullable = true)
    private int trangThai;

    @Column(name = "NGAY_TAO", nullable = true)
    private Date ngayTao;

    @Column(name = "NGAY_CAP_NHAT", nullable = true)
    private Date ngayCapNhat;



    @Column(name = "NGUOI_DUYET_ID", nullable = true)
    private Integer nguoiDuyet;

    @Lob
    @Column(name = "NOI_DUNG", unique = true)
    private String noiDung;

    @Column(name = "ANH", nullable = true, length = 150)
    private String anh;

    @Column(name = "TRAILER", nullable = true, length = 500)
    private String trailer;

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Integer getNguoiDuyet() {
        return nguoiDuyet;
    }

    public void setNguoiDuyet(Integer nguoiDuyet) {
        this.nguoiDuyet = nguoiDuyet;
    }

    public Date getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(Date ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayDuyet() {
        return ngayDuyet;
    }

    public void setNgayDuyet(Date ngayDuyet) {
        this.ngayDuyet = ngayDuyet;
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

    public Date getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(Date ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public Integer getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(Integer thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public Date getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(Date namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
