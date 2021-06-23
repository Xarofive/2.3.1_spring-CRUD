package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.DAO.UserDaoImpl;
import web.model.User;

import javax.validation.Valid;


@Controller
@RequestMapping("/users")
public class UsersController {

    private UserDaoImpl userDaoImpl;

    public UsersController(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("users", userDaoImpl.index());
        model.addAttribute("userToAdd", new User());
        return "users/users";
    }

    @PostMapping
    public String create(@ModelAttribute("userToAdd") @Valid User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "redirect:/users";
        }

        userDaoImpl.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userDaoImpl.showById(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @PathVariable("id") int id) {

        if (bindingResult.hasErrors()) {
            return "redirect:/users";
        }

        userDaoImpl.update(user, id);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userDaoImpl.delete(id);
        return "redirect:/users";
    }


}
