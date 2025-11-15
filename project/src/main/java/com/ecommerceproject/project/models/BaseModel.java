package com.ecommerceproject.project.models;

import java.util.Date;

import lombok.Data;

@Data
public class BaseModel {
    private Long id;
    private Date createdAt;
    private  Date updatedAt;
}
