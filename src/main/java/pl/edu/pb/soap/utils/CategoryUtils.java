package pl.edu.pb.soap.utils;

import pl.edu.pb.soap.restModel.Category;

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
                .sorted(Comparator.comparingInt(x -> x.getPosition()))
                .collect(Collectors.toList());
        return  result;
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
