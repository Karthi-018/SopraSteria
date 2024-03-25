package edu.training.ProductServices1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodResponse {
    private Integer foodId;
    private String foodName;
    private String foodDesc;
    private BigDecimal foodPrice;
    private Integer foodQuant;

}
