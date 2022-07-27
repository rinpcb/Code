package vn.com.spingboot_review_phim.ApiController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.spingboot_review_phim.Interface.VaiTroDao;
import vn.com.spingboot_review_phim.Model.Message;
import vn.com.spingboot_review_phim.Model.VaiTro;

import java.util.List;

@RestController
@RequestMapping("api")
public class VaiTroApiController {
    @Autowired
    VaiTroDao vaiTroDao;
    @GetMapping("vaitro/all")
    public ResponseEntity<List<VaiTro>> getAll() {
        List<VaiTro> lstVaiTro = vaiTroDao.layDanhSach();
        return new ResponseEntity<List<VaiTro>>(lstVaiTro, HttpStatus.OK);
    }

    @GetMapping("vaitro/{id}")
    public ResponseEntity<?> getVaiTroById(@PathVariable("id") int id) {
        if (vaiTroDao.layChiTietTheoMa(id) == null) {
            Message apiErr = new Message("không thể tạo vai trò có ID" + id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            VaiTro objvaiTro = vaiTroDao.layChiTietTheoMa(id);
            return new ResponseEntity<VaiTro>(objvaiTro, HttpStatus.OK);
        }
    }

    @PostMapping("vaitro/add")
    public ResponseEntity<?> addVaiTro(@RequestBody VaiTro objVaiTro) {
        boolean kQ = vaiTroDao.themMoi(objVaiTro);
        if (kQ) {
            return new ResponseEntity<VaiTro>(objVaiTro, HttpStatus.OK);
        }
        Message apiErr = new Message("không thể tạo vai trò mới");
        return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
    }

    @PutMapping("vaitro/{id}")
    public ResponseEntity<?> updateVaiTro(@PathVariable("id") int id, @RequestBody VaiTro objVaiTro) {
        VaiTro objVaiTroOld = vaiTroDao.layChiTietTheoMa(id);
        if (objVaiTroOld == null) {
            Message apiErr = new Message("Không tìm thấy vai trò có id: " + id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            objVaiTroOld.setTenVaiTro(objVaiTro.getTenVaiTro());
            objVaiTroOld.setMoTa(objVaiTro.getMoTa());

            vaiTroDao.capNhat(objVaiTroOld);
            return new ResponseEntity<VaiTro>(objVaiTroOld, HttpStatus.OK);
        }
    }

    @DeleteMapping("vaitro/{id}")
    public ResponseEntity<?> deleteVaiTro(@PathVariable("id") int id) {
        VaiTro objVaiTro = vaiTroDao.layChiTietTheoMa(id);
        if (objVaiTro == null) {
            Message apiErr = new Message("Không tìm tên vai trò có id: " + id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            vaiTroDao.xoa(id);
            Message apiErr = new Message("Xoá tên vai trò có id: " + id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.OK);
        }
    }
}
