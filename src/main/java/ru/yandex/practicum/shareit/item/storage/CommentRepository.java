package ru.yandex.practicum.shareit.item.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.practicum.shareit.item.model.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByItemIdOrderByCreatedDesc(Long itemId);
}