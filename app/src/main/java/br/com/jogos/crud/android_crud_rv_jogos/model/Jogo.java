package br.com.jogos.crud.android_crud_rv_jogos.model;

/**
 * Created by Mescla on 14/03/2017.
 */

public class Jogo {

    private Long id;

    private String nome;
    private String fabricante;

    public Jogo(String nome, String fabricante) {

        this.nome = nome;
        this.fabricante = fabricante;

    }

    public Jogo(Long id, String nome, String fabricante) {
        this.id = id;
        this.nome = nome;
        this.fabricante = fabricante;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Jogo() {

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getNome() {
        return nome;
    }

    public String getFabricante() {
        return fabricante;
    }

}
