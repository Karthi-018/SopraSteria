package edu.training.ems;

public class ProductService {
    static  Product products[] = new Product[4];
    static int i=0;
    public void addProduct(Product product)
    {
        products[i]=product;
        i++;
    }
    public void listProducts()
    {
       for (Product product : products)
           System.out.println(product);
    }
    public void editProduct(String pName,double price)
    {
        for(Product product : products)
        {
            if(pName.equals(product.getProductName()))
            {
                System.out.println(product);
                product.setProductPrice(price);
                System.out.println(product);
            }
        }
    }
    public void searchProduct(String pName)
    {
        for(Product product : products)
        {
            if(pName.equals(product.getProductName()))
            {
                System.out.println(product);
            }
        }
    }
}
