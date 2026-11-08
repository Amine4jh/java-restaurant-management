import java.util.List;

public class Waiter extends User {

    Waiter(String name, int userID, String password, String role) {
        super(name, userID, password, role);
    }

    @Override
    void showInfo() {
        System.out.print("User ID: " + getUserId() + "\n");
        System.out.print("Name: " + getName() + "\n");
        System.out.print("Role: " + getRole() + "\n");
    }

    void createReservation(Reservation reservation) {
        RestaurantData.reservations.add(reservation);
        System.out.println("New reservation has been created successfully!");
    }

    void createOrder(Order order) {
        RestaurantData.orders.add(order);
        System.out.println("New order has been created successfully!");
    }

    void generateBill(Order order) {
        Bill newBill = new Bill(RestaurantData.bills.getLast().billId + 1, order, order.calculateTotal(), 20, 5, 0);
        double total = newBill.calculateTotal();
        newBill.setTotal(total);

        RestaurantData.bills.add(newBill);
        System.out.println("New bill has been generated successfully!");
    }

    void viewReservations() {
        List<Reservation> reservationsList = RestaurantData.reservations;
        System.out.print("----------\n");
        for (Reservation currentRes : reservationsList) {
            currentRes.showInfo();
        }
        System.out.print("----------\n");
        System.out.print("Total reservations: " + reservationsList.size() + "\n");
    }

    void viewOrders() {
        List<Order> ordersList = RestaurantData.orders;
        System.out.print("----------\n");
        for (Order currentOrder : ordersList) {
            currentOrder.showOrder();
        }
        System.out.print("----------\n");
        System.out.print("Total orders: " + ordersList.size() + "\n");
    }
}
