package admin.portal.Security.repository;

import admin.portal.Security.entities.AuthToken;
import admin.portal.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthTokenRepository extends JpaRepository<AuthToken, String> {


    List<AuthToken> findByUser(User user);
    public void deleteToken(AuthToken token);
    public void update(AuthToken token);
    boolean isTokenExpired(AuthToken token);

}
