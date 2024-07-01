package com.baridonfrancisco.forohub.domain.user;

public record UserDTOUpdate(
        String username,
        String password,
        String email
) {
}
