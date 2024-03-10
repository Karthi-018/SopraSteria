package org.example;

import java.util.Scanner;

 class ECommerce {
    static String[] products = new String[50];
    static int lastIndex = 0;

    static Scanner scan = new Scanner(System.in);

    public void adminLogin() {
        System.out.println("Enter username:");
        String username = scan.nextLine();
        System.out.println("Enter password:");
        String password = scan.nextLine();

        if (!username.equals("admin") || !password.equals("Reset@123")) {
            System.out.println("Invalid username or password.");
            System.exit(0);
        } else {
            System.out.println("Login successful");
        }
    }

    public void customerLogin() {
        System.out.println("Enter username:");
        String username = scan.nextLine();
        System.out.println("Enter password:");
        String password = scan.nextLine();

        if (!password.equals("Reset@123")) {
            System.out.println("Invalid password.");
            System.exit(0);
        } else {
            System.out.println("Login successful");
        }
    }

    public void addProduct() {
        System.out.println("Enter product to add:");
        String product = scan.nextLine();
        products[lastIndex++] = product;
    }

    public void removeProduct() {
        System.out.println("Enter product to remove:");
        String product = scan.nextLine();
        boolean flag = false;
        for (int i = 0; i < lastIndex; i++) {
            if (products[i].equals(product)) {
                flag = true;
                while (i < lastIndex - 1) {
                    products[i] = products[i + 1];
                    i++;
                }
                lastIndex--;
            }
        }
        if (!flag) {
            System.out.println("Product not found");
        }
    }

    public void editProduct() {
        System.out.println("Enter product to edit:");
        String product = scan.nextLine();
        boolean flag = false;
        for (int i = 0; i < lastIndex; i++) {
            if (products[i].equals(product)) {
                System.out.println("Enter new product:");
                String newProduct = scan.nextLine();
                flag = true;
                products[i] = newProduct;
            }
        }
        if (!flag) {
            System.out.println("Product not found");
        }
    }

    public void displayProducts() {
        if (lastIndex == 0) {
            System.out.println("No products available");
        } else {
            System.out.println("PRODUCTS:");
            for (int i = 0; i < lastIndex; i++) {
                System.out.println(products[i]);
            }
        }
    }

    public void searchProduct() {
        System.out.println("Enter product to search:");
        String product = scan.nextLine();
        boolean flag = false;
        for (int i = 0; i < lastIndex; i++) {
            if (products[i].equals(product)) {
                flag = true;
                System.out.println("Product found");
                break;
            }
        }
        if (!flag) {
            System.out.println("Product not found");
        }
    }

    public static void main(String[] args) {

        int con = 0;

        do {
            System.out.println("Enter your choice:\n1.Admin\n2.Customer");
            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1: {
                    ECommerce admin = new ECommerce();
                    admin.adminLogin();
                    System.out.println("Enter number of products to Add:");
                    int n = scan.nextInt();
                    scan.nextLine();
                    for(int i=0;i<n;i++)
                    {
                        admin.addProduct();
                    }
                    admin.removeProduct();
                    admin.editProduct();
                    admin.displayProducts();
                    System.out.println("Enter 1 to continue, 0 to exit");
                    con = scan.nextInt();
                    scan.nextLine();
                    break;
                }

                case 2: {
                    ECommerce customer = new ECommerce();
                    customer.customerLogin();
                    customer.searchProduct();
                    customer.displayProducts();
                    System.out.println("Enter 1 to continue, 0 to exit");
                    con = scan.nextInt();
                    scan.nextLine();
                    break;
                }
                default:
                    System.out.println("Enter the right choice");
            }
        } while (con == 1);
    }
}