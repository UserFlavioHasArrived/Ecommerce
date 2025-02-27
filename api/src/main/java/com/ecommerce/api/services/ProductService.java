package com.ecommerce.api.services;

import com.ecommerce.api.dto.ProductDTO;
import com.ecommerce.api.entities.Product;
import com.ecommerce.api.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productsDTO = new ArrayList<>();
        for (Product product : products) {
            productsDTO.add(new ProductDTO(product.getName(), product.getPrice(), product.getDescription(), product.getImgUrl()));
        }
        return productsDTO;
    }
    
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        return new ProductDTO(product.getName(), product.getPrice(), product.getDescription(), product.getImgUrl());
    }

    @Transactional
    public ProductDTO create(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setImgUrl(productDTO.getImgUrl());
        product.setCategories(productDTO.getCategories());
        productRepository.save(product);
        return new ProductDTO(product.getName(), product.getPrice(), product.getDescription(), product.getImgUrl());
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO productDTO) {
        Product product = new Product();
        product.setId(id);
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setImgUrl(productDTO.getImgUrl());
        product.setCategories(productDTO.getCategories());
        productRepository.save(product);
        return new ProductDTO(product.getName(), product.getPrice(), product.getDescription(), product.getImgUrl());
    }

    public  ProductDTO delete(Long id) {
        productRepository.deleteById(id);
        return null;
    }
}

