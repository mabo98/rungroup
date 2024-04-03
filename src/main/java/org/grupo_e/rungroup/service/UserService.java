package org.grupo_e.rungroup.service;

import org.grupo_e.rungroup.dto.RegistrationDto;
import org.grupo_e.rungroup.models.UserEntity;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
