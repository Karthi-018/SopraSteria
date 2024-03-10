package org.example;

import java.util.*;


public class Main
{
    static List<Song> songs=new ArrayList<>();
    public static void createSong(String title, String genre, double duration,double rating)
    {
        Song sn=new Song(title,genre,duration,rating);
        songs.add(sn);
    }
    public static void durationsort()
    {
        songs.sort((d1,d2)->d1.getDuration()>d2.getDuration()?1:-1);
        for(Song sn:songs){
            System.out.println(sn);
        }
    }
    public static void ratingsort()
    {
        songs.sort((d1,d2)->d1.getRating()>d2.getRating()?1:-1);
        for(Song sn:songs){
            System.out.println(sn);
        }
    }
    public static void search(String title)
    {
        boolean flag = true;
        try{
            for(Song sn:songs)
            {
                if(title.equals(sn.getTitle()))
                {
                    System.out.println(sn);
                    flag =  false;
                }

            }
                if(flag)
                {
                    throw new SongNotFoundException("song Not Found");

                }
        }
        catch(SongNotFoundException e)
        {
            System.out.print("Song Not Found Exception: ");
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("1.Sort by duration\n 2.Sort by rating\n 3.Search by name");
        System.out.println("Enter your choice :");
        int choice=sc.nextInt();
        createSong("hello","life",4.56,4.3);
        createSong("dual","life",3.56,4.6);
        createSong("sarigama","soul",4.34,4.5);
        createSong("dhirana","music",4.54,4.7);
       if(choice==1)
       {
         durationsort();
       } else if (choice==2)
       {
        ratingsort();
       }
       else if (choice==3)
       {
           System.out.println("enter song name:");
           String name=sc.next();
           search(name);
       }

    }


}
