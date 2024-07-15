package me.dio.dominio.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    private Conta conta;

    @OneToOne(cascade = CascadeType.ALL)
    private Cartao cartao;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Servico> servico;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Noticia> noticia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public List<Servico> getServico() {
        return servico;
    }

    public void setServico(List<Servico> servico) {
        this.servico = servico;
    }

    public List<Noticia> getNoticia() {
        return noticia;
    }

    public void setNoticia(List<Noticia> noticia) {
        this.noticia = noticia;
    }

}
