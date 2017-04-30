package pl.edu.pb.soap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.pb.soap.beans.AllegroSoapClient;
import pl.edu.pb.soap.model.LoginForm;

/**
 * Created by Mateusz on 26.04.2017.
 */
@Controller
public class HomeController {
    @Autowired
    AllegroSoapClient client;

    @Autowired
    Environment env;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String index(ModelMap map) {
        map.put("msg", "Hello Spring 4 Web MVC!" + env.getProperty("allegro.sandbox.key"));
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("loginFrom", new LoginForm());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String proccessLogin(@ModelAttribute LoginForm loginForm, Model model) {
        if (loginForm != null) {
            String session = client.login(loginForm.getUsername(), loginForm.getPassword());
            model.addAttribute("apiSession", session);
        }
        return "loginResult";
    }
}
