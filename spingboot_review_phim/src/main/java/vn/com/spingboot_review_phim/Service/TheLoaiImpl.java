package vn.com.spingboot_review_phim.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.spingboot_review_phim.Interface.TheLoaiDao;
import vn.com.spingboot_review_phim.Interface.TheLoaiReponsitory;
import vn.com.spingboot_review_phim.Model.TheLoai;

import java.util.List;

@Service("theLoaiDao")
public class TheLoaiImpl implements TheLoaiDao {
    @Autowired
    TheLoaiReponsitory theLoaiReponsitory;

    @Override
    public List<TheLoai> layDanhSach() {
        return (List<TheLoai>)theLoaiReponsitory.findAll();
    }

    @Override
    public TheLoai layChiTietTheoMa(Object id) {
        TheLoai objTheLoai = null;
        try {
            objTheLoai = theLoaiReponsitory.findById(Integer.parseInt(""+id)).get();
        }catch (Exception ex)
        {
            System.out.println("Lỗi không lấy được thể loại phim"+ ex.getMessage());
        }
        return objTheLoai;
    }

    @Override
    public boolean themMoi(TheLoai obj) {
        TheLoai objtheLoai = theLoaiReponsitory.save(obj);
        if (objtheLoai != null)
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean capNhat(TheLoai obj) {
        TheLoai objTheLoai = theLoaiReponsitory.findById(obj.getId()).get();
        if (objTheLoai != null)
        {
            objTheLoai.setTenTheLoai(obj.getTenTheLoai());
            theLoaiReponsitory.save(objTheLoai);
            return true;
        }
        return false;
    }

    @Override
    public boolean xoa(Object id) {
        TheLoai objTheLoai = layChiTietTheoMa(id);
        if (objTheLoai != null)
        {
            theLoaiReponsitory.delete(objTheLoai);
            return true;
        }
        return false;
    }

    @Override
    public List<TheLoai> timKiemTheLoaiPhim(String tuKhoa) {
        if (tuKhoa != null) {
            return theLoaiReponsitory.timKiemTheLoaiPhim(tuKhoa);
        }
        return (List<TheLoai>) theLoaiReponsitory.findAll();
    }
}
