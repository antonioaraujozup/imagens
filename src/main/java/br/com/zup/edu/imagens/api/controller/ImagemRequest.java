package br.com.zup.edu.imagens.api.controller;

import br.com.zup.edu.imagens.api.model.Imagem;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

public class ImagemRequest {

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    @NotBlank
    private String endereco;

    @NotNull
    @PastOrPresent
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime cadastradaEm;

    public ImagemRequest() {
    }

    public Imagem paraImagem() {
        return new Imagem(titulo,descricao,endereco,cadastradaEm);
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCadastradaEm(LocalDateTime cadastradaEm) {
        this.cadastradaEm = cadastradaEm;
    }
}
