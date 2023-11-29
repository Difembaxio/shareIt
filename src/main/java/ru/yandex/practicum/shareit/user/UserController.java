package ru.yandex.practicum.shareit.user;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/{userId}")
    public UserDto getUserById(@Valid @Positive @PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping()
    public UserDto addUser(@Validated(AddUserValidation.class) @RequestBody UserDto userDto) {
        return userService.add(userDto);
    }

    @PatchMapping("/{userId}")
    public UserDto updateUser(@Validated(UpdateUserValidation.class) @RequestBody UserDto userDto,
                              @Valid @Positive @PathVariable Long userId) {
        userDto.setId(userId);
        return userService.update(userDto);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@Valid @Positive @PathVariable Long userId) {
        userService.delete(userId);
    }
}