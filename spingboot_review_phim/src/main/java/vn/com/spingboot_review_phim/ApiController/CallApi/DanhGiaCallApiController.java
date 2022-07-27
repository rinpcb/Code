package vn.com.spingboot_review_phim.ApiController.CallApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.com.spingboot_review_phim.Interface.DanhGiaDao;
import vn.com.spingboot_review_phim.Interface.PhimDao;
import vn.com.spingboot_review_phim.Model.DanhGiaViewModel;
import vn.com.spingboot_review_phim.Model.Phim;

import java.util.List;

@Controller
@RequestMapping("call-api")
public class DanhGiaCallApiController {

    @Autowired
    DanhGiaDao danhGiaDao;

    @RequestMapping("/danhgia")
    public String hienThiDanhSach(Model model)
    {
        List<DanhGiaViewModel> lstDanhGia = danhGiaDao.layDanhSachView();
        model.addAttribute("lstDanhGia", lstDanhGia);
        return "QuanLyDanhGiaCallApi";
    }

    @Autowired
    PhimDao phimDao;
    @ModelAttribute("lstPhim")
    public List<Phim> hienThiDanhSachPhim() {
        List<Phim> lstPhim = phimDao.layDanhSach();
        return lstPhim;

    }
}
