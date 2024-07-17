package br.com.alura.forum.api.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record DadosCadastroTopico(
        @NotBlank String titulo,
        @NotBlank String mensagem,
        LocalDateTime dataCriacao,
        String statusMsg,
        @NotBlank String autor,
        @NotBlank String curso,
        String resposta) {
}
