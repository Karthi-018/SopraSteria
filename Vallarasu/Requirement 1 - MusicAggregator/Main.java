package MusicAggregator;

import java.util.*;

public class Main {
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        Song s=new Song();

        List<Song> songList=new ArrayList<>();
        songList.add(s.createSong("Perfect,love,4.23,9.9"));
        songList.add(s.createSong("OrdinaryPerson,Calm,2.54,8.1"));
        songList.add(s.createSong("AmIDreaming,Peace,4.16,8.6"));
        songList.add(s.createSong("rasputin,Rock,5.16,8.2"));
        songList.add(s.createSong("Copines,Love,2.57,8"));
        int n=1;
        while(n!=0)
        {
            System.out.println("**************Music Aggregator**********");
            System.out.println("1. Sort based on duration");
            System.out.println("2. Sort based on rating");
            System.out.println("3. Search Song");
            System.out.println("4. Exit");
            switch(in.nextInt())
            {
                case 1:
                    Collections.sort(songList, (s1, s2) -> s1.getDuration().compareTo(s2.getDuration()));
                    for(Song i: songList)
                    {
                        System.out.println(i);
                    }
                    System.out.println("\n");                    break;
                case 2:
                    Collections.sort(songList, (s1, s2) -> s1.getRating().compareTo(s2.getRating()));
                    for(Song i: songList)
                    {
                        System.out.println(i);
                    }
                    System.out.println("\n");
                    break;
                case 3:
                    System.out.println("\nEnter the Song Name to Search\n");
                    String songName=in.next();
                    int temp=0;
                    for(Song i: songList)
                    {
                        if(i.getTitle().equalsIgnoreCase(songName)) {
                            System.out.format("%-20s %-10s %.2f Minutes \t %-12s\n",
                                    i.getTitle(), i.getGenre(), i.getDuration(), i.getRating());
                            temp++;
                        }
                    }
                    if(temp==0)
                        System.out.println("The Song is Not Available");
                    System.out.println("\n");
                    break;
                case 4:
                    n=0;
                    break;
            }

        }
    }
}
