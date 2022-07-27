package vn.com.spingboot_review_phim.ApiController.CallApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.com.spingboot_review_phim.Interface.TheLoaiDao;
import vn.com.spingboot_review_phim.Model.SearchView;
import vn.com.spingboot_review_phim.Model.TheLoai;

import java.util.List;

@Controller
@RequestMapping("call-api")
public class TheLoaiCallApi {
    @Autowired
    TheLoaiDao theLoaiDao;
    @RequestMapping(value = "/theloai")
    public String hienThiDanhSachTheLoai(Model model) {
        List<TheLoai> lstTheLoai = theLoaiDao.layDanhSach();
        model.addAttribute("lstTheLoai", lstTheLoai);
        return "TheLoaiCallApi";
    }

    @RequestMapping("/timkiem-theloai")
    public String timKiemVaiTro(@ModelAttribute("view") SearchView searchView, Model model){
        List<TheLoai> lstTheLoai = theLoaiDao.timKiemTheLoaiPhim(searchView.getTuKhoa());
        model.addAttribute("lstTheLoai", lstTheLoai);
        model.addAttribute("view", new SearchView());
        return "TheLoaiCallApi";
    }
}
