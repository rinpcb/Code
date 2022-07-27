package vn.com.stanford.je1121.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.com.stanford.je1121.model.NguoiDung;
import vn.com.stanford.je1121.model.NguoiDungDao;

import javax.servlet.http.HttpSession;

@Controller
public class DangNhapController {
    @RequestMapping(value = "/dang-nhap")
    public String hienThiDangNhap(Model model)
    {
        //truyền 1 đối tượng ra bên ngoài
        model.addAttribute("user", new NguoiDung());
        return "DangNhap";
    }
    @Autowired
    NguoiDungDao nguoiDungDao;
    @RequestMapping(value = "/thucHienDangNhap", method = RequestMethod.POST)
    public String thucHienDangNhap(@ModelAttribute("user") NguoiDung user, Model model, HttpSession session)
    {
        System.out.println("Tên đang nhập:" + user.getTenDangNhap());
        System.out.println("Mật khẩu:" + user.getMatKhau());
        if (user.getTenDangNhap().trim().length()==0)
        {
            model.addAttribute("thongbao", "Bạn cần phải nhập tên đăng nhập");
            return "DangNhap";
        }
        if (user.getMatKhau().trim().length()==0)
        {
            model.addAttribute("thongbao", "Bạn cần phải nhập mật khẩu");
            return "DangNhap";
        }
        model.addAttribute("user", user);
        //lấy thông tin tài khoản
        NguoiDung objUser = nguoiDungDao.layNguoiDungTheoTaiKhoan(user.getTenDangNhap());
        if (objUser != null)
        {
            String matKhauDB = objUser.getMatKhau();
            //nếu đúng mật khẩu
            if (user.getMatKhau().equals(matKhauDB))
            {
                //lưu thông tin vào sesion
                session.setAttribute("UserOnline", user.getTenDangNhap());
                return "redirect:admin/quanly-sach";
            }
            else {
                model.addAttribute("thongbao", "mật khẩu không chính xác");
            }
        }
        else {
            model.addAttribute("thongbao", "tài khoản không có");
        }
        return "DangNhap";
    }
}
