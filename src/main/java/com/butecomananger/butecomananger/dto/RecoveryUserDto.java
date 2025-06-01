package com.butecomananger.butecomananger.dto;

import com.butecomananger.butecomananger.model.Role;

import java.util.List;

public record RecoveryUserDto(
        Long id,
        String email,
        List<Role> roles
) {
}
