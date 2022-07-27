package vn.com.spingboot_review_phim.ApiController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.spingboot_review_phim.Model.Message;
import vn.com.spingboot_review_phim.Model.QuocGia;
import vn.com.spingboot_review_phim.Interface.QuocGiaDao;

import java.util.List;

@RestController
@RequestMapping("api")
public class QuocGiaApiController {

    @Autowired
    QuocGiaDao quocGiaDao;

    @GetMapping("quocgia/all")
    public ResponseEntity<List<QuocGia>> getAll() {
        List<QuocGia> lstQG = quocGiaDao.layDanhSach();
        return new ResponseEntity<List<QuocGia>>(lstQG, HttpStatus.OK);
    }

    @GetMapping("quocgia/{id}")
    public ResponseEntity<?> getQGById(@PathVariable("id") int id) {
        if (quocGiaDao.layChiTietTheoMa(id) == null) {
            Message apiErr = new Message("không thể tạo quốc gia có ID" + id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            QuocGia objquocGia = quocGiaDao.layChiTietTheoMa(id);
            return new ResponseEntity<QuocGia>(objquocGia, HttpStatus.OK);
        }
    }

    @PostMapping("quocgia/add")
    public ResponseEntity<?> addQuocGia(@RequestBody QuocGia objquocGia) {
        boolean kQ = quocGiaDao.themMoi(objquocGia);
        if (kQ) {
            return new ResponseEntity<QuocGia>(objquocGia, HttpStatus.OK);
        }
        Message apiErr = new Message("không thể tạo quốc gia mới");
        return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
    }

    @PutMapping("quocgia/{id}")
    public ResponseEntity<?> updateQuocGia(@PathVariable("id") int id, @RequestBody QuocGia objQuocGia) {
        QuocGia objQuocGiaOld = quocGiaDao.layChiTietTheoMa(id);
        if (objQuocGiaOld == null) {
            Message apiErr = new Message("Không tìm thấy quốc gia có id: " + id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            objQuocGiaOld.setMaQuocGia(objQuocGia.getMaQuocGia());
            objQuocGiaOld.setTenQuocGia(objQuocGia.getTenQuocGia());

            quocGiaDao.capNhat(objQuocGiaOld);
            return new ResponseEntity<QuocGia>(objQuocGiaOld, HttpStatus.OK);
        }
    }

    @DeleteMapping("quocgia/{id}")
    public ResponseEntity<?> deleteQuocGia(@PathVariable("id") int id) {
        QuocGia objquoGia = quocGiaDao.layChiTietTheoMa(id);
        if (objquoGia == null) {
            Message apiErr = new Message("Không tìm thấy quốc gia có id: " + id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            quocGiaDao.xoa(id);
            Message apiErr = new Message("Xoá quốc gia có id: " + id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.OK);
        }
    }
}
