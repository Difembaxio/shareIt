package ru.yandex.practicum.shareit.request;

import ru.yandex.practicum.shareit.user.User;

import java.time.LocalDateTime;

public class ItemRequest {
    private Long id;
    private String descriptions;
    private User requestor;

    private LocalDateTime created;
}
