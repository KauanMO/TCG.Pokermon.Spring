package com.tcg.pokermon.modules.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@Table(name = "pkm_user")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private LocalDateTime createdAt;

    private Integer favoritePokemonCode;

    private List<UserRoleEnum> roles;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.roles = List.of(UserRoleEnum.PLAYER);
    }
}
