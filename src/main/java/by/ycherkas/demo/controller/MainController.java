package by.ycherkas.demo.controller;

import by.ycherkas.demo.model.User;
import by.ycherkas.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model){
        Iterable <User> users = userService.findAll();
        model.addAttribute("users", users);
        return "home";
    }

}
