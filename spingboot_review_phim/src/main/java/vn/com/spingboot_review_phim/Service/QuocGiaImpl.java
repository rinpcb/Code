package vn.com.spingboot_review_phim.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.spingboot_review_phim.Interface.QuocGiaDao;
import vn.com.spingboot_review_phim.Model.QuocGia;
import vn.com.spingboot_review_phim.Interface.QuocGiaReponsitory;

import java.util.List;

@Service("quocGiaDao")
public class QuocGiaImpl implements QuocGiaDao {
    @Autowired
    QuocGiaReponsitory quocGiaReponsitory;
    @Override
    public List<QuocGia> layDanhSach() {
        return (List<QuocGia>)quocGiaReponsitory.findAll();
    }

    @Override
    public QuocGia layChiTietTheoMa(Object id) {
        QuocGia objquocGia = null;
        try {
            objquocGia = quocGiaReponsitory.findById(Integer.parseInt("" + id)).get();
        } catch (Exception ex) {
            System.out.println("Lỗi không lấy được quốc gia " + ex.getMessage());
        }
        return objquocGia;
    }

    @Override
    public boolean themMoi(QuocGia obj) {
        QuocGia objquocGia = quocGiaReponsitory.save(obj);
        if (objquocGia != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean capNhat(QuocGia obj) {
        QuocGia objquocGia = quocGiaReponsitory.findById(obj.getId()).get();
        if (objquocGia != null) {
            objquocGia.setMaQuocGia(obj.getMaQuocGia());
            objquocGia.setTenQuocGia(obj.getTenQuocGia());
            quocGiaReponsitory.save(objquocGia);
            return true;
        }
        return false;
    }

    @Override
    public boolean xoa(Object id) {
        QuocGia objquocGia = layChiTietTheoMa(id);

        if (objquocGia != null) {
            quocGiaReponsitory.delete(objquocGia);
            return true;
        }
        return false;
    }

    @Override
    public List<QuocGia> timKiemQuocGia(String tuKhoa) {
        if (tuKhoa != null) {
            return quocGiaReponsitory.timKiemQuocGia(tuKhoa);
        }
        return (List<QuocGia>) quocGiaReponsitory.findAll();
    }
}
