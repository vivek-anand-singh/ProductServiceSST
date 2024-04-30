package com.sst.productservicesst.Services;

import com.sst.productservicesst.Exceptions.CategoryNotFoundException;
import com.sst.productservicesst.Exceptions.ProductNotFoundException;
import com.sst.productservicesst.Models.Category;
import com.sst.productservicesst.Models.Product;
import com.sst.productservicesst.Repositories.CategoryRepository;
import com.sst.productservicesst.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("SelfProductService")
public class SelfProductService implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    SelfProductService(ProductRepository productRepository,CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct =  productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException(id,"Product Not Found");
        }
        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();
        if (category.getId() == null) {
            product.setCategory(categoryRepository.save(category));
        }
        Product product1 = productRepository.save(product);
        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());
        product1.setCategory(optionalCategory.get());

        if(optionalCategory.isEmpty()){
            throw new CategoryNotFoundException(category.getId()+" ,Category Not Found");
        }
        return product1;
    }
}
