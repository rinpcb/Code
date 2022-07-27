package vn.com.spingboot_review_phim.ApiController.CallApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.com.spingboot_review_phim.Interface.ChucNangDao;
import vn.com.spingboot_review_phim.Model.ChucNang;

import java.util.List;

@Controller
@RequestMapping("call-api")
public class ChucNangCallApiController {
    @Autowired
    ChucNangDao chucNangDao;

    @RequestMapping("chucnang")
    public String hienThiDanhSachChucNang(Model model)
    {
        List<ChucNang> lstChucNang = chucNangDao.layDanhSach();
        model.addAttribute("lstChucNang", lstChucNang);
        return "QuanLyChucNangCallApi";
    }
}
