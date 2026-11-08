import java.util.ArrayList;
import java.util.List;

public class Order {
    protected int orderId;
    protected Reservation reservation;
    protected List<Menu> menuItems;
    protected String status;

    Order(int orderId, Reservation reservation, String status) {
        this.orderId = orderId;
        this.reservation = reservation;
        this.menuItems = new ArrayList<>();
        this.status = status;
    }

    // --- SETTERS ---

    void setOrderId (int orderId) {
        this.orderId = orderId;
    }

    void setReservation (Reservation reservation) {
        this.reservation = reservation;
    }

    void setMenuItems (List<Menu> menuItems) {
        this.menuItems = menuItems;
    }

    void setStatus (String status) {
        this.status = status;
    }

    // --- GETTERS ---

    int getOrderId () {
        return this.orderId;
    }

     Reservation getReservation () {
        return this.reservation;
    }

    List<Menu> getMenuItems () {
        return this.menuItems;
    }

     String getStatus () {
        return this.status;
    }

    // Other class methods

    void addMenuItem (Menu menuItem) {
        menuItems.add(menuItem);
        System.out.println("Item has been added successfully to order " + this.orderId);
    }

    void showOrder () {
        System.out.println("Order ID: " + this.orderId + ", Reservation ID: " + this.reservation.reservationId + ", Total Items: " + this.menuItems.size() + ", Status: " + this.status);
    }

    double calculateTotal () {
        double total = 0;
        for (Menu menuItem : this.menuItems) {
            total += menuItem.price;
        }

        return total;
    }
}
