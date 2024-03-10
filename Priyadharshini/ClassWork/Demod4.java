package edu.steria.emp;
import edu.steria.trap.Demod;
class Demod4
{
 public static void main(String[]args)
{

 System.out.println(Demod.r1);
//System.out.println(r2);
//System.out.println(r3);
 //System.out.println(Demod.r4);
 Demod5.main(args);
}
}
class Demod5 extends Demod4
{
 public static void main(String[]args)
{

 System.out.println(Demod.r1);
//System.out.println(r2);
//System.out.println(r3);
 //System.out.println(r4);
}
}