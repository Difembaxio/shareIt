package ru.yandex.practicum.shareit.exeption;

public class WrongOwnerException extends RuntimeException {
    public WrongOwnerException(String message) {
        super(message);
    }
}