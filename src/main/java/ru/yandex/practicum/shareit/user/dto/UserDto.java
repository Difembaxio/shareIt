package ru.yandex.practicum.shareit.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import ru.yandex.practicum.shareit.util.Create;
import ru.yandex.practicum.shareit.util.Update;

@Data
@Builder
public class UserDto {
    private Long id;
    @NotBlank(groups = Create.class, message = "Имя не может быть пустым")
    private String name;
    @Email(groups = {Create.class, Update.class})
    @NotEmpty(groups = Create.class, message = "Почта не должна быть пустой")
    private String email;
}