package com.baridonfrancisco.forohub.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public UserDTOCreate createUser(UserData userData) {
        User user = new User(userData);
        userRepository.save(user);
        return new UserDTOCreate(user.getUser_name(),
                user.getPassword(),
                user.getEmail(), user.getProfile());


    }


    public UserDTOGet retrieveUser(Long id) {
       return userRepository.findById(id)
                .map(UserDTOGet::new)
               .orElse(null);

    }

    public Page<UserDTOGet> findAllUser(Pageable pageable) {
        return userRepository.findAllUsers(pageable)
                .map(UserDTOGet::new);
    }
}
