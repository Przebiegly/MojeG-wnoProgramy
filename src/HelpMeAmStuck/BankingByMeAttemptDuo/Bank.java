package HelpMeAmStuck.BankingByMeAttemptDuo;

import java.util.Scanner;

public class Bank {
    private static Scanner scanner = new Scanner(System.in);
    private Database database = new Database();

    public void registerUser() {
        System.out.println("User Registration");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        User user = new User(0, username, password, email);
        database.registerUser(user);
    }

    public void loginUser() {
        System.out.println("User Login");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = database.loginUser(username, password);
        if (user != null) {
            System.out.println("Login successful. Welcome, " + user.getUsername() + "!");
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    public static void BankingIGuess() {
        Bank bank = new Bank();

        // User registration
        bank.registerUser();

        // User login
        bank.loginUser();
    }
}
