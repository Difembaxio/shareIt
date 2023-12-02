package ru.yandex.practicum.shareit.user.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import ru.yandex.practicum.shareit.user.model.User;

public class UserMapper {

    public static UserDto toUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();

    }
    public static User toUser(UserDto userDto) {
        return User.builder()
                 .id(userDto.getId())
                 .name(userDto.getName())
                 .email(userDto.getEmail())
                 .build();
    }
    public static List<UserDto> toListUsersDto(Collection<User> users) {
        List<UserDto> usersDto = new ArrayList<>();
        for (User user : users) {
            usersDto.add(toUserDto(user));
        }
        return usersDto;
    }
}