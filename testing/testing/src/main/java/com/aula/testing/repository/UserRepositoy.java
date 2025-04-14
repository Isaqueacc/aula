package com.aula.testing.repository;

import com.aula.testing.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoy extends JpaRepository<UserEntity,Long>{
}
