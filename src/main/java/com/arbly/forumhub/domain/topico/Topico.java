package com.arbly.forumhub.domain.topico;

import com.arbly.forumhub.domain.curso.Curso;
import com.arbly.forumhub.domain.resposta.Resposta;
import com.arbly.forumhub.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "topicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 255)
    private String titulo;

    @Column(nullable = false, unique = true, length = 255)
    private String mensagem;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Column(nullable = false, length = 20)
    private String status;

    @ManyToOne(optional = false)
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
    private List<Resposta> respostas;

    @Column(nullable = false)
    private Boolean ativo = true;

    public Topico(String titulo, String mensagem, LocalDateTime dataCriacao, String status,
                  Usuario autor, Curso curso, Boolean ativo) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.dataCriacao = dataCriacao;
        this.status = status;
        this.autor = autor;
        this.curso = curso;
        this.ativo = ativo;
        this.respostas = new ArrayList<>();
    }

    public void atualizarInformacoes(@Valid TopicoAtualizarDados dados) {
        if (dados.titulo() != null){
            this.titulo  = dados.titulo();
        }
        if (dados.mensagem() != null){
            this.mensagem = dados.mensagem();
        }
    }

    public void excluir() {
        this.ativo = false;
    }

    /*public Topico(String titulo, String mensagem, LocalDateTime dataCriacao, String status, Usuario autor,
                  Curso curso, Boolean ativo, List<Resposta> respostas) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.dataCriacao = dataCriacao;
        this.status = status;
        this.autor = autor;
        this.curso = curso;
        this.ativo = ativo;
        this.respostas = respostas;
    }*/

}


