package ru.yandex.practicum.shareit.user;

import java.util.List;

public interface UserService {

    List<UserDto> getAll();

    UserDto add(UserDto userDto);

    UserDto update(UserDto userDto);

    UserDto getUserById(Long id);

    void delete(Long id);
}