package edu.training.OrderServices1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDetailsDto {
    private String productName;
    private Integer productQuant;
    private Integer productPrice;
}
