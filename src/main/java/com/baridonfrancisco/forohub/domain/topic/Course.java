package com.baridonfrancisco.forohub.domain.topic;

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

    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;


}
