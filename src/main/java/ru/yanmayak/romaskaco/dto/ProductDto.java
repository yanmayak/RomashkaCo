package ru.yanmayak.romaskaco.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@NoArgsConstructor
public class ProductDto {
    private UUID id;

    @Schema(description = "Название товара")
    @Size(min = 1, max = 255)
    @NotBlank
    private String productName;

    @Schema(description = "Описание товара")
    @Max(4096)
    private String productDescription;

    @Schema(description = "Цена товара")
    @Min(0)
    private Double productPrice;

    @Schema(description = "Наличие товара")
    private Boolean isInStock;

    public ProductDto(String productName, String productDescription, Double productPrice, Boolean isInStock) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.isInStock = isInStock;
    }
}
