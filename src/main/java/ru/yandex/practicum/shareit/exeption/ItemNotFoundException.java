package ru.yandex.practicum.shareit.exeption;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException (String message){
        super(message);
    }
}
