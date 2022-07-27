package vn.com.spingboot_review_phim.ApiController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.com.spingboot_review_phim.Interface.PhimYeuThichDao;
import vn.com.spingboot_review_phim.Model.Message;
import vn.com.spingboot_review_phim.Model.PhimYeuThich;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("api")
public class PhimYeuThichApi {
   @Autowired
    PhimYeuThichDao phimYeuThichDao;

    @GetMapping("phimyeuthich/all")
    public ResponseEntity<List<PhimYeuThich>> getAll(Model model){
        List<PhimYeuThich> lstPYT = phimYeuThichDao.layDanhSach();
        return new ResponseEntity<List<PhimYeuThich>> (lstPYT, HttpStatus.OK);
    }
    @GetMapping("phimyeuthich/{id}")
    public ResponseEntity<?> getAll( @PathVariable("id") Integer id){

        if(phimYeuThichDao.layChiTietTheoMa(id) == null){
            Message apiEr = new Message("không thể lấy ci tiết có Id la:" +id);
            return new ResponseEntity<Message>(apiEr,HttpStatus.NOT_FOUND);
        }else {

            PhimYeuThich objPYT = phimYeuThichDao.layChiTietTheoMa(id);
            return new ResponseEntity<PhimYeuThich>(objPYT,HttpStatus.OK);
        }
    }

    @PostMapping("phimyeuthich/add")
    public ResponseEntity<?> addPhimYeuThich(@RequestBody PhimYeuThich objPhim, HttpSession session) {

        objPhim.setNguoiDung(Integer.parseInt(session.getAttribute("userId") + ""));
      List <PhimYeuThich> lstPhimYT = phimYeuThichDao.layIdTheoPhimId(objPhim.getNguoiDung(), objPhim.getPhim());

        if (lstPhimYT.size()==0) {
            boolean ketQua = phimYeuThichDao.themMoi(objPhim);

            if (ketQua) {
                return new ResponseEntity<PhimYeuThich>(objPhim, HttpStatus.OK);
            }
            Message apiErr = new Message("Không thể tạo mới phim");
            return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);

        } else {
            Message apiErr = new Message("Không thể thêm mới phim yêu thích");
            return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("phimyeuthich/{id}")
    public ResponseEntity<?>updatePhimYeuThich(@PathVariable("id")int id,@RequestBody PhimYeuThich objPhim){
        PhimYeuThich objPhimOld = phimYeuThichDao.layChiTietTheoMa(id);
        if(objPhimOld == null){
            Message apiErr = new Message("Không thể tìm thấy phim có Id là:" +id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
        }else {

            objPhimOld.setPhim(objPhim.getPhim());
            objPhimOld.setNguoiDung(objPhim.getNguoiDung());
            phimYeuThichDao.capNhat(objPhimOld);
            return new ResponseEntity<PhimYeuThich>(objPhimOld,HttpStatus.OK);
        }
    }
    @DeleteMapping("phimyeuthich/{id}")
    public ResponseEntity<?> deletePhimYeuThich(@PathVariable("id") Integer id){
        PhimYeuThich objPhim = phimYeuThichDao.layChiTietTheoMa(id);
        if (objPhim == null) {
            Message apiErr = new Message("Không tìm thấy Phim có id: "+ id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            phimYeuThichDao.xoa(id);
            Message apiErr = new Message("Xoá phim có id: "+ id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.OK);
        }
    }
}
