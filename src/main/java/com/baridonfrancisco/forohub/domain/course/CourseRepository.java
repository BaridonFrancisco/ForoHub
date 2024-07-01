package com.baridonfrancisco.forohub.domain.course;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course,Long> {

    Optional<Course> findByCourseNameIgnoreCase(String course);


}
