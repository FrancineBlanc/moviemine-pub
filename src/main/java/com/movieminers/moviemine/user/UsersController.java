package com.movieminers.moviemine.user;

import com.movieminers.moviemine.authority.AuthoritiesRepository;
import com.movieminers.moviemine.authority.Authority;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UsersController {

  @Autowired
  UserRepository userRepository;

  @Autowired
  AuthoritiesRepository authoritiesRepository;

  @PostMapping("/signup")
  public RedirectView signup(@ModelAttribute User user, RedirectAttributes redirectAttrs) {
    user.setEnabled(true);
    userRepository.save(user);
    Authority authority = new Authority(user.getUsername(), "ROLE_USER");
    authoritiesRepository.save(authority);
    redirectAttrs.addFlashAttribute("success", "Account created successfully, please log in.");
    return new RedirectView("/");
  }

  @PostMapping("/login")
  public RedirectView login() {
    return new RedirectView("/dashboard");
  }
}
