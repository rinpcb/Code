package vn.com.spingboot_review_phim.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.com.spingboot_review_phim.Config.Encryption;
import vn.com.spingboot_review_phim.Interface.NguoiDungDao;
import vn.com.spingboot_review_phim.Model.NguoiDung;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class DangNhapController {
    @RequestMapping(value = "/dang-nhap")
    public String hienThiDangNhap(Model model) {
        //truyền 1 đối tượng ra bên ngoài
        model.addAttribute("user", new NguoiDung());
        return "DangNhap";
    }

    @Autowired
    NguoiDungDao nguoiDungDao;
    @PostMapping(value = "/thucHienDangNhap")
    public String thucHienDangNhap(@ModelAttribute("user") NguoiDung user,
                                   Model model, HttpSession session)
    {
        System.out.println("Tên đăng nhập: " + user.getTenDangNhap());
        System.out.println("Mật khẩu: " + user.getMatKhau());

        if (user.getTenDangNhap().trim().length()==0){
            model.addAttribute("thongBao", "Bạn cần phải nhập tên đăng nhập");

            return "DangNhap";
        }
        if (user.getMatKhau().trim().length() == 0) {
            model.addAttribute("thongBao", "Bạn cần phải nhập mật khẩu");

            return "DangNhap";
        }

        model.addAttribute("user", user);
        NguoiDung objUser = nguoiDungDao.getUserByName(user.getTenDangNhap());

        if (objUser != null) {
            String matKhauDb = objUser.getMatKhau();

            if (Encryption.MD5(user.getMatKhau()).equals(matKhauDb)) {
                //Lưu thông tin vào session
                session.setAttribute("UserOnline", user.getTenDangNhap());
                session.setAttribute("userId",objUser.getId());
                if (objUser.getVaiTro() == 3 || objUser.getVaiTro() == 4 || objUser.getVaiTro() == 5 || objUser.getVaiTro() ==6){
                    return "redirect:/call-api/phim";
                }
                else {
                    return "redirect:/trang-chu";
                }
            } else {
                model.addAttribute("thongBao", "Mật khẩu không chính xác");
            }
        } else {
            model.addAttribute("thongBao", "Tài khoản không tồn tại");
        }

        return "DangNhap";
    }

    @GetMapping(value = "/dang-xuat")
    public String dangXuat(HttpServletRequest request) {
        HttpSession session = request.getSession();

        if (session.getAttribute("userOnline") != null) {
            session.invalidate();
        }

        return "redirect:/dang-nhap";
    }

    @RequestMapping(value = "/dang-ky")
    public String hienThiDangKy(Model model) {
        //Truyền đối tượng ra bên ngoài view
        model.addAttribute("user", new NguoiDung());
        return "DangKy";
    }

    @PostMapping(value = "/thucHienDangKy")
    public String thucHienDangKy(@ModelAttribute("user") NguoiDung user, Model model) {

        if (user.getHoTen().trim().length() == 0) {
            model.addAttribute("thongBao", "Bạn cần phải nhập họ & tên");
            return "DangKy";
        }
        if (user.getTenDangNhap().trim().length() == 0) {
            model.addAttribute("thongBao", "Bạn cần phải nhập tên đăng nhập");
            return "DangKy";
        }
        if (user.getMatKhau().trim().length() == 0) {
            model.addAttribute("thongBao", "Bạn cần phải nhập mật khẩu");
            return "DangKy";
        }
        if (user.getDienThoai().trim().length() == 0) {
            model.addAttribute("thongBao", "Bạn cần phải nhập số điện thoại");
            return "DangKy";
        }
        if (user.getEmail().trim().length() == 0) {
            model.addAttribute("thongBao", "Bạn cần phải nhập email");
            return "DangKy";
        }
        if (user.getDiaChi().trim().length() == 0) {
            model.addAttribute("thongBao", "Bạn cần phải nhập địa chỉ");
            return "DangKy";
        }


        NguoiDung objOldUser = nguoiDungDao.getUserByName(user.getTenDangNhap());
        if (objOldUser != null) {
            if (user.getEmail().equals(objOldUser.getEmail())) {
                model.addAttribute("thongBao", "Địa chỉ email đã được sử dụng");
                return "DangKy";
            }
            model.addAttribute("thongBao", "Tên đăng nhập đã được sử dụng");
            return "DangKy";

        } else {
            String password = user.getMatKhau();
            user.setMatKhau(Encryption.MD5(password));
            user.setVaiTro(1);
            boolean ketQua = nguoiDungDao.themMoi(user);
            if (ketQua){
                return "redirect:/dang-nhap";
            }
        }
        return "DangKy";
    }
}
