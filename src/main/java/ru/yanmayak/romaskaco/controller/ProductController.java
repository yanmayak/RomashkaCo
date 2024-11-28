package ru.yanmayak.romaskaco.controller;

import ru.yanmayak.romaskaco.dto.ProductDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yanmayak.romaskaco.service.ProductService;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
@Tag(name = "Товары")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    @Operation(summary = "Получение списка всех товаров")
    public ResponseEntity<Collection<ProductDto>> getProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{product-id}")
    @Operation(summary = "Получение информации о товаре")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("product-id") UUID productId) {
        return ResponseEntity.ok(productService.getProductById(productId));
    }

    @PostMapping
    @Operation(summary = "Создание карточки товара")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.createProduct(productDto));
    }

    @PutMapping("/{product-id}")
    @Operation(summary = "Обновление информации о товаре")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("product-id") UUID productId, @Valid @RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.updateProduct(productId, productDto));
    }

    @DeleteMapping("/{product-id}")
    @Operation(summary = "Удаление информации о товаре")
    public void deleteProduct(@PathVariable("product-id") UUID productId) {
        productService.deleteProduct(productId);
    }
}
