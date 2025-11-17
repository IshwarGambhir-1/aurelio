package com.yash.shopapp.productservice.serviceImpl;

import com.yash.shopapp.productservice.entity.Product;
import com.yash.shopapp.productservice.repository.ProductRepository;
import com.yash.shopapp.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private RestTemplate restTemplate;

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<CategoryDTO> getAllCategoriesFromCategoryService() {
        String url = "http://localhost:8080/api/categories";
        try {
            ResponseEntity<CategoryDTO[]> response = restTemplate.getForEntity(url, CategoryDTO[].class);
            return Arrays.asList(response.getBody());
        } catch (RestClientException e) {
            throw new RuntimeException("Failed to fetch categories from CategoryService", e);
        }
    }
    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    }

    @Override
    public Product updateProduct(Long id, Product updatedProduct) {
        Product product = getProductById(id);
        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());
        product.setDescription(updatedProduct.getDescription());
        product.setRating(updatedProduct.getRating());

        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);

    }
}
