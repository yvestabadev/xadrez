package br.com.akconsultor.xadrez.pecas;

import br.com.akconsultor.xadrez.pecas.movimentos.MoveUmPraQualquerLado;
import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;

public class Rei extends Peca implements MoveUmPraQualquerLado {

	public Rei(Boolean ehBranca, Integer coluna, Integer linha, Tabuleiro tabuleiro) {
		super.setEhBranca(ehBranca);
		super.setPosicao(coluna, linha);
		if (ehBranca) {
			tabuleiro.setPosicoesBrancas(this, coluna, linha);
		} else {
			tabuleiro.setPosicoesPretas(this, coluna, linha);
		}

	}

	@Override
	public void verificaDestino(Tabuleiro tabuleiro) {
		boolean podeMover[][] = moveRei(this, tabuleiro);
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (tabuleiro.getLugaresAmeacados()[i][j]) {
					podeMover[i][j] = false;
				}
			}
		}
		
		tabuleiro.complementarMovimento(podeMover);

	}

	@Override
	public void ameacaCasas(Tabuleiro tabuleiro) {
		tabuleiro.complementarAmeaca(moveRei(this, tabuleiro));
	}
	

}
