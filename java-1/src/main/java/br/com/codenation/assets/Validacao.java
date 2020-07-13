package br.com.codenation.assets;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;
import br.com.codenation.model.Jogador;
import br.com.codenation.model.Time;

import java.util.List;

public class Validacao {

    public static void validaSeExisteIdJogador(Long idJogador, List<Jogador> listaJogadores) {
        for (Jogador jogador : listaJogadores) {
            if (jogador.getIdJogador().equals(idJogador)) {
                return;
            }
        }
        throw new JogadorNaoEncontradoException();
    }

    public static void validaSeExisteIdTime(Long idTime, List<Time> listaTimes) {
        for (Time time : listaTimes) {
            if (time.getIdTime().equals(idTime)) {
                return;
            }
        }
        throw new TimeNaoEncontradoException();
    }

    public static void validaSeEstaDisponivelIdJogador(Long idJogador, List<Jogador> listaJogadores) {
        for (Jogador jogador : listaJogadores) {
            if (jogador.getIdJogador().compareTo(idJogador) == 0L) {
                throw new IdentificadorUtilizadoException();
            }
        }
    }

    public static void validaSeEstaDisponivelIdTime(Long idTime, List<Time> listaTimes) {
        for (Time time : listaTimes) {
            if(time.getIdTime().compareTo(idTime) == 0L) {
                throw new IdentificadorUtilizadoException();
            }
        }
    }

    public static void validaSeListaTimeNaoEstaVazia(List<Time> listaTimes) {
        if (listaTimes.isEmpty()) {
            throw new TimeNaoEncontradoException();
        }
    }

    public static void validaSeTimeTemCapitao(Time time) {
        if (time.getIdCapitao() == null) {
            throw new CapitaoNaoInformadoException();
        }
    }
}
