package ru.yandex.practicum.shareit.exeption;

public class EmailAlreadyExistException extends RuntimeException {
    public EmailAlreadyExistException (String massage){
        super(massage);
    }
}
