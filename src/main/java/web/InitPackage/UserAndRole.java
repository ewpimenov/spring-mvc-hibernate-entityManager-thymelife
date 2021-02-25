/*
package web.InitPackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PersistenceContext;


import org.springframework.transaction.annotation.Transactional;
import web.model.Role;
import web.model.User;
import web.service.UserService;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

@Component
@Transactional
public class UserAndRole {

    @Autowired
    private UserService userService;

    @PersistenceContext
    private EntityManager entityManager;

    public UserAndRole(UserService userService, EntityManager entityManager) {
        this.userService = userService;
        this.entityManager = entityManager;
    }

    public UserAndRole() {
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

        Set<Role> list1 = new HashSet<>();
        Set<Role> list2 = new HashSet<>();

        user1.setRoles(list1);
        user2.setRoles(list2);

        entityManager.persist(role1);
        entityManager.persist(role2);

        userService.addUser(user1);
        userService.addUser(user2);
    }
}
*/
