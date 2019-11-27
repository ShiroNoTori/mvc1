package controller;

import model.Role;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.RoleService;
import service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;

    private PasswordEncoder encoder;

    private RoleService roleService;

    @Autowired
    AdminController(UserService userService, PasswordEncoder encoder, RoleService roleService) {
        this.userService = userService;
        this.encoder = encoder;
        this.roleService = roleService;
    }

    @PostMapping("/add")
    public String addUser(@RequestParam(name = "login") String login,
                          @RequestParam(name = "name") String name,
                          @RequestParam(name = "password") String password,
                          @RequestParam(name = "role") String roleName) {
        Role role = roleService.findByName(roleName);
        User user = new User(login, name, encoder.encode(password), role.getId());
        userService.save(user);
        return "redirect:/admin/all";
    }

    @GetMapping("/add")
    public String addUser() {
        return "userAdd";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("userList", userService.findAll());
        return "userList";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        userService.deleteById(id);
        return "redirect:/admin/all";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Integer id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "userUpdate";
    }

    @PostMapping("/update")
    public String update(@RequestParam(name = "id") Integer id,
                         @RequestParam(name = "name") String name,
                         @RequestParam(name = "password") String password) {
        User user = userService.findById(id);

        user.setName(name);
        if (!password.isEmpty()) {
            user.setPassword(encoder.encode(password));
        }

        userService.update(user);
        return "redirect:/admin/all";
    }
}
