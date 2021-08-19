package br.com.akconsultor.xadrez.pecas;

import br.com.akconsultor.xadrez.pecas.movimentos.Direcao;
import br.com.akconsultor.xadrez.pecas.movimentos.ProtegeRei;
import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;

public class Peao extends Peca implements ProtegeRei {

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
		if (tabuleiro.getCheck()) {
			boolean[][] destino = corrigeDestino(this.movimentoPeao(), this, tabuleiro);
			tabuleiro.complementarMovimento(destino);
		} else {

			tabuleiro.complementarMovimento(this.movimentoPeao());
		}
	}

	private boolean[][] movimentoPeao() {
		boolean[][] podeMover = new boolean[8][8];
		Integer[] posicao = this.getPosicao();
		Integer qtdeCasas;
		Integer posInicial;
		
		if(this.getEhBranca()) {
			qtdeCasas = 1;
			posInicial = 1;
		}else {
			qtdeCasas = -1;
			posInicial = 6;
		}

	
			if (!tabuleiro.getPosicoes(this.getEhBranca(), posicao[0], posicao[1] + qtdeCasas)
					&& !tabuleiro.getPosicoes(!this.getEhBranca(), posicao[0], posicao[1] + qtdeCasas)) {
				podeMover[posicao[0]][posicao[1] + qtdeCasas] = true;
				if (!tabuleiro.getPosicoes(this.getEhBranca(), posicao[0], posicao[1] + (qtdeCasas*2))
						&& !tabuleiro.getPosicoes(!this.getEhBranca(), posicao[0], posicao[1] + (qtdeCasas*2)) && posicao[1] == posInicial) {
					podeMover[posicao[0]][posicao[1] + (qtdeCasas*2)] = true;
				}
			}
			try {
				if (tabuleiro.getPosicoes(!this.getEhBranca(), posicao[0] + 1, posicao[1] + qtdeCasas)) {
					podeMover[posicao[0] + 1][posicao[1] + qtdeCasas] = true;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
			}
			try {

				if (tabuleiro.getPosicoes(!this.getEhBranca(), posicao[0] - 1, posicao[1] + qtdeCasas)) {
					podeMover[posicao[0] - 1][posicao[1] + qtdeCasas] = true;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
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
		
		verificaCheck();
	}

	private void verificaCheck() {
		Integer[] reiPreto = tabuleiro.getReiPreto();
		Integer[] reiBranco = tabuleiro.getReiBranco();
		Integer[] posicao = this.getPosicao();

		if (this.getEhBranca()) {
			try {
				if (posicao[0] + 1 == reiPreto[0] && posicao[1] + 1 == reiPreto[1]) {
					tabuleiro.setPecaAmeaca(this);
					tabuleiro.adicionarDirecoesCheck(Direcao.DIAGONAL);
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}
			try {
				if (posicao[0] - 1 == reiPreto[0] && posicao[1] + 1 == reiPreto[1]) {
					tabuleiro.setPecaAmeaca(this);
					tabuleiro.adicionarDirecoesCheck(Direcao.DIAGONAL);
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}

		} else {
			try {
				if (posicao[0] + 1 == reiBranco[0] && posicao[1] - 1 == reiBranco[1]) {
					tabuleiro.setPecaAmeaca(this);
					tabuleiro.adicionarDirecoesCheck(Direcao.DIAGONAL);
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}
			try {
				if (posicao[0] - 1 == reiBranco[0] && posicao[1] - 1 == reiBranco[1]) {
					tabuleiro.setPecaAmeaca(this);
					tabuleiro.adicionarDirecoesCheck(Direcao.DIAGONAL);
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}
		}
	}
}
