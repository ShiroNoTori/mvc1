package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService service;

    @Autowired
    UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public String addUser(@RequestParam(name = "login") String login,
                          @RequestParam(name = "name") String name,
                          @RequestParam(name = "password") String password) {
        User user = new User(login, name, password);
        service.save(user);
        return "redirect:/user/all";
    }

    @GetMapping("/add")
    public String addUser() {
        return "userAdd";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("userList", service.findAll());
        return "userList";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.deleteById(id);
        return "redirect:/user/all";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Integer id, Model model) {
        User user = service.findById(id);
        model.addAttribute("user", user);
        return "userUpdate";
    }

    @PostMapping("/update")
    public String update(@RequestParam(name = "id") Integer id,
                         @RequestParam(name = "name") String name,
                         @RequestParam(name = "password") String password) {
        User user = service.findById(id);

        user.setName(name);
        user.setPassword(password);

        service.update(user);
        return "redirect:/user/all";
    }

}