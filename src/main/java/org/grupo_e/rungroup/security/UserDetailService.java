package org.grupo_e.rungroup.security;

import org.springframework.security.core.userdetails.User;

public interface UserDetailService {
    User loadUserByUsername(String username);
}
