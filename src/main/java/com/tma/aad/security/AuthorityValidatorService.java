package com.tma.aad.security;

public interface AuthorityValidatorService {
    boolean hasAccess(String roleName);
}
