import java.util.Scanner;
import java.util.LinkedList;

class User {
    String username, password;
    
    User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

class LoginSystem {
    private final String adminUsername = "admin";
    private final String adminPassword = "admin123";
    private LinkedList<User> sellers = new LinkedList<>();
    private LinkedList<User> customers = new LinkedList<>();
    private Scanner scanner = new Scanner(System.in);

    public boolean loginAsAdmin() {
        System.out.println("    Admin Login    ");
        System.out.print("Enter admin username: ");
        String username = scanner.next();
        System.out.print("Enter admin password: ");
        String password = scanner.next();

        if (username.equals(adminUsername) && password.equals(adminPassword)) {
            System.out.println("Welcome Admin!");
            return true;
        } else {
            System.out.println("Invalid Admin Credentials!");
            return false;
        }
    }

    public boolean loginAsSeller() {
        System.out.println("    Seller Login    ");
        System.out.print("Enter seller username: ");
        String username = scanner.next();
        
        for (User seller : sellers) {
            if (seller.username.equals(username)) {
                System.out.print("Enter password: ");
                String password = scanner.next();
                if (seller.password.equals(password)) {
                    System.out.println("Welcome Seller " + username);
                    return true;
                } else {
                    System.out.println("Incorrect Password!");
                    return false;
                }
            }
        }
        System.out.println("Seller not found. Please register first.");
        return false;
    }

    public boolean loginAsCustomer() {
        System.out.println("    Customer Login    ");
        System.out.print("Enter customer username: ");
        String username = scanner.next();
        
        for (User customer : customers) {
            if (customer.username.equals(username)) {
                System.out.print("Enter password: ");
                String password = scanner.next();
                if (customer.password.equals(password)) {
                    System.out.println("Welcome Customer " + username);
                    return true;
                } else {
                    System.out.println("Incorrect Password!");
                    return false;
                }
            }
        }
        System.out.println("Customer not found. Please register first.");
        return false;
    }

    public void registerSeller() {
        System.out.println("    Seller Registration    ");
        System.out.print("Choose a username: ");
        String username = scanner.next();
        
        for (User seller : sellers) {
            if (seller.username.equals(username)) {
                System.out.println("Seller already exists!");
                return;
            }
        }
        
        System.out.print("Choose a password: ");
        String password = scanner.next();
        sellers.add(new User(username, password));
        System.out.println("Seller registered successfully.");
    }

    public void registerCustomer() {
        System.out.println("    Customer Registration    ");
        System.out.print("Choose a username: ");
        String username = scanner.next();
        
        for (User customer : customers) {
            if (customer.username.equals(username)) {
                System.out.println("Customer already exists!");
                return;
            }
        }
        
        System.out.print("Choose a password: ");
        String password = scanner.next();
        customers.add(new User(username, password));
        System.out.println("Customer registered successfully.");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LoginSystem loginSystem = new LoginSystem();
        
        int choice;
        do {
            System.out.println("\n Welcome to Login Window ");
            System.out.println("1. Admin Login");
            System.out.println("2. Seller Login");
            System.out.println("3. Customer Login");
            System.out.println("4. Seller Registration");
            System.out.println("5. Customer Registration");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    loginSystem.loginAsAdmin();
                    break;
                case 2:
                    loginSystem.loginAsSeller();
                    break;
                case 3:
                    loginSystem.loginAsCustomer();
                    break;
                case 4:
                    loginSystem.registerSeller();
                    break;
                case 5:
                    loginSystem.registerCustomer();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);
        
        scanner.close();
    }
}