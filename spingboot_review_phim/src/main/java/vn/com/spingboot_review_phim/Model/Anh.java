package vn.com.spingboot_review_phim.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ANH")
public class Anh {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_Anh")
    @SequenceGenerator(name = "SEQ_Anh", sequenceName = "SEQ_Anh", allocationSize = 1)
    @Column(name = "ID", unique =true)
    private Integer id;

    @Column(name = "TEN_ANH", length = 100)
    private String tenAnh;

    @Column(name = "MO_TA", length = 500)
    private String moTa;

    @Column(name = "PHIM_ID")
    private Integer phim;

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    private String tenPhim;

    private String ten;


    @Column(name = "TEN", length = 50)
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Integer getPhim() {
        return phim;
    }

    public void setPhim(Integer phim) {
        this.phim = phim;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTenAnh() {
        return tenAnh;
    }

    public void setTenAnh(String tenAnh) {
        this.tenAnh = tenAnh;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
