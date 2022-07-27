package vn.com.spingboot_review_phim.ApiController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.com.spingboot_review_phim.Interface.PhimDao;
import vn.com.spingboot_review_phim.Model.Message;
import vn.com.spingboot_review_phim.Model.Phim;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api")
public class PhimApiController {
    @Autowired
    PhimDao phimDao;

    //Hàm lấy danh sách phim
    @GetMapping("phim/all")
    public ResponseEntity<List<Phim>> getAll() {
        List<Phim> lstPhim = phimDao.layDanhSach();
        return new ResponseEntity<List<Phim>>(lstPhim, HttpStatus.OK);
    }


    //Lấy phim theo Id
    @GetMapping("phim/{id}")
    public ResponseEntity<?> getPhimById(@PathVariable("id") int id) {
        if (phimDao.layChiTietTheoMa(id) == null) {
            Message apiErr = new Message("không thể lấy thông tin bộ phim có ID" + id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            Phim objPhim = phimDao.layChiTietTheoMa(id);
            return new ResponseEntity<Phim>(objPhim, HttpStatus.OK);
        }
    }

    //Hàm thêm mới
    @PostMapping("phim/add")
    public ResponseEntity<?> addPhim(@RequestBody Phim objPhim) {
        objPhim.setNgayTao(new Date());
        objPhim.setNgayCapNhat(new Date());
        objPhim.setNgayDuyet(new Date());
        objPhim.setTrangThai(0);
        objPhim.setNguoiDuyet(10);
        boolean kQ = phimDao.themMoi(objPhim);
        if (kQ) {
            return new ResponseEntity<Phim>(objPhim, HttpStatus.OK);
        }
        Message apiErr = new Message("không thể tạo phim");
        return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
    }

    //Upload ảnh
    @PostMapping("phim/upload")
    public ResponseEntity<Object> fileUpload(@RequestParam("fUpload") MultipartFile fUpload) {
        String fileName = "";
        if (fUpload != null) {
            //Lấy tên file
            fileName = fUpload.getOriginalFilename();
            //Lấy đường dẫn upload trong file web.xml
            String strPath = "D:\\JAVA\\FullStack_JAVA_DEV\\Project_RinNV\\spingboot_review_phim\\src\\main\\resources\\static\\image";

            try {
                //Tạo file
                File file = new File(strPath, fileName);

                //Ghi ra file
                fUpload.transferTo(file);

            } catch (IOException e) {
                System.err.println("Có lỗi xảy ra trong quá trình upload file. Chi tiết: " + e.getMessage());
            }
        }
        return new ResponseEntity<Object>("Upload Successfully", HttpStatus.OK);
    }




    //Duyệt phim theo id
    @PutMapping("phim/approve/{id}")
    public ResponseEntity<?> duyetPhim(@PathVariable("id") String id, HttpSession session){
        Phim objPhim = phimDao.layChiTietTheoMa(id);
        if (objPhim == null)
        {
            Message apiErr = new Message("Không tìm thấy phim có id:"  + id);
            return new ResponseEntity<>(apiErr, HttpStatus.NOT_FOUND);
        }else
        {
            objPhim.setTrangThai(1);
            objPhim.setNguoiDuyet(Integer.parseInt(session.getAttribute("userId")+""));
            objPhim.setNgayDuyet(new Date());
            phimDao.capNhat(objPhim);
            Message apiErr = new Message("Duyệt thành công phim có id: " + id);
            return new ResponseEntity<>(apiErr, HttpStatus.OK);
        }
    }


    /*
    * Bỏ duyệt
     */
    @PutMapping("phim/disapprove/{id}")
    public ResponseEntity<?> huyDuyetPhim(@PathVariable("id") String id, HttpSession session) {
        Phim objPhim = phimDao.layChiTietTheoMa(id);
        if (objPhim == null) {
            Message apiErr = new Message("Không tìm thấy phim có id " + id);
            return new ResponseEntity<>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            objPhim.setTrangThai(0);
            objPhim.setNguoiDuyet(10);
            objPhim.setNgayDuyet(null);
            phimDao.capNhat(objPhim);
            Message apiErr = new Message("Duyệt thành công phimcó id " + id);
            return new ResponseEntity<>(apiErr, HttpStatus.OK);
        }
    }

    /*
    * Cập nhật phim
     */
    @PutMapping("phim/{id}")
    public ResponseEntity<?> updatePhim(@PathVariable("id") int id, @RequestBody Phim objPhim) {
        Phim objPhimOld = phimDao.layChiTietTheoMa(id);
        if (objPhimOld == null) {
            Message apiErr = new Message("Không tìm thấy bộ phim có id: " + id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            objPhimOld.setTenPhim(objPhim.getTenPhim());
            objPhimOld.setMoTa(objPhim.getMoTa());
            objPhimOld.setNamSanXuat(objPhim.getNamSanXuat());
            objPhimOld.setThoiLuong(objPhim.getThoiLuong());
            objPhimOld.setNgayChieu(objPhim.getNgayChieu());
            objPhimOld.setQuocGia(objPhim.getQuocGia());
            objPhimOld.setDienVien(objPhim.getDienVien());
            objPhimOld.setDaoDien(objPhim.getDaoDien());
            objPhimOld.setTheLoai(objPhim.getTheLoai());
            objPhimOld.setNoiDung(objPhim.getNoiDung());

            phimDao.capNhat(objPhimOld);
            return new ResponseEntity<Phim>(objPhimOld, HttpStatus.OK);
        }
    }

    /*
    * Xóa phim
     */
    @DeleteMapping("phim/{id}")
    public ResponseEntity<?> deletePhim(@PathVariable("id") int id) {
        Phim objPhim = phimDao.layChiTietTheoMa(id);
        if (objPhim == null) {
            Message apiErr = new Message("Không tìm thấy bộ phim có id: " + id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            phimDao.xoa(id);
            Message apiErr = new Message("Xoá bộ phim có id: " + id);
            return new ResponseEntity<Message>(apiErr, HttpStatus.OK);
        }
    }


}
