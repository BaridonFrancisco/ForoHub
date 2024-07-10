package com.baridonfrancisco.forohub.domain.topic;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TopicRepository extends JpaRepository<Topic,Long> {

    boolean existsByTitleIgnoreCaseAndMessageIgnoreCase(String title, String message);


}
