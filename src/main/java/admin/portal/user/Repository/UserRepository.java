package admin.portal.user.Repository;

import admin.portal.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findUserByUsername(String username);
    public List<User> findAll();
}
