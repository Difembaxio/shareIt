package ru.yandex.practicum.shareit.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserStorage userStorage;

    @Override
    public List<UserDto> getAll() {
        return userStorage.getAll().stream().map(UserMapper::toUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto add(UserDto userDto) {
        return UserMapper.toUserDto(userStorage.add(UserMapper.toUser(userDto)));
    }

    @Override
    public UserDto update(UserDto userDto) {
        UserDto oldUser = getUserById(userDto.getId());
        if (userDto.getName() == null) userDto.setName(oldUser.getName());
        if (userDto.getEmail() == null) userDto.setEmail(oldUser.getEmail());
        return UserMapper.toUserDto(userStorage.update(UserMapper.toUser(userDto)));
    }

    @Override
    public UserDto getUserById(Long id) {
        return UserMapper.toUserDto(userStorage.getUserById(id));
    }

    @Override
    public void delete(Long id) {
        userStorage.delete(id);
    }
}