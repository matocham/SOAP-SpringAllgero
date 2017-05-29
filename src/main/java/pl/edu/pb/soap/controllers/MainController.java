package pl.edu.pb.soap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.pb.soap.beans.AllegroSoapClient;
import pl.edu.pb.soap.restModel.Advertisement;

/**
 * Created by Mateusz on 26.04.2017.
 */
@Controller
public class MainController {
    @Autowired
    AllegroSoapClient client;

    @Autowired
    Environment env;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String index(ModelMap map) {
        map.put("msg", "Hello Spring 4 Web MVC!" + env.getProperty("allegro.sandbox.key"));
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage() {
        return "index";
    }

    @RequestMapping(value = "/categories/show", method = RequestMethod.GET)
    public String showCategory() {
        return "category";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchForItems() {
        return "search";
    }

    @RequestMapping(value = "/adds/show", method = RequestMethod.GET)
    public String getItemDetails(Model model, @RequestParam("add") long id) {
        Advertisement add = client.getAdd(id);
        model.addAttribute("add", add);
        return "showItem";
    }

    @RequestMapping(value = "/item/add", method = RequestMethod.GET)
    public String addItem() {
        return "addItem";
    }
}
