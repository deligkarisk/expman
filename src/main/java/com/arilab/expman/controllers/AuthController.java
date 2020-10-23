package com.arilab.expman.controllers;

import com.arilab.expman.domain.User;
import com.arilab.expman.domain.validator.OnInsert;
import com.arilab.expman.service.app.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.validation.groups.Default;
import java.util.Optional;

@Controller
public class AuthController {

    private final Logger logger = LoggerFactory.getLogger(AuthController.class);
    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }


    @GetMapping("/profile")
    public String profile() {
        return "auth/profile";
    }


    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "auth/register";
    }

    @PostMapping("/register")
    public String registerNewUser(@Validated({OnInsert.class}) User user, BindingResult bindingResult, Model model,
                                  RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            logger.info("Validation found errors while registering a new user");
            // If there are errors on the registration we need to show the form again but with the previously
            // populated values. Thus, the user object that was originally passed to the model, is passed again to
            // the view.
            model.addAttribute("user",user);
            //We also send back the validation errors
            model.addAttribute("validationErrors", bindingResult.getAllErrors());
            return "auth/register";
        } else {
            User newUser = userService.register(user);
            redirectAttributes
                    .addAttribute("id",newUser.getId())
                    .addFlashAttribute("success", true);
            return "redirect:/register";

        }

    }

    @GetMapping("/activate/{email}/{activationCode}")
    @Transactional
    public String activate(@PathVariable String email, @PathVariable String activationCode) {
        Optional<User> user = userService.findByEmailAndActivationCode(email, activationCode);
        if (user.isPresent()) {
            User newUser = user.get();
            newUser.setEnabled(true);
            // Not sure why we need the below, but it is necessary according to Dan Vega.
            // If confirmPassword is empty then we get errors in saving the new user.
            // I assume therefore there is a better way of implementing this that would
            // spare us the need to set the password every time we need to save our user.
            newUser.setConfirmPassword(newUser.getPassword());
            userService.save(newUser);
            userService.sendWelcomeEmail(newUser);
            return "auth/activated";
        }
        return "redirect:/";
    }
}
