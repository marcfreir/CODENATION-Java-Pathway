package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

interface MeuTimeInterface {

    void incluirTime(Long idTime, String nomeTime, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario);

    void incluirJogador(Long idJogador, Long idTime, String nomeJogador, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salarioJogador);

    void definirCapitao(Long idJogador);

    Long buscarCapitaoDoTime(Long idTime);

    String buscarNomeJogador(Long idJogador);

    String buscarNomeTime(Long idTime);

    Long buscarJogadorMaiorSalario(Long idTime);

    BigDecimal buscarSalarioDoJogador(Long idJogador);

    List<Long> buscarJogadoresDoTime(Long idTime);

    Long buscarMelhorJogadorDoTime(Long idTime);

    Long buscarJogadorMaisVelho(Long idTime);

    List<Long> buscarTimes();

    List<Long> buscarTopJogadores(Integer top);
}
