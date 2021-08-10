package br.com.akconsultor.xadrez.tabuleiro;

import br.com.akconsultor.xadrez.pecas.Peca;

public class Tabuleiro {
	
	private boolean[][] posicoesBrancas = new boolean[8][8];
	private boolean[][] posicoesPretas = new boolean[8][8];
	private boolean[][] acionarMovimento = new boolean[8][8];
	
	public boolean getPosicoesBrancas(Integer coluna, Integer linha) {
		return posicoesBrancas[coluna][linha];
	}
	public void setPosicoesBrancas(Peca peca, Integer coluna, Integer linha) {
		this.posicoesBrancas[coluna][linha] = true;
	}
	public boolean getPosicoesPretas(Integer coluna, Integer linha) {
		return posicoesPretas[coluna][linha];
	}
	public void setPosicoesPretas(Peca peca, Integer coluna, Integer linha) {
		this.posicoesPretas[coluna][linha] = true;
	}
	public boolean[][] getAcionarMovimento() {
		return acionarMovimento;
	}
	public void setAcionarMovimento(boolean[][] acionarMovimento) {
		this.acionarMovimento = acionarMovimento;
	}
	
	public void complementarMovimento(boolean[][] movimento) {
		for(int i = 0; i< 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(movimento[i][j]) {
					this.acionarMovimento[i][j] = true;
				}
			}
		}
	}

	

}
