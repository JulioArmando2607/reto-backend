package com.reto.bancom.infrastructure.persistence.repository;

import com.reto.bancom.infrastructure.persistence.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostUserRepository extends JpaRepository<PostEntity, Long> {
    List<PostEntity> findByUserId(Long userId);
}
