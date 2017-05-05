package pl.edu.pb.soap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pb.soap.beans.AllegroSoapClient;
import pl.edu.pb.soap.restModel.AddsContainer;
import pl.edu.pb.soap.restModel.Category;
import pl.edu.pb.soap.utils.CategoryUtils;

import java.util.List;

/**
 * Created by Mateusz on 01.05.2017.
 */
@RestController
public class AjaxController {
    @Autowired
    AllegroSoapClient allegro;

    @RequestMapping("/rest/categories/list")
    public List<Category> getCategories(@RequestParam("parent") Integer parent) {
        List<Category> result = allegro.getCategories();
        return CategoryUtils.getCategoriesByParent(parent, result);
    }

    @RequestMapping("/rest/categories/content")
    public AddsContainer getAdds(@RequestParam("category") Integer category, @RequestParam("size") Integer size, @RequestParam("offset") Integer offset) {
        return allegro.getAddsFromCategory(category, offset, size);
    }

    @RequestMapping(value = "/rest/adds/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getAddImage(Integer addId) {
        return null;
    }
}