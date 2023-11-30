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
    @NotBlank(groups = AddItemValidation.class, message = "Название не может быть пустым")
    private String name;
    @Size(groups = {AddItemValidation.class, UpdateItemValidation.class},
            max = 1000, message = "Максимальная длина описания — 1000 символов")
    @NotNull(groups = AddItemValidation.class)
    private String description;
    private Long ownerId;
    @NotNull(groups = AddItemValidation.class)
    private Boolean available;
    private Long requestId;
}