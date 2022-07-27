package vn.com.spingboot_review_phim.ApiController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.spingboot_review_phim.Interface.ChucNangDao;
import vn.com.spingboot_review_phim.Model.ChucNang;
import vn.com.spingboot_review_phim.Model.Message;

import java.util.List;

@RestController
@RequestMapping("api")
public class ChucNangApiController {
    @Autowired
    ChucNangDao chucNangDao;

    @GetMapping("chucnang/all")
    public ResponseEntity<List<ChucNang>> getAll()
    {
        List<ChucNang> lstChucNang = chucNangDao.layDanhSach();
        return new ResponseEntity<List<ChucNang>>(lstChucNang, HttpStatus.OK);
    }

    @GetMapping("chucnang/{id}")
    public ResponseEntity<?> getChucNangById(@PathVariable("id") int id)
    {
        if (chucNangDao.layChiTietTheoMa(id) ==null)
        {
            Message apiErr  = new Message("Không thể lấy danh sách chức năng có Id"+id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
        }else {
            ChucNang objChucNang = chucNangDao.layChiTietTheoMa(id);
            return new ResponseEntity<ChucNang>(objChucNang, HttpStatus.OK);
        }
    }

    @PostMapping("chucnang/add")
    public ResponseEntity<?> addChucNang(@RequestBody ChucNang objChucNang) {
        boolean kQ = chucNangDao.themMoi(objChucNang);
        if (kQ) {
            return new ResponseEntity<ChucNang>(objChucNang, HttpStatus.OK);
        }
        Message apiErr = new Message("không thể tạo chức năng");
        return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
    }

    @PutMapping("chucnang/{id}")
    public ResponseEntity<?> updateChucNang(@PathVariable("id") int id, @RequestBody ChucNang objDaoDien) {
        ChucNang objChucNangOld = chucNangDao.layChiTietTheoMa(id);
        if (objChucNangOld == null) {
            Message apiErr = new Message("Không tìm thấy chức năng có id: " + id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            objChucNangOld.setTenChucNang(objDaoDien.getTenChucNang());
            objChucNangOld.setMoTa(objDaoDien.getMoTa());
            objChucNangOld.setTenFrom(objDaoDien.getTenFrom());
            objChucNangOld.setModule(objDaoDien.getModule());
            objChucNangOld.setOderNumber(objDaoDien.getOderNumber());

            chucNangDao.capNhat(objChucNangOld);
            return new ResponseEntity<ChucNang>(objChucNangOld, HttpStatus.OK);
        }
    }

    @DeleteMapping("chucnang/{id}")
    public ResponseEntity<?> deleteChucNang(@PathVariable("id") int id) {
        ChucNang objChucNang = chucNangDao.layChiTietTheoMa(id);
        if (objChucNang == null) {
            Message apiErr = new Message("Không tìm thấy chức năng có id: " + id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            chucNangDao.xoa(id);
            Message apiErr = new Message("Xoá chức năng có id: " + id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.OK);
        }
    }
}
