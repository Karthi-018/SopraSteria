package edu.sopra.training.SpringBootMVC.services;

import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import edu.sopra.training.SpringBootMVC.model.product;
import edu.sopra.training.SpringBootMVC.respositories.ProductRepository;


@Service
public class Create {
	
	private static final Logger LOG= LoggerFactory.getLogger(Create.class);
	@Autowired
	ProductRepository repo;
	
	public void addProduct(String pname,String pdesc,int pprice,int qty,Blob pImg) {
		
	
		
		LOG.info("In add product");
		product p= new product();
		p.setPname(pname);
		p.setPdesc(pdesc);
		p.setPprice(pprice);
		p.setQty(qty);
//		p.setImgpath(pImg);
		repo.save(p);
		
		
//		LOG.info("After ADDING THE PRODUCT");
	}
	
	public List<product> listProduct(){
		
		List<product> list= new ArrayList<>();
		
		list=(List<product>) repo.findAll();
		
		
		return list;
	}
	
	public void deleteProduct(int pid) {
		
		repo.deleteById(pid);
	}
	
	public product editProduct(int pid) {
		
		return repo.findBypid(pid);
		
	}
	
	public String updateProduct(int pid,int pprice,int qty) {
		
		if(qty>0 && pprice>0) {
			product p= repo.findBypid(pid);
			p.setPprice(pprice);
			p.setQty(qty);
			repo.save(p);
			return "Product details is updated";
		}
		
		else {
			return "Product details can't be updated";
		}
	}
	
	public product search(int pid) {
		
		return repo.findBypid(pid);
	}
	
	public product searchProduct(product p) {
		
		product pro= repo.findBypid(p.getPid());
		
		return pro;
	}
	

}
