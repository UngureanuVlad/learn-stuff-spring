package io.learnstuff.mvc.controller;

import java.util.Locale;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView login(Locale locale, Model model) {
    return new ModelAndView("home");

  }

  @RequestMapping(value = "/home", method = RequestMethod.GET)
  public ModelAndView viewStats(Map<String, Object> model) {
    return new ModelAndView("home");
  }
}
