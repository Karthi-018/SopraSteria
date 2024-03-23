package edu.training.OrderServices1.dto;

import edu.training.OrderServices1.model.ProductDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {

    List<ProductDetailsDto> productDetailsDtoList;
}
