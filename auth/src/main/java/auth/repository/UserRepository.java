package auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import auth.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
