//package web.InitPackage;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//
//import web.model.Role;
//import web.model.User;
//import web.service.UserService;
//
//import javax.annotation.PostConstruct;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//import java.util.ArrayList;;
//import java.util.List;
//
//@Component
//@Transactional
//public class DbInit {
//
//    @Autowired
//    private UserService userService;
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @PostConstruct
//    public void init() {
//
//        User user1 = new User("Man", "Manov", "ADMIN",
//                "$2y$12$cTCAPhdp7AB4VO.qT9lmiePb/H7ZcoFkWXu3wPaqWygT7zR8jdG7y");
//
//        User user2 = new User("Dan", "Danov", "USER",
//                "$2y$12$gbXJWbISPK2Jy6deMuPb..tyDLoXESgffu4VH/tC781lNF6vMyRiK");
//
//        Role role1 = new Role();
//        role1.setRole("ADMIN");
//
//        Role role2 = new Role();
//        role2.setRole("USER");
//
//        List<Role> list1 = new ArrayList<>();
//        List<Role> list2 = new ArrayList<>();
//
//        user1.setRoles(list1);
//        user2.setRoles(list2);
//
//        entityManager.persist(role1);
//        entityManager.persist(role2);
//
//        userService.addUser(user1);
//        userService.addUser(user2);
//    }
//}
