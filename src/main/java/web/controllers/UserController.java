package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.srvice.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getAllUsers(ModelMap model) {

        model.addAttribute("value", userService.getAllUsers());
        model.addAttribute("user", new User());

        return "users";
    }

    @PostMapping("/")
    public String createUser(@ModelAttribute("user") User user) {
        userService.createUser(user);

        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);

        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String getUpdate(ModelMap model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUser(id));

        return "/update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.updateUser(id, user);

        return "redirect:/";
    }
}
