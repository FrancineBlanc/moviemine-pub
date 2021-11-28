package com.movieminers.moviemine.user;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
  // Optional<User> findById(Long id);
  User findAllById(Long id);

  User findByUsername(String username);

}
