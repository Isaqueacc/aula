package com.aula.testing.repository;

import com.aula.testing.models.FisicProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FisicProductRepo extends JpaRepository<FisicProductEntity, Long> {
}
