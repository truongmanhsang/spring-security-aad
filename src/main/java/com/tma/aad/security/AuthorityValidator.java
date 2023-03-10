package com.tma.aad.security;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("authorityValidatorService")
public class AuthorityValidator implements AuthorityValidatorService {

    @Override
    public boolean hasAccess(String roleName) {
        OAuth2AuthenticationToken principal = (OAuth2AuthenticationToken)
                SecurityContextHolder.getContext().getAuthentication();
        boolean emptyRolesCheck = Optional.of(principal).map(OAuth2AuthenticationToken::getPrincipal)
                .map(OAuth2User::getAttributes)
                .map(user -> user.containsKey("roles"))
                .orElse(false);

        if (principal == null || !emptyRolesCheck) {
            return false;
        }

        boolean rolesCheck = ((List<String>)principal.getPrincipal().getAttributes().get("roles"))
                .stream().anyMatch(roles -> roles.equals(roleName));

        return rolesCheck;
    }
}
