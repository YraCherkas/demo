package by.ycherkas.demo.repository;

import by.ycherkas.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
