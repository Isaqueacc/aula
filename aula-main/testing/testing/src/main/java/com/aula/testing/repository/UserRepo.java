package com.aula.testing.repository;

import com.aula.testing.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Long>{
    Optional<UserEntity> findByEmail(String email);

}
