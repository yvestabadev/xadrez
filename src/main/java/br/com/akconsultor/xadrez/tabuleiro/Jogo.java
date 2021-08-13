package br.com.akconsultor.xadrez.tabuleiro;

public class Jogo {
	
	private Jogador jogador1;
	private Jogador jogador2;
	private Tabuleiro tabuleiro;
	
	public Jogo(String jogador1, String jogador2) {
		this.tabuleiro = new Tabuleiro();
		this.jogador1 = new Jogador(jogador1, true, tabuleiro);
		this.jogador2 = new Jogador(jogador2, false, tabuleiro);
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
