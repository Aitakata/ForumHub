package br.com.alura.forum.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaTopico(@NotNull Long id,
                                  String titulo,
                                  String mensagem,
                                  String dataCriacao,
                                  Boolean statusMsg,
                                  String autor,
                                  String curso,
                                  String respostas) {
}
