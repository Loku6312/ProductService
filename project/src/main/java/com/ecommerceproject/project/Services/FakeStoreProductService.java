package com.ecommerceproject.project.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ecommerceproject.project.DTOS.fakeStoreProductDto;
import com.ecommerceproject.project.models.Category;
import com.ecommerceproject.project.models.Product;

@Service
@Primary
public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    @Override
    public List<Product> getAllProducts() {
        ResponseEntity<fakeStoreProductDto[]> responseEntity=restTemplate.getForEntity("https://fakestoreapi.com/products",fakeStoreProductDto[].class);
        fakeStoreProductDto[] fakeStoreProductDtos=responseEntity.getBody();
        List<Product> products=new ArrayList<>();
        for(fakeStoreProductDto dto:fakeStoreProductDtos){
            products.add(convertFakeStoreDtoToProduct(dto));
        }
        return products;
    }

    @Override
    public Product getSinglProduct(Long productId) {

        
        //make a http call to fakeStore api to get the product with the given id
        ResponseEntity<fakeStoreProductDto> responseEntity=restTemplate.getForEntity("https://fakestoreapi.com/products/"+productId,fakeStoreProductDto.class);
        fakeStoreProductDto fakeProductDto=responseEntity.getBody();
        Product product=new Product();
        product.setTitle(fakeProductDto.getTitle());
        product.setDescription(fakeProductDto.getDescription());
        product.setPrice(fakeProductDto.getPrice());
        product.setImageUrl(fakeProductDto.getImageUrl());
        Category category=new Category();
        category.setTitle(fakeProductDto.getCategory());
        product.setCategory(category);
        product.setId(productId);
        return product;

        //throw new UnsupportedOperationException("Unimplemented method 'getSinglProduct'");
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        return null;
    }
    private Product convertFakeStoreDtoToProduct(fakeStoreProductDto dto){
        if(dto==null){
            return null;
        }
        Product product=new Product();
        product.setTitle(dto.getTitle());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setImageUrl(dto.getImageUrl());
        Category category=new Category();
        category.setTitle(dto.getCategory());
        product.setCategory(category);
        product.setId(dto.getId());
        return product;
    }
    
}
