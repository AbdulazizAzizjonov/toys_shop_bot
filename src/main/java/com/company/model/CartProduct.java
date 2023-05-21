package com.company.model;

import com.company.model.Customer;
import com.company.model.Product;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class CartProduct {
    private Integer id;
    private Customer customer;
    private Product product;
    private Integer quantity;
}
