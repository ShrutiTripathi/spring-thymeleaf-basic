package com.example.basic.thymleaf.controller;

import com.example.basic.thymleaf.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String showCreateUserForm(Model model) {
        model.addAttribute("formData", new CreateUserFormData());
        return "create";
    }

    @PostMapping("/create")
    public String doCreateUser(@Valid @ModelAttribute("formData") CreateUserFormData formData,
                               BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        service.createUser(formData.toParameters());
        return "redirect:/users/userslist";
    }

    @GetMapping("/userslist")
    public String listUsers(Model model) {
        model.addAttribute("users", service.getUsers());
        return "list";
    }
}
