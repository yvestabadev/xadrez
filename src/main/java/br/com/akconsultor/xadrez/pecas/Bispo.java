package br.com.akconsultor.xadrez.pecas;

import br.com.akconsultor.xadrez.pecas.movimentos.Direcao;
import br.com.akconsultor.xadrez.pecas.movimentos.MoveDiagonal;
import br.com.akconsultor.xadrez.pecas.movimentos.ProtegeRei;
import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;

public class Bispo extends Peca implements MoveDiagonal, ProtegeRei{
	
	public Bispo(Boolean ehBranca, Integer coluna, Integer linha, Tabuleiro tabuleiro) {
		super.setEhBranca(ehBranca);
		super.setPosicao(coluna, linha);
		super.setTabuleiro(tabuleiro);
		this.adicionarDirecoes(Direcao.DIAGONAL);
		if(ehBranca) {
			tabuleiro.setPosicoesBrancas(this, coluna, linha);
		} else {
			tabuleiro.setPosicoesPretas(this, coluna, linha);
		}
		
	}

	@Override
	public void verificaDestino() {
		tabuleiro.complementarMovimento(moveDiagonal(this, tabuleiro));
		
	}

	@Override
	public void ameacaCasas() {
		tabuleiro.complementarAmeaca(moveDiagonal(this, tabuleiro));
		verificaCheck(this, tabuleiro);
	}

}
