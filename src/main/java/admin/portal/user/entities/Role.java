package admin.portal.user.entities;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name="roles")
public class Role  implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", nullable=false, unique=true, updatable=false)
    public long id;

    @Column(name="role", unique=true)
    public String role;

    @Override
    @Transient
    public String getAuthority() {
        return this.role;
    }



    public Role() {
    }



    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
