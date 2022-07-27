package vn.com.spingboot_review_phim.ApiController.CallApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.com.spingboot_review_phim.Interface.NguoiDungDao;
import vn.com.spingboot_review_phim.Interface.VaiTroDao;
import vn.com.spingboot_review_phim.Model.NguoiDungViewModel;
import vn.com.spingboot_review_phim.Model.SearchView;
import vn.com.spingboot_review_phim.Model.VaiTro;

import java.util.List;

@Controller
@RequestMapping("call-api")
public class NguoiDungCallApi {
    @Autowired
    NguoiDungDao nguoiDungDao;

    @RequestMapping(value = "/user")
    public String hienThiDanhSachUser(Model model)
    {
        List<NguoiDungViewModel> lstUser = nguoiDungDao.getAll();
        model.addAttribute("lstUser",lstUser);
        model.addAttribute("view", new SearchView());
        return "QuanLyNguoiDungCallApi";
    }

    @Autowired
    VaiTroDao vaiTroDao;
    @ModelAttribute("lstVaiTro")
    public List<VaiTro> hienThiDanhSachVaiTro(){
        List<VaiTro> lstVaiTro = vaiTroDao.layDanhSach();
        return lstVaiTro;
    }

    @RequestMapping("/timkiem")
    public String timKiemNguoiDung(@ModelAttribute("view") SearchView searchView, Model model){
        List<NguoiDungViewModel> lstUser = nguoiDungDao.timKiemNguoiDung(searchView.getTuKhoa(), searchView.getVaiTro());
        model.addAttribute("lstUser", lstUser);
        model.addAttribute("view", new SearchView());
        return "QuanLyNguoiDungCallApi";
    }
}
