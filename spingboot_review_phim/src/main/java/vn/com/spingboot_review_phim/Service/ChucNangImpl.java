package vn.com.spingboot_review_phim.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.spingboot_review_phim.Interface.ChucNangDao;
import vn.com.spingboot_review_phim.Interface.ChucNangRespository;
import vn.com.spingboot_review_phim.Model.ChucNang;

import java.util.List;

@Service("chucNangDao")
public class ChucNangImpl  implements ChucNangDao {

    @Autowired
    ChucNangRespository chucNangRespository;
    @Override
    public List<ChucNang> layDanhSach() {
        return (List<ChucNang>)chucNangRespository.findAll();
    }

    @Override
    public ChucNang layChiTietTheoMa(Object id) {
        ChucNang objChucNang = null;
        try {
            objChucNang = chucNangRespository.findById(Integer.parseInt(""+id)).get();
        }catch (Exception e){
            System.out.println("Không lấy được chức năng Chi tiết: "+e.getMessage());
            objChucNang = null;
        }
        return objChucNang;
    }

    @Override
    public boolean themMoi(ChucNang obj) {
        ChucNang objChucNang = chucNangRespository.save(obj);
        if (objChucNang != null){
            return true;
        }
        return false;
    }

    @Override
    public boolean capNhat(ChucNang obj) {
        ChucNang objChucNang = chucNangRespository.findById(obj.getId()).get();
        if (objChucNang!=null){
            objChucNang.setTenChucNang(obj.getTenChucNang());
            objChucNang.setMoTa(obj.getMoTa());
            objChucNang.setTenFrom(obj.getTenFrom());
            objChucNang.setModule(obj.getModule());
            objChucNang.setOderNumber(obj.getOderNumber());

            chucNangRespository.save(objChucNang);
            return true;
        }
        return false;
    }

    @Override
    public boolean xoa(Object id) {
        ChucNang objChucNang = layChiTietTheoMa(id);
        if (objChucNang != null){
            chucNangRespository.delete(objChucNang);
            return true;
        }
        return false;
    }
}
