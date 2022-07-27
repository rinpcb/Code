package vn.com.spingboot_review_phim.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "VAI_TRO")
public class VaiTro {
    private Integer id;
    private String tenVaiTro;
    private String moTa;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VAI_TRO")
    @SequenceGenerator(name = "SEQ_VAI_TRO", sequenceName = "SEQ_VAI_TRO", allocationSize = 1)
    @Column(name = "ID", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TEN_VAI_TRO", unique = true, length = 200)
    public String getTenVaiTro() {
        return tenVaiTro;
    }

    public void setTenVaiTro(String tenVaiTro) {
        this.tenVaiTro = tenVaiTro;
    }

    @Basic
    @Column(name = "MO_TA", unique = true, length = 500)
    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
