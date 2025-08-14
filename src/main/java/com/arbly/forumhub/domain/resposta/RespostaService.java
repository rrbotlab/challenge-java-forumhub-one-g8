package com.arbly.forumhub.domain.resposta;

import com.arbly.forumhub.domain.topico.TopicoRepository;
import com.arbly.forumhub.domain.usuario.UsuarioDetails;
import com.arbly.forumhub.domain.usuario.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RespostaService {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    TopicoRepository topicoRepository;
    @Autowired
    RespostaRepository respostaRepository;


    @Transactional
    public Resposta criar(RespostaCriarDados dados){

        var usuarioAutenticado = (UsuarioDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var autor = usuarioRepository.findById(usuarioAutenticado.getUsuario().getId()).orElseThrow(() -> new UsernameNotFoundException("Usuário inválido"));
        var topico = topicoRepository.findById(dados.topicoId()).orElseThrow(() -> new EntityNotFoundException("Topico inválido"));
        var dataCriacao = LocalDateTime.now();

        return respostaRepository.save(new Resposta(dados.mensagem(), topico, dataCriacao, autor, false, true));

    }

}
