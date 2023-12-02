package ru.yandex.practicum.shareit.user.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.practicum.shareit.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}