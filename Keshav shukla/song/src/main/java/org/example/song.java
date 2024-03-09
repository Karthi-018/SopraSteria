package org.example;

import java.sql.Time;
import java.util.Date;
import java.util.Timer;

public class song implements Comparable<song> {
    private String title;
    private String genre;
    private long duration;
    private Double rating;

    public song() {
    }

    public song(String title, String genre,long duration, Double rating) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "song{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                ", rating=" + rating +
                '}';
    }

    @Override
    public int compareTo(song o) {
        return 0;
    }
//    static song createSong(String line){
//
//    }
}
