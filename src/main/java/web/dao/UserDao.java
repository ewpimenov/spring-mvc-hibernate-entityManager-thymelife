package web.dao;

import org.springframework.security.core.userdetails.UserDetails;
import web.model.User;

import java.util.List;

public interface UserDao{

    List<User> getAllUsers();

    void addUser(User user);

    void deleteUser(int id);

    void updateUser(User user);

    User getUser(int id);

    User getUserByName(String s);
}
