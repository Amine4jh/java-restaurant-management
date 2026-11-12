import java.util.List;

public class Auth {
    public static User login(int userId, String password) {
        for (List<User> usersList : RestaurantData.users.values()) {
            for (User user : usersList) {
                if (user.getUserId() == userId) {
                    if (user.getPassword().equals(password)) {
                        return user;
                    } else {
                        System.out.println("Password incorrect!");
                    }
                } else {
                    System.out.println("User not found. Please contact an admin to create your account!");
                }
            }
        }
        return null;
    }

    public static void logout() {
        return;
    }
}
