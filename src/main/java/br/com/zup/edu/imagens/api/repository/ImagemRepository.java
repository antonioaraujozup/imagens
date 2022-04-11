package br.com.zup.edu.imagens.api.repository;

import br.com.zup.edu.imagens.api.model.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagemRepository extends JpaRepository<Imagem, Long> {
}
