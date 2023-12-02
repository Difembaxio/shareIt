package ru.yandex.practicum.shareit.user.service;

import ru.yandex.practicum.shareit.user.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto updateUser(Long id, UserDto userDto);

    List<UserDto> readUsers();

    void deleteUser(Long id);

    UserDto getUserById(Long id);
}