package emp.sopra;

import java.util.*;

public class Main {
    static String[] products = new String[99];
    static int productsAvailable = 0;

    static Scanner scanner = new Scanner(System.in);

    static void addProduct() {
        System.out.print("Enter the name of the product to add: ");
        products[productsAvailable] = scanner.next();
        productsAvailable++;
        System.out.println("Product added successfully.");
    }

    static void editProduct() {
        int editFlag = 0;
        System.out.print("Enter the product name to edit: ");
        String editProduct = scanner.next();
        for (int i = 0; i < productsAvailable; i++) {
            if (products[i].equals(editProduct)) {
                System.out.print("Enter the new name for the product: ");
                products[i] = scanner.next();
                editFlag = 1;
                System.out.println("Product edited successfully.");
            }
        }
        if (editFlag == 0) {
            System.out.println("Product not found for editing.");
        }
    }

    static void viewProduct() {
        if (productsAvailable != 0) {
            System.out.println("List of available products:");
            for (int i = 0; i < productsAvailable; i++) {
                System.out.println(products[i]);
            }
        } else {
            System.out.println("No products are available.");
        }
    }

    static void deleteProduct() {
        int deleteFlag = 0, k = -1;
        System.out.print("Enter the product name to delete: ");
        String deleteProduct = scanner.next();
        for (int i = 0; i < productsAvailable; i++) {
            if (products[i].equals(deleteProduct)) {
                deleteFlag = 1;
                k = i;
                break;
            }
        }
        if (deleteFlag == 0) {
            System.out.println("Product not found for deletion.");
            return;
        }
        for (int i = k; i < productsAvailable - 1; i++) {
            products[i] = products[i + 1];
        }
        System.out.println("Product deleted successfully.");
        productsAvailable--;
    }

    static void searchProduct() {
        System.out.print("Enter the product name to search: ");
        String productName = scanner.next();
        for (int i = 0; i < productsAvailable; i++) {
            if (products[i].equals(productName)) {
                System.out.println("Product found.If you want to search again search for a difefrent product or same product. ");
                return;
            }
        }
        System.out.println("Product not found. Search with correct product name.");
    }


    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1.Admin\n2.Customer\n3.Exit");
            System.out.print(" Please Select user type: ");
            int option;
            try {
                option = scanner.nextInt();
                if (option < 1 || option > 3) {
                    System.out.println("Invalid option. Please select 1, 2, or 3.");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                scanner.next(); // Clear the invalid input
                continue;
            }

            if (option == 3) {
                System.out.println("Exiting the program.");
                break;
            }

            System.out.print("Enter username: ");
            String username = scanner.next();
            System.out.print("Enter password: ");
            String password = scanner.next();

            int operation;

            if (option == 1) {
                if (username.equals("Admin") && password.equals("Dinesh")) {
                    System.out.println("\nOperations:");
                    System.out.println("1.Add Product");
                    System.out.println("2.Edit Product");
                    System.out.println("3.View Products");
                    System.out.println("4.Delete Product");
                    System.out.println("5.Exit");

                    while (true) {
                        System.out.print("Select operation in the given list : ");
                        try {
                            operation = scanner.nextInt();
                            if (operation < 1 || operation > 5) {
                                System.out.println("Invalid operation. Please select 1, 2, 3, 4, or 5.");
                                continue;
                            }
                        } catch (InputMismatchException ex) {
                            System.out.println("Invalid input. Please enter a number (1, 2, 3, 4, or 5).");
                            scanner.next(); // Clear the invalid input
                            continue;
                        }

                        if (operation == 1)
                            addProduct();
                        else if (operation == 2)
                            editProduct();
                        else if (operation == 3)
                            viewProduct();
                        else if (operation == 4)
                            deleteProduct();
                        else {
                            System.out.println("Admin session ended.");
                            break;
                        }
                    }
                } else
                    System.out.println("Invalid credentials.");
            } else if (option == 2) {
                if (username.equals("user") && password.equals("password")) {
                    System.out.println("\nOperations:");
                    System.out.println("1.View Products");
                    System.out.println("2.Search Product");
                    System.out.println("3.Exit");

                    while (true) {
                        System.out.print("Select operation in the given list: ");
                        try {
                            operation = scanner.nextInt();
                            if (operation < 1 || operation > 3) {
                                System.out.println("Invalid operation. Please select 1, 2, or 3.");
                                continue;
                            }
                        } catch (InputMismatchException ex) {
                            System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                            scanner.next(); // Clear the invalid input
                            continue;
                        }

                        if (operation == 1)
                            viewProduct();
                        else if (operation == 2)
                            searchProduct();
                        else {
                            System.out.println("Customer session ended.");
                            break;
                        }
                    }
                } else
                    System.out.println("Invalid credentials.");
            }
        }
    }
}