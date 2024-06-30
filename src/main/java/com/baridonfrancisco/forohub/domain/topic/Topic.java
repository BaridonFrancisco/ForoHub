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
    private Topic_Status topic_status;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "topic",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Response> listResponses;

}
