package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @GetMapping()
    public String printUsers(Model model) {
        model.addAttribute("user", userService.listUsers());
        return "/admin";
    }

    @GetMapping("/create")
    public String createUserFrom(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("role", roleService.listRoles());
        return "create";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                          @RequestParam("role") ArrayList<Long> role) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        user.setRoles(roleService.getRoleById(role));
        userService.addUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/update")
    public String updateUserForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "update";
    }

    @PostMapping("/{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                         @RequestParam("role") ArrayList<Long> role) {
        if (bindingResult.hasErrors()) {
            return "update";
        }
        user.setRoles(roleService.getRoleById(role));
        userService.updateUser(user);

        return "redirect:/admin";
    }
}
