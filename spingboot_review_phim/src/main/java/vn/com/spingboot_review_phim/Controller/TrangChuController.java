package vn.com.spingboot_review_phim.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.com.spingboot_review_phim.Interface.*;
import vn.com.spingboot_review_phim.Model.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TrangChuController {

    @Autowired
    PhimDao phimDao;
    @Autowired
    TheLoaiDao theLoaiDao;

    @RequestMapping(value = "/trang-chu")
    public String trangChuPhim(Model model) {
        List<PhimViewModel> lstPhim = phimDao.layDanhSachPhim();
        List<TheLoai> lstTheLoai = theLoaiDao.layDanhSach();

        model.addAttribute("lstPhim", lstPhim);
        model.addAttribute("lstTheLoai", lstTheLoai);
        return "TrangChuPhim";
    }

    @Autowired
    DanhGiaDao danhGiaDao;
    @ModelAttribute("lstDanhGia")
    public List<DanhGia> hienThiDanhSach(){
        List<DanhGia> lstDanhGia = danhGiaDao.layDanhSach();
        return lstDanhGia;
    }

    /**
     * Hàm hiển thị lên giao diện
     */
    @Autowired
    DienVienDao dienVienDao;
    @ModelAttribute("lstDienVien")
    public List<DienVien> layDanhSachDienVien(Model model)
    {
        return dienVienDao.layDanhSach();
    }

    @Autowired
    DaoDienDao daoDienDao;
    @ModelAttribute("lstDaoDien")
    public List<DaoDien> layDanhSachDaoDien(Model model)
    {
        return daoDienDao.layDanhSach();
    }


    /**
    Hàm lấy danh sách phim
     */
    @RequestMapping(value = "/phim-danhsach")
    public String danhSachPhim(Model model) {
        List<TheLoai> lstTheLoai = theLoaiDao.layDanhSach();
        Page<Phim> page = phimDao.phanTrang(1);
        long totalItems = page.getTotalElements();
        int totalPages = page.getTotalPages();

        List<Phim> lstPhim = page.getContent();

        //hiện thị trang
        model.addAttribute("currentPage", 1);
        //Hiển thị tổng số trang
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("lstPhim", lstPhim);
        model.addAttribute("lstTheLoai", lstTheLoai);
        model.addAttribute("view", new PhimView());
        return "DanhSachPhim";
    }

    /**
     * Phân trang
     * @param model
     * @param currentPage
     * @return
     */
    @GetMapping(value = "trang-chu/page/{pageNumber}")
    public String listByPage(Model model, @PathVariable("pageNumber")int currentPage) {

        Page<Phim> page = phimDao.phanTrang(currentPage);
        long totalItems = page.getTotalElements();
        int totalPages = page.getTotalPages();

        //Lấy danh sách phim
        List<Phim> lstPhim = page.getContent();


        //hiện thị trang
        model.addAttribute("currentPage", currentPage);

        //Hiển thị tổng trang
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("lstPhim", lstPhim);

        return "DanhSachPhim";
    }


    /**
    * Hàm tìm kiếm phim trang người dùng
     */

    @ModelAttribute("lstTheLoai")
    public List<TheLoai> hienThiDanhSachTL(){
        List<TheLoai> lstTheLoai = theLoaiDao.layDanhSach();
        return lstTheLoai;
    }

    @Autowired
    QuocGiaDao quocGiaDao;
    @ModelAttribute("lstQuocGia")
    public List<QuocGia> hienThiDanhSachQuocGia(){
        List<QuocGia> lstQuocGia = quocGiaDao.layDanhSach();
        return lstQuocGia;
    }

    /**
     * Hàm Tìm kiếm phim
     * @param phimView
     * @param model
     * @return
     */
    @RequestMapping("/timkiem-phim")
    public String timKiemPhimDanhSach(@ModelAttribute("view")PhimView phimView, Model model){
        List<PhimViewModel> lstPhim = phimDao.timKiemPhim(phimView.getTuKhoa(), phimView.getTheLoai(),
                phimView.getDaoDien(), phimView.getDienVien(), phimView.getQuocGia(), phimView.getStartDate(), phimView.getEndDate());
        model.addAttribute("lstPhim", lstPhim);
        model.addAttribute("view", new PhimView());
        return "DanhSachPhim";
    }
}
