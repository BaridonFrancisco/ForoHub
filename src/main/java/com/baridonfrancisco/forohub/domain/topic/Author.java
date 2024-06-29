package com.baridonfrancisco.forohub.domain.topic;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "Authors")
@Entity(name = "Author")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String user;
    private String email;
    private String password;




}
