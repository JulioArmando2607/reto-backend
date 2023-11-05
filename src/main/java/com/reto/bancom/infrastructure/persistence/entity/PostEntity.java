package com.reto.bancom.infrastructure.persistence.entity;

import com.reto.bancom.infrastructure.persistence.utils.Audit;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "posts")
public class PostEntity extends Audit<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(name = "text")
    private String text;
}
