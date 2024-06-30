package com.baridonfrancisco.forohub.domain.user;

import com.baridonfrancisco.forohub.domain.response.Response;
import com.baridonfrancisco.forohub.domain.topic.Topic;
import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Table(name = "Users")
@Entity(name = "User")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String user_name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Topic> listTopic;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch =FetchType.EAGER)
    private List<Response>listResponse;

    @Enumerated(EnumType.STRING)
    private Profile profile;

    public User(UserData userData) {
        this.user_name=userData.userName();
        this.email=userData.email();
        this.password=userData.password();
        this.profile=Profile.USER;
    }
}
