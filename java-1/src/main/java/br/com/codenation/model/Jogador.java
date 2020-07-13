package br.com.codenation.model;

import java.math.BigDecimal;
import java.time.LocalDate;

//This class implements the Java Interface Comparable
public class Jogador implements Comparable<Jogador> {
    private Long idJogador;
    private Long idTime;
    private String nomeJogador;
    private LocalDate dataNascimento;
    private Integer nivelHabilidade;
    private BigDecimal salarioJogador;

    //Constructor ListaJogadores
    public Jogador(Long idJogador, Long idTime, String nomeJogador, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salarioJogador) {
        this.idJogador = idJogador;
        this.idTime = idTime;
        this.nomeJogador = nomeJogador;
        this.dataNascimento = dataNascimento;
        this.nivelHabilidade = nivelHabilidade;
        this.salarioJogador = salarioJogador;
    }
    //Getters methods
    public Long getIdJogador() {
        return idJogador;
    }
    public Long getIdTime() {
        return idTime;
    }
    public String getNomeJogador() {
        return nomeJogador;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public Integer getNivelHabilidade() {
        return nivelHabilidade;
    }
    public BigDecimal getSalarioJogador() {
        return salarioJogador;
    }

    @Override
    public int compareTo(Jogador outro) {
        return outro.getNivelHabilidade().compareTo(this.nivelHabilidade);
    }
}
