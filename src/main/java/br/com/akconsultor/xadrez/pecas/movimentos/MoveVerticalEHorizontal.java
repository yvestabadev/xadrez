package br.com.akconsultor.xadrez.pecas.movimentos;

import br.com.akconsultor.xadrez.pecas.Peca;
import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;

public interface MoveVerticalEHorizontal {

	public default boolean[][] moveLado(Peca peca, Tabuleiro tabuleiro) {
		boolean[][] podeMover = new boolean[8][8];
		Integer[] posicao = peca.getPosicao();
		if (peca.getEhBranca()) {
			for (int i = posicao[0] + 1; i < 8; i++) {

				if (tabuleiro.getPosicoesBrancas(i, posicao[1])) {
					break;
				} else if (tabuleiro.getPosicoesPretas(i, posicao[1])) {
					podeMover[i][posicao[1]] = true;
					break;
				}

				podeMover[i][posicao[1]] = true;
			}

			for (int i = posicao[0] - 1; i >= 0; i--) {

				if (tabuleiro.getPosicoesBrancas(i, posicao[1])) {
					break;
				} else if (tabuleiro.getPosicoesPretas(i, posicao[1])) {
					podeMover[i][posicao[1]] = true;
					break;
				}

				podeMover[i][posicao[1]] = true;
			}
			
			for (int i = posicao[1] + 1; i < 8; i++) {

				if (tabuleiro.getPosicoesBrancas(posicao[0], i)) {
					break;
				} else if (tabuleiro.getPosicoesPretas(posicao[0], i)) {
					podeMover[posicao[0]][i] = true;
					break;
				}

				podeMover[posicao[0]][i] = true;
			}
			for (int i = posicao[1] - 1; i >= 0; i--) {

				if (tabuleiro.getPosicoesBrancas(posicao[0], i)) {
					break;
				} else if (tabuleiro.getPosicoesPretas(posicao[0], i)) {
					podeMover[posicao[0]][i] = true;
					break;
				}

				podeMover[posicao[0]][i] = true;
			}
		} else if (!peca.getEhBranca()) {
			for (int i = posicao[0] + 1; i < 8; i++) {

				if (tabuleiro.getPosicoesPretas(i, posicao[1])) {
					break;
				} else if (tabuleiro.getPosicoesBrancas(i, posicao[1])) {
					podeMover[i][posicao[1]] = true;
					break;
				}

				podeMover[i][posicao[1]] = true;
			}

			for (int i = posicao[0] - 1; i >= 0; i--) {

				if (tabuleiro.getPosicoesPretas(i, posicao[1])) {
					break;
				} else if (tabuleiro.getPosicoesBrancas(i, posicao[1])) {
					podeMover[i][posicao[1]] = true;
					break;
				}

				podeMover[i][posicao[1]] = true;
			}
			
			for (int i = posicao[1] + 1; i < 8; i++) {

				if (tabuleiro.getPosicoesPretas(posicao[0], i)) {
					break;
				} else if (tabuleiro.getPosicoesBrancas(posicao[0], i)) {
					podeMover[posicao[0]][i] = true;
					break;
				}

				podeMover[posicao[0]][i] = true;
			}
			for (int i = posicao[1] - 1; i >= 0; i--) {

				if (tabuleiro.getPosicoesPretas(posicao[0], i)) {
					break;
				} else if (tabuleiro.getPosicoesBrancas(posicao[0], i)) {
					podeMover[posicao[0]][i] = true;
					break;
				}

				podeMover[posicao[0]][i] = true;
			}
		}
		
		return podeMover;
	}
}
