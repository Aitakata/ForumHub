package br.com.alura.forum.api.dto;

import br.com.alura.forum.api.model.Topico;
import jakarta.validation.constraints.NotNull;

public record DadosListagemTopico(Long id, String titulo, String autor) {
    public DadosListagemTopico(Topico topico) {
//        this.titulo = topico.getTitulo();
//        this.autor = topico.getAutor();
        this(topico.getId(), topico.getTitulo(), topico.getAutor());
    }
}
