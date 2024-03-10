package trainee;
import java.util.*;


    class User {
        private String username;
        private String password;
        private String userType;

        public User(String username, String password, String userType) {
            this.username = username;
            this.password = password;
            this.userType = userType;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public String getUserType() {
            return userType;
        }
    }

    class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }

    public class Main{
        private static User admin = new User("admin", "admin123", "admin");
        private static User customer = new User("customer", "customer123", "customer");
        private static Product[] products = new Product[10];
        private static int productCount = 0;

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome to the Product Management System!");

            User loggedInUser = login(scanner);

            if (loggedInUser != null) {
                if (loggedInUser.getUserType().equals("admin")) {
                    adminActions(scanner);}
                else if (loggedInUser.getUserType().equals("customer")) {
                    customeractions(scanner);}
            } else {
                System.out.println("Invalid username or password. Exiting...");
            }
        }

        private static User login(Scanner scanner) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
                return admin;
            } else if (username.equals(customer.getUsername()) && password.equals(customer.getPassword())) {
                return customer;
            } else {
                return null;
            }
        }

        private static void adminActions(Scanner scanner) {
            while (true) {
                System.out.println("\nAdmin Menu:");
                System.out.println("1. Add Product");
                System.out.println("2. Edit Product");
                System.out.println("3. Delete Product");
                System.out.println("4. View Product");
                System.out.println("5. Logout");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addProduct(scanner);
                        break;
                    case 2:
                        editProduct(scanner);
                        break;
                    case 3:
                        deleteProduct(scanner);
                        break;
                    case 4:
                        viewProducts(scanner);
                        break;
                    case 5:
                        System.out.println("Logging out...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }

        public static void customeractions(Scanner scanner) {
            System.out.println("welcome customer");
            viewProducts(scanner);
            
        }

        private static void addProduct(Scanner scanner) {
            System.out.print("Enter product name: ");
            String name = scanner.nextLine();
            System.out.print("Enter product price: ");
            double price = scanner.nextDouble();

            products[productCount++] = new Product(name, price);
            System.out.println("Product added successfully!");
        }

        private static void editProduct(Scanner scanner) {
            System.out.print("Enter product name to edit: ");
            String name = scanner.nextLine();

            for (int i = 0; i < productCount; i++) {
                if (products[i].getName().equalsIgnoreCase(name)) {
                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    products[i] = new Product(name, newPrice);
                    System.out.println("Product edited successfully!");
                    return;
                }
            }

            System.out.println("Product not found.");
        }

        private static void deleteProduct(Scanner scanner) {
            System.out.print("Enter product name to delete: ");
            String name = scanner.nextLine();

            for (int i = 0; i < productCount; i++) {
                if (products[i].getName().equalsIgnoreCase(name)) {
                    for (int j = i; j < productCount - 1; j++) {
                        products[j] = products[j + 1];
                    }
                    productCount--;
                    System.out.println("Product deleted successfully!");
                    return;
                }
            }

            System.out.println("Product not found.");
        }

        private static void viewProducts(Scanner scanner) {
            System.out.println("\nProducts:");
            for (int i = 0; i < productCount; i++) {
                System.out.println((i + 1) + ". " + products[i].getName() + " - $" + products[i].getPrice());
            }
        }
    }
