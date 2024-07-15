package com.baridonfrancisco.forohub.security;

import java.time.Instant;

public record JWTDTO(

        String username,
        String token
       // Instant time
) {
}
