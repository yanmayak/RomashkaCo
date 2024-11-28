package ru.yanmayak.romaskaco.repository;

import ru.yanmayak.romaskaco.dto.ProductDto;

import java.util.Collection;
import java.util.UUID;

public interface ProductRepository {
    Collection<ProductDto> getAll();
    ProductDto getById(UUID id);
    ProductDto create(ProductDto productDto);
    ProductDto update(UUID id, ProductDto productDto);
    void delete(UUID id);
}
