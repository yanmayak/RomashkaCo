package ru.yanmayak.romaskaco.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yanmayak.romaskaco.dto.ProductDto;
import ru.yanmayak.romaskaco.entity.Product;
import ru.yanmayak.romaskaco.exception.ProductNotFoundException;
import ru.yanmayak.romaskaco.mapper.ProductMapper;
import ru.yanmayak.romaskaco.repository.ProductRepository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(
                        productMapper::mapToProductDto
                )
                .collect(
                        Collectors.toList()
                );
    }

    @Override
    public ProductDto getProductById(UUID id) {
        return productMapper.mapToProductDto(
                productRepository.findById(id)
                        .orElseThrow(() -> new ProductNotFoundException("Товар не найден"))
        );
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        return productMapper.mapToProductDto(
                productRepository.save(
                        productMapper.mapToProduct(
                                productDto
                        )
                )
        );
    }

    @Override
    public ProductDto updateProduct(UUID id, ProductDto productDto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Товар не найден"));

        if (productDto.getProductName() != null) {
            product.setProductName(productDto.getProductName());
        }
        if (productDto.getProductDescription() != null) {
            product.setProductDescription(productDto.getProductDescription());
        }
        if (productDto.getProductPrice() != 0) {
            product.setProductPrice(productDto.getProductPrice());
        }
        if (productDto.getIsInStock() != null) {
            product.setIsInStock(productDto.getIsInStock());
        }

        return productMapper.mapToProductDto(productRepository.save(product));
    }

    @Override
    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }


}
