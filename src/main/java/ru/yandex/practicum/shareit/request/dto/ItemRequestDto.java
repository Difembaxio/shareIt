package ru.yandex.practicum.shareit.request.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import ru.yandex.practicum.shareit.user.model.User;

import java.time.LocalDateTime;

@Builder
@Data
public class ItemRequestDto {
    @Positive(message = "Request id должен быть положительным")
    private Long id;
    @NotBlank(message = "Описание не должно быть пустым")
    private String description;
    private User requester;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime created;
}