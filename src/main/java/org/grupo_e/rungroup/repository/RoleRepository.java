package org.grupo_e.rungroup.repository;

import org.grupo_e.rungroup.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);

}
