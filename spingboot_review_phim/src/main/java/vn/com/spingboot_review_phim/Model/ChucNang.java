package vn.com.spingboot_review_phim.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CHUC_NANG")
public class ChucNang {
    private Integer id;
    private String tenChucNang;
    private String moTa;
    private String tenFrom;
    private String module;
    private Integer oderNumber;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CHUC_NANG")
    @SequenceGenerator(name = "SEQ_CHUC_NANG", sequenceName = "SEQ_CHUC_NANG", allocationSize = 1)
    @Column(name = "ID", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TEN_CHUC_NANG", unique = true, length = 150)
    public String getTenChucNang() {
        return tenChucNang;
    }

    public void setTenChucNang(String tenChucNang) {
        this.tenChucNang = tenChucNang;
    }

    @Basic
    @Column(name = "MO_TA", unique = true, length = 200)
    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Basic
    @Column(name = "TEN_FROM", unique = true, length = 200)
    public String getTenFrom() {
        return tenFrom;
    }

    public void setTenFrom(String tenFrom) {
        this.tenFrom = tenFrom;
    }

    @Basic
    @Column(name = "MODULE", unique = true, length = 200)
    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    @Basic
    @Column(name = "ODER_NUMBER", unique = true)
    public Integer getOderNumber() {
        return oderNumber;
    }

    public void setOderNumber(Integer oderNumber) {
        this.oderNumber = oderNumber;
    }
}
