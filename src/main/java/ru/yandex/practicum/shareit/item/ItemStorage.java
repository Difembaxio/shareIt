package ru.yandex.practicum.shareit.item;

import javax.naming.CompositeName;
import java.util.List;

public interface ItemStorage {

    Item getItemById(Long itemId);

    List<Item> getItems(Long userId);

    Item addItem(Item item);

    Item updateItem(Item item);

    List<Item> searchItems(String text);
}