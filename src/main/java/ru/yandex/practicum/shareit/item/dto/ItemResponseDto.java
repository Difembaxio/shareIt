package ru.yandex.practicum.shareit.item.dto;

import lombok.Builder;
import lombok.Data;
import ru.yandex.practicum.shareit.booking.dto.BookingResponseDto;

import java.util.List;

@Builder
@Data
public class ItemResponseDto {
    private Long id;
    private String name;
    private String description;
    private Boolean available;
    private BookingResponseDto lastBooking;
    private BookingResponseDto nextBooking;
    private List<CommentResponseDto> comments;

}