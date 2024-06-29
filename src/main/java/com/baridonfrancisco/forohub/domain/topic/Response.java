package com.baridonfrancisco.forohub.domain.topic;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
    private Long id;

    private String message;

    private Topic topic;

    private LocalDateTime creationDate;

    private Author author;

    private String resolved;




}
