package com.template.demo.security.oauth2;

import com.template.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OidcUserServiceImpl extends OidcUserService {

    private final UserRepository userRepository;

    @Override
    public OidcUser loadUser(final OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        OidcUser oidcUser = super.loadUser(userRequest);
        userRepository.findByUsername(oidcUser.getEmail())
                .orElseThrow(() -> new OAuth2AuthenticationException("User not registered!"));
        return oidcUser;
    }
}
