package vn.com.stanford.je1121.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.com.stanford.je1121.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

public class TrangChuController {
    @Autowired
    SachDao sachDao;
    @Autowired
    ChuDeDao chuDeDao;

    @GetMapping(value = "/trang-chu")
    public String hienThiDanhSach(Model model)
    {
        //Lấy danh sách sách
        List<Sach> lstSach = sachDao.layDanhSach();

        model.addAttribute("lstSach", lstSach);

        List<ChuDe> lstChuDe = chuDeDao.layDanhSach();
        model.addAttribute("lstChuDe", lstChuDe);

        return "TrangChuSach";
    }

    @GetMapping(value = "/trang-chu/{ma}")
    public String hienThiDanhSachTheoChuDe(@PathVariable("ma")String ma, Model model)
    {
        System.out.println("Mã chủ đề: " + ma);
        //Lấy danh sách sách
        List<Sach> lstSach = sachDao.laySachTheoChuDe(ma);

        model.addAttribute("lstSach", lstSach);

        List<ChuDe> lstChuDe = chuDeDao.layDanhSach();
        model.addAttribute("lstChuDe", lstChuDe);

        return "TrangChuSach";
    }


}
