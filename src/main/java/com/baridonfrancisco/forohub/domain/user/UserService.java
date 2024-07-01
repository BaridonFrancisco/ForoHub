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

    public UserDTOUpdate updateUser(UserDataUpdate dateUpdate) {
        var userdb = userRepository.findById(dateUpdate.id()).map(user -> {

            if(dateUpdate.username()!=null && !dateUpdate.username().isBlank()){
                user.setUser_name(dateUpdate.username());
            }

           if(dateUpdate.email()!=null && !dateUpdate.email().isBlank()){
                user.setEmail(dateUpdate.email());
            }

            if(dateUpdate.password()!=null && !dateUpdate.password().isEmpty()){
                user.setPassword(dateUpdate.password());
            }
            return user;
        }).orElseThrow(() -> new RuntimeException("User not Found"));
        userRepository.save(userdb);
        return new UserDTOUpdate(userdb.getUser_name(), userdb.getPassword(), userdb.getEmail());

    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
