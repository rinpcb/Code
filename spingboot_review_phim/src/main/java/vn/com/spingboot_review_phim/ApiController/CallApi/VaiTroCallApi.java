package vn.com.spingboot_review_phim.ApiController.CallApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.com.spingboot_review_phim.Interface.VaiTroDao;
import vn.com.spingboot_review_phim.Model.SearchView;
import vn.com.spingboot_review_phim.Model.VaiTro;

import java.util.List;

@Controller
@RequestMapping("call-api")
public class VaiTroCallApi {
    @Autowired
    VaiTroDao vaiTroDao;

    @RequestMapping("/vaitro")
    public String hienthiDanhSachVaiTro(Model model){
        List<VaiTro> lstVaiTro = vaiTroDao.layDanhSach();
        model.addAttribute("lstVaiTro", lstVaiTro);
        return "QuanLyVaiTroCallApi";
    }

    @RequestMapping("/timkiem-vaitro")
    public String timKiemVaiTro(@ModelAttribute("view") SearchView searchView, Model model){
        List<VaiTro> lstVaiTro = vaiTroDao.timKieVaiTro(searchView.getTuKhoa());
        model.addAttribute("lstVaiTro", lstVaiTro);
        model.addAttribute("view", new SearchView());
        return "QuanLyVaiTroCallApi";
    }
}
