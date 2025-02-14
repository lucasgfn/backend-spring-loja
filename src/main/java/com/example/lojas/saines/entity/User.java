package com.example.lojas.saines.entity;

import com.example.lojas.saines.dto.UserRequestDTO;
import com.example.lojas.saines.enuns.UserPaper;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "O nome não pode ser nulo")
    private String nome;
    @Email(message = "O email deve ser válido")
    @NotBlank
    private String email;
    private String telefone;
    private String endereco;
    @NotNull(message = "Senha não pode ser nulo")
    @NotBlank
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "paper_id", nullable = false)
    private Paper paper;

    public User(UserRequestDTO userRequestDTO) {
        this.nome = userRequestDTO.nome();
        this.email = userRequestDTO.email();
        this.password = userRequestDTO.password();
        this.paper = userRequestDTO.paper();
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }
}
