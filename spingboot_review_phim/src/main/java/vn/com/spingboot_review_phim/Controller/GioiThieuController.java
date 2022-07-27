package vn.com.spingboot_review_phim.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GioiThieuController {
    @GetMapping(value = "/gioiThieu")
    public String gioiThieu(Model model)
    {
        model.addAttribute("gioiThieu", "Hello Word");
        return "GioiThieu";
    }
}
