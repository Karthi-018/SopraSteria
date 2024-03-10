package edu.steria;
import java.util.*;
class Dem
{
//    static final Dem d=new Dem();
    String name="ABC";
    private Dem(String name)
    {
        this.name=name;
    }
    void show()
    {
        System.out.println(name);
    }
    static Dem get (String name)//factory method
   {
    return new Dem(name);
    }
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
           Dem d=Dem.get("xyz");
           d.show();
    }
}