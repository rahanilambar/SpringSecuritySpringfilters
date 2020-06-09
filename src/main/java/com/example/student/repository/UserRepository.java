package com.example.student.repository;

import com.example.student.model.UserDetails;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nilambar
 */
@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer>{
    public Optional<UserDetails> findByName(String name);
}
