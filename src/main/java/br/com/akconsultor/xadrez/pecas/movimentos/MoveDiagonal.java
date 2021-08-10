package br.com.akconsultor.xadrez.pecas.movimentos;

import br.com.akconsultor.xadrez.pecas.Peca;
import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;

public interface MoveDiagonal {

	public default boolean[][] moveDiagonal(Peca peca, Tabuleiro tabuleiro) {
		boolean[][] podeMover = new boolean[8][8];
		Integer[] posicao = peca.getPosicao();

		if (peca.getEhBranca()) {
			for (int i = posicao[0] + 1; i < 8; i++) {
				try {
					if (tabuleiro.getPosicoesBrancas(i, posicao[1] + i - posicao[0])) {
						break;
					} else if (tabuleiro.getPosicoesPretas(i, posicao[1] + i - posicao[0])) {
						podeMover[i][posicao[1] + i - posicao[0]] = true;
						break;
					}
				} catch (IndexOutOfBoundsException e) {
					break;
				}

				podeMover[i][posicao[1] + i - posicao[0]] = true;
			}

			for (int i = posicao[0] - 1; i >= 0; i--) {
				try {
					if (tabuleiro.getPosicoesBrancas(i, posicao[1] + i - posicao[0])) {
						break;
					} else if (tabuleiro.getPosicoesPretas(i, posicao[1] + i - posicao[0])) {
						podeMover[i][posicao[1] + i - posicao[0]] = true;
						break;
					}
				} catch (IndexOutOfBoundsException e) {
					break;
				}

				podeMover[i][posicao[1] + i - posicao[0]] = true;
			}

			for (int i = posicao[0] + 1; i < 8; i++) {
				try {
					if (tabuleiro.getPosicoesBrancas(i, posicao[1] + posicao[0] - i)) {
						break;
					} else if (tabuleiro.getPosicoesPretas(i, posicao[1] + posicao[0] - i)) {
						podeMover[i][posicao[1] + posicao[0] - i] = true;
						break;
					}
				} catch (IndexOutOfBoundsException e) {
					break;
				}

				podeMover[i][posicao[1] + posicao[0] - i] = true;
			}

			for (int i = posicao[0] - 1; i >= 0; i--) {
				try {
					if (tabuleiro.getPosicoesBrancas(i, posicao[1] + posicao[0] - i)) {
						break;
					} else if (tabuleiro.getPosicoesPretas(i, posicao[1] + posicao[0] - i)) {
						podeMover[i][posicao[1] + posicao[0] - i] = true;
						break;
					}
				} catch (IndexOutOfBoundsException e) {
					break;
				}

				podeMover[i][posicao[1] + posicao[0] - i] = true;
			}

		} else {
			for (int i = posicao[0] + 1; i < 8; i++) {
				try {
					if (tabuleiro.getPosicoesPretas(i, posicao[1] + i - posicao[0])) {
						break;
					} else if (tabuleiro.getPosicoesBrancas(i, posicao[1] + i - posicao[0])) {
						podeMover[i][posicao[1] + i - posicao[0]] = true;
						break;
					}
				} catch (IndexOutOfBoundsException e) {
					break;
				}

				podeMover[i][posicao[1] + i - posicao[0]] = true;
			}

			for (int i = posicao[0] - 1; i >= 0; i--) {
				try {
					if (tabuleiro.getPosicoesPretas(i, posicao[1] + i - posicao[0])) {
						break;
					} else if (tabuleiro.getPosicoesBrancas(i, posicao[1] + i - posicao[0])) {
						podeMover[i][posicao[1] + i - posicao[0]] = true;
						break;
					}
				} catch (IndexOutOfBoundsException e) {
					break;
				}

				podeMover[i][posicao[1] + i - posicao[0]] = true;
			}

			for (int i = posicao[0] + 1; i < 8; i++) {
				try {
					if (tabuleiro.getPosicoesPretas(i, posicao[1] + posicao[0] - i)) {
						break;
					} else if (tabuleiro.getPosicoesBrancas(i, posicao[1] + posicao[0] - i)) {
						podeMover[i][posicao[1] + posicao[0] - i] = true;
						break;
					}
				} catch (IndexOutOfBoundsException e) {
					break;
				}

				podeMover[i][posicao[1] + posicao[0] - i] = true;
			}

			for (int i = posicao[0] - 1; i >= 0; i--) {
				try {
					if (tabuleiro.getPosicoesPretas(i, posicao[1] + posicao[0] - i)) {
						break;
					} else if (tabuleiro.getPosicoesBrancas(i, posicao[1] + posicao[0] - i)) {
						podeMover[i][posicao[1] + posicao[0] - i] = true;
						break;
					}
				} catch (IndexOutOfBoundsException e) {
					break;
				}

				podeMover[i][posicao[1] + posicao[0] - i] = true;
			}

		}

		return podeMover;
	}

}
