package web.model;

import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import web.service.UserService;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class UserAndRole {

    private EntityManager entityManager;

    private UserService userService;

    public UserAndRole(UserService userService, EntityManager entityManager) {
        this.userService = userService;
        this.entityManager = entityManager;
    }

    @PostConstruct
    public void init() {

        User user1 = new User("Man", "Manov", "ADMIN",
                "$2a$04$/.fYWasEiCJglF/yEd/IrudFLJlTHn8xVAueazCqyVEhrsZmH01fO");

        User user2 = new User("Dan", "Danov", "USER",
                "$2a$04$GB0952ZyhDbopPigTBfw5OWdOv/9PhXV98HC5Sr532wlhQ4uQaKza");

        Role role1 = new Role();
        role1.setRole("ADMIN");

        Role role2 = new Role();
        role2.setRole("USER");

        List<Role> list1 = new ArrayList<>();
        List<Role> list2 = new ArrayList<>();

        user1.setRoles(list1);
        user2.setRoles(list2);

        entityManager.persist(role1);
        entityManager.persist(role2);

        userService.addUser(user1);
        userService.addUser(user2);
    }
}
