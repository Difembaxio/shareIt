package ru.yandex.practicum.shareit.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private Long id;
    @NotBlank(groups = AddUserValidation.class, message = "Имя не может быть пустым")
    private String name;
    @NotNull(groups = AddUserValidation.class)
    @Email(groups = {AddUserValidation.class, UpdateUserValidation.class}, message = "Некорректный email")
    private String email;
}