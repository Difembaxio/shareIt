package ru.yandex.practicum.shareit.item;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemDto {
    private Long id;
    @NotBlank(message = "Название не можеть быть пустым")
    private String name;
    @Size(max = 500,message = "Описание  может максимум 500 символов")
    private String description;
    @NotNull
    private Boolean available;

    private Long ownerId;

    private Long requestId;
}
