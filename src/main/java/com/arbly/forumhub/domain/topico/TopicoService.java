package com.arbly.forumhub.domain.topico;

import com.arbly.forumhub.domain.curso.CursoRepository;
import com.arbly.forumhub.domain.usuario.UsuarioDetails;
import com.arbly.forumhub.domain.usuario.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Service
public class TopicoService {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    CursoRepository cursoRepository;
    @Autowired
    TopicoRepository topicoRepository;

    @Transactional
    public Topico criar(TopicoCriarDados dados){

        var usuarioAutenticado = (UsuarioDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var autor = usuarioRepository.findById(usuarioAutenticado.getUsuario().getId()).orElseThrow(() -> new UsernameNotFoundException("Usuário inválido"));
        var curso = cursoRepository.findById(dados.cursoId()).orElseThrow(() -> new EntityNotFoundException("Curso inválido"));
        var dataCriacao = LocalDateTime.now();

        return topicoRepository.save(new Topico(dados.titulo(), dados.mensagem(), dataCriacao,
                "ABERTO", autor, curso, true));

    }

}
