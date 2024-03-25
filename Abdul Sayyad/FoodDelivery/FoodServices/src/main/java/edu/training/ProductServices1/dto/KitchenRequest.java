package edu.training.ProductServices1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KitchenRequest {
    private String foodName;
    private Integer foodQuant;

}
