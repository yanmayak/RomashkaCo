package ru.yanmayak.romaskaco.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import ru.yanmayak.romaskaco.dto.ProductDto;
import ru.yanmayak.romaskaco.entity.Product;
import ru.yanmayak.romaskaco.repository.ProductRepository;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public abstract class ProductMapper {
    @Autowired
    private ProductRepository productRepository;

    public abstract ProductDto mapToProductDto(Product product);
    public abstract Product mapToProduct(ProductDto productDto);
}
