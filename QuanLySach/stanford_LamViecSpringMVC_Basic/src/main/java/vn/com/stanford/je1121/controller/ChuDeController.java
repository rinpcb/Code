package vn.com.stanford.je1121.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.com.stanford.je1121.model.ChuDe;
import vn.com.stanford.je1121.model.ChuDeDao;

import java.util.List;

@Controller
public class ChuDeController {
    @Autowired
    ChuDeDao chuDeDao;
    @RequestMapping (value = "chude")
    public String hienThiDanhSachChuDe(Model model)
    {
        //lấy danh sách chủ đề
        List<ChuDe> lstChuDe = chuDeDao.layDanhSach();
        //hiển thị ra views
        model.addAttribute("lstChuDe", lstChuDe);
        return "quanLyThongTinChuDe";
    }

    @RequestMapping (value = "/chude-add")
    public String hienThiThemMoi(Model model)
    {
        model.addAttribute("chude", new ChuDe());
        return "ChuDeAdd";
    }

    @RequestMapping (value = "/themMoiChuDe", method = RequestMethod.POST)
    public String thucHienThemChuDe(@ModelAttribute("chude") @Validated ChuDe objChuDe, BindingResult result, Model model)
    {
        //nếu có lỗi sảy ra
        if (result.hasErrors())
        {
            model.addAttribute("messege", "Bạn cần nhập đầy đủ thông tin");
        }else {}

        boolean isInsert= true;
        //nếu chủ đề đã có thì sẽ là trường hp sửa
        ChuDe objChuDeOld = chuDeDao.layChiTietTheoMa(objChuDe.getMaChuDe());

        boolean ketQua = false;
        if (isInsert)
        {
            ketQua = chuDeDao.themMoi(objChuDe);
        }
        else
        {
            ketQua = chuDeDao.capNhat(objChuDe);
        }
        if (ketQua)
        {
            return "ChuDe";
        }
        return "ChuDeAdd";
    }

    @RequestMapping(value = "/chude-edit/{ma}")
    public String suaThongTinChuDe(@PathVariable("ma") String ma, Model model) {
        System.out.println("Mã sách là:" + ma);

        ChuDe objChuDe = chuDeDao.layChiTietTheoMa(ma);
        model.addAttribute("chude", objChuDe);
        return "ChuDeAdd";
    }

    @RequestMapping(value = "/chude-delete/{ma}")
    public String xoaThongTinSach(@PathVariable("ma") String ma, Model model)
    {
        if (ma!=null && !ma.isEmpty())
        {
            //xóa thông tin
            boolean ketQua = chuDeDao.xoa(ma);
            if (ketQua)
            {
                List<ChuDe> lstChuDe = chuDeDao.layDanhSach();
                model.addAttribute("lstChuDe", lstChuDe);
            }
        }
        return "ChuDe";
    }
}
