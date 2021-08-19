package br.com.akconsultor.xadrez.pecas;

import java.util.ArrayList;
import java.util.List;

import br.com.akconsultor.xadrez.pecas.movimentos.Direcao;
import br.com.akconsultor.xadrez.pecas.movimentos.MoveUmPraQualquerLado;
import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;

public class Rei extends Peca implements MoveUmPraQualquerLado {

	public Rei(Boolean ehBranca, Integer coluna, Integer linha, Tabuleiro tabuleiro) {
		super.setEhBranca(ehBranca);
		super.setPosicao(coluna, linha);
		super.setTabuleiro(tabuleiro);
		if (ehBranca) {
			tabuleiro.setPosicoesBrancas(this, coluna, linha);
			tabuleiro.setReiBranco(coluna, linha);
			tabuleiro.setReiBrancoPeca(this);
		} else {
			tabuleiro.setPosicoesPretas(this, coluna, linha);
			tabuleiro.setReiPreto(coluna, linha);
			tabuleiro.setReiPretoPeca(this);
		}

	}

	@Override
	public void verificaDestino() {
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
	public void ameacaCasas() {
		tabuleiro.complementarAmeaca(moveRei(this, tabuleiro));
	}

	@Override
	public void setPosicao(Integer coluna, Integer linha) {
		super.setPosicao(coluna, linha);
		if (this.getEhBranca()) {
			this.tabuleiro.setReiBranco(coluna, linha);
		} else {
			this.tabuleiro.setReiPreto(coluna, linha);
		}
	}

	public void pedeProtecao() {

		for (int i = this.getPosicao()[0] + 1; i < 8; i++) {
			int j = this.getPosicao()[1];
			if (tabuleiro.getPosicoes(this.getEhBranca(), i, j)) {
				Peca peca = this.encontraPeca(this.getEhBranca(), i, j);
				peca.setDirecaoProtegida(Direcao.HORIZONTAL);
				break;
			} else if (tabuleiro.getPosicoes(!this.getEhBranca(), i, j)) {
				break;
			}
		}

		for (int i = this.getPosicao()[0] - 1; i >= 0; i--) {
			int j = this.getPosicao()[1];
			if (tabuleiro.getPosicoes(this.getEhBranca(), i, j)) {
				Peca peca = this.encontraPeca(this.getEhBranca(), i, j);
				peca.setDirecaoProtegida(Direcao.HORIZONTAL);
				break;
			} else if (tabuleiro.getPosicoes(!this.getEhBranca(), i, j)) {
				break;
			}
		}

		for (int i = this.getPosicao()[1] - 1; i >= 0; i--) {
			int j = this.getPosicao()[0];
			if (tabuleiro.getPosicoes(this.getEhBranca(),j, i)) {
				Peca peca = this.encontraPeca(this.getEhBranca(), j, i);
				peca.setDirecaoProtegida(Direcao.VERTICAL);
				break;
			} else if (tabuleiro.getPosicoes(!this.getEhBranca(),j, i)) {
				break;
			}
		}

		for (int i = this.getPosicao()[1] + 1; i < 8; i++) {
			int j = this.getPosicao()[0];
			if (tabuleiro.getPosicoes(this.getEhBranca(),j, i)) {
				Peca peca = this.encontraPeca(this.getEhBranca(), j, i);
				peca.setDirecaoProtegida(Direcao.VERTICAL);
				break;
			} else if (tabuleiro.getPosicoes(!this.getEhBranca(), j, i)) {
				break;
			}
		}

		for (int i = this.getPosicao()[0] + 1; i < 8; i++) {
			int j = this.getPosicao()[1] + (i - this.getPosicao()[0]);
			try {
				if (tabuleiro.getPosicoes(this.getEhBranca(),i, j)) {
					Peca peca = this.encontraPeca(this.getEhBranca(), i, j);
					peca.setDirecaoProtegida(Direcao.NESW);
					break;
				} else if (tabuleiro.getPosicoes(!this.getEhBranca(),i, j)) {
					break;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				break;
			}
		}

		for (int i = this.getPosicao()[0] - 1; i >= 0; i--) {
			int j = this.getPosicao()[1] + (i - this.getPosicao()[0]);
			try {
				if (tabuleiro.getPosicoes(this.getEhBranca(),i, j)) {
					Peca peca = this.encontraPeca(this.getEhBranca(), i, j);
					peca.setDirecaoProtegida(Direcao.NESW);
					break;
				} else if (tabuleiro.getPosicoes(!this.getEhBranca(),i, j)) {
					break;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				break;
			}
		}

		for (int i = this.getPosicao()[0] + 1; i < 8; i++) {
			int j = this.getPosicao()[1] - (i - this.getPosicao()[0]);
			try {
				if (tabuleiro.getPosicoes(this.getEhBranca(),i, j)) {
					Peca peca = this.encontraPeca(this.getEhBranca(), i, j);
					peca.setDirecaoProtegida(Direcao.NWSE);
					break;
				} else if (tabuleiro.getPosicoes(!this.getEhBranca(),i, j)) {
					break;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				break;
			}
		}

		for (int i = this.getPosicao()[0] - 1; i >= 0; i--) {
			int j = this.getPosicao()[1] - (i - this.getPosicao()[0]);
			try {
				if (tabuleiro.getPosicoes(this.getEhBranca(),i, j)) {
					Peca peca = this.encontraPeca(this.getEhBranca(), i, j);
					peca.setDirecaoProtegida(Direcao.NWSE);
					break;
				} else if (tabuleiro.getPosicoes(!this.getEhBranca(),i, j)) {
					break;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				break;
			}

		}

	}

	private Peca encontraPeca(Boolean ehBranca, Integer coluna, Integer linha) {

		if (ehBranca) {
			List<Peca> pecas = this.tabuleiro.getPecasBrancas();

			for (Peca peca : pecas) {
				if (peca.getPosicao()[0] == coluna && peca.getPosicao()[1] == linha) {
					return peca;
				}
			}
		} else {
			List<Peca> pecas = this.tabuleiro.getPecasPretas();

			for (Peca peca : pecas) {
				if (peca.getPosicao()[0] == coluna && peca.getPosicao()[1] == linha) {
					return peca;
				}
			}
		}
		return null;
	}

}
