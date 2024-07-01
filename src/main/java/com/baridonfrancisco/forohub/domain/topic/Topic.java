package com.baridonfrancisco.forohub.domain.topic;

import com.baridonfrancisco.forohub.domain.course.Category;
import com.baridonfrancisco.forohub.domain.course.Course;
import com.baridonfrancisco.forohub.domain.response.Response;
import com.baridonfrancisco.forohub.domain.user.User;
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

    public Topic(TopicData data,Course course,User user) {
        this.title=data.title();
        this.user=user;
        this.course=course;
        this.creationTime=LocalDateTime.now();
        this.message=data.message();
        this.topic_status=Topic_Status.ACTIVE;
    }
}
