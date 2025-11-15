package com.ecommerceproject.project.DTOS;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class fakeStoreProductDto {
    private Long id;
    private String Title;
    private String description;
    private Double price;
    private String imageUrl;
    private String Category;
}
