package ru.yanmayak.romaskaco.service;

import ru.yanmayak.romaskaco.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import ru.yanmayak.romaskaco.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service("Products")
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Collection<ProductDto> getAllProducts() {
        return productRepository.getAll();
    }

    public ProductDto getProductById(UUID id) {
        return productRepository.getById(id);
    }

    public ProductDto createProduct(ProductDto productDto) {
        return productRepository.create(productDto);
    }

    public ProductDto updateProduct(UUID id, ProductDto productDto) {
        return productRepository.update(id, productDto);
    }

    public void deleteProduct(UUID id) {
        productRepository.delete(id);
    }
}
