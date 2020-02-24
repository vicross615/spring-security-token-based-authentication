package admin.portal.Security.service;

import admin.portal.Security.entities.AuthToken;
import admin.portal.Security.repository.AuthTokenRepository;
import admin.portal.user.entities.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AuthTokenServiceImpl implements AuthTokenService {

    AuthTokenRepository authTokenRepository;

    @Autowired
    public AuthTokenServiceImpl(AuthTokenRepository authTokenRepository) {
        this.authTokenRepository = authTokenRepository;
    }


    @Override
    public List<AuthToken> findByUser(User user) {
        return this.authTokenRepository.findByUser(user);
    }

    @Override
    public void deleteToken(AuthToken token) {
        this.authTokenRepository.deleteToken(token);
    }

    @Override
    public void update(AuthToken token) {
        this.authTokenRepository.update(token);
    }

    @Override
    public boolean isTokenExpired(AuthToken token) {
        return false;
    }

    @Override
    public AuthToken create(User loggedInUser){
        AuthToken token = new AuthToken();
        token.setUser(loggedInUser);
        return this.authTokenRepository.saveAndFlush(token);
    }
}
