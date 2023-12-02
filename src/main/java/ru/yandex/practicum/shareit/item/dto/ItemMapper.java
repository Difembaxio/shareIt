package ru.yandex.practicum.shareit.item.dto;

import ru.yandex.practicum.shareit.booking.dto.BookingMapper;
import ru.yandex.practicum.shareit.booking.model.Booking;
import ru.yandex.practicum.shareit.item.model.Item;
import ru.yandex.practicum.shareit.user.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ItemMapper {
    private ItemMapper() {

    }

    public static ItemDto toItemDto(Item item) {
        return item != null ? ItemDto.builder()
                .id(item.getId())
                .name(item.getName())
                .description(item.getDescription())
                .available(item.getAvailable())
                .owner(item.getOwner())
                .requestId(item.getRequestId())
                .build() : null;
    }

    public static Item toItem(ItemDto itemDto, User owner) {
        return itemDto != null ? Item.builder()
                 .id(itemDto.getId())
                 .name(itemDto.getName())
                 .description(itemDto.getDescription())
                 .available(itemDto.getAvailable())
                 .owner(owner)
                 .requestId(itemDto.getRequestId())
                 .build() : null;
    }

    public static List<ItemDto> toItemListDto(List<Item> itemList) {
        return itemList.stream()
                .map(ItemMapper::toItemDto)
                .collect(Collectors.toList());
    }

    public static ItemResponseDto toItemResponseDto(Item item,
                                                    Booking lastBooking,
                                                    Booking nextBooking,
                                                    List<CommentResponseDto> comments) {
        return ItemResponseDto.builder()
                .id(item.getId())
                .name(item.getName())
                .available(item.getAvailable())
                .description(item.getDescription())
                .lastBooking(lastBooking == null ? null : BookingMapper.toBookingResponseDto(lastBooking))
                .nextBooking(nextBooking == null ? null : BookingMapper.toBookingResponseDto(nextBooking))
                .comments(comments)
                .build();
    }
}