package web.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import web.model.User;
import web.service.RoleService;
import web.service.UserService;


@Controller
@RequestMapping("/admin")
@Transactional
public class AdminController {

    private RoleService roleService;

    private final PasswordEncoder passwordEncoder;

    private UserService userService;

    public AdminController(RoleService roleService, UserService userService, PasswordEncoder passwordEncoder) {
        this.roleService = roleService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
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
    public String create(@ModelAttribute("user") User user) {
        user.setRoles(roleService.getAllRolesByName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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
        model.addAttribute("roles", roleService.getAllRolesByName());
        return "updateUser";
    }

    @PostMapping("/updateUser")
    public String update(@ModelAttribute("user") User user, @RequestParam("role") String[] role) {

        user.setRoles(roleService.getRolesByName(role));

        User userFromDB = userService.getUser(user.getId());
        String oldPassword = userFromDB.getPassword();
        if (!user.getPassword().equals(oldPassword)) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.updateUser(user);
        }
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
