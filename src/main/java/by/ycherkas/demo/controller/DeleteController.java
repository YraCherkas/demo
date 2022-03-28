package by.ycherkas.demo.controller;


import by.ycherkas.demo.model.User;
import by.ycherkas.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeleteController {


    private final UserService userService;

    @Autowired
    public DeleteController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user_delete/{id}")
    public String deleteUser(@PathVariable("id") String id) {
        userService.deleteById(id);
        return "redirect:/";
    }


    @GetMapping("edit_user/{id}")
    public String editForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "edit_user";
    }

    @PostMapping("/edit_user/{id}")
    public String editForm(@ModelAttribute(name = "user") User user,
                           @PathVariable String id, Model model) {
        user.setId(id);
        userService.saveUser(user);
        return "redirect:/";
    }
}