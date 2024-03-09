package edu.steria.train;

public class Main {
    public static void main(String[] args) {
        College c=new College();
        try {
            c.add();
            c.add();            c.add();
            c.sorting();
        }
        //"ABC College,www.abc.com,1234567890,John Doe,5,City A,1978-04-12"
        //"XYZ College,www.abc.com,1234567890,John Doe,4,City B,1979-07-12"
        //"DEF College,www.abc.com,1234567890,John Doe,3,City C,1978-09-11"
        catch (Exception e){
            System.out.println(e);
        }
    }
}
