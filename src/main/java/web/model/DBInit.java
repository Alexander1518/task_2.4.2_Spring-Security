package web.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;
import web.model.User;
import web.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class DBInit {
    private final UserService userService;

    @Autowired
    public DBInit(UserService userService) {
        this.userService = userService;

    }

    @PostConstruct
    void initDB() {
//        Set<Role> setAdmin = new HashSet<>();
//        Role roleAdmin = new Role("ROLE_ADMIN");
//        setAdmin.add(roleAdmin);
        User user = new User("ADMIN", "ADMIN", "admin@mail.ru", 21, "ADMIN");
        userService.addUser(user);

//        Set<Role> setUser = new HashSet<>();
//        Role roleUser = new Role(2L, "ROLE_USER");
//        setUser.add(roleUser);

        //    userService.addUser(new User("USER", "USER", "user@mail.ru", 22, "USER"));


//        User user = new User();
//        user.setName("USER");
//        user.setSurname("USER");
//        user.setEmail("user@mail.ru");
//        user.setAge(25);
//        user.setPassword("USER");
//        user.setRoles();
//        user.getRoles().add(roleUser);
//        userService.addUser(user);
    }
}

