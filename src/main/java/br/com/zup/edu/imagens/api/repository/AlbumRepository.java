package br.com.zup.edu.imagens.api.repository;

import br.com.zup.edu.imagens.api.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
