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
						//se tiver peca da cor do rei na posicao nao pode andar
						if(tabuleiro.getPosicoes(peca.getEhBranca(), i, j)) {
							break;
						} 
						
						podeMover[i][j] = true;
						
						//se tiver peca da cor adversaria pode andar mas nao pode mais andar
						if(tabuleiro.getPosicoes(!peca.getEhBranca(), i, j));{
							break;
						}
					}

				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
		}

		return podeMover;
	}
}
