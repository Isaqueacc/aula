package com.aula.testing.repository;

import com.aula.testing.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoy extends JpaRepository<UserEntity,Long>{
}
