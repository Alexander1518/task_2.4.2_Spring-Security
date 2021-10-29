package web.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import web.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    void addUser(User user);
    void updateUser(User user);
    void deleteUserById(long id);
    User getUserById(long id);
    List<User> listUsers();
    User getUserByName(String name);
}