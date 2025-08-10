package com.arbly.forumhub.domain.resposta;

import com.arbly.forumhub.domain.topico.Topico;
import com.arbly.forumhub.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "respostas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 255)
    private String mensagem;

    @ManyToOne(optional = false)
    @JoinColumn(name = "topico_id")
    private Topico topico;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @ManyToOne(optional = false)
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    private Boolean solucao = false;

    @Column(nullable = false)
    private Boolean ativo = true;

    public Resposta(String mensagem, Topico topico, LocalDateTime dataCriacao, Usuario autor, Boolean solucao, Boolean ativo) {
        this.mensagem = mensagem;
        this.topico = topico;
        this.dataCriacao = dataCriacao;
        this.autor = autor;
        this.solucao = solucao;
        this.ativo = ativo;
    }

    public void atualizarInformacoes(@Valid RespostaAtualizarDados dados) {
        if (dados.mensagem() != null){
            this.mensagem = dados.mensagem();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
