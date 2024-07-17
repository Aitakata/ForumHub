package br.com.alura.forum.api.model;

import br.com.alura.forum.api.dto.DadosAtualizaTopico;
import br.com.alura.forum.api.dto.DadosCadastroTopico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name="topicos")
@Entity(name="topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private Boolean statusMsg;
    private String autor;
    private String curso;
    private String respostas;

    public Topico(DadosCadastroTopico dados) {

        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.dataCriacao = dados.dataCriacao();
        this.statusMsg = Boolean.valueOf(dados.statusMsg());
        this.autor = dados.autor();
        this.curso = dados.curso();
        this.respostas = dados.resposta();
    }

    public void atualizaInfo(DadosAtualizaTopico dados) {
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }
        if (dados.dataCriacao() != null) {
            this.dataCriacao = LocalDateTime.now();
        }
        if (dados.statusMsg() != null) {
            this.statusMsg = dados.statusMsg();
        }
        if (dados.autor() != null) {
            this.autor = dados.autor();
        }
        if (dados.curso() != null) {
            this.curso = dados.curso();
        }
    }
}
