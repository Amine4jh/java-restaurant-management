import java.util.List;

public class Admin extends User{

    Admin(String name, int userId, String password, String role) {
        super(name, userId, password, role);
    }

    @Override
    void showInfo() {
        System.out.println("User ID: " + this.userId);
        System.out.println("Name: " + this.name);
    }

    void manageUsers(String action, User user){
        if (action == "add") {
            try {
                List<User> listOfUsers = RestaurantData.users.get(user.role);
                // Check if the user added before
                if (listOfUsers != null && !listOfUsers.isEmpty()) {
                    for (User userToAdd : listOfUsers) {
                        if (userToAdd.userId == user.userId) {
                            System.out.println("User is already added previously!");
                            return;
                        }
                    }
                }
                listOfUsers.add(user);
                System.out.println(user.name + " has been added successfully as " + user.role);
            }
            catch (Exception e) {
                System.out.println("The given role isn't correct: " + e.getMessage());
            }
        } else if (action == "delete") {
            List<User> listOfUsers = RestaurantData.users.get(user.role);
            for (User targetUser : listOfUsers) {
                if (targetUser.userId == user.userId) {
                    listOfUsers.remove(targetUser);
                    System.out.println(user.name + " has been deleted successfully!");
                    return;
                }
            }
            System.out.println("There is no user with that name " + user.name);
        } else if (action == "edit") {
            System.out.println(user.name + " has modified successfully!");
        } else {
            System.out.println("Action Wrong");
        }
    }
}
