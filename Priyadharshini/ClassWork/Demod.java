package edu.steria.trap;
public class Demod
{
static public String r1="priya";
static private String r2="sri";
static String r3="pavi";
static protected String  r4="danush";
public static void main(String[]args)
{
  
  System.out.println(r1);
  System.out.println(r2);
  System.out.println(r3);
  System.out.println(r4);
  Demod2.main(args);
  Demod3.main(args);
}
}

class Demod2
{
 public static void main(String[]args)
{
 System.out.println(Demod.r1);
 //System.out.println(r2);
 System.out.println(Demod.r3);
 System.out.println(Demod.r4);
}
}
class Demod3 extends Demod
{
 public static void main(String[]args)
{
 System.out.println(r1);
 //System.out.println(r2);
 System.out.println(r3);
 System.out.println(r4);
}
}
