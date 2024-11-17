package ru.yanmayak.romaskaco.service;

import ru.yanmayak.romaskaco.dto.ProductDto;
import java.util.Collection;
import java.util.UUID;

public interface ProductService {
    public Collection<ProductDto> getAllProducts();
    public ProductDto getProductById(UUID id);
    public ProductDto createProduct(ProductDto productDto);
    public ProductDto updateProduct(UUID id, ProductDto productDto);
    public void deleteProduct(UUID id);
}
