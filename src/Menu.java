public class Menu {
    protected int itemId;
    protected String name;
    protected String description;
    protected double price;
    protected String category;

    Menu(int itemId, String name, String description, double price, String category) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    // --- SETTERS ---

    void setItemId (int itemId) {
        this.itemId = itemId;
    }

    void setName (String name) {
        this.name = name;
    }

    void setDescription (String description) {
        this.description = description;
    }

    void setPrice (double price) {
        this.price = price;
    }

    void setCategory (String category) {
        this.category = category;
    }

    // --- GETTERS ---

    int getItemId () {
        return this.itemId;
    }

    String getName () {
        return this.name;
    }

    String getDescription () {
        return this.description;
    }

    double getPrice () {
        return this.price;
    }

    String getCategory () {
        return this.category;
    }

    // Other class methods

    void showItem () {
        System.out.println("Item ID: " + this.itemId + ", Name: " + this.name + ", Description: " + this.description + ", Price: " + this.price + ", Category: " + this.category);
    }
}
