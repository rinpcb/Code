package vn.com.spingboot_review_phim.ApiController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.spingboot_review_phim.Interface.PhimDienVienDao;
import vn.com.spingboot_review_phim.Model.Message;
import vn.com.spingboot_review_phim.Model.PhimDienVien;

import java.util.List;

@RestController
@RequestMapping("api")
public class PhimDienVienApiController {
    @Autowired
    PhimDienVienDao phimDienVienDao;

    @GetMapping("phimdienvien/all")
    public ResponseEntity<List<PhimDienVien>> getAll()
    {
        List<PhimDienVien> lstPhimDienVien = phimDienVienDao.layDanhSach();
        return new ResponseEntity<List<PhimDienVien>>(lstPhimDienVien, HttpStatus.OK);
    }

    @GetMapping("phimdienvien/{id}")
    public ResponseEntity<?> getPhimDienVienById(@PathVariable("id") int id)
    {
        if (phimDienVienDao.layChiTietTheoMa(id) ==null)
        {
            Message apiErr  = new Message("Không thể lấy danh sách phim diễn viên có Id"+id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
        }else {
            PhimDienVien objPhimDienVien = phimDienVienDao.layChiTietTheoMa(id);
            return new ResponseEntity<PhimDienVien>(objPhimDienVien, HttpStatus.OK);
        }
    }

    @PostMapping("phimdienvien/add")
    public ResponseEntity<?> addPhimDienVien(@RequestBody PhimDienVien objPhimDv) {
        boolean kQ = phimDienVienDao.themMoi(objPhimDv);
        if (kQ) {
            return new ResponseEntity<PhimDienVien>(objPhimDv, HttpStatus.OK);
        }
        Message apiErr = new Message("không thể tạo Phim - diễn viên");
        return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
    }

    @PutMapping("phimdienvien/{id}")
    public ResponseEntity<?> updatePhimDienVien(@PathVariable("id") int id, @RequestBody PhimDienVien objPhimDV) {
        PhimDienVien objPhimDVOld = phimDienVienDao.layChiTietTheoMa(id);
        if (objPhimDVOld == null) {
            Message apiErr = new Message("Không tìm thấy phim - diễn viên có id: " + id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            objPhimDVOld.setVaiDien(objPhimDV.getVaiDien());
            objPhimDVOld.setPhimId(objPhimDV.getPhimId());
            objPhimDVOld.setDienVienId(objPhimDV.getDienVienId());
            phimDienVienDao.capNhat(objPhimDVOld);
            return new ResponseEntity<PhimDienVien>(objPhimDVOld, HttpStatus.OK);
        }
    }

    @DeleteMapping("phimdienvien/{id}")
    public ResponseEntity<?> deletePhimDienVien(@PathVariable("id") int id) {
        PhimDienVien objPhimDienVien = phimDienVienDao.layChiTietTheoMa(id);
        if (objPhimDienVien == null) {
            Message apiErr = new Message("Không tìm thấy phim - diễn viên có id: " + id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            phimDienVienDao.xoa(id);
            Message apiErr = new Message("Xoá phim - diễn viên có id: " + id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.OK);
        }
    }
}
