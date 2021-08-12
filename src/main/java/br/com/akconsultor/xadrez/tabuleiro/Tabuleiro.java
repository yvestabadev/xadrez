package br.com.akconsultor.xadrez.tabuleiro;

import java.util.ArrayList;
import java.util.List;

import br.com.akconsultor.xadrez.pecas.Peca;

public class Tabuleiro {
	
	private boolean[][] posicoesBrancas = new boolean[8][8];
	private boolean[][] posicoesPretas = new boolean[8][8];
	private boolean[][] acionarMovimento = new boolean[8][8];
	private boolean[][] lugaresAmeacados = new boolean[8][8];
	private List<Peca> pecasBrancas = new ArrayList<Peca>();
	private List<Peca> pecasPretas = new ArrayList<Peca>();
	private Boolean vezDasBrancas = true;

	
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
	public void resetAcionarMovimento() {
		this.acionarMovimento = new boolean[8][8];
	}
	
	
	
	public List<Peca> getPecasBrancas() {
		return pecasBrancas;
	}
	public void setPecasBrancas(List<Peca> pecasBrancas) {
		this.pecasBrancas = pecasBrancas;
	}
	public List<Peca> getPecasPretas() {
		return pecasPretas;
	}
	public void setPecasPretas(List<Peca> pecasPretas) {
		this.pecasPretas = pecasPretas;
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
	
	public void verifica(Jogador jogador, Peca peca) {
		if(jogador.getJogaComBranco() && this.vezDasBrancas) {
			peca.verificaDestino(this);
		} else if (!jogador.getJogaComBranco() && !this.vezDasBrancas) {
			peca.verificaDestino(this);
		}
	}
	
	public void move(Jogador jogador, Peca peca, Integer coluna, Integer linha) {
		if (jogador.getJogaComBranco() && this.vezDasBrancas
				&& this.acionarMovimento[coluna][linha]) {
			this.posicoesBrancas[peca.getPosicao()[0]][peca.getPosicao()[1]] = false;
			peca.setPosicao(coluna, linha);
			this.posicoesBrancas[peca.getPosicao()[0]][peca.getPosicao()[1]] = true;
			this.vezDasBrancas = false;
		} else if (!jogador.getJogaComBranco() && !this.vezDasBrancas
				&& this.acionarMovimento[coluna][linha]) {
			this.posicoesPretas[peca.getPosicao()[0]][peca.getPosicao()[1]] = false;
			peca.setPosicao(coluna, linha);
			this.posicoesPretas[peca.getPosicao()[0]][peca.getPosicao()[1]] = true;
			this.vezDasBrancas = true;
		}
	}

	

}
