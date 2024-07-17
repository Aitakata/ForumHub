package br.com.alura.forum.api.repository;

import br.com.alura.forum.api.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico,Long> {
}
