package sia.tacocloud.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sia.tacocloud.model.RegistrationForm;
import sia.tacocloud.model.User;
import sia.tacocloud.repository.UserRepository;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
@Slf4j
public class UserRegisterController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public String registerForm(){
        log.info("Request Received");
        return "register";
    }

    @PostMapping
    public String processRegistration(RegistrationForm form){
        log.info("Inside Register");
        User user = form.toUser(passwordEncoder);
        log.info("Convert user");
        userRepository.save(user);
        log.info("Saved user");
        return "redirect:/login";
    }
}
