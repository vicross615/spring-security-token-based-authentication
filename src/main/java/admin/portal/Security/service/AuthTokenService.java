package admin.portal.Security.service;

import admin.portal.Security.entities.AuthToken;
import admin.portal.user.entities.User;

import java.util.List;

public interface AuthTokenService {

    List<AuthToken> findByUser(User user);
    public void deleteToken(AuthToken token);
    public void update(AuthToken token);
    boolean isTokenExpired(AuthToken token);

    AuthToken create(User loggedInUser);
}
