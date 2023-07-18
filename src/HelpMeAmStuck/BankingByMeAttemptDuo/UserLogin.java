package HelpMeAmStuck.BankingByMeAttemptDuo;

public class UserLogin {
    private Database database;

    public UserLogin(Database database) {
        this.database = database;
    }

    public boolean loginUser(String username, String password) {
        // Write code to check if the username and password match any user in the "users" table
        // Use database.createStatement() to execute SQL statements
        // Return true if login is successful, false otherwise
        return false;
    }
}

