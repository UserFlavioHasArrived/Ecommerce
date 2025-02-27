package com.ecommerce.api.entities;

import com.ecommerce.api.dto.CategoryDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data //getters and setters and constructor
@Entity
@Table(name = "tb_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    private Double price;
    private String imgUrl;

    @ManyToMany
    @JoinTable(
            name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();

    public void setCategories( List<CategoryDTO> categories) {
        this.categories.clear();
        for (CategoryDTO categoryDTO : categories) {
            Category category = new Category();
            category.setName(categoryDTO.getName());
            this.categories.add(category);
        }
    }
}
