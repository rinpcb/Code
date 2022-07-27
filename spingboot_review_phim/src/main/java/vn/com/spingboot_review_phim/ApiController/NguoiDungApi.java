package vn.com.spingboot_review_phim.ApiController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.spingboot_review_phim.Interface.NguoiDungDao;
import vn.com.spingboot_review_phim.Model.Message;
import vn.com.spingboot_review_phim.Model.NguoiDung;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api")
public class NguoiDungApi {
    @Autowired
    NguoiDungDao nguoiDungDao;
    @GetMapping("user/all")
    public ResponseEntity<List<NguoiDung>> getAll() {
        List<NguoiDung> lstSt = nguoiDungDao.layDanhSach();
        return new ResponseEntity<List<NguoiDung>>(lstSt, HttpStatus.OK);
    }

    @GetMapping("user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") int id) {
        if (nguoiDungDao.layChiTietTheoMa(id) == null) {
            Message apiErr = new Message("không thể tạo ID" + id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            NguoiDung objUs = nguoiDungDao.layChiTietTheoMa(id);
            return new ResponseEntity<NguoiDung>(objUs, HttpStatus.OK);
        }
    }

    @PostMapping("user/add")
    public ResponseEntity<?> addUser(@RequestBody NguoiDung objNguoiDung) {
        objNguoiDung.setNgayTao(new Date());
        boolean kQ = nguoiDungDao.themMoi(objNguoiDung);
        if (kQ) {
            return new ResponseEntity<NguoiDung>(objNguoiDung, HttpStatus.OK);
        }
        Message apiErr = new Message("không thể tạo user");
        return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
    }

    @PutMapping("user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") int id, @RequestBody NguoiDung objUser) {
        NguoiDung objUserOld = nguoiDungDao.layChiTietTheoMa(id);
        if (objUserOld == null) {
            Message apiErr = new Message("Không tìm thấy người dùng có id: " + id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            objUserOld.setTenDangNhap(objUser.getTenDangNhap());
            objUserOld.setHoTen(objUser.getHoTen());
            objUserOld.setDienThoai(objUser.getDienThoai());
            objUserOld.setEmail(objUser.getEmail());
            objUserOld.setDiaChi(objUser.getDiaChi());
            objUserOld.setVaiTro(objUser.getVaiTro());


            nguoiDungDao.capNhat(objUserOld);
            return new ResponseEntity<NguoiDung>(objUserOld, HttpStatus.OK);
        }
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") int id) {
        NguoiDung objUser = nguoiDungDao.layChiTietTheoMa(id);
        if (objUser == null) {
            Message apiErr = new Message("Không tìm thấy người dùng có id: " + id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            nguoiDungDao.xoa(id);
            Message apiErr = new Message("Xoá người dùng có id: " + id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.OK);
        }
    }
}
