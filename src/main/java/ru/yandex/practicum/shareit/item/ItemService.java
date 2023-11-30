package ru.yandex.practicum.shareit.item;

import java.util.List;

public interface ItemService {

    ItemDto getItemById(Long itemId);

    List<ItemDto> getItems(Long userId);

    ItemDto addItem(ItemDto itemDto);

    ItemDto updateItem(ItemDto itemDto);

    List<ItemDto> searchItems(String text);
}