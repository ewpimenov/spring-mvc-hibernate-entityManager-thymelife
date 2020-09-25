package web.controller;

import org.springframework.stereotype.Controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.UserDao;
import web.model.User;
import javax.annotation.PostConstruct;

@Controller
@Transactional
public class UserController {

    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

   /* @PostConstruct
    public void createUsersInTable(){
        userDao.addUser(new User("Vasya", "1234"));
    }*/

    @GetMapping("/")
    public String hello(Model model) {
        model.addAttribute("users", userDao.getAllUsers());
        return "listUsers";
    }

    @GetMapping("/addUser")
    public String getUserAddForm(@ModelAttribute("user") User user) {
        return "addUser";
    }

    @PostMapping("/addUser")
    public String create(@ModelAttribute("user") User user) {
        userDao.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/listUsers")
    public String listAllUsers(Model model) {
        model.addAttribute("users", userDao.getAllUsers());
        return "listUsers";
    }

    @GetMapping("/updateUser")
    public String updateForm(@RequestParam int id, Model model) {
        model.addAttribute("user", userDao.getUser(id));
        return "updateUser";
    }

    @PostMapping("/updateUser")
    public String update(@ModelAttribute("user") User user) {
        userDao.updateUser(user);
        return "redirect:/";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam int id, Model model) {
        model.addAttribute("user", userDao.getUser(id));
        return "deleteUser";
    }

    @PostMapping("/deleteUser")
    public String delete(@ModelAttribute("user") User user) {
        userDao.deleteUser(user);
        return "redirect:/";
    }
}
