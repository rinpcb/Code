package vn.com.spingboot_review_phim.Model;

import javax.persistence.*;

@Entity
@Table(name = "PHIM_DIEN_VIEN")
public class PhimDienVien {
    private int id;
    private String vaiDien;
    private int phimId;
    private int dienVienId;
    private String hoTen;



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PHIM_DIEN_VIEN")
    @SequenceGenerator(name = "SEQ_PHIM_DIEN_VIEN", sequenceName = "SEQ_PHIM_DIEN_VIEN", allocationSize = 1)
    @Column(name = "ID", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    @Column(name = "VAI_DIEN", unique = true, length = 150)
    public String getVaiDien() {
        return vaiDien;
    }

    public void setVaiDien(String vaiDien) {
        this.vaiDien = vaiDien;
    }


    @Column(name = "PHIM_ID", unique = true)
    public int getPhimId() {
        return phimId;
    }

    public void setPhimId(int phimId) {
        this.phimId = phimId;
    }

    @Column(name = "DIEN_VIEN_ID", unique = true)
    public int getDienVienId() {
        return dienVienId;
    }

    public void setDienVienId(int dienVienId) {
        this.dienVienId = dienVienId;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
}
