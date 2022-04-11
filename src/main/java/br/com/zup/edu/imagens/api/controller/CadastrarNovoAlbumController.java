package br.com.zup.edu.imagens.api.controller;

import br.com.zup.edu.imagens.api.model.Album;
import br.com.zup.edu.imagens.api.repository.AlbumRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class CadastrarNovoAlbumController {

    private final AlbumRepository repository;

    public CadastrarNovoAlbumController(AlbumRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/albuns")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid AlbumRequest request, UriComponentsBuilder uriComponentsBuilder) {
        Album novoAlbum = request.paraAlbum();

        repository.save(novoAlbum);

        URI location = uriComponentsBuilder.path("/albuns/{id}")
                .buildAndExpand(novoAlbum.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
