package com.baridonfrancisco.forohub.domain.user;

public record UserDTOGet(
        Long id,
        String user,
        String password,
        String email,
        Profile profile


) {
    public UserDTOGet(User user){
        this(user.getId(),user.getUsername(),user.getPassword(),user.getEmail(),user.getProfile());
    }

}
