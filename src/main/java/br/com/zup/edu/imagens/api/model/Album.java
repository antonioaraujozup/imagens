package br.com.zup.edu.imagens.api.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private LocalDateTime criadoEm = LocalDateTime.now();

    @ManyToMany(cascade = CascadeType.MERGE)
    private Set<Imagem> imagens = new HashSet<>();

    /**
     * @deprecated Construtor para uso exclusivo do Hibernate.
     */
    @Deprecated
    public Album() {
    }

    public Album(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public void adicionaImagem(Imagem novaImagem) {
        this.imagens.add(novaImagem);
        novaImagem.adicionaAlbum(this);
    }

    public Long getId() {
        return id;
    }
}
