package admin.portal.Security.entities;


import admin.portal.user.entities.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "auth_tokens")
public class AuthToken {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
     @Column(unique=true, nullable=false)
    String id;

    @Column(name="last_access_time", nullable=false)
    LocalDateTime lastAccessTime;

    @ManyToOne
     @JoinColumn(name="user_id", referencedColumnName = "id")
    User user;

    public AuthToken() {

    }

    @PrePersist
    public void onPrePersist() {
        this.lastAccessTime = LocalDateTime.now();
    }


    public void setUser(User user) {
        this.user = user;
    }
}
