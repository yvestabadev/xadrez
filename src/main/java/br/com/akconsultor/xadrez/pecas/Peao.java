package br.com.akconsultor.xadrez.pecas;

import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;

public class Peao extends Peca {

	public Peao(Boolean ehBranca, Integer coluna, Integer linha, Tabuleiro tabuleiro) {
		super.setEhBranca(ehBranca);
		super.setPosicao(coluna, linha);
		super.setTabuleiro(tabuleiro);
		if (ehBranca) {
			tabuleiro.setPosicoesBrancas(this, coluna, linha);
		} else {
			tabuleiro.setPosicoesPretas(this, coluna, linha);
		}

	}

	@Override
	public void verificaDestino() {
		tabuleiro.complementarMovimento(this.movimentoPeao());
	}

	private boolean[][] movimentoPeao() {
		boolean[][] podeMover = new boolean[8][8];
		Integer[] posicao = this.getPosicao();

		if (this.getEhBranca()) {
			if (!tabuleiro.getPosicoesBrancas(posicao[0], posicao[1] + 1)
					&& !tabuleiro.getPosicoesPretas(posicao[0], posicao[1] + 1)) {
				podeMover[posicao[0]][posicao[1] + 1] = true;
				if (!tabuleiro.getPosicoesBrancas(posicao[0], posicao[1] + 2)
						&& !tabuleiro.getPosicoesPretas(posicao[0], posicao[1] + 2) && posicao[1] == 1) {
					podeMover[posicao[0]][posicao[1] + 2] = true;
				}
			}
			try {
				if (tabuleiro.getPosicoesPretas(posicao[0] + 1, posicao[1] + 1)) {
					podeMover[posicao[0] + 1][posicao[1] + 1] = true;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
			}
			try {

				if (tabuleiro.getPosicoesPretas(posicao[0] - 1, posicao[1] + 1)) {
					podeMover[posicao[0] - 1][posicao[1] + 1] = true;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
			}

		} else {
			if (!tabuleiro.getPosicoesBrancas(posicao[0], posicao[1] - 1)
					&& !tabuleiro.getPosicoesPretas(posicao[0], posicao[1] - 1)) {
				podeMover[posicao[0]][posicao[1] - 1] = true;
				if (!tabuleiro.getPosicoesBrancas(posicao[0], posicao[1] - 2)
						&& !tabuleiro.getPosicoesPretas(posicao[0], posicao[1] - 2) && posicao[1] == 6) {
					podeMover[posicao[0]][posicao[1] - 2] = true;
				}
			}
			try {
				if (tabuleiro.getPosicoesBrancas(posicao[0] + 1, posicao[1] - 1)) {
					podeMover[posicao[0] + 1][posicao[1] - 1] = true;
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}
			try {
				if (tabuleiro.getPosicoesBrancas(posicao[0] - 1, posicao[1] - 1)) {
					podeMover[posicao[0] - 1][posicao[1] - 1] = true;
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}
		}

		return podeMover;
	}

	@Override
	public void ameacaCasas() {
		boolean[][] ameaca = new boolean[8][8];
		Integer[] posicao = this.getPosicao();

		if (this.getEhBranca()) {

			try {

				ameaca[posicao[0] + 1][posicao[1] + 1] = true;

			} catch (ArrayIndexOutOfBoundsException e) {
			}
			try {

				ameaca[posicao[0] - 1][posicao[1] + 1] = true;

			} catch (ArrayIndexOutOfBoundsException e) {
			}

			tabuleiro.complementarAmeaca(ameaca);
		}

		if (!this.getEhBranca()) {

			try {
				ameaca[posicao[0] + 1][posicao[1] - 1] = true;
			} catch (ArrayIndexOutOfBoundsException e) {
			}
			try {
				ameaca[posicao[0] - 1][posicao[1] - 1] = true;
			} catch (ArrayIndexOutOfBoundsException e) {
			}
			
			tabuleiro.complementarAmeaca(ameaca);

		}
	}

}
