package edu.sterio;

public abstract class Phone1 {
    void Makecall(String phonenumber)
    {
        System.out.println("calling");
    }
    void Playmusic(String song)
        {
        System.out.println("Playing");
    }
    abstract void Playgame(String game);
}
