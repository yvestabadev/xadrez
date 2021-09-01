package br.com.akconsultor.xadrez.tabuleiro;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Jogo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(cascade = CascadeType.ALL)
	private Jogador jogador1;
	@OneToOne(cascade = CascadeType.ALL)
	private Jogador jogador2;
	@OneToOne(cascade = CascadeType.ALL)
	private Tabuleiro tabuleiro;

	public Jogo() {
	}

	public Jogo(String jogador1, String jogador2) {
		this.tabuleiro = new Tabuleiro(1);
		this.jogador1 = new Jogador(jogador1, true, tabuleiro);
		this.jogador2 = new Jogador(jogador2, false, tabuleiro);

	}

	public Long getId() {
		return id;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public Jogador getJogador1() {
		return jogador1;
	}

	public Jogador getJogador2() {
		return jogador2;
	}

}
