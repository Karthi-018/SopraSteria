import java.util.Scanner;

class Admin {

    static String[] productArray = new String[100];
    static Scanner sc = new Scanner(System.in);
    int lastProductIndex = -1;

    void addProduct() {
        System.out.print("Enter Product: ");
        String product = sc.nextLine();
        int i = lastProductIndex + 1;
        productArray[i] = product;
        System.out.println("New Product Added " + productArray[i]);
        lastProductIndex++;
    }

    void listProducts() {
        System.out.println("---");
        for (int i = 0; i < 100; i++) {
            if (productArray[i] == null) break;
            System.out.println(productArray[i]);
        }
        System.out.println("---");

    }

    void editProduct() {
        System.out.print("Enter Product: ");
        String product = sc.nextLine();
        System.out.print("Enter new Product: ");
        String newProduct = sc.nextLine();
        for (int i = 0; i < 100; i++) {
            if (productArray[i] == null) break;
            if (productArray[i].equals(product)) {
                productArray[i] = newProduct;
                return;
            }
        }
        System.out.println("Product Not Found");
    }

    void deleteProduct() {

        System.out.print("Enter Product: ");
        String product = sc.nextLine();
        int index = -1;
        for (int i = 0; i < 100; i++) {
            if (productArray[i] == null) break;
            if (productArray[i].equals(product)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Product Not Found");
        } else {
            if (index == 99) {
                productArray[index] = null;
                return;
            }
            for (int i = index; i < 99; i++) {
                if (productArray[i] == null) break;
                productArray[i] = productArray[i + 1];
            }
            System.out.println("Product Deleted");
        }

        lastProductIndex--;
    }

    static class Customer {
        void listProducts() {
            System.out.println("---");
            for (int i = 0; i < 100; i++) {
                if (productArray[i] == null) break;
                System.out.println(productArray[i]);
            }
            System.out.println("---");
        }

        void searchProduct() {
            System.out.print("Enter Product: ");
            String product = sc.nextLine();
            for (int i = 0; i < 100; i++) {
                if (productArray[i] == null) break;
                if (productArray[i].equals(product)) {
                    System.out.println("=====");

                    System.out.println(product + " is Present");
                    System.out.println("=====");

                    return;
                }
            }
            System.out.println("Product Not Found");


        }


    }


}


public class Main {
    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        Admin admin = new Admin();
        Admin.Customer customer = new Admin.Customer();
        while (true) {
            System.out.println("------------");

            System.out.println("1.Admin Login");
            System.out.println("2.Customer Login");
            System.out.println("------------");

            System.out.print("Enter your Choice: ");

            choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                String password;
                boolean access = false;
                for (int num = 5; num > 0; num--) {

                    System.out.print("Enter Password: ");
                    password = sc.nextLine();
                    System.out.println(password);
                    if (password.equals("Reset@123")) {
                        access = true;
                        break;
                    } else {
                        System.out.println("Wrong Password Try Again " + num + " Attemps Remaining");
                        access = false;
                    }
                }

                if (access) {
                    while (true) {
                        System.out.println("------------");

                        System.out.println("1.Add Product");
                        System.out.println("2.Edit Product");
                        System.out.println("3.List Product");
                        System.out.println("4.Delete Product");
                        System.out.println("5.Exit");
                        System.out.println("------------");

                        System.out.print("Enter your Choice: ");
                        int adminChoice = sc.nextInt();
                        if (adminChoice == 1) {
                            admin.addProduct();
                        } else if (adminChoice == 2) {
                            admin.editProduct();
                        } else if (adminChoice == 3) {
                            admin.listProducts();
                        } else if (adminChoice == 4) {
                            admin.deleteProduct();
                        } else if (adminChoice == 5) {
                            break;
                        } else {
                            System.out.println("Wrong entry");

                        }

                    }
                }

            } else if (choice == 2) {
                String password;
                boolean access = false;
                for (int num = 5; num > 0; num--) {

                    System.out.print("Enter Password: ");
                    password = sc.nextLine();
                    System.out.println(password);
                    if (password.equals("123")) {
                        access = true;
                        break;
                    } else {
                        System.out.println("Wrong Password Try Again " + (num - 1) + " Attemps Remaining");
                        access = false;
                    }
                }
                if (access) {
                    while (true) {
                        System.out.println("------------");
                        System.out.println("1.Search Product");
                        System.out.println("2.list Product");
                        System.out.println("3.Exit");
                        System.out.println("------------");

                        System.out.print("Enter your Choice: ");
                        int cusChoice = sc.nextInt();
                        if (cusChoice == 1) {
                            customer.searchProduct();
                        } else if (cusChoice == 2) {
                            customer.listProducts();
                        } else if (cusChoice == 3) {
                            break;
                        } else {
                            System.out.println("Wrong entry");

                        }

                    }

                }

            } else {

                System.out.println("Wrong entry");
            }


        }


    }


}