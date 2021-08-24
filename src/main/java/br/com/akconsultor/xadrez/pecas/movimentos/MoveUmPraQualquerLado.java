package br.com.akconsultor.xadrez.pecas.movimentos;

import br.com.akconsultor.xadrez.pecas.Peca;
import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;

public interface MoveUmPraQualquerLado {

	public default boolean[][] moveRei(Peca peca, Tabuleiro tabuleiro) {

		boolean[][] podeMover = new boolean[8][8];
		Integer[] posicao = peca.getPosicao();

		for (int i = posicao[0] - 1; i <= posicao[0] + 1; i++) {
			for (int j = posicao[1] - 1; j <= posicao[1] + 1; j++) {
				try {
					if (i != posicao[0] || j != posicao[1]) {
						podeMover[i][j] = true;
					}

				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
		}

		return podeMover;
	}
}
