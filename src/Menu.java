public class Menu {
    int itemId;
    String name;
    String description;
    double price;
    String category;

    Menu(int itemId, String name, String description, double price, String category) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    void showItem () {
        System.out.println("Item ID: " + this.itemId + ", Name: " + this.name + ", Description: " + this.description + ", Price: " + this.price + ", Category: " + this.category);
    }
}
