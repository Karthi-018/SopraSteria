package sopra.training;
import java.sql.*;
import java.util.Scanner;

public class ECommerceApp {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/admin";
    static final String USER = "root";
    static final String PASS = "jyoti";

    public static void main(String[] args) {
        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

            Scanner scanner = new Scanner(System.in);

                while (true) {
                    System.out.println("1. Admin Login\n2. User Sign Up\n3. User Login\n4. Exit");
                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            adminLogin(connection);
                            break;

                        case 2:
                            userSignUp(connection);
                            break;

                        case 3:
                            userLogin(connection);
                            break;

                        case 4:
                            System.exit(0);

                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private static void adminLogin(Connection connection) {
            Scanner scanner = new Scanner(System.in);
            boolean isAdminAuthenticated = false;

            System.out.print("Enter admin username: ");
            String adminUsername = scanner.nextLine();
            System.out.print("Enter admin password: ");
            String adminPassword = scanner.nextLine();


            if ("admin".equals(adminUsername) && "admin123".equals(adminPassword)) {
                isAdminAuthenticated = true;
            }

            if (isAdminAuthenticated) {
                while (true) {
                    System.out.println("\nAdmin Menu:");
                    System.out.println("1. Add Product\n2. Edit Product\n3. List Products\n4. Delete Product\n5. Logout");
                    int adminChoice = scanner.nextInt();

                    switch (adminChoice) {
                        case 1:
                            addProduct(connection);
                            break;

                        case 2:
                            editProduct(connection);
                            break;

                        case 3:
                            listProducts(connection);
                            break;

                        case 4:
                            deleteProduct(connection);
                            break;

                        case 5:
                            return;

                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                }
            } else {
                System.out.println("Admin authentication failed. Try again or exit.");
            }
        }

        private static void addProduct(Connection connection) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter product details:");
                System.out.println("Enter product id :");
                int productId = scanner.nextInt();
                System.out.print("Product Name: ");
                String productName = scanner.next();
                System.out.print("Price: ");
                double price = scanner.nextDouble();
                System.out.print("Quantity: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Description: ");
                String description = scanner.nextLine();

                // Insert product into the database
                String sql = "INSERT INTO product (pid,pname, price, quantity, description) VALUES (?,?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setInt(1, productId);
                    preparedStatement.setString(2, productName);
                    preparedStatement.setDouble(3, price);
                    preparedStatement.setInt(4, quantity);
                    preparedStatement.setString(5, description);

                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Product added successfully.");
                    } else {
                        System.out.println("Failed to add the product.");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        private static void editProduct(Connection connection) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter product ID to edit: ");
                int productId = scanner.nextInt();

                // Check if the product exists
                String checkProductQuery = "SELECT * FROM product WHERE pid = ?";
                try (PreparedStatement checkProductStatement = connection.prepareStatement(checkProductQuery)) {
                    checkProductStatement.setInt(1, productId);

                    try (ResultSet resultSet = checkProductStatement.executeQuery()) {
                        if (!resultSet.next()) {
                            System.out.println("Product not found.");
                            return;
                        }
                    }
                }

                System.out.print("Price: ");
                double price = scanner.nextDouble();
                System.out.print("Quantity: ");
                int quantity = scanner.nextInt();


                // Update product in the database
                String updateProductQuery = "UPDATE product SET price = ?, quantity = ? WHERE pid = ?";
                try (PreparedStatement updateProductStatement = connection.prepareStatement(updateProductQuery)) {

                    updateProductStatement.setDouble(2, price);
                    updateProductStatement.setInt(3, quantity);

                    updateProductStatement.setInt(5, productId);

                    int rowsAffected = updateProductStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Product updated successfully.");
                    } else {
                        System.out.println("Failed to update the product.");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private static void listProducts(Connection connection) {
            try {
                // Fetch and display the list of products from the database
                String sql = "SELECT * FROM product";
                try (Statement statement = connection.createStatement();
                     ResultSet resultSet = statement.executeQuery(sql)) {
                    System.out.println("\nProduct List:");
                    System.out.printf("%-5s %-20s %-10s %-10s %-50s%n", "ID", "Name", "Price", "Quantity", "Description");
                    while (resultSet.next()) {
                        int productId = resultSet.getInt("pid");
                        String productName = resultSet.getString("pname");
                        double price = resultSet.getDouble("price");
                        int quantity = resultSet.getInt("quantity");
                        String description = resultSet.getString("description");

                        System.out.printf("%-5d %-20s %-10.2f %-10d %-50s%n", productId, productName, price, quantity, description);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private static void deleteProduct(Connection connection) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter product ID to delete: ");
                int productId = scanner.nextInt();

                // Delete product from the database
                String sql = "DELETE FROM product WHERE pid = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setInt(1, productId);

                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Product deleted successfully.");
                    } else {
                        System.out.println("Product not found or failed to delete.");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private static void userSignUp(Connection connection) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("User Registration:");
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                // Check if the username is already taken
                String checkUsernameQuery = "SELECT * FROM users WHERE username = ?";
                try (PreparedStatement checkUsernameStatement = connection.prepareStatement(checkUsernameQuery)) {
                    checkUsernameStatement.setString(1, username);

                    try (ResultSet resultSet = checkUsernameStatement.executeQuery()) {
                        if (resultSet.next()) {
                            System.out.println("Username is already taken. Please choose another one.");
                            return;
                        }
                    }
                }

                String insertUserQuery = "INSERT INTO users (username, password) VALUES (?, ?)";
                try (PreparedStatement insertUserStatement = connection.prepareStatement(insertUserQuery)) {
                    insertUserStatement.setString(1, username);
                    insertUserStatement.setString(2, password);

                    int rowsAffected = insertUserStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("User registration successful.");
                    } else {
                        System.out.println("Failed to register user.");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private static void userLogin(Connection connection) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                // Authenticate the user
                String authenticateQuery = "SELECT * FROM users WHERE username = ? AND password = ?";
                try (PreparedStatement authenticateStatement = connection.prepareStatement(authenticateQuery)) {
                    authenticateStatement.setString(1, username);
                    authenticateStatement.setString(2, password);

                    try (ResultSet resultSet = authenticateStatement.executeQuery()) {
                        if (resultSet.next()) {
                            System.out.println("User login successful.");

                            System.out.println("\nWelcome:" + username);
                            boolean exitloop=false;
                            while(!exitloop) {
                                System.out.println("1. Search Products\n2. List Products\n3. Buy Products\n4. Logout");
                                int userChoice = scanner.nextInt();

                                switch (userChoice) {
                                    case 1:
                                        searchUserProduct(connection);
                                        break;

                                    case 2:
                                        listUserProducts(connection);
                                        break;

                                    case 3:
                                        buyUserProducts(connection);
                                        break;
                                    case 4:
                                        exitloop=true;
                                        break;
                                    default:
                                        System.out.println("Invalid choice. Please try again.");
                                        break;
                                }
                            }
                        } else {
                            System.out.println("Invalid username or password.");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }catch (SQLException e) {
                e.printStackTrace();
            }

        }
            private static void searchUserProduct(Connection connection){
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter product name to search: ");
                String productName = scanner.nextLine();

                // Search and display product details from the database
                String searchProductQuery = "SELECT * FROM product WHERE pname LIKE ?";
                try (PreparedStatement searchProductStatement = connection.prepareStatement(searchProductQuery)) {
                    searchProductStatement.setString(1, "%" + productName + "%");

                    try (ResultSet resultSet = searchProductStatement.executeQuery()) {
                        System.out.println("\nSearch Results:");
                        System.out.printf("%-5s %-20s %-10s %-10s %-50s%n", "ID", "Name", "Price", "Quantity", "Description");
                        while (resultSet.next()) {
                            int productId = resultSet.getInt("pid");
                            String productNameResult = resultSet.getString("pname");
                            double price = resultSet.getDouble("price");
                            int quantity = resultSet.getInt("quantity");
                            String description = resultSet.getString("description");

                            System.out.printf("%-5d %-20s %-10.2f %-10d %-50s%n", productId, productNameResult, price, quantity, description);
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            private static void buyUserProducts(Connection connection){
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter product name to buy: ");
                String productNam = scanner.next();

                // Fetch product details from the database
                String getProductQuery = "SELECT * FROM product WHERE pname = ?";
                try (PreparedStatement getProductStatement = connection.prepareStatement(getProductQuery)) {
                    getProductStatement.setString(1, productNam);

                    try (ResultSet resultSet = getProductStatement.executeQuery()) {
                        if (resultSet.next()) {
                            double price = resultSet.getDouble("price");
                            int quantityInStock = resultSet.getInt("quantity");
                            String Description=resultSet.getString("description");

                            System.out.printf("Product: %s\nPrice: %.2f\nProduct Description: %s\n", productNam, price, Description);

                            // Ask for quantity to buy
                            System.out.print("Enter quantity to buy: ");
                            int quantityToBuy = scanner.nextInt();

                            if (quantityToBuy > 0 && quantityToBuy <= quantityInStock) {
                                // Update quantity in the database
                                String updateQuantityQuery = "UPDATE product SET quantity = ? WHERE pname = ?";
                                try (PreparedStatement updateQuantityStatement = connection.prepareStatement(updateQuantityQuery)) {
                                    updateQuantityStatement.setInt(1, quantityInStock - quantityToBuy);
                                    updateQuantityStatement.setString(2, productNam);
                                    updateQuantityStatement.executeUpdate();

                                    // Display bill
                                    double totalAmount = price * quantityToBuy;
                                    System.out.printf("You have successfully purchased %d units of %s.\nTotal Amount: %.2f%n", quantityToBuy, productNam, totalAmount);
                                }
                            } else {
                                System.out.println("product out of stock.");
                            }
                        } else {
                            System.out.println("Product not found.");
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            private static void listUserProducts (Connection connection){
                try {
                    // Fetch and display the list of products from the database
                    String sql = "SELECT * FROM product";
                    try (Statement statement = connection.createStatement();
                         ResultSet resultSet = statement.executeQuery(sql)) {
                        System.out.println("\nProduct List:");
                        System.out.printf("%-5s %-20s %-10s %-50s%n", "ID", "Name", "Price", "Description");
                        while (resultSet.next()) {
                            int productId = resultSet.getInt("pid");
                            String productName = resultSet.getString("pname");
                            double price = resultSet.getDouble("price");
                            String description = resultSet.getString("description");

                            System.out.printf("%-5d %-20s %-10.2f %-50s%n", productId, productName, price, description);
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


