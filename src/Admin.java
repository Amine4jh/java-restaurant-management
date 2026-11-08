import java.util.List;
import java.util.Scanner;

public class Admin extends User{

    Admin(String name, int userId, String password, String role) {
        super(name, userId, password, role);
    }

    @Override
    void showInfo() {
        System.out.print("User ID: " + getUserId() + "\n");
        System.out.print("Name: " + getName() + "\n");
        System.out.print("Name: " + getRole() + "\n");
    }

    // Helper for user input
    static void inputHandler (String[] newLineOutputs, String lastLineOutput) {
        for (String newLineOutput : newLineOutputs) {
            System.out.println(newLineOutput);
        }
        System.out.print(lastLineOutput + " ");
    }

    void manageUsers(String action, User user){
        if (action.equals("add")) {
            List<User> listOfUsers = RestaurantData.users.get(user.getRole() + "s");

            if (listOfUsers == null) {
                System.out.println("ERROR: The given role " + user.getRole() + " is not valid!");
                return;
            }

            for (User searchedUser : listOfUsers) {
                if (searchedUser.getUserId() == user.getUserId()) {
                    System.out.println("User is already added previously!");
                    return;
                }
            }

            listOfUsers.add(user);
            System.out.println(user.getName() + " has been added successfully as " + user.getRole());
        } else if (action.equals("delete")) {
            List<User> listOfUsers = RestaurantData.users.get(user.getRole());

            if (listOfUsers != null) {
                boolean removed = listOfUsers.remove(user);
                if (removed) {
                    System.out.println(user.getName() + " has been deleted successfully!");
                }else {
                    System.out.println("User not found!");
                }
            }
        } else if (action.equals("edit")) {
            Scanner sc = new Scanner(System.in);
            String[] newLineInputs = {"----------", "What to edit?", "1. Name", "2. Password", "3. Role", "----------"};
            inputHandler(newLineInputs, "Choose a number (1,2 or 3):");
            int chosenOption = sc.nextInt();
            sc.nextLine();

            if (chosenOption == 1) {
                System.out.print("Enter the new name: ");
                user.setName(sc.nextLine().trim());
                System.out.println(user.getName() + " has modified successfully!");
            } else if (chosenOption == 2) {
                System.out.print("Enter the new password: ");
                user.setPassword(sc.nextLine().trim());
                System.out.println(user.getName() + " has modified successfully!");
            } else if (chosenOption == 3) {
                System.out.print("Choose one of those roles (Admin, Waiter, Chef) : ");
                user.setRole(sc.nextLine().trim());
                System.out.println(user.getName() + " has modified successfully!");
            } else {
                System.out.println("Wrong action!");
            }
        } else {
            System.out.println("Wrong action!");
        }
    }
}
