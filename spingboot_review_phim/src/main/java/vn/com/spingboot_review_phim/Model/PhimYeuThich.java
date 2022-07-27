package vn.com.spingboot_review_phim.Model;

import javax.persistence.*;

@Entity
@Table(name = "PHIM_YEU_THICH")
public class PhimYeuThich {
    private Integer id;
    private Integer phim;
    private Integer nguoiDung;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PHIM_YEU_THICH")
    @SequenceGenerator(name = "SEQ_PHIM_YEU_THICH", sequenceName = "SEQ_PHIM_YEU_THICH", allocationSize = 1)
    @Column(name = "ID", unique =true)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "PHIM_ID", unique = true)
    public Integer getPhim() {
        return phim;
    }

    public void setPhim(Integer phim) {
        this.phim = phim;
    }

    @Column(name = "NGUOI_DUNG_ID", unique = true)
    public Integer getNguoiDung() {
        return nguoiDung;
    }

    public void setNguoiDung(Integer nguoiDung) {
        this.nguoiDung = nguoiDung;
    }
}
