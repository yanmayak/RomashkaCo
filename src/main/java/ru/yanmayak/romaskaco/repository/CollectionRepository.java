package ru.yanmayak.romaskaco.repository;

import ru.yanmayak.romaskaco.dto.ProductDto;
import ru.yanmayak.romaskaco.exception.FieldValidationException;
import ru.yanmayak.romaskaco.exception.ProductNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

@Component
@Slf4j
public class CollectionRepository implements ProductRepository {
    private final HashMap<UUID, ProductDto> products = new HashMap<>();
    private UUID id = UUID.randomUUID();

    @Override
    public Collection<ProductDto> getAll() {
        log.info("Получение списка всех товаров");
        if (products.isEmpty()) {
            throw new ProductNotFoundException("Товар не найден.");
        } else {
            return products.values();
        }
    }

    @Override
    public ProductDto getById(UUID id) {
        log.info("Получение товара с заданным UUID");
        if (!products.containsKey(id)) {
            throw new ProductNotFoundException("Товар не найден.");
        } else {
            return products.get(id);
        }
    }

    @Override
    public ProductDto create(ProductDto productDto) {
        log.info("Создание нового товара");
        if (productDto.getProductPrice() == null) {
            productDto.setProductPrice(0.0);
        }
        if (productDto.getIsInStock() == null) {
            productDto.setIsInStock(false);
        }
        productDto.setId(UUID.randomUUID());
        products.put(productDto.getId(), productDto);
        return productDto;
    }

    @Override
    public ProductDto update(UUID id, ProductDto productDto) {
        log.info("Обновление информации о товаре");
        if (!products.containsKey(id)) {
            throw new ProductNotFoundException("Товар не найден.");
        } else {
            ProductDto oldProductDto = products.get(id);
            if (productDto.getProductName() != null) {
                oldProductDto.setProductName(productDto.getProductName());
            }
            if (productDto.getProductDescription() != null) {
                oldProductDto.setProductDescription(productDto.getProductDescription());
            }
            if (productDto.getProductPrice() != null) {
                oldProductDto.setProductPrice(productDto.getProductPrice());
            }
            if (productDto.getIsInStock() != null) {
                oldProductDto.setIsInStock(productDto.getIsInStock());
            }
            validateProductFields(oldProductDto);
            products.replace(id, oldProductDto);
            return oldProductDto;
        }
    }

    @Override
    public void delete(UUID id) {
        log.info("Удаление товара");
        if (!products.containsKey(id)) {
            throw new ProductNotFoundException("Товар не найден.");
        } else {
            products.remove(id);
        }
    }

    private void validateProductFields(ProductDto productDto) {
        if (productDto.getProductName() == null) {
            throw new FieldValidationException("Название товара не может быть пустым.");
        }
        if (productDto.getProductName().length() > 255) {
            throw new FieldValidationException("Название товара не может быть длиннее 255 символов.");
        }
        if (productDto.getProductDescription().length() > 4096) {
            throw new FieldValidationException("Описание товара не может быть длиннее 4096 символов.");
        } else if (productDto.getProductPrice() < 0) {
            throw new FieldValidationException("Цена товара не может быть отрицательной.");
        }
    }
}
