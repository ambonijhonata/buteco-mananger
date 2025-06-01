package com.butecomananger.butecomananger.dto;

import com.butecomananger.butecomananger.enums.RoleName;

public record CreateUserDto(
        String email,
        String password,
        RoleName role
) {
}
