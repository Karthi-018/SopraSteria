package edu.training.OrderServices1.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {
    private List<ProductDetailsDto> productDetailsDtoList;
    private Date productDeliverDate = new Date(2024,03,25);
}
