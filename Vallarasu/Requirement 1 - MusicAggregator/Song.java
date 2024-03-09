package MusicAggregator;

import java.util.Date;

public class Song {
    private String title;
    private String genre;
    private Double duration;
    private Double rating;

    public Song (){}
    public Song(String title, String genre, Double duration, Double rating) {
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Song createSong(String line)
    {
        String s[]=line.split(",");
        String title=s[0];
        String genre=s[1];
        Double duration=Double.parseDouble(s[2]);
        Double rating=Double.parseDouble(s[3]);
        return new Song(title,genre,duration,rating);
    }

    @Override
    public String toString() {
        return "Song { " +
                "title = " + title + '\'' +
                ", genre = " + genre + '\'' +
                ", duration = " + duration +
                " Minutes , rating = " + rating +
                " }";
    }
}
