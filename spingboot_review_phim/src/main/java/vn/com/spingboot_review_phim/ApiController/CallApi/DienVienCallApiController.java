package vn.com.spingboot_review_phim.ApiController.CallApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.com.spingboot_review_phim.Interface.DienVienDao;
import vn.com.spingboot_review_phim.Model.DienVien;
import vn.com.spingboot_review_phim.Model.SearchView;

import java.util.List;

@Controller
@RequestMapping("call-api")
public class DienVienCallApiController {
    @Autowired
    DienVienDao dienVienDao;

    @RequestMapping("dienvien")
    public String hienThiDanhSachDienvien(Model model)
    {
        List<DienVien> lstDienVien= dienVienDao.layDanhSach();
        model.addAttribute("lstDienVien", lstDienVien);
        return "QuanLyDienVienCallApi";
    }

    @RequestMapping("/timkiem-dienvien")
    public String timKiemDienVien(@ModelAttribute("view") SearchView searchView, Model model){
        List<DienVien> lstDienVien = dienVienDao.timKiemDienVien(searchView.getTuKhoa());
        model.addAttribute("lstDienVien", lstDienVien);
        model.addAttribute("view", new SearchView());
        return "QuanLyDienVienCallApi";
    }
}
