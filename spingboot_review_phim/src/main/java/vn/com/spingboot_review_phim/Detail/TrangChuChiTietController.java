package vn.com.spingboot_review_phim.Detail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.com.spingboot_review_phim.Interface.*;
import vn.com.spingboot_review_phim.Model.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TrangChuChiTietController {
    @Autowired
    PhimChiTietDao phimChiTietDao;


    @Autowired
    DanhGiaDao danhGiaDao;

    @Autowired
    TheLoaiDao theLoaiDao;

    @Autowired
    DienVienDao dienVienDao;

    @Autowired
    PhimDienVienDao phimDienVienDao;

    @Autowired
    DaoDienDao daoDienDao;

    @Autowired
    AnhDao anhDao;

    @RequestMapping("chitiet-phim/{id}")
    public String hienThiChiTietPhim(@PathVariable("id") Integer id, Model model) {

        List<PhimChiTietView> lstPhimChiTiet = phimChiTietDao.getAll(id);
        List<DanhGiaViewModel> lstDanhGia = danhGiaDao.layDiemTheoPhimId(id);
        List<TheLoai> lstTheLoai = theLoaiDao.layDanhSach();
        List<PhimDienVien> lstPhimDV = phimDienVienDao.layPhimDienVienTheoPhimId(id);
        List<Anh> lstAnh = anhDao.layDanhSachAnhTheoPhimId(id);

        model.addAttribute("lstPhimChiTiet", lstPhimChiTiet);
        model.addAttribute("lstDanhGia", lstDanhGia);
        model.addAttribute("lstTheloai", lstTheLoai);
        model.addAttribute("lstPhimDV", lstPhimDV);
        model.addAttribute("lstAnh", lstAnh);
        return "TrangChiTietPhim";
    }

    @RequestMapping("/phim-theloai")
    public String hienThiPhimTheoTheLoai(@RequestParam(value = "id", required = false) Integer id,
                                         @RequestParam(value = "dienVienId", required = false) Integer dienVienId,
                                         @RequestParam(value = "daoDienId", required = false) Integer daoDienId, Model model)
    {

        List<PhimViewModel> lstPhimTheLoai = phimChiTietDao.getPhimByTheLoai(id, dienVienId, daoDienId);
        List<DanhGiaViewModel> lstDanhGia = danhGiaDao.layDiemTheoPhimId(id);
        List<DaoDien> lstDaoDien = daoDienDao.layDanhSach();
        model.addAttribute("lstPhimTheLoai",lstPhimTheLoai);
        model.addAttribute("lstDanhGia", lstDanhGia);
        model.addAttribute("lstDaoDien", lstDaoDien);
        model.addAttribute("view", new PhimView());
        return "QuanLyPhimTheoTheLoai";
    }

    @ModelAttribute("lstTheLoai")
    public List<TheLoai> layDanhSachTheLoai(Model model) {
        return theLoaiDao.layDanhSach();
    }

    @Autowired
    QuocGiaDao quocGiaDao;
    @ModelAttribute("lstQuocGia")
    public List<QuocGia> hienThiDanhSachQuocGia(){
        List<QuocGia> lstQuocGia = quocGiaDao.layDanhSach();
        return lstQuocGia;
    }

    @ModelAttribute("lstDienVien")
    public List<DienVien> layDanhSachDienVien(Model model)
    {
        return dienVienDao.layDanhSach();
    }

    @RequestMapping("xemchitiet_phim/{id}")
    public String hienThiChiTietPhimAdmin(@PathVariable("id") Integer id, Model model) {

        List<PhimChiTietView> lstPhimChiTiet = phimChiTietDao.getAll(id);
        List<DanhGiaViewModel> lstDanhGia = danhGiaDao.layDiemTheoPhimId(id);
        List<TheLoai> lstTheLoai = theLoaiDao.layDanhSach();
        List<PhimDienVien> lstPhimDV = phimDienVienDao.layPhimDienVienTheoPhimId(id);


        model.addAttribute("lstPhimChiTiet", lstPhimChiTiet);
        model.addAttribute("lstDanhGia", lstDanhGia);
        model.addAttribute("lstTheloai", lstTheLoai);
        model.addAttribute("lstPhimDV", lstPhimDV);

        return "ChiTietPhim";
    }

    @Autowired
    PhimYeuThichDao phimYeuThichDao;
    @RequestMapping("phim-yeuthich")
    public String hienThiPhimYeuThich(@RequestParam(value = "id", required = false) Integer id, Model model, HttpSession session) {

        List<PhimViewModel> lstPhimYeuThich = phimYeuThichDao.getPhimYeuThichByNguoiDung(Integer.parseInt(session.getAttribute("userId")+""));
        List<TheLoai> lstTheLoai = theLoaiDao.layDanhSach();
        List<DienVien> lstDienVien = dienVienDao.layDanhSach();
        List<DaoDien> lstDaoDien = daoDienDao.layDanhSach();

        model.addAttribute("lstPhimYeuThich", lstPhimYeuThich);
        model.addAttribute("lstTheLoai", lstTheLoai);
        model.addAttribute("lstDienVien",lstDienVien);
        model.addAttribute("lstDaoDien",lstDaoDien);
        return "PhimYeuThich";
    }
}
