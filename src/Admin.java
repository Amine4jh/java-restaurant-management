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

            for (User currentUser : listOfUsers) {
                if (currentUser.getUserId() == user.getUserId()) {
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

    void manageMenuItems (String action, Menu menuItem) {
        if (action.equals("add")) {
            List<Menu> listOfMenuItems = RestaurantData.menu;

            for (Menu currentMenuItem : listOfMenuItems) {
                if (currentMenuItem.itemId == menuItem.itemId) {
                    System.out.println("Menu item is already exist!");
                    return;
                }
            }

            listOfMenuItems.add(menuItem);
            System.out.println("Menu item has been added successfully!");
        } else if (action.equals("delete")) {
            List<Menu> listOfMenuItems = RestaurantData.menu;

            if (listOfMenuItems != null) {
                boolean removed = listOfMenuItems.remove(menuItem);
                if (removed) {
                    System.out.println("Menu item has been deleted successfully!");
                } else {
                    System.out.println("Menu item not found!");
                }
            }
        } else if (action.equals("edit")) {
            Scanner sc = new Scanner(System.in);
            String[] newLineInputs = {"----------", "What to edit?", "1. Name", "2. Description", "3. Price", "4. Category", "----------"};
            inputHandler(newLineInputs, "Choose a number (1,2, 3 or 4):");
            int chosenOption = sc.nextInt();
            sc.nextLine();

            if (chosenOption == 1) {
                System.out.print("Enter the new name: ");
                menuItem.setName(sc.nextLine().trim());
                System.out.println("Menu item name has modified successfully!");
            } else if (chosenOption == 2) {
                System.out.print("Enter the new description: ");
                menuItem.setDescription(sc.nextLine().trim());
                System.out.println("Menu item description has modified successfully!");
            } else if (chosenOption == 3) {
                System.out.print("Enter the new price: ");
                menuItem.setPrice(sc.nextDouble());
                sc.nextLine();
                System.out.println("Menu item price has modified successfully!");
            } else if (chosenOption == 4) {
                System.out.print("Enter the new category: ");
                menuItem.setCategory(sc.nextLine().trim());
                System.out.println("Menu item category has modified successfully!");
            } else {
                System.out.println("Wrong action!");
            }
        } else {
            System.out.println("Wrong action!");
        }
    }
}
