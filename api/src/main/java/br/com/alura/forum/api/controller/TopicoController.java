package br.com.alura.forum.api.controller;

import br.com.alura.forum.api.dto.DadosAtualizaTopico;
import br.com.alura.forum.api.dto.DadosCadastroTopico;
import br.com.alura.forum.api.dto.DadosDetalhamentoTopico;
import br.com.alura.forum.api.dto.DadosListagemTopico;
import br.com.alura.forum.api.model.Topico;
import br.com.alura.forum.api.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroTopico dados){
        repository.save(new Topico(dados));
    }

    @GetMapping
    // mudei os default size=20 e sort={"asc"}
    public Page<DadosListagemTopico> listar(@PageableDefault(size = 15, sort = {"titulo"})
                                            Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemTopico::new);
    }

    @GetMapping("/id")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizaTopico dados){
        // carrega o topico a partir do BD
        var topico = repository.getReferenceById(dados.id());
        // sobrepoe as informações a alterar
        topico.atualizaInfo(dados);
        // salvat novamente no BD - NÃO PRECISA,
        // o fato de ser transactional garante a ataulizacao do BD
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }

}
