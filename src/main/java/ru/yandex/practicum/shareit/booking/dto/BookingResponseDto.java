package ru.yandex.practicum.shareit.booking.dto;

import lombok.Builder;
import lombok.Data;
import ru.yandex.practicum.shareit.booking.model.BookingStatus;

import java.time.LocalDateTime;

@Data
@Builder
public class BookingResponseDto {
    private Long id;
    private LocalDateTime start;
    private LocalDateTime end;
    private Long itemId;
    private Long bookerId;
    private BookingStatus bookingStatus;
}