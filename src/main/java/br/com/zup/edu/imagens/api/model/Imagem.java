package br.com.zup.edu.imagens.api.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private LocalDateTime cadastradaEm;

    @ManyToMany(mappedBy = "imagens")
    private Set<Album> albums = new HashSet<>();

    /**
     * @deprecated Construtor para uso exclusivo do Hibernate.
     */
    @Deprecated
    public Imagem() {
    }

    public Imagem(String titulo, String descricao, String endereco, LocalDateTime cadastradaEm) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.endereco = endereco;
        this.cadastradaEm = cadastradaEm;
    }

    public void adicionaAlbum(Album novoAlbum) {
        this.albums.add(novoAlbum);
    }

    public Long getId() {
        return id;
    }

}
