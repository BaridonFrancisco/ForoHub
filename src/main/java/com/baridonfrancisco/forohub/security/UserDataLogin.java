package com.baridonfrancisco.forohub.security;

import jakarta.validation.constraints.NotBlank;

public record UserDataLogin(
        @NotBlank
        String user,
        @NotBlank
        String password

) {
}
