package vn.com.spingboot_review_phim.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "NGUOI_DUNG")
public class NguoiDung {
    private Integer id;
    private String hoTen;
    private String tenDangNhap;
    private String matKhau;
    private String dienThoai;
    private String email;
    private String diaChi;
    private Date ngayTao;
    private Integer vaiTro;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_NGUOI_DUNG")
    @SequenceGenerator(name = "SEQ_NGUOI_DUNG", sequenceName = "SEQ_NGUOI_DUNG", allocationSize = 1)
    @Column(name = "ID", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "HO_TEN", unique = true, length = 150)
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    @Basic
    @Column(name = "TEN_DANG_NHAP", unique = true, length = 50)
    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    @Basic
    @Column(name = "MAT_KHAU", unique = true, length = 50)
    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    @Basic
    @Column(name = "DIEN_THOAI", unique = true, length = 20)
    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    @Basic
    @Column(name = "EMAIL", unique = true, length = 30)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "DIA_CHI", unique = true, length = 500)
    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Basic
    @Column(name = "NGAY_TAO", unique = true)
    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    @Basic
    @Column(name = "VAI_TRO_ID", unique = true)
    public Integer getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(Integer vaiTro) {
        this.vaiTro = vaiTro;
    }

}
