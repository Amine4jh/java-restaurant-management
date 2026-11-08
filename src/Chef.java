import java.util.List;

public class Chef extends User{

    Chef(String name, int userId, String password, String role) {
        super(name, userId, password, role);
    }

    @Override
    void showInfo() {
        System.out.print("User ID: " + getUserId() + "\n");
        System.out.print("Name: " + getName() + "\n");
        System.out.print("Name: " + getRole() + "\n");
    }

    void viewOrders () {
        List<Order> ordersList = RestaurantData.orders;
        System.out.print("----------\n");
        for (Order currentOrder : ordersList) {
            currentOrder.showOrder();
        }
        System.out.print("----------\n");
        System.out.print("Total orders: " + ordersList.size() + "\n");
    }

    void updateOrderStatus (Order order, String status) {
        order.setStatus(status);
    }
}
