package com.butecomananger.butecomananger.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "users")
@Entity(name = "User")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = true)
    private String email;

    @Column(unique = true, nullable = true)
    private String password;

    //fetch = FetchType.EAGER -> carrega as roles quando um usuario é buscado no banco
    //cascade = CascadeType.PERSIST -> quando um usuario é salve, também salva as roles que ainda não foram persistidas no banco
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name="users_roles", //nome da tabela
            joinColumns = @JoinColumn(name = "user_id"), //a coluna que representa o usuario sera user_id
            inverseJoinColumns = @JoinColumn(name="role_id"))//a coluna que representa a role sera role_id
    private List<Role> roles;
}
