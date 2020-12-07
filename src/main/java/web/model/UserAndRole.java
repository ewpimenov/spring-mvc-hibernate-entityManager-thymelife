package web.model;

import org.springframework.stereotype.Component;
import web.service.UserService;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class UserAndRole {

    private UserService userService;

    public UserAndRole(UserService userService) {
        this.userService = userService;
    }
    @PostConstruct
    public void createUsersInTable() {

        User user1 = new User("Vasya", "Sidorov", "ADMIN",
                "$2a$04$/.fYWasEiCJglF/yEd/IrudFLJlTHn8xVAueazCqyVEhrsZmH01fO");

        User user2 = new User("Ivan", "Ivanov", "USER",
                "$2a$04$GB0952ZyhDbopPigTBfw5OWdOv/9PhXV98HC5Sr532wlhQ4uQaKza");

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

}
