package ru.yandex.practicum.shareit.item;


import lombok.Builder;
import lombok.Data;
import ru.yandex.practicum.shareit.user.User;

@Data
@Builder
public class Item {
    private Long id;
    private String name;
    private String description;
    private Boolean available;
    private User owner;
    private Long requestId;
}