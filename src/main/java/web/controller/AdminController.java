package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {


    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping("/hello")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC-SECURITY application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "hello";
    }

    @GetMapping
    public String adminPage() {
        return "admin";
    }

    @GetMapping("/addUser")
    public String getUserAddForm(@ModelAttribute("user") User user) {
        return "addUser";
    }

    @PostMapping("/addUser")
    public String create(@ModelAttribute("user") User user){

        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/listUsers")
    public String listAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "listUsers";
    }

    @GetMapping("/updateUser")
    public String updateForm(@RequestParam int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "updateUser";
    }

    @PostMapping("/updateUser")
    public String update(@ModelAttribute("user") User user, @ModelAttribute ("role") Role role) {

        userService.updateUser(user);

        return "redirect:/";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "deleteUser";
    }

    @PostMapping("/deleteUser")
    public String delete(@ModelAttribute("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

}
