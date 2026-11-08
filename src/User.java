public abstract class User {
    private String name;
    private int userId;
    private String password;
    private String role;

    User(String name, int userId, String password, String role) {
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.role = role;
    }

    // --- SETTERS ---

    void setName (String name) {
        this.name = name;
    }

    void setUserId (int userId) {
        this.userId = userId;
    }

    void setPassword (String password) {
        this.password = password;
    }

    void setRole (String role) {
        this.role = role;
    }

    // --- GETTERS ---

    String getName () {
        return this.name;
    }

    int getUserId () {
        return this.userId;
    }

    String getPassword () {
        return this.password;
    }

    String getRole () {
        return this.role;
    }

    // --- Other class methods ---

    abstract void showInfo (); // ABSTRACT METHOD

    String editPassword (String currentPassword, String newPassword) {
        if (currentPassword == this.password) {
            this.password = newPassword;
            return "Password changed successfully!";
        }
        return "Your current password is wrong!";
    }
}
