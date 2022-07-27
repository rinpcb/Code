package vn.com.spingboot_review_phim.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.spingboot_review_phim.Interface.DienVienDao;
import vn.com.spingboot_review_phim.Interface.DienVienRepository;
import vn.com.spingboot_review_phim.Model.DienVien;

import java.util.List;

@Service("dienVienDao")
public class DienVienImpl implements DienVienDao {
    @Autowired
    DienVienRepository dienVienRepository;

    @Override
    public List<DienVien> layDanhSach() {
        return (List<DienVien>)dienVienRepository.findAll();
    }

    @Override
    public DienVien layChiTietTheoMa(Object id) {
        DienVien objdienVien = null;
        try {
            objdienVien = dienVienRepository.findById(Integer.parseInt("" + id)).get();
        } catch (Exception ex) {
            System.out.println("Lỗi không lấy diễn viên có id: " + ex.getMessage());
        }
        return objdienVien;
    }

    @Override
    public boolean themMoi(DienVien obj) {
        DienVien objdienVien = dienVienRepository.save(obj);
        if (objdienVien != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean capNhat(DienVien obj) {
        DienVien objdienVien = dienVienRepository.findById(obj.getId()).get();
        if (objdienVien != null) {
            objdienVien.setHoTen(obj.getHoTen());
            objdienVien.setGioiTinh(obj.getGioiTinh());
            dienVienRepository.save(objdienVien);
            return true;
        }
        return false;
    }

    @Override
    public boolean xoa(Object id) {
        DienVien objdienVien = layChiTietTheoMa(id);

        if (objdienVien != null) {
            dienVienRepository.delete(objdienVien);
            return true;
        }
        return false;
    }

    @Override
    public List<DienVien> timKiemDienVien(String tuKhoa) {
        if (tuKhoa != null) {
            return dienVienRepository.timKiemDienVien(tuKhoa);
        }
        return (List<DienVien>) dienVienRepository.findAll();
    }
}
