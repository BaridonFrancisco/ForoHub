package com.baridonfrancisco.forohub.domain.topic;

import com.baridonfrancisco.forohub.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic,Long> {



}
