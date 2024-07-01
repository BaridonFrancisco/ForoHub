package com.baridonfrancisco.forohub.domain.course;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "Courses")
@Entity(name = "Course")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "coursename")
    private String courseName;
    @Enumerated(EnumType.STRING)
    private Category category;


}
