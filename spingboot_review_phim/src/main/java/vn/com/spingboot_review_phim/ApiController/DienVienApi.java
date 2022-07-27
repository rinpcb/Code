package vn.com.spingboot_review_phim.ApiController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.spingboot_review_phim.Interface.DienVienDao;
import vn.com.spingboot_review_phim.Model.DienVien;
import vn.com.spingboot_review_phim.Model.Message;

import java.util.List;

@RestController
@RequestMapping("api")
public class DienVienApi {
    @Autowired
    DienVienDao dienVienDao;

    @GetMapping("dienvien/all")
    public ResponseEntity<List<DienVien>> getAll() {
        List<DienVien> lstSt = dienVienDao.layDanhSach();
        return new ResponseEntity<List<DienVien>>(lstSt, HttpStatus.OK);
    }

    @GetMapping("dienvien/{id}")
    public ResponseEntity<?> getDienVienById(@PathVariable("id") int id) {
        if (dienVienDao.layChiTietTheoMa(id) == null) {
            Message apiErr = new Message("không thể lấy thông tin diễn viên có ID" + id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            DienVien objDienVien = dienVienDao.layChiTietTheoMa(id);
            return new ResponseEntity<DienVien>(objDienVien, HttpStatus.OK);
        }
    }

    @PostMapping("dienvien/add")
    public ResponseEntity<?> addDienVien(@RequestBody DienVien objDienVien) {
        boolean kQ = dienVienDao.themMoi(objDienVien);
        if (kQ) {
            return new ResponseEntity<DienVien>(objDienVien, HttpStatus.OK);
        }
        Message apiErr = new Message("không thể tạo diễn viên");
        return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
    }

    @PutMapping("dienvien/{id}")
    public ResponseEntity<?> updateDienVien(@PathVariable("id") int id, @RequestBody DienVien objdienVien) {
        DienVien objDienVienOld = dienVienDao.layChiTietTheoMa(id);
        if (objDienVienOld == null) {
            Message apiErr = new Message("Không tìm thấy diễn viên có id: " + id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            objDienVienOld.setHoTen(objdienVien.getHoTen());
            objDienVienOld.setGioiTinh(objdienVien.getGioiTinh());
            dienVienDao.capNhat(objDienVienOld);
            return new ResponseEntity<DienVien>(objDienVienOld, HttpStatus.OK);
        }
    }

    @DeleteMapping("dienvien/{id}")
    public ResponseEntity<?> deleteDienVien(@PathVariable("id") int id) {
        DienVien objDienVien = dienVienDao.layChiTietTheoMa(id);
        if (objDienVien == null) {
            Message apiErr = new Message("Không tìm thấy diễn viên có id: " + id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            dienVienDao.xoa(id);
            Message apiErr = new Message("Xoá diễn viên có id: " + id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.OK);
        }
    }
}
