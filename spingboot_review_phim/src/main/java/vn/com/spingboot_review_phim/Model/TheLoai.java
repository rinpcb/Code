package vn.com.spingboot_review_phim.Model;

import javax.persistence.*;

@Entity
@Table(name = "THE_LOAI")
public class TheLoai {
    private Integer id;
    private String tenTheLoai;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_THE_LOAI")
    @SequenceGenerator(name = "SEQ_THE_LOAI", sequenceName = "SEQ_THE_LOAI", allocationSize = 1)
    @Column(name = "ID", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TEN_THE_LOAI", unique = true, length = 150)
    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }


}
