package auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import auth.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
