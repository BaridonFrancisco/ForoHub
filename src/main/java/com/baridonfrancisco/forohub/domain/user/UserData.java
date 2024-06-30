package com.baridonfrancisco.forohub.domain.user;

import jakarta.validation.constraints.NotBlank;

public record UserData(
        @NotBlank String userName,
        @NotBlank  String password,
        @NotBlank String email
) {

}
