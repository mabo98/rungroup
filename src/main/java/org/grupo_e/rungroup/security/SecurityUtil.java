package org.grupo_e.rungroup.security;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;

public class SecurityUtil {
    public static String getSessionUser() {
        Authentication autentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(autentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = autentication.getName();
            return currentUserName;
        }
        return null;
    }
}
