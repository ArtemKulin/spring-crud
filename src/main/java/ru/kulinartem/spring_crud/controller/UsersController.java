package ru.kulinartem.spring_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kulinartem.spring_crud.dao.UserDAO;
import ru.kulinartem.spring_crud.model.User;

@Controller
public class UsersController {

    private final UserDAO userDAO;

    @Autowired
    public UsersController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping(value = "/")
    @Transactional
    public String printAllUsers(Model model) {
        model.addAttribute("users", userDAO.getAllItems());
        return "users";
    }

    @GetMapping("/{id}")
    @Transactional
    public String printUserById(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userDAO.getItemById(id));
        return "user";
    }

    @GetMapping("/new")
    @Transactional
    public String addNewUser(@ModelAttribute("newUser") User user) {
        return "new";

    }

    @PostMapping
    @Transactional
    public String createUser(@ModelAttribute("newUser") User user) {
        userDAO.saveItem(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    @Transactional
    public String editUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userDAO.getItemById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    @Transactional
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userDAO.updateItem(user, id);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    @Transactional
    public String deleteUser(@ModelAttribute("user") User user) {
       userDAO.deleteItem(user);
        return "redirect:/";
    }

}
