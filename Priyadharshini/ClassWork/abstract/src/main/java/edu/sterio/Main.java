package edu.sterio;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
       public static void main(String[] args) {
              SmartPhone iphone = new SmartPhone();
              iphone.Makecall("9877898989");
              iphone.Playmusic("erathalae");
              iphone.Playgame("gta");

              Padphone phone = new Padphone();
              phone.Makecall("9090990909");
              phone.Playmusic("8jhhh");
              phone.Playgame("snake");
       }
}