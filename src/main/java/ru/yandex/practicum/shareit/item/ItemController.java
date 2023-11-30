package ru.yandex.practicum.shareit.item;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
@Validated
public class ItemController {

    private final ItemService itemService;


    @GetMapping("/{itemId}")
    public ItemDto getItemById(@Valid @Positive @PathVariable Long itemId) {
        return itemService.getItemById(itemId);
    }

    @GetMapping
    public List<ItemDto> getItems(@Valid @Positive @RequestHeader("X-Sharer-User-Id") Long userId) {
        return itemService.getItems(userId);
    }

    @PostMapping()
    public ItemDto addItem(@Validated(AddItemValidation.class) @RequestBody ItemDto itemDto,
                           @Valid @Positive @RequestHeader("X-Sharer-User-Id") Long ownerId) {
        itemDto.setOwnerId(ownerId);
        return itemService.addItem(itemDto);
    }

    @PatchMapping("/{itemId}")
    public ItemDto updateItem(@Validated(UpdateItemValidation.class) @RequestBody ItemDto itemDto,
                              @Valid @Positive @PathVariable Long itemId,
                              @Valid @Positive @RequestHeader("X-Sharer-User-Id") Long ownerId) {
        itemDto.setId(itemId);
        itemDto.setOwnerId(ownerId);
        return itemService.updateItem(itemDto);
    }

    @GetMapping("/search")
    public List<ItemDto> searchItems(@RequestParam("text") String text) {
        return itemService.searchItems(text);
    }
}