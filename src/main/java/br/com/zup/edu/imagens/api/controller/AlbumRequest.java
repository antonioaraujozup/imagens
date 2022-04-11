package br.com.zup.edu.imagens.api.controller;

import br.com.zup.edu.imagens.api.model.Album;

import javax.validation.constraints.NotBlank;

public class AlbumRequest {

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    public AlbumRequest() {
    }

    public Album paraAlbum() {
        return new Album(titulo,descricao);
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
