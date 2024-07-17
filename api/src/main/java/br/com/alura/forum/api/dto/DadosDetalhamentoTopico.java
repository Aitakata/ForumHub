package br.com.alura.forum.api.dto;

import br.com.alura.forum.api.model.Topico;
import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        Boolean statusMsg,
        String autor,
        String curso,
        String respostas) {
    public DadosDetalhamentoTopico(Topico topico) {
        this(topico.getId(),
             topico.getTitulo(),
             topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatusMsg(),
                topico.getAutor(),
                topico.getCurso(),
                topico.getRespostas());
    }
}
