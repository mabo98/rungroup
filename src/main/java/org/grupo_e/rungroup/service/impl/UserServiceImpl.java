package org.grupo_e.rungroup.service.impl;

import org.grupo_e.rungroup.dto.RegistrationDto;
import org.grupo_e.rungroup.models.Role;
import org.grupo_e.rungroup.models.UserEntity;
import org.grupo_e.rungroup.repository.RoleRepository;
import org.grupo_e.rungroup.repository.UserRepository;
import org.grupo_e.rungroup.service.UserService;

import java.lang.reflect.Array;
import java.util.Arrays;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        UserEntity user = new UserEntity();
        user.setUsername(registrationDto.getUsername());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        Role role = roleRepository.findByName("USER");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }
}
