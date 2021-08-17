package br.com.akconsultor.xadrez.pecas;

import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;

public abstract class Peca {
	
	private Integer[] posicao = new Integer[2];
	private Boolean ehBranca;
	protected Tabuleiro tabuleiro;
	
	
	
	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	public Integer[] getPosicao() {
		return posicao;
	}
	public void setPosicao(Integer coluna, Integer linha) {
		this.posicao[0] = coluna;
		this.posicao[1] = linha;
	}
	public Boolean getEhBranca() {
		return ehBranca;
	}
	public void setEhBranca(Boolean ehBranca) {
		this.ehBranca = ehBranca;
	}
	
	
	public abstract void verificaDestino();
	
	public abstract void ameacaCasas();
	
	
	
}
