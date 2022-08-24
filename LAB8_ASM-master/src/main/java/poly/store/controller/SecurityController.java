package poly.store.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
    @RequestMapping("/security/login/form")
    public String loginForm(Model model){
        model.addAttribute("message","VUI LÒNG ĐĂNG NHẬP");
        return "security/login";
    }

    @RequestMapping("/security/login/success")
    public String loginSuccess(Model model) {
        model.addAttribute("message", "ĐĂNG NHẬP THÀNH CÔNG");

        return "security/login";
    }

    @RequestMapping("/security/login/error")
    public String loginError(Model model) {
        model.addAttribute("message", "SAI THÔNG TIN ĐĂNG NHẬP");
        return "security/login";
    }

    @RequestMapping("/security/unauthoried")
    public String unauthoried(Model model) {
        model.addAttribute("message", "KHÔNG CÓ QUYỀN TRUY XUẤT");
        return "security/login";
    }

    @RequestMapping("/security/logoff/success")
    public String logoffSuccess(Model model) {
        model.addAttribute("message", "BẠN ĐÃ ĐĂNG XUẤT");
        return "security/login";
    }

}
