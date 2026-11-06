public class Admin extends User{

    Admin(String name, int userId, String password) {
        super(name, userId, password);
    }

    @Override
    void showInfo() {
        System.out.println("User ID: " + this.userId);
        System.out.println("Name: " + this.name);
    }

//    String manageUsers(String action, Object user){
//        if (action == "add") {
//            return user.name + " has added successfully!";
//        } else if (action == "delete") {
//            return user.name + " has deleted successfully!";
//        } else if (action == "edit") {
//            return user.name + " has modified successfully!";
//        } else {
//           return "Action Wrong";
//        }
//    }
}
