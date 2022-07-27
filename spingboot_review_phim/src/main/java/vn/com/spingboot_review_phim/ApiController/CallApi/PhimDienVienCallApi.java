package vn.com.spingboot_review_phim.ApiController.CallApi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.com.spingboot_review_phim.Interface.DienVienDao;
import vn.com.spingboot_review_phim.Interface.PhimDao;
import vn.com.spingboot_review_phim.Interface.PhimDienVienDao;
import vn.com.spingboot_review_phim.Model.DienVien;
import vn.com.spingboot_review_phim.Model.PhimDienVienViewModel;
import vn.com.spingboot_review_phim.Model.Phim;

import java.util.List;

@Controller
@RequestMapping("call-api")
public class PhimDienVienCallApi {
    @Autowired
    PhimDienVienDao phimDienVienDao;

    @RequestMapping("/phimdienvien")
    public String hienThiDanhSach(Model model)
    {
        List<PhimDienVienViewModel> lstPhimDienVien = phimDienVienDao.getAll();
        model.addAttribute("lstPhimDienVien", lstPhimDienVien);
        return "QuanLyPhimDienVienCallApi";
    }

    @Autowired
    DienVienDao dienVienDao;
    @ModelAttribute("lstDienVien")
    public List<DienVien> hienThiDanhSachDienVien(){
        List<DienVien> lstDienVien = dienVienDao.layDanhSach();
        return lstDienVien;
    }

    @Autowired
    PhimDao phimDao;
    @ModelAttribute("lstPhim")
    public List<Phim> hienThiDanhSachPhim()
    {
        List<Phim> lstPhim = phimDao.layDanhSach();
        return lstPhim;
    }
}
