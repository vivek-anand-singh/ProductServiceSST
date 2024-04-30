package com.sst.productservicesst.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private Double price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Category category;
    private String image;

//    Product(Long id,String title,String description,Double price, Category category,String image){
//        this.id = id;
//        this.title = title;
//        //and so on
//        //we use @AllArgsConstructor
//    }

}