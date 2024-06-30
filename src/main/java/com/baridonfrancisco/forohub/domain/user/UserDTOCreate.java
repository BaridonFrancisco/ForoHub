package com.baridonfrancisco.forohub.domain.user;

public record UserDTOCreate(
        String username,
        String password,
        String email,
        Profile profile
) {
}
