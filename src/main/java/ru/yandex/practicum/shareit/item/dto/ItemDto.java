package ru.yandex.practicum.shareit.item.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import ru.yandex.practicum.shareit.booking.dto.BookingResponseDto;
import ru.yandex.practicum.shareit.user.model.User;

import java.util.List;
@Data
@Builder
public class ItemDto {
    @Positive(message = "Item id должен быть положительным")
    private Long id;
    @NotBlank(message = "Наименование не должно быть пустым")
    private String name;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User owner;
    @NotBlank
    @Size(max = 512, message = "Описание не должно превышать 512 символов")
    private String description;
    @NotNull
    private Boolean available;
    private Long requestId;
    private BookingResponseDto lastBooking;
    private BookingResponseDto nextBooking;
    private List<CommentResponseDto> comments;
}