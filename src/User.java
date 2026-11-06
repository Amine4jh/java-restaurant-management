public abstract class User {
    String name;
    int userId;
    String password;

    User(String name, int userId, String password) {
        this.name = name;
        this.userId = userId;
        this.password = password;
    }

    abstract void showInfo (); // ABSTRACT METHOD

    String editPassword (String currentPassword, String newPassword) {
        if (currentPassword == this.password) {
            this.password = newPassword;
            return "Password changed successfully!";
        }
        return "Your current password is wrong!";
    }
}
