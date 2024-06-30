package com.baridonfrancisco.forohub.domain.topic;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Table(name = "Responses")
@Entity(name = "Response")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;


    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    private LocalDateTime creationDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String solution;




}
