package edu.training.inventoryservice.service;

import edu.training.inventoryservice.dto.InventoryResponce;
import edu.training.inventoryservice.model.Inventory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class InventoryService {

    List<Inventory> inventoryList = new ArrayList<>(Arrays.asList(new Inventory(1,"aaa",5),new Inventory(2,"bbb",2),new Inventory(3,"ccc",0)));



    public String checkProductStock(String productName)
    {
        String msg=null;
            for(Inventory product : inventoryList )
            {
                if(product.getProductName().equals(productName))
                {
                    if(product.getProductQty()>0)
                    {
                        msg="Oder Placed Succesffully";
                        InventoryResponce.builder()
                                .productName(product.getProductName())
                                .productStatus(true)
                                .build();
                    }
                    else {
                        msg="Product Out of Stock";
                    }
                }
            }

            return msg;
    }
}
