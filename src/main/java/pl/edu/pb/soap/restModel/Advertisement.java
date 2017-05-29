package pl.edu.pb.soap.restModel;

/**
 * Created by Mateusz on 04.05.2017.
 */
public class Advertisement {
    long id;
    String title;
    String price;
    String priceBidding;
    String priceWithDelivery;
    String lastTime;
    String state;
    String endDate;
    String imageUrl;
    String owner;
    String description;
    long category;

    public Advertisement() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public String getPriceWithDelivery() {
        return priceWithDelivery;
    }

    public void setPriceWithDelivery(String priceWithDelivery) {
        this.priceWithDelivery = priceWithDelivery;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public long getCategory() {
        return category;
    }

    public void setCategory(long category) {
        this.category = category;
    }

    public String getPriceBidding() {
        return priceBidding;
    }

    public void setPriceBidding(String priceBidding) {
        this.priceBidding = priceBidding;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
