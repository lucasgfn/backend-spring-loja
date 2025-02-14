package com.example.lojas.saines.entity;

import com.example.lojas.saines.enuns.UserPaper;
import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "paper")
public class Paper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "O nome do papel não pode ser nulo")
    @Enumerated(EnumType.STRING)
    private UserPaper nome;

    // Relacionamento OneToMany com User
    @OneToMany(mappedBy = "paper", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<User> users = new HashSet<>();
}
