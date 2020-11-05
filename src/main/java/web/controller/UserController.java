package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import web.model.Role;
import web.model.User;
import web.service.UserService;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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


        User user1 = new User("Vasya", "Sidorov", "ADMIN", "1111");

        User user2 = new User("Ivan", "Ivanov", "USER", "2222");
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
    public String loginPage() {
        return "login";
    }

    @GetMapping("/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    @GetMapping("/user")
    public String userPage() {
        return "user";
    }


}
