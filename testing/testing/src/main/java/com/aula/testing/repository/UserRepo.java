package com.aula.testing.repository;

import com.aula.testing.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity,Long>{
}
