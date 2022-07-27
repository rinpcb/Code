package vn.com.stanford.je1121.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String gioiThieu(Model model) {
        //gửi dữ liệu ra
        model.addAttribute("gioiThieu","Chào mừng bạn đến với SpringMVC");
        return "GioiThieu";
    }
}
