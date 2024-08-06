package com.baridonfrancisco.forohub.domain.topic;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TopicRepository extends JpaRepository<Topic,Long> {

    boolean existsByTitleIgnoreCaseAndMessageIgnoreCase(String title, String message);

    @Query("SELECT t FROM Topic t WHERE t.id=:topicId AND NOT t.topic_status=:topicStatus")
    Optional<Topic>findByIdAndStatus(Long topicId,Topic_Status topicStatus);





}
