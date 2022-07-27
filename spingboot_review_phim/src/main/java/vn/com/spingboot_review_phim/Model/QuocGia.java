package vn.com.spingboot_review_phim.Model;

import javax.persistence.*;

@Entity
@Table(name = "QUOC_GIA", schema = "QUANLYTT_PHIM", catalog = "")
public class QuocGia {
    private Integer id;
    private String maQuocGia;
    private String tenQuocGia;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_QUOC_GIA")
    @SequenceGenerator(name = "SEQ_QUOC_GIA", sequenceName = "SEQ_QUOC_GIA", allocationSize = 1)
    @Column(name = "ID", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "MA_QUOC_GIA", nullable = true, length = 10)
    public String getMaQuocGia() {
        return maQuocGia;
    }

    public void setMaQuocGia(String maQuocGia) {
        this.maQuocGia = maQuocGia;
    }

    @Basic
    @Column(name = "TEN_QUOC_GIA", nullable = true, length = 150)
    public String getTenQuocGia() {
        return tenQuocGia;
    }

    public void setTenQuocGia(String tenQuocGia) {
        this.tenQuocGia = tenQuocGia;
    }
}
