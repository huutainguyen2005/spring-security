package vn.edu.fpt.musicstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    //    @RequestMapping(value = "/home")
//    public String homePage(Model model) {
//        model.addAttribute("title", "Welcom to Spring");
//        return "home/welcome";
//    }
    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String homePage(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "password") String password,
            Model model) {
        model.addAttribute("title", "Welcom to Spring");
        model.addAttribute("name", name);
        return "home/welcome";
    }

    @GetMapping("/album")
    public String createAlbum() {
        return "album/create";
    }
}