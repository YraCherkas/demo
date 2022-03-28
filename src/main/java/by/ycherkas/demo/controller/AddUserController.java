package by.ycherkas.demo.controller;


import by.ycherkas.demo.model.User;
import by.ycherkas.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddUserController {

    private final UserService userService;

    @Autowired
    public AddUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add_user")
    public String addUserForm(Model model){
        model.addAttribute("user", new User());
        return "add_user";
    }

    @PostMapping("/add_user")
    public String addUser(@ModelAttribute(name = "user") User user){
        userService.saveUser(user);
        return "redirect:/";
    }

}