import java.util.ArrayList;
import java.util.List;

public class Order {
    int orderId;
    Reservation reservation;
    List<Menu> menuItems;
    String status;

    Order(int orderId, Reservation reservation, String status) {
        this.orderId = orderId;
        this.reservation = reservation;
        this.menuItems = new ArrayList<>();
        this.status = status;
    }

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
