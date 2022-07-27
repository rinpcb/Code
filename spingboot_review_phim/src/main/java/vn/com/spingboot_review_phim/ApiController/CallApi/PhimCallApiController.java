package vn.com.spingboot_review_phim.ApiController.CallApi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.com.spingboot_review_phim.Interface.*;
import vn.com.spingboot_review_phim.Model.*;

import java.util.List;


@Controller
@RequestMapping("call-api")
public class PhimCallApiController {

    @Autowired
    PhimDao phimDao;
    @RequestMapping(value = "/phim")
    public String hienThiDanhPhim(Model model) {

        //Lấy danh sách phim
        List<PhimViewModel> lstPhim = phimDao.layDanhSachPhimView();

        //Hiển thị ra view
        model.addAttribute("lstPhim", lstPhim);
        return "QuanLyPhimCallApi";
    }

    @Autowired
    TheLoaiDao theLoaiDao;
    @ModelAttribute("lstTheLoai")
    public List<TheLoai> hienThiDanhTheLoai() {

        //lấy danh sách thể loại
        List<TheLoai> lstTheLoai = theLoaiDao.layDanhSach();
        return lstTheLoai;
    }

    @Autowired
    QuocGiaDao quocGiaDao;
    @ModelAttribute("lstQuocGia")
    public List<QuocGia> hienThiDanhSachQuocGia(){
        List<QuocGia> lstQuocGia = quocGiaDao.layDanhSach();
        return lstQuocGia;
    }

    @Autowired
    DienVienDao dienVienDao;
    @ModelAttribute("lstDienVien")
    public List<DienVien> hienThiDanhSachDienVien(){
        List<DienVien> lstDienVien = dienVienDao.layDanhSach();
        return lstDienVien;
    }

    @Autowired
    DaoDienDao daoDienDao;
    @ModelAttribute("lstDaoDien")
    public List<DaoDien> hienThiDanhSachDaoDien(){
        List<DaoDien> lstDaoDien = daoDienDao.layDanhSach();
        return lstDaoDien;
    }

    @Autowired
    NguoiDungDao nguoiDungDao;
    @ModelAttribute("lstNguoiDung")
    public List<NguoiDung> hienThiDanhSachNguoiDung(){
        List<NguoiDung> lstNguoiDung = nguoiDungDao.layDanhSach();
        return lstNguoiDung;
    }

    @RequestMapping("/timkiem-phim")
    public String timKiemPhim(@ModelAttribute("view")PhimView phimView, Model model){
        List<PhimViewModel> lstPhim = phimDao.timKiemPhim(phimView.getTuKhoa(), phimView.getTheLoai(),
                phimView.getDaoDien(), phimView.getDienVien(), phimView.getQuocGia(), phimView.getStartDate(), phimView.getEndDate());
        model.addAttribute("lstPhim", lstPhim);
        model.addAttribute("view", new PhimView());
        return "QuanLyPhimCallApi";
    }

}
