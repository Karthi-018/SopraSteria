package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main{
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        song s1 = new song("dopal", "romantic", 10, 9.666);
        song s2 = new song("meramehboob", "emotional", 5, 9.866);
        song s3 = new song("aidilhaimushkil", "emotional", 2, 10.000);

        List<song> song1 = new ArrayList<>();
        song1.add(s1);
        song1.add(s2);
//        System.out.println(song1);
        while (true) {
            System.out.println("enter 1 to sort the song list based on duration\n" +
                    "enter 2 to sort the song list based on rating\n" +
                    "enter 3 to search the song name from list\n");
            int res=sc.nextInt();
            switch (res){
                case 1:
                    for (int i = 0; i < song1.size()-1; i++) {
                        Collections.sort(song1, (song2, song3) -> song2.getDuration()>song3.getDuration()?1:-1);
                    }
                      System.out.println(song1);

                       break;
                case 2:
                       Collections.sort(song1, (song2, song3) -> song2.getRating().compareTo(song3.getRating()));
                        System.out.println(song1);

                        break;
                case 3:
                  System.out.println("enter the title of the song which you want to search");
                  String sear=sc.next();
                  boolean flag=false;
                  try {
                      for (int i = 0; i < song1.size(); i++) {
                          if (song1.get(i).getTitle().equals(sear)) {
                              System.out.println(song1.get(i));
                              flag=true;
                              break;
                          }
                      }
                      if(flag== false){
                          throw new songexception("song not found");
                      }
                  }
                  catch( songexception e){
                      System.out.print("Song Not Found Exception: ");
                      System.out.println(e.getMessage());
                      }
                      break;
                      default:
                          System.out.println("enter the correct value");
                          break;


                  }
            }
    }


}
