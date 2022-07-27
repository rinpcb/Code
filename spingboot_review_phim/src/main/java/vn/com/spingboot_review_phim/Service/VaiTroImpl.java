package vn.com.spingboot_review_phim.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.spingboot_review_phim.Interface.VaiTroDao;
import vn.com.spingboot_review_phim.Interface.VaiTroReponsitory;
import vn.com.spingboot_review_phim.Model.VaiTro;

import java.util.List;

@Service("vaiTroDao")
public class VaiTroImpl implements VaiTroDao {
    @Autowired
    VaiTroReponsitory vaiTroReponsitory;

    @Override
    public List<VaiTro> layDanhSach() {
        return (List<VaiTro>)vaiTroReponsitory.findAll();
    }

    @Override
    public VaiTro layChiTietTheoMa(Object id) {
        VaiTro objvaiTro = null;
        try {
            objvaiTro = vaiTroReponsitory.findById(Integer.parseInt("" + id)).get();
        } catch (Exception ex) {
            System.out.println("Lỗi không lấy được vai trò " + ex.getMessage());
        }
        return objvaiTro;
    }

    @Override
    public boolean themMoi(VaiTro obj) {
        VaiTro objVaiTro = vaiTroReponsitory.save(obj);
        if (objVaiTro != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean capNhat(VaiTro obj) {
        VaiTro objVaiTro = vaiTroReponsitory.findById(obj.getId()).get();
        if (objVaiTro != null) {
            objVaiTro.setTenVaiTro(obj.getTenVaiTro());
            objVaiTro.setMoTa(obj.getMoTa());
            vaiTroReponsitory.save(objVaiTro);
            return true;
        }
        return false;
    }

    @Override
    public boolean xoa(Object id) {
        VaiTro objVaiTro = layChiTietTheoMa(id);

        if (objVaiTro != null) {
            vaiTroReponsitory.delete(objVaiTro);
            return true;
        }
        return false;
    }

    @Override
    public List<VaiTro> timKieVaiTro(String tuKhoa) {
        if (tuKhoa != null) {
            return vaiTroReponsitory.timKiemVaiTro(tuKhoa);
        }
        return (List<VaiTro>) vaiTroReponsitory.findAll();
    }
}
