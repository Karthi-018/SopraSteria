package org.example;

import java.util.Date;

class Song
{
   private String title;
   private String genre;
   private double duration;
   private double rating;

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

   public double getDuration() {
      return duration;
   }

   public void setDuration(double duration) {
      this.duration = duration;
   }

   public double getRating() {
      return rating;
   }

   public void setRating(double rating) {
      this.rating = rating;
   }

   public Song(String title, String genre, double duration, double rating) {
      this.title = title;
      this.genre = genre;
      this.duration = duration;
      this.rating = rating;
   }

   @Override
   public String toString() {
      return "Song{" +
              "title='" + title + '\'' +
              ", genre='" + genre + '\'' +
              ", duration=" + duration +
              ", rating=" + rating +
              '}';
   }

}
