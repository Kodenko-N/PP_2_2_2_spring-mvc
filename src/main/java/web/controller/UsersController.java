package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.DAO.UserDAO;

@Controller
@RequestMapping("/")
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
}
