package ru.yandex.practicum.shareit.user.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.shareit.exeption.AlreadyExistException;
import ru.yandex.practicum.shareit.exeption.UserNotFoundException;
import ru.yandex.practicum.shareit.user.dto.UserDto;
import ru.yandex.practicum.shareit.user.dto.UserMapper;
import ru.yandex.practicum.shareit.user.model.User;
import ru.yandex.practicum.shareit.user.storage.UserRepository;


import java.util.List;

import static ru.yandex.practicum.shareit.user.dto.UserMapper.toUserDto;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        try {
            UserDto createdUser = toUserDto(userRepository.save(UserMapper.toUser(userDto)));
            log.info("Успешно выполнен запрос на создание пользователя {}", userDto);
            return createdUser;
        } catch (DataIntegrityViolationException e) {
            log.error("Не удалось выполнить запрос  на создание пользователя = {}", userDto);
            throw new AlreadyExistException("Пользователь с email = " + userDto.getEmail() + " уже существует.");
        }
    }


    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        try {
            User updatedUser = userRepository.findById(id)
                    .orElseThrow(() -> {
                        log.error("Не удалось выполнить запрос на частичное обновление пользователя с id = {} ", id);
                        return new UserNotFoundException("Невозможно обновить данные пользователя с id =  " + id +
                                " - пользователь с таким id не найден в базе.");
                    });

            if (userDto.getEmail() != null && !userDto.getEmail().isBlank()) {
                updatedUser.setEmail(userDto.getEmail());
            }
            if (userDto.getName() != null && !userDto.getName().isBlank()) {
                updatedUser.setName(userDto.getName());
            }
            log.info("Успешно выполнен запрос на частичное обновление пользователя с id = {}", id);
            return toUserDto(userRepository.saveAndFlush(updatedUser));
        } catch (DataIntegrityViolationException e) {
            log.error("Не удалось выполнить запрос  на частичное обновление пользователя пользователя = {}, email = {} не уникален",
                    userDto, userDto.getEmail());
            throw new AlreadyExistException("Пользователь с email = " + userDto.getEmail() + " уже существует.");
        }
    }


    @Override
    public List<UserDto> readUsers() {
        List<UserDto> allUsers = UserMapper.toListUsersDto(userRepository.findAll());
        log.info("Успешно выполнен запрос на получение информации обо всех пользователях");
        return allUsers;
    }


    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            log.error("Не удалось выполнить запрос  на удаление пользователя c id = {}", id);
            throw new UserNotFoundException("Пользователь с id " + id + " не найден. Удаление невозможно.");
        }
        log.info("Успешно выполнен запрос  на удаление пользователя c id = {}", id);
        userRepository.deleteById(id);
    }


    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Ошибка при получении информации о пользователе с id = {}", id);
                    return new UserNotFoundException("Пользователь с id " + id + " не найден");
                });

        log.info("Успешно выполнен запрос на получение информации о пользователя с id = {}", id);
        return toUserDto(user);
    }
}