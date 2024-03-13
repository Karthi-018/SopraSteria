package edu.training.HibMappingDemo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Book.class);
    	Student s1 = new Student(101,"Siva",85);
    	Student s2 = new Student(102,"Yaazhini",77);
    	Student s3 = new Student(103,"Sivaazhini",80);
    	Student s4 = new Student(104,"Karthi",85);
    	Student s5 = new Student(105,"Pavi",82);
    	
    	Book b1 = new Book(1,"JAVA");
    	Book b2 = new Book(2,"Python");
    	Book b3 = new Book(3,"React");
    	Book b4 = new Book(4,"Angular");
    	Book b5 = new Book(5,"Flutter");
    	List<Book> blist = new ArrayList<Book>();
    	blist.add(b1);
    	blist.add(b2);
    	blist.add(b3);
    	
    	List<Student> slist = new ArrayList<Student>();
    	slist.add(s1);
    	slist.add(s5);
    	slist.add(s2);
    	
    	
    	s1.setBook(blist);
    	
    	b1.setStudent(slist);
    	
    	
    	SessionFactory sf = con.buildSessionFactory();
    	Session s = sf.openSession();
    	
    	
    	Transaction tx = s.beginTransaction();
    	
//    	s.save(s1);
//    	s.save(s2);
//    	s.save(s3);
//    	s.save(s4);
//    	s.save(s5);
//    	s.save(b1);
//    	s.save(b2);
//    	s.save(b3);
//    	s.save(b4);
//    	s.save(b5);
    	Student stu = (Student)s.get(Student.class, 101);
//    	System.out.println(stu.getsName());
    	
    	tx.commit();
    	s.close();
    	
    	Session session1 = sf.openSession();
    	Transaction tx1 = session1.beginTransaction();
    	Query q = session1.createQuery("from Student");
    	
    	List<Student> students = (List<Student>)q.list();
  
    	tx1.commit();
    	session1.close();
    	
    }
}
