package edu.steria;
import java.util.*;
public class Admin {
    protected static String[] stringArray = new String[20];
     int k = 0;

    void addproduct(String name) {
        stringArray[k++] = name;
        System.out.println("The phone is added");
    }


    void editproduct(String edit1, String update) {
        boolean updated = false;
        for (int i = 0; i < k; i++) {
            if (stringArray[i].equals(edit1)) {
                stringArray[i] = update;
                updated = true;
                break;
            }
        }
        if (updated) {
            System.out.println("The new value is updated");
        } else {
            System.out.println("The value you searched for is not found");
        }

    }

    void listproduct() {
        for (int i = 0; i < k; i++) {
            System.out.println(stringArray[i]);
        }
    }

    void deleteproduct(String del) {
        int flag = 0;
        for (int i = 0; i < k; i++) {
            if (stringArray[i].equals(del)) {
                flag = 1;
                stringArray[i] = stringArray[i + 1];
                k--;
            }
        }
        if (flag == 1) {
            System.out.println("The value is deleted");
            for (int i = 0; i < k; i++) {
                System.out.println(stringArray[i]);
            }
        } else {
            System.out.println("The value you searched for is not found");
        }

    }

}







