package ru.kulinartem.spring_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kulinartem.spring_crud.model.User;
import ru.kulinartem.spring_crud.service.UserDaoImpl;

@Controller
public class UsersController {

    private final UserDaoImpl userDaoImpl;

    @Autowired
    public UsersController(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Transactional
    @GetMapping(value = "/")
    public String printAllUsers(Model model) {
        model.addAttribute("users", userDaoImpl.getAllItems());
        return "users";
    }

    @Transactional
    @GetMapping("/{id}")
    public String printUserById(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userDaoImpl.getItemById(id));
        return "user";
    }

    @GetMapping("/new")
    public String showNewUser(@ModelAttribute("newUser") User user) {
        return "new";

    }

    @Transactional
    @PostMapping
    public String createUser(@ModelAttribute("newUser") User user) {
        userDaoImpl.saveItem(user);
        return "redirect:/";
    }

    @Transactional
    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userDaoImpl.getItemById(id));
        return "edit";
    }

    @Transactional
    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userDaoImpl.updateItem(user, id);
        return "redirect:/";
    }

    @Transactional
    @DeleteMapping("/{id}")
    public String deleteUser(@ModelAttribute("user") User user) {
       userDaoImpl.deleteItem(user);
        return "redirect:/";
    }
}
