package poly.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
public class HomeController {
    @RequestMapping({"/","/home/index"})
    public String home() {
        return "redirect:/product/list";
    }

    @RequestMapping({"/admin","/admin/home/index"})
    public String admin(HttpSession session) {
        session.setAttribute("name", "Atta");
        return "redirect:/assets/admin/index.html";
    }
}
