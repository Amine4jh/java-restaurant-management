public class Waiter extends User {

    Waiter(String name, int userID, String password) {
        super(name, userID, password);
    }

    @Override
    void showInfo() {
        System.out.println("User ID: " + this.userId);
        System.out.println("Name: " + this.name);
    }

    void reserve(Object reservation) {

    }
}
