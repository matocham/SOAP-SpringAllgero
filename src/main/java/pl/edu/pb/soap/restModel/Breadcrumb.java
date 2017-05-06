package pl.edu.pb.soap.restModel;

/**
 * Created by Mateusz on 06.05.2017.
 */
public class Breadcrumb {
    String categoryName;
    int id;

    public Breadcrumb(String categoryName, int id) {
        this.categoryName = categoryName;
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
