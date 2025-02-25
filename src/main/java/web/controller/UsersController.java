package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.DAO.UserDAO;
import web.model.User;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserDAO userDAO;

    @Autowired
    public UsersController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping
    public String usersList(Model model) {
        model.addAttribute("users", userDAO.getUsers());
        return "list";
    }

    @GetMapping("/{id}")
    public String userShow(@PathVariable ("id") int id, Model model) {
        model.addAttribute("user", userDAO.userShow(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
       userDAO.save(user);
       return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable ("id") int id, Model model) {
        model.addAttribute("user", userDAO.userShow(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable ("id") int id) {
        userDAO.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable ("id") int id) {
        userDAO.delete(id);
        return "redirect:/users";
    }
}
