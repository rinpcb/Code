package vn.com.spingboot_review_phim.ApiController.CallApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.com.spingboot_review_phim.Interface.QuocGiaDao;
import vn.com.spingboot_review_phim.Model.QuocGia;
import vn.com.spingboot_review_phim.Model.SearchView;

import java.util.List;

@Controller
@RequestMapping("call-api")
public class QuocGiaCallApiController {
    @Autowired
    QuocGiaDao quocGiaDao;

    @RequestMapping("/quocgia")
    public String hienThiDanhSachQuocGia(Model model)
    {
        List<QuocGia> lstQuocGia = quocGiaDao.layDanhSach();
        model.addAttribute("lstQuocGia", lstQuocGia);
        return "QuocGiaCallApi";
    }

    @RequestMapping("/timkiem-quocgia")
    public String timKiemQuocGia(@ModelAttribute("view") SearchView searchView, Model model){
        List<QuocGia> lstQuocGia = quocGiaDao.timKiemQuocGia(searchView.getTuKhoa());
        model.addAttribute("lstQuocGia", lstQuocGia);
        model.addAttribute("view", new SearchView());
        return "QuocGiaCallApi";
    }
}
