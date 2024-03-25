package edu.training.OrderServices1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FoodDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer foodDetailsId;
    private String foodName;
    private Integer foodPrice;

}
