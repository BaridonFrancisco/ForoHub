package com.baridonfrancisco.forohub.domain.user;

import jakarta.validation.constraints.NotNull;

public record UserDataUpdate(
        @NotNull Long id,
        String username,
        String password,
        String email
){
}
