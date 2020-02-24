package me.kosgei.springJpa.repository;

import me.kosgei.springJpa.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
     User findUserById(int id);
}
