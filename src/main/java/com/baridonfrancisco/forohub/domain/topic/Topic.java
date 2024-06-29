package com.baridonfrancisco.forohub.domain.topic;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "Topics")
@Entity(name = "Topic")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String message;
    private LocalDateTime creationTime;
    @Enumerated(EnumType.STRING)
    private Status status;

    private Author author;
    private Course course;
    private List<Response> listResponses;

}
