package vn.com.spingboot_review_phim.ApiController.CallApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.com.spingboot_review_phim.Interface.DaoDienDao;
import vn.com.spingboot_review_phim.Model.DaoDien;
import vn.com.spingboot_review_phim.Model.SearchView;

import java.util.List;

@Controller
@RequestMapping("call-api")
public class DaoDienCallApiController {
    @Autowired
    DaoDienDao daoDienDao;

    @RequestMapping("daodien")
    public String hienThiDanhSach(Model model)
    {
        List<DaoDien> lstDaoDien = daoDienDao.layDanhSach();
        model.addAttribute("lstDaoDien", lstDaoDien);
        return "QuanLyDaoDienCallApi";
    }

    @RequestMapping("/timkiem-daodien")
    public String timKiemVaiTro(@ModelAttribute("view") SearchView searchView, Model model){
        List<DaoDien> lstDaoDien = daoDienDao.timKiemDaoDien(searchView.getTuKhoa());
        model.addAttribute("lstDaoDien", lstDaoDien);
        model.addAttribute("view", new SearchView());
        return "QuanLyDaoDienCallApi";
    }
}
