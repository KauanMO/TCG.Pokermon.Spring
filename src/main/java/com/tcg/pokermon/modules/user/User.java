package com.tcg.pokermon.modules.user;

import com.tcg.pokermon.modules.card.Card;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
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

    private Double balance;

    @OneToMany(mappedBy = "user")
    private List<Card> cards;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.roles = List.of(UserRoleEnum.PLAYER);
        this.balance = 1_000.0;
    }
}
