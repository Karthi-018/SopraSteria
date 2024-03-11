package edu.sopra.employment;
import java.util.Scanner;

public class EmploymentManagementSystem {
    private static final int MAX_EMPLOYEES = 100; // Maximum number of employees
    private static Emp[] employees = new Emp[MAX_EMPLOYEES];
    private static int totalEmployees = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Employee\n2. View Employees\n3. Edit Employee\n4. Search Employee\n5. Delete Employee\n6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    editEmployee();
                    break;
                case 4:
                    searchEmployee();
                    break;
                case 5:
                    deleteEmployee();
                    break;
                case 6:
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addEmployee() {
        if (totalEmployees < MAX_EMPLOYEES) {
            System.out.print("Enter employee name: ");
            String name = scanner.next();
            System.out.print("Enter employee ID: ");
            int id = scanner.nextInt();
            System.out.print("Enter employee position: ");
            String position = scanner.next();

            Emp employee = new Emp(name, id, position);
            employees[totalEmployees++] = employee;
            System.out.println("Employee added successfully!");
        } else {
            System.out.println("Maximum number of employees reached. Cannot add more.");
        }
    }

    private static void viewEmployees() {
        System.out.println("Employee Details:");
        for (int i = 0; i < totalEmployees; i++) {
            System.out.println("Name: " + employees[i].name + ", ID: " + employees[i].id + ", Position: " + employees[i].position);
        }
    }

    private static void editEmployee() {
        System.out.print("Enter the ID of the employee to edit: ");
        int searchId = scanner.nextInt();

        for (int i = 0; i < totalEmployees; i++) {
            if (employees[i].id == searchId) {
                System.out.print("Enter new name: ");
                employees[i].name = scanner.next();
                System.out.print("Enter new position: ");
                employees[i].position = scanner.next();
                System.out.println("Employee details updated successfully!");
                return;
            }
        }

        System.out.println("Employee not found with ID: " + searchId);
    }

    private static void searchEmployee() {
        System.out.print("Enter the ID of the employee to search: ");
        int searchId = scanner.nextInt();

        for (int i = 0; i < totalEmployees; i++) {
            if (employees[i].id == searchId) {
                System.out.println("Employee Details - Name: " + employees[i].name + ", ID: " + employees[i].id + ", Position: " + employees[i].position);
                return;
            }
        }

        System.out.println("Employee not found with ID: " + searchId);
    }

    private static void deleteEmployee() {
        System.out.print("Enter the ID of the employee to delete: ");
        int searchId = scanner.nextInt();

        for (int i = 0; i < totalEmployees; i++) {
            if (employees[i].id == searchId) {
                // Shift remaining elements to fill the gap
                for (int j = i; j < totalEmployees - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                totalEmployees--;
                System.out.println("Employee deleted successfully!");
                return;
            }
        }

        System.out.println("Employee not found with ID: " + searchId);
    }
}
