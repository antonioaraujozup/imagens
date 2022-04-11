package br.com.zup.edu.imagens.api.controller;

import br.com.zup.edu.imagens.api.model.Album;
import br.com.zup.edu.imagens.api.model.Imagem;
import br.com.zup.edu.imagens.api.repository.AlbumRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class CadastrarNovaImagemController {

    private final AlbumRepository repository;

    public CadastrarNovaImagemController(AlbumRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/albuns/{idAlbum}/imagens")
    public ResponseEntity<?> cadastrar(@PathVariable Long idAlbum, @RequestBody @Valid ImagemRequest request, UriComponentsBuilder uriComponentsBuilder) {
        Album album = repository.findById(idAlbum)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não existe álbum cadastrado para o Id informado!"));

        Imagem novaImagem = request.paraImagem();

        album.adicionaImagem(novaImagem);

        repository.saveAndFlush(album);

        URI location = uriComponentsBuilder.path("/albuns/{idAlbum}/imagens/{idImagem}")
                .buildAndExpand(album.getId(), novaImagem.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}

