package ru.yandex.practicum.shareit.booking.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import ru.yandex.practicum.shareit.booking.model.BookingStatus;
import ru.yandex.practicum.shareit.item.model.Item;
import ru.yandex.practicum.shareit.user.model.User;

import java.time.LocalDateTime;

@Data
@Builder
public class BookingDto {

    private Long id;
    @NotNull
    private LocalDateTime start;
    @NotNull
    @Future
    private LocalDateTime end;
    private Item item;
    private User booker;
    private BookingStatus status;
}