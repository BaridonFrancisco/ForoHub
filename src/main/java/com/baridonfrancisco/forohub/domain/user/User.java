package com.baridonfrancisco.forohub.domain.user;

import com.baridonfrancisco.forohub.domain.response.Response;
import com.baridonfrancisco.forohub.domain.topic.Topic;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.Collection;
import java.util.List;

@Table(name = "Users")
@Entity(name = "User")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(exclude = "listTopic")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_name")
    private String userName;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Topic> listTopic;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch =FetchType.EAGER)
    private List<Response>listResponse;

    @Enumerated(EnumType.STRING)
    private Profile profile;

    public User(UserData userData) {
        this.userName =userData.userName();
        this.email=userData.email();
        this.password=new BCryptPasswordEncoder().encode(userData.password());
        this.profile=Profile.USER;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("Rol_User"));
    }



    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
