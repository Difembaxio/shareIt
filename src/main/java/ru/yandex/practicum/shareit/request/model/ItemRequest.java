package ru.yandex.practicum.shareit.request.model;

import lombok.Builder;
import lombok.Data;
import ru.yandex.practicum.shareit.user.model.User;

import java.time.LocalDateTime;

@Data
@Builder
public class ItemRequest {

    private Long id;
    private String description;
    private Long requesterId;
    private LocalDateTime created;

}