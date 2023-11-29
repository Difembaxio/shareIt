package ru.yandex.practicum.shareit.user;


import java.util.List;
public interface UserStorage {

    List<User> getAll();

    User add(User user);

    User update(User user);

    User getUserById(Long id);

    void delete(Long id);
}