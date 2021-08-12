package br.com.akconsultor.xadrez.pecas;

import br.com.akconsultor.xadrez.pecas.movimentos.MoveVerticalEHorizontal;
import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;

public class Torre extends Peca implements MoveVerticalEHorizontal{
	
	
	public Torre(Boolean ehBranca, Integer coluna, Integer linha, Tabuleiro tabuleiro) {
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
		tabuleiro.complementarMovimento(moveLado(this, tabuleiro));		
	}


	

}
