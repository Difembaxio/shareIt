package ru.yandex.practicum.shareit.booking.service;

import ru.yandex.practicum.shareit.booking.dto.BookingDto;
import ru.yandex.practicum.shareit.booking.dto.BookingRequestDto;

import java.util.List;

public interface BookingService {
    BookingDto create(BookingRequestDto bookingRequestDto, Long userId);

    BookingDto approve(Long bookingId, Long userId, Boolean approved);

    List<BookingDto> getAllByOwner(Long ownerId, String state);

    List<BookingDto> getAllByUser(Long userId, String state);

    BookingDto getByIdAndBookerId(Long bookingId, Long userId);
}