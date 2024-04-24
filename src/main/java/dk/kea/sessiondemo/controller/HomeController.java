package dk.kea.sessiondemo.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showIndex(HttpSession httpSession){
        if (httpSession.getAttribute("theusername") == null){
            return "redirect:/login";
        }
        return "index";
    }

    @GetMapping("/login")
    public String showLogin(){
        return "login";
    }

    @PostMapping("login")
    public String doLogin(@RequestParam("username") String user, HttpSession httpSession){
        //gør noget for at logge ind
        httpSession.setAttribute("theusername", user);
        return "redirect:/";
    }
}
