package vn.com.spingboot_review_phim.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DIEN_VIEN", schema = "QUANLYTT_PHIM", catalog = "")
public class DienVien {
    private Integer id;
    private String hoTen;
    private Integer gioiTinh;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DIEN_VIEN")
    @SequenceGenerator(name = "SEQ_DIEN_VIEN", sequenceName = "SEQ_DIEN_VIEN", allocationSize = 1)
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
    @Column(name = "GIOI_TINH", unique = true)
    public Integer getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Integer gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
}
