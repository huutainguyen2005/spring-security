package vn.edu.fpt.musicstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.fpt.musicstore.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User getUserByUsernameIgnoreCase(String username);
}
