package com.movieminers.moviemine.index;

import com.movieminers.moviemine.user.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

  @GetMapping("/")
  public String signup(Model model) {
    model.addAttribute("user", new User());
    return "index";
  }
}
