package sopra.edu.training.SpringDataJPA.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sopra.edu.training.SpringDataJPA.models.Customer;
import sopra.edu.training.SpringDataJPA.models.Product;
import sopra.edu.training.SpringDataJPA.models.admin;
import sopra.edu.training.SpringDataJPA.repositories.AdminRepo;
import sopra.edu.training.SpringDataJPA.repositories.CustomerRepo;
import sopra.edu.training.SpringDataJPA.repositories.ProductRepo;

@Service
public class AdminService {
	@Autowired
	ProductRepo repo;
	
	@Autowired
	CustomerRepo repo1;
	
	@Autowired
	AdminRepo repo2;
	public boolean adminLogin(String uname , String passw) {
		admin A = repo2.findByUname(uname);
		return A.getPassw().equals(passw);
	}
	
	public boolean addproduct(int pid,String pname,String pdesc,int pquant,int pprice) {
		if(pquant<=0 || pprice<=0) {
			return false;
		}
		
		Product p = new Product(pid,pname,pdesc,pquant,pprice);
		repo.save(p);
		return true;
	}
	public Product searchProduct(int pid) {
		return repo.findBypId(pid);
	}
	
	public List<Product> viewProducts(){
		return (List<Product>)repo.findAll();
	}
	
	public void deleteProduct(int pid) {
		repo.deleteById(pid);
	}
	
	public boolean editProduct(int pid,int pquant,int pprice) {
		if(pquant<0 || pprice<=0) {
			return false;
		}
		Product p = repo.findBypId(pid);
		p.setProductQuant(pquant);
		p.setProductPrice(pprice);
		repo.save(p);
		return true;
	}
	
	public List<String> Newuser(){
   	 List<Customer> list = repo1.findByaccess("New");
   	 List<String> list1 = new ArrayList<>();
   	 for(Customer c:list) {
   		 list1.add(c.getUserEmail());
   	 }
   	 return list1;
    }
    
    public List<String> Accept(){
   	 List<Customer> list = repo1.findByaccess("accept");
   	 List<String> list1 = new ArrayList<>();
   	 for(Customer c:list) {
   		 list1.add(c.getUserEmail());
   	 }
   	 return list1;
    }
    
    public List<String> Deny(){
   	 List<Customer> list = repo1.findByaccess("deny");
   	 List<String> list1 = new ArrayList<>();
   	 for(Customer c:list) {
   		 list1.add(c.getUserEmail());
   	 }
   	 return list1;
    }
    
    public void  approve(String email) {
    	 Customer c = repo1.findByUserEmail(email);
    	 c.setAccess("accept");
    	 repo1.save(c);
    }
    public void  disapprove(String email) {
   	 Customer c = repo1.findByUserEmail(email);
   	 c.setAccess("deny");
   	 repo1.save(c);
   }
    
}

