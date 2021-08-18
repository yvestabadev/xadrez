package br.com.akconsultor.xadrez.pecas;

import java.util.ArrayList;
import java.util.List;

import br.com.akconsultor.xadrez.pecas.movimentos.Direcao;
import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;

public abstract class Peca {

	private Integer[] posicao = new Integer[2];
	private Boolean ehBranca;
	protected List<Direcao> direcoes = new ArrayList<Direcao>();
	protected Tabuleiro tabuleiro;

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void adicionarDirecoes(Direcao direcao) {
		direcoes.add(direcao);
	}
	
	public List<Direcao> getDirecoes() {
		return direcoes;
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
