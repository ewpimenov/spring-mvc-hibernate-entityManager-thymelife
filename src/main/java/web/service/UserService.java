package web.service;

import web.model.Role;
import web.model.User;

import java.util.List;


public interface UserService {

    List<User> getAllUsers();

    void addUser(User user);

    void deleteUser(int id);

    void updateUser(User user);

    User getUser(int id);

    User findByUsername(String username);


}
