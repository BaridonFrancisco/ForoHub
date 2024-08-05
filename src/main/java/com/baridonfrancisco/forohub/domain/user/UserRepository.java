package com.baridonfrancisco.forohub.domain.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u")
    Page<User> findAllUsers(Pageable pageable);

   UserDetails findByUserNameAndActive(String name,boolean active);

   Optional<User>findByUserName(String name);
}
