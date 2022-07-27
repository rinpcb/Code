package vn.com.spingboot_review_phim.ApiController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.spingboot_review_phim.Interface.DaoDienDao;
import vn.com.spingboot_review_phim.Model.DaoDien;
import vn.com.spingboot_review_phim.Model.Message;

import java.util.List;

@RestController
@RequestMapping("api")
public class DaoDienApi {
    @Autowired
    DaoDienDao daoDienDao;

    @GetMapping("daodien/all")
    public ResponseEntity<List<DaoDien>> getAll()
    {
        List<DaoDien> lstDaoDien = daoDienDao.layDanhSach();
        return new ResponseEntity<List<DaoDien>>(lstDaoDien, HttpStatus.OK);
    }

    @GetMapping("daodien/{id}")
    public ResponseEntity<?> getDaoDienById(@PathVariable("id") int id)
    {
        if (daoDienDao.layChiTietTheoMa(id) ==null)
        {
            Message apiErr  = new Message("Không thể lấy danh sách đạo diễn có Id"+id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
        }else {
            DaoDien objDaoDien = daoDienDao.layChiTietTheoMa(id);
            return new ResponseEntity<DaoDien>(objDaoDien, HttpStatus.OK);
        }
    }

    @PostMapping("daodien/add")
    public ResponseEntity<?> addDaoDien(@RequestBody DaoDien objDaoDien) {
        boolean kQ = daoDienDao.themMoi(objDaoDien);
        if (kQ) {
            return new ResponseEntity<DaoDien>(objDaoDien, HttpStatus.OK);
        }
        Message apiErr = new Message("không thể tạo đạo diễn");
        return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
    }

    @PutMapping("daodien/{id}")
    public ResponseEntity<?> updateDaoDien(@PathVariable("id") int id, @RequestBody DaoDien objDaoDien) {
        DaoDien objDaoDienOld = daoDienDao.layChiTietTheoMa(id);
        if (objDaoDienOld == null) {
            Message apiErr = new Message("Không tìm thấy đạo diễn có id: " + id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            objDaoDienOld.setHoTen(objDaoDien.getHoTen());
            objDaoDienOld.setGioiTinh(objDaoDien.getGioiTinh());
            daoDienDao.capNhat(objDaoDienOld);
            return new ResponseEntity<DaoDien>(objDaoDienOld, HttpStatus.OK);
        }
    }

    @DeleteMapping("daodien/{id}")
    public ResponseEntity<?> deleteDaoDien(@PathVariable("id") int id) {
        DaoDien objDaoDien = daoDienDao.layChiTietTheoMa(id);
        if (objDaoDien == null) {
            Message apiErr = new Message("Không tìm thấy đạo diễn có id: " + id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            daoDienDao.xoa(id);
            Message apiErr = new Message("Xoá đạo diễn có id: " + id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.OK);
        }
    }
}
