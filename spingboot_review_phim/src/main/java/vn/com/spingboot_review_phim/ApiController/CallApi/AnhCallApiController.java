package vn.com.spingboot_review_phim.ApiController.CallApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.com.spingboot_review_phim.Interface.AnhDao;
import vn.com.spingboot_review_phim.Interface.PhimDao;
import vn.com.spingboot_review_phim.Model.Anh;
import vn.com.spingboot_review_phim.Model.AnhView;
import vn.com.spingboot_review_phim.Model.Phim;

import java.util.List;

@Controller
@RequestMapping("call-api")
public class AnhCallApiController {
    @Autowired
    AnhDao anhDao;
    @RequestMapping("/anh")
    public String hienThiDanhSachAnh(Model model) {

        List<Anh> lstAnh = anhDao.layDanhSachView();
        model.addAttribute("lstAnh", lstAnh);
        model.addAttribute("anhView", new AnhView());

        return ("QuanLyAnhCallApi");
    }

    @RequestMapping("timkiem/anh")
    public String timKiemAnh(@ModelAttribute("anhView") AnhView anhView, Model model){

        List<Anh>lstAnh = anhDao.timKiemAnh(anhView.tuKhoa,anhView.getPhim());

        model.addAttribute("lstAnh",lstAnh);
        model.addAttribute("anhView",new AnhView());
        return ("QuanLyAnhCallApi");
    }

    @Autowired
    PhimDao phimDao;

    @ModelAttribute("lstPhim")
    public List<Phim> hienThiDanhSachPhim(){

        List<Phim> lstPhim = phimDao.layDanhSach();

        return lstPhim;
    }
}
