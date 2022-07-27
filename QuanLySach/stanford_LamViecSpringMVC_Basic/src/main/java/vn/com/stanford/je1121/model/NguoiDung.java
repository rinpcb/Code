package vn.com.stanford.je1121.model;

import javax.persistence.*;

@Entity
@Table(name="Nguoi_Dung")
public class NguoiDung {
    private Integer id;
    private String tenDangNhap;
    private String matKhau;
    private String hoTen;
    private String dienThoai;
    private String email;
    private String diaChi;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_Nguoidung")
    @SequenceGenerator(name = "SEQ_Nguoidung", sequenceName = "SEQ_Nguoidung", allocationSize = 1)
    @Column(name = "ID", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name = "Ten_Dang_Nhap", nullable = true, length = 50)
    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    @Column(name = "Mat_Khau", nullable = true, length = 50)
    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    @Column(name = "Ho_Ten", nullable = true, length = 30)
    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    @Column(name = "Dien_Thoai", nullable = true, length = 50)
    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    @Column(name = "Email", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "Dia_Chi", nullable = true, length = 150)
    public String getDiaChi() {
        return diaChi;
    }


    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
