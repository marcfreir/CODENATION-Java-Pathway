package br.com.codenation;

import br.com.codenation.assets.Validacao;
import br.com.codenation.model.Jogador;
import br.com.codenation.model.Time;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private List<Time> listaTimes = new ArrayList<>();
	private List<Jogador> listaJogadores = new ArrayList<>();

	public void incluirTime(Long idTime, String nomeTime, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		Validacao.validaSeEstaDisponivelIdTime(idTime, this.listaTimes);
		Time time = new Time(idTime, nomeTime, dataCriacao, corUniformePrincipal, corUniformeSecundario);
		this.listaTimes.add(time);
	}

	public void incluirJogador(Long idJogador, Long idTime, String nomeJogador, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salarioJogador) {
		Validacao.validaSeEstaDisponivelIdJogador(idJogador, this.listaJogadores);
		Validacao.validaSeListaTimeNaoEstaVazia(this.listaTimes);
		Jogador jogador = new Jogador(idJogador, idTime, nomeJogador, dataNascimento, nivelHabilidade, salarioJogador);
		buscarTimesPeloID(idTime).getListaJogadores().add(jogador.getIdJogador());
		listaJogadores.add(jogador);
	}

	private Time buscarTimesPeloID(Long idTime) {
		for (Time time : listaTimes) {
			if (time.getIdTime().equals(idTime)) {
				return time;
			}
		}
		return null;
	}

	private Jogador buscarJogadoresPeloID(Long idJogador) {
		for (Jogador jogador : listaJogadores) {
			if (jogador.getIdJogador().equals(idJogador)) {
				return jogador;
			}
		}
		return null;
	}

	public void definirCapitao(Long idJogador) {
		Validacao.validaSeExisteIdJogador(idJogador, this.listaJogadores);
		Jogador jogador = buscarJogadoresPeloID(idJogador);
		Time time = buscarTimesPeloID(jogador.getIdTime());
		time.setIdCapitao(jogador.getIdJogador());
	}

	public Long buscarCapitaoDoTime(Long idTime) {
		Validacao.validaSeListaTimeNaoEstaVazia(this.listaTimes);
		Validacao.validaSeExisteIdTime(idTime, this.listaTimes);
		Time time = buscarTimesPeloID(idTime);
		Validacao.validaSeTimeTemCapitao(time);
		return time.getIdCapitao();
	}

	public String buscarNomeJogador(Long idJogador) {
		Validacao.validaSeExisteIdJogador(idJogador, this.listaJogadores);
		Jogador jogador = buscarJogadoresPeloID(idJogador);
		return jogador.getNomeJogador();
	}

	public String buscarNomeTime(Long idTime) {
		Validacao.validaSeExisteIdTime(idTime, this.listaTimes);
		Time time = buscarTimesPeloID(idTime);
		return time.getNomeTime();
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		Validacao.validaSeExisteIdTime(idTime, this.listaTimes);
		Time time = buscarTimesPeloID(idTime);
		List<Long> idsJogadores = time.getListaJogadores();
		Collections.sort(idsJogadores);
		return idsJogadores;
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		Validacao.validaSeExisteIdTime(idTime, this.listaTimes);
		Time time = buscarTimesPeloID(idTime);
		Jogador melhorJogador = null;

		for (Long idJogador : time.getListaJogadores()) {
			Jogador jogador = buscarJogadoresPeloID(idJogador);
			if(melhorJogador == null || melhorJogador.getNivelHabilidade() < jogador.getNivelHabilidade()) {
				melhorJogador = jogador;
			}
		}
		return melhorJogador.getIdJogador();
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		Validacao.validaSeExisteIdTime(idTime, this.listaTimes);
		Time time = buscarTimesPeloID(idTime);
		Jogador jogadorMaisVelho = null;

		for (Long idJogador : time.getListaJogadores()) {
			Jogador jogador = buscarJogadoresPeloID(idJogador);
			if (jogadorMaisVelho == null || jogadorMaisVelho.getDataNascimento().isAfter(jogador.getDataNascimento())) {
				jogadorMaisVelho = jogador;
			}
		}
		return jogadorMaisVelho.getIdJogador();
	}

	public List<Long> buscarTimes() {
		List<Long> idsTimes = new ArrayList<>();
		this.listaTimes.forEach(time -> idsTimes.add(time.getIdTime()));
		Collections.sort(idsTimes);
		return idsTimes;
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		Validacao.validaSeExisteIdTime(idTime, this.listaTimes);
		Time time = buscarTimesPeloID(idTime);
		Jogador jogadorMaiorSalario = null;

		for (Long idJogador : time.getListaJogadores()) {
			Jogador jogador = buscarJogadoresPeloID(idJogador);
			if (jogadorMaiorSalario == null || jogadorMaiorSalario.getSalarioJogador().compareTo(jogador.getSalarioJogador()) == -1) {
				jogadorMaiorSalario = jogador;
			} else if (jogadorMaiorSalario.getSalarioJogador().compareTo(jogador.getSalarioJogador()) == 0) {
				jogadorMaiorSalario = jogadorMaiorSalario.getIdJogador() < jogador.getIdJogador() ? jogadorMaiorSalario : jogador;
			}
		}
		return jogadorMaiorSalario.getIdJogador();
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		Validacao.validaSeExisteIdJogador(idJogador, this.listaJogadores);
		Jogador jogador = buscarJogadoresPeloID(idJogador);
		return jogador.getSalarioJogador();
	}

	public List<Long> buscarTopJogadores(Integer top) {
		List<Jogador> topJogadores = listaJogadores;
		List<Long> topJogadoresIDs = new ArrayList<>();

		if (topJogadores.isEmpty()) {
			return topJogadoresIDs;
		}

		Collections.sort(topJogadores);

		for (int index = 0; index < top - 1; index++) {
			if (topJogadores.get(index).getNivelHabilidade() == topJogadores.get(index + 1).getNivelHabilidade() && topJogadores.get(index).getIdJogador() > topJogadores.get(index + 1).getIdJogador()) {
				Jogador jogadorComIndex = topJogadores.get(index);
				topJogadores.set(index, topJogadores.get(index + 1));
				topJogadores.set(index + 1, jogadorComIndex);
			}
		}
		for (int index = 0; index < top; index++) {
			topJogadoresIDs.add(topJogadores.get(index).getIdJogador());
		}
		return topJogadoresIDs;
	}

}
