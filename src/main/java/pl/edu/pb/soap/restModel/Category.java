package pl.edu.pb.soap.restModel;

/**
 * Created by Mateusz on 01.05.2017.
 */
public class Category {
    private int id;
    private int parentId;
    private String name;
    private int position;

    public Category(int id, int parentId, String name, int position) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
