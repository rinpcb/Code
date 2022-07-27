package vn.com.spingboot_review_phim.ApiController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.spingboot_review_phim.Interface.DanhGiaDao;
import vn.com.spingboot_review_phim.Model.DanhGia;
import vn.com.spingboot_review_phim.Model.DanhGiaViewModel;
import vn.com.spingboot_review_phim.Model.Message;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("api")
public class DanhGiaApiController {
    @Autowired
    DanhGiaDao danhGiaDao;


    @GetMapping("danhgia/all")
    public ResponseEntity<List<DanhGiaViewModel>> getAll(){
        List<DanhGiaViewModel> lstDanhGia = danhGiaDao.layDanhSachView();

        return new ResponseEntity<List<DanhGiaViewModel>>(lstDanhGia , HttpStatus.OK);

    }

    @GetMapping("danhgia/{id}")
    public ResponseEntity<?> getDanhGiaById(@PathVariable("id") int id){
        if (danhGiaDao.layChiTietTheoMa(id) == null) {
            Message apiErr = new Message("Không thể tạo dánh giá có ID: " + id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            DanhGia objDanhGia = danhGiaDao.layChiTietTheoMa(id);
            return new ResponseEntity<DanhGia>(objDanhGia, HttpStatus.OK);
        }
    }

    @PostMapping("danhgia/add")
    public ResponseEntity<?> addDanhGia(@RequestBody DanhGia objDG, HttpSession session){

        objDG.setNguoiDg(Integer.parseInt(session.getAttribute("userId")+""));
        DanhGia objDanhGiaOld = danhGiaDao.getNguoiDungAndPhim(objDG.getNguoiDg(), objDG.getPhim());
        if (objDanhGiaOld == null) {

            boolean ketQua = danhGiaDao.themMoi(objDG);

            if (ketQua) {
                return new ResponseEntity<DanhGia>(objDG, HttpStatus.OK);
            }

            Message apiErr = new Message("Không thể thêm đánh giá");
            return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
        }else {
            objDanhGiaOld.setDiem(objDG.getDiem());
            objDanhGiaOld.setPhim(objDG.getPhim());
            danhGiaDao.capNhat(objDanhGiaOld);
            return new ResponseEntity<DanhGia>(objDanhGiaOld, HttpStatus.OK);
        }

    }


    @PutMapping("danhgia/{id}")
    public ResponseEntity<?> updateDanhGia(@PathVariable("id") int id, @RequestBody DanhGia objDanhGia){
        DanhGia objDanhGiaOld = danhGiaDao.layChiTietTheoMa(id);
        if (objDanhGiaOld == null) {
            Message apiErr = new Message("Không tìm thấy đánh giá có id: "+ id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            objDanhGiaOld.setDiem(objDanhGia.getDiem());
            objDanhGiaOld.setPhim(objDanhGia.getPhim());
            danhGiaDao.capNhat(objDanhGiaOld);
            return new ResponseEntity<DanhGia>(objDanhGiaOld, HttpStatus.OK);
        }
    }


    @DeleteMapping("danhgia/{id}")
    public ResponseEntity<?> deleteDanhGia(@PathVariable("id") int id) {
        DanhGia objDanhGia = danhGiaDao.layChiTietTheoMa(id);
        if (objDanhGia == null) {
            Message apiErr = new Message("Không tìm thấy đánh giá có id: " + id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            danhGiaDao.xoa(id);
            Message apiErr = new Message("Xoá đánh giá có id: " + id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.OK);
        }
    }
}
