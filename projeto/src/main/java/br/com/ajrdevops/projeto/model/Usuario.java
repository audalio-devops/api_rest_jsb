package br.com.ajrdevops.projeto.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.scheduling.support.SimpleTriggerContext;

@Data

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome", length = 200, nullable = false)
    private String nome;
    @Column(name = "email", length = 50, nullable = false)
    private String email;
    @Column(name = "senha", columnDefinition = "TEXT", nullable = false)
    private String senha;
    @Column(name = "telefone", length = 15)
    private String telefone;


}
