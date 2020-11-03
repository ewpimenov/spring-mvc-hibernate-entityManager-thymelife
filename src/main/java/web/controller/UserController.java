package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import web.model.Role;
import web.model.User;
import web.service.UserService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void createUsersInTable() {


        User user1 = new User("Vasya", "Sidorov", "DDDD", "1111");

        User user2 = new User("Ivan", "Ivanov", "SSSS", "2222");
        Role role1 = new Role();
        role1.setRole("ADMIN");

        Role role2 = new Role();
        role2.setRole("USER");

        List<Role> list1 = new ArrayList<>();
        list1.add(role1);

        List<Role> list2 = new ArrayList<>();
        list2.add(role2);

        user1.setRoles(list1);
        user2.setRoles(list2);

        userService.addUser(user1);
        userService.addUser(user2);

    }


    @GetMapping("/")
    public String hello(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "listUsers";
    }

    @GetMapping("/addUser")
    public String getUserAddForm(@ModelAttribute("user") User user) {
        return "addUser";
    }

    @PostMapping("/addUser")
    public String create(@ModelAttribute("user") User user) {
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
    public String update(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "deleteUser";
    }

    @GetMapping("/deleteUser")
    public String delete(@ModelAttribute("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
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

    @GetMapping("/login")
    public String loginPage(@ModelAttribute("user") String username) {
        userService.findByUsername(username);
        return "login";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }
}
