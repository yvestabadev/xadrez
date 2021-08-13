package br.com.akconsultor.xadrez.pecas;

import br.com.akconsultor.xadrez.pecas.movimentos.MoveDiagonal;
import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;

public class Bispo extends Peca implements MoveDiagonal{
	
	public Bispo(Boolean ehBranca, Integer coluna, Integer linha, Tabuleiro tabuleiro) {
		super.setEhBranca(ehBranca);
		super.setPosicao(coluna, linha);
		if(ehBranca) {
			tabuleiro.setPosicoesBrancas(this, coluna, linha);
		} else {
			tabuleiro.setPosicoesPretas(this, coluna, linha);
		}
		
	}

	@Override
	public void verificaDestino(Tabuleiro tabuleiro) {
		tabuleiro.complementarMovimento(moveDiagonal(this, tabuleiro));
		
	}

	@Override
	public void ameacaCasas(Tabuleiro tabuleiro) {
		tabuleiro.complementarAmeaca(moveDiagonal(this, tabuleiro));
	}

}
