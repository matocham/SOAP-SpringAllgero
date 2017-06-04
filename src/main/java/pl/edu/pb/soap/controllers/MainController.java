package pl.edu.pb.soap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.edu.pb.soap.beans.AllegroSoapClient;
import pl.edu.pb.soap.model.AddItemResult;
import pl.edu.pb.soap.restModel.Advertisement;

import java.io.IOException;

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

    @RequestMapping(value = "/add/my", method = RequestMethod.GET)
    public String getMyAdds() {
        return "myAdds";
    }

    @RequestMapping(value = "/item/add", method = RequestMethod.GET)
    public String addItem() {
        return "addItem";
    }

    @RequestMapping(value = "/item/add", method = RequestMethod.POST)
    public String addItemFrom(Model model, @RequestParam("title") String title, @RequestParam("description") String description,
                              @RequestParam("leftCategory") int category, @RequestParam("price") double price,
                              @RequestParam("shippingPrice") double shippingPrice, @RequestParam("image") MultipartFile image,
                              @RequestParam("deliveryType") int deliveryType) throws IOException {
        title = new String(title.getBytes("ISO-8859-1"), "UTF-8");
        description = new String(description.getBytes("ISO-8859-1"), "UTF-8");
        AddItemResult result = client.createNewAdd(title, description, price, shippingPrice, category, deliveryType, image);
        model.addAttribute("result", result);
        if (result.getMessageId() == -1) {
            return "errorPage";
        } else {
            return "successPage";
        }
    }
}
