package africa.Semicolon.exampleSpringBlog.repository;

import africa.Semicolon.exampleSpringBlog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
