package pl.edu.pb.soap.utils;

import pl.edu.pb.soap.restModel.Category;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mateusz on 01.05.2017.
 */
public class CategoryUtils {
    public static List<Category> getCategoriesByParent(int parentId, List<Category> allCategories){
        List<Category> result = allCategories
                .stream()
                .filter(cat -> cat.getParentId() == parentId)
                .sorted(Comparator.comparing(x -> x.getName()))
                .collect(Collectors.toList());
        return  result;
    }

    public static List<Category> getCategoriesBySybling(int syblingId, List<Category> allCategories){
        for(Category catt : allCategories){
            if(catt.getId() == syblingId){
                return  getCategoriesByParent(catt.getParentId(),allCategories);
            }
        }
        return Collections.emptyList();
    }

    public static List<Category> getTopLevelCategories(List<Category> allCategories){
        return getCategoriesByParent(0, allCategories);
    }

    public static String paddDate(int date){
        if(date<10){
            return "0"+date;
        }
        return date+"";
    }
}
