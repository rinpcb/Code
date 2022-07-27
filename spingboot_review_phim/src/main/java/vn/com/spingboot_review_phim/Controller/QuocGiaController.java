package vn.com.spingboot_review_phim.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.com.spingboot_review_phim.Model.QuocGia;
import vn.com.spingboot_review_phim.Interface.QuocGiaDao;

import java.util.List;

@Controller
public class QuocGiaController {
    @Autowired
    QuocGiaDao quocGiaDao;

    @RequestMapping(value = "/quoc-gia")
    public String hienThiDanhSach(Model model) {
        List<QuocGia> lstQG = quocGiaDao.layDanhSach();
        model.addAttribute("lstQG", lstQG);
        return "QuanLyQuocGia";
    }
}
