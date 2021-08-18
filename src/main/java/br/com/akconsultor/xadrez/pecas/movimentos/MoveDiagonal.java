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

	public default void verificaCheck(Peca peca, Tabuleiro tabuleiro) {

		Integer[] reiBranco = tabuleiro.getReiBranco();
		Integer[] reiPreto = tabuleiro.getReiPreto();
		Integer[] posicaoPeca = peca.getPosicao();
		boolean podeMover[][] = moveDiagonal(peca, tabuleiro);

		if (peca.getEhBranca()) {

			if (podeMover[reiPreto[0]][reiPreto[1]]) {
				if (reiPreto[0] < posicaoPeca[0] && reiPreto[1] < posicaoPeca[1]) {
					tabuleiro.adicionarDirecoesCheck(Direcao.SW);
				} else if (reiPreto[0] < posicaoPeca[0] && reiPreto[1] > posicaoPeca[1]) {
					tabuleiro.adicionarDirecoesCheck(Direcao.NW);
				} else if (reiPreto[0] > posicaoPeca[0] && reiPreto[1] > posicaoPeca[1]) {
					tabuleiro.adicionarDirecoesCheck(Direcao.NE);
				} else {
					tabuleiro.adicionarDirecoesCheck(Direcao.SE);
				}

				tabuleiro.setPecaAmeaca(peca);
			}

		} else {

			if (podeMover[reiBranco[0]][reiBranco[1]]) {
				if (reiBranco[0] < posicaoPeca[0] && reiBranco[1] < posicaoPeca[1]) {
					tabuleiro.adicionarDirecoesCheck(Direcao.SW);
				} else if (reiBranco[0] < posicaoPeca[0] && reiBranco[1] > posicaoPeca[1]) {
					tabuleiro.adicionarDirecoesCheck(Direcao.NW);
				} else if (reiBranco[0] > posicaoPeca[0] && reiBranco[1] > posicaoPeca[1]) {
					tabuleiro.adicionarDirecoesCheck(Direcao.NE);
				} else {
					tabuleiro.adicionarDirecoesCheck(Direcao.SE);
				}

				tabuleiro.setPecaAmeaca(peca);

			}

		}

	}

}
