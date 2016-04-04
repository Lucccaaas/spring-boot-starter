package com.bonday.service.user;

import com.bonday.service.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by yunge on 16/3/31.
 */
@Repository
public interface UserRepository extends MongoRepository<User, String>, UserRepositoryCustom {
    Optional<User> findByFirstName(String name);

    Collection<User> findByLastName(String name);

    Optional<User> findByNameAndPassword(String name, String password);
}
