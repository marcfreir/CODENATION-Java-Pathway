package br.com.codenation.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Time {
    private Long idTime;
    private String nomeTime;
    private LocalDate dataCriacao;
    private String corUniformePrincipal;
    private String corUniformeSecundario;
    private List<Long> listaJogadores;
    private Long idCapitao;

    //Constructor ListaTimes


    public Time(Long idTime, String nomeTime, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
        this.idTime = idTime;
        this.nomeTime = nomeTime;
        this.dataCriacao = dataCriacao;
        this.corUniformePrincipal = corUniformePrincipal;
        this.corUniformeSecundario = corUniformeSecundario;
        this.listaJogadores = new ArrayList<>();
    }

    //Getters Methods
    public Long getIdTime() {
        return idTime;
    }
    public String getNomeTime() {
        return nomeTime;
    }
    public LocalDate getDataCriacao() {
        return dataCriacao;
    }
    public String getCorUniformePrincipal() {
        return corUniformePrincipal;
    }
    public String getCorUniformeSecundario() {
        return corUniformeSecundario;
    }
    public List<Long> getListaJogadores() {
        return listaJogadores;
    }
    public Long getIdCapitao() {
        return idCapitao;
    }

    //Set Method for idCapitao
    public void setIdCapitao(Long idCapitao) {
        this.idCapitao = idCapitao;
    }
}
