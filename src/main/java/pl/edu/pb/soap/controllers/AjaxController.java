package pl.edu.pb.soap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pb.soap.beans.AllegroSoapClient;
import pl.edu.pb.soap.restModel.AddsContainer;
import pl.edu.pb.soap.restModel.Breadcrumb;
import pl.edu.pb.soap.restModel.Category;
import pl.edu.pb.soap.restModel.EndingInfo;
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

    @RequestMapping("/rest/categories/list/sybling")
    public List<Category> getCategoriesBySybling(@RequestParam("sybling") Integer sybling) {
        List<Category> result = allegro.getCategories();
        return CategoryUtils.getCategoriesBySybling(sybling, result);
    }

    @RequestMapping("/rest/categories/content")
    public AddsContainer getAdds(@RequestParam("category") Integer category, @RequestParam("size") Integer size, @RequestParam("offset") Integer offset) {
        return allegro.getAddsFromCategory(category, offset, size);
    }

    @RequestMapping("/rest/items/search")
    public AddsContainer search(@RequestParam("q") String query, @RequestParam("size") Integer size, @RequestParam("offset") Integer offset, @RequestParam("cat") Integer category) {
        return allegro.search(query, offset, size, category);
    }

    @RequestMapping(value = "/rest/navigation/breadcrumbs")
    public List<Breadcrumb> getBreadcrubms(Integer category) {
        return allegro.getPathTo(category);
    }

    @RequestMapping(value = "/rest/navigation/ending")
    public EndingInfo isEnding(Integer category) {
        List<Category> result = allegro.getCategories();
        boolean isEmpty = CategoryUtils.getCategoriesByParent(category, result).isEmpty();
        return new EndingInfo(isEmpty);
    }

    @RequestMapping("/rest/adds/my")
    public AddsContainer getMyAdds(@RequestParam("size") Integer size, @RequestParam("offset") Integer offset) {
        return allegro.getMyAdds(offset, size);
    }
}
