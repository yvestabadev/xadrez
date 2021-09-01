package br.com.akconsultor.xadrez.pecas;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.OrderColumn;

import br.com.akconsultor.xadrez.pecas.movimentos.Direcao;
import br.com.akconsultor.xadrez.pecas.movimentos.MoveUmPraQualquerLado;
import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;

@Entity
public class Rei extends Peca implements MoveUmPraQualquerLado {
	
	@ElementCollection
	@JoinTable(name = "posicao_inicial_rei")
	@OrderColumn
	Integer[] posicaoInicial;

	public Rei() {
	}

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

		this.posicaoInicial = new Integer[] { coluna, linha };

	}

	@Override
	public void verificaDestino() {
		boolean podeMover[][] = moveRei(this, tabuleiro);
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (tabuleiro.getLugaresAmeacados(i, j)) {
					podeMover[i][j] = false;
				}
			}
		}

		if (super.getEhBranca()) {
			if (tabuleiro.getRoqueGrande(true) && this.validaRoqueGrande()) {
				podeMover[2][0] = this.validaRoqueGrande();
				tabuleiro.setAtencaoRoqueGrandeBranco(true);
			}

			if (tabuleiro.getRoquePequeno(true) && this.validaRoquePequeno()) {
				podeMover[6][0] = this.validaRoquePequeno();
				tabuleiro.setAtencaoRoquePequenoBranco(true);
			}
		} else {
			if (tabuleiro.getRoqueGrande(false) && this.validaRoqueGrande()) {
				podeMover[2][7] = this.validaRoqueGrande();
				tabuleiro.setAtencaoRoqueGrandePreto(true);
			}

			if (tabuleiro.getRoquePequeno(false) && this.validaRoquePequeno()) {
				podeMover[6][7] = this.validaRoquePequeno();
				tabuleiro.setAtencaoRoquePequenoPreto(true);
			}
		}

		tabuleiro.complementarMovimento(podeMover);

	}

	private boolean validaRoqueGrande() {

		if (this.getEhBranca() && !tabuleiro.getPosicoes(true, 3, 0) && !tabuleiro.getPosicoes(false, 3, 0)
				&& !tabuleiro.getPosicoes(true, 2, 0) && !tabuleiro.getPosicoes(false, 2, 0)
				&& !tabuleiro.getPosicoes(true, 1, 0) && !tabuleiro.getPosicoes(false, 1, 0)
				&& !tabuleiro.getLugaresAmeacados(3, 0) && !tabuleiro.getLugaresAmeacados(2, 0)) {
			return true;
		}

		if (!this.getEhBranca() && !tabuleiro.getPosicoes(true, 3, 7) && !tabuleiro.getPosicoes(false, 3, 7)
				&& !tabuleiro.getPosicoes(true, 2, 7) && !tabuleiro.getPosicoes(false, 2, 7)
				&& !tabuleiro.getPosicoes(true, 1, 7) && !tabuleiro.getPosicoes(false, 1, 7)
				&& !tabuleiro.getLugaresAmeacados(3, 7) && !tabuleiro.getLugaresAmeacados(2, 7)) {
			return true;
		}

		return false;
	}

	private boolean validaRoquePequeno() {

		if (this.getEhBranca() && !tabuleiro.getPosicoes(true, 5, 0) && !tabuleiro.getPosicoes(false, 5, 0)
				&& !tabuleiro.getPosicoes(true, 6, 0) && !tabuleiro.getPosicoes(false, 6, 0)
				&& !tabuleiro.getLugaresAmeacados(5, 0) && !tabuleiro.getLugaresAmeacados(6, 0)) {
			return true;
		}

		if (!this.getEhBranca() && !tabuleiro.getPosicoes(true, 5, 7) && !tabuleiro.getPosicoes(false, 5, 7)
				&& !tabuleiro.getPosicoes(true, 6, 7) && !tabuleiro.getPosicoes(false, 6, 7)
				&& !tabuleiro.getLugaresAmeacados(5, 7) && !tabuleiro.getLugaresAmeacados(6, 7)) {
			return true;
		}

		return false;
	}

	@Override
	public void ameacaCasas() {
		tabuleiro.complementarAmeaca(moveRei(this, tabuleiro));

		if (tabuleiro.getRoqueGrande(this.getEhBranca()) || tabuleiro.getRoquePequeno(this.getEhBranca())) {
			if (this.posicaoInicial[0] != super.getPosicao()[0] || this.posicaoInicial[1] != super.getPosicao()[1]) {
				tabuleiro.invalidaRoqueGrande(this.getEhBranca());
				tabuleiro.invalidaRoquePequeno(this.getEhBranca());
			}
		}
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
				peca.setDirecaoProtegida(Direcao.DIREITA);
				break;
			} else if (tabuleiro.getPosicoes(!this.getEhBranca(), i, j)) {
				break;
			}
		}

		for (int i = this.getPosicao()[0] - 1; i >= 0; i--) {
			int j = this.getPosicao()[1];
			if (tabuleiro.getPosicoes(this.getEhBranca(), i, j)) {
				Peca peca = this.encontraPeca(this.getEhBranca(), i, j);
				peca.setDirecaoProtegida(Direcao.ESQUERDA);
				break;
			} else if (tabuleiro.getPosicoes(!this.getEhBranca(), i, j)) {
				break;
			}
		}

		for (int i = this.getPosicao()[1] - 1; i >= 0; i--) {
			int j = this.getPosicao()[0];
			if (tabuleiro.getPosicoes(this.getEhBranca(), j, i)) {
				Peca peca = this.encontraPeca(this.getEhBranca(), j, i);
				peca.setDirecaoProtegida(Direcao.TRAS);
				break;
			} else if (tabuleiro.getPosicoes(!this.getEhBranca(), j, i)) {
				break;
			}
		}

		for (int i = this.getPosicao()[1] + 1; i < 8; i++) {
			int j = this.getPosicao()[0];
			if (tabuleiro.getPosicoes(this.getEhBranca(), j, i)) {
				Peca peca = this.encontraPeca(this.getEhBranca(), j, i);
				peca.setDirecaoProtegida(Direcao.FRENTE);
				break;
			} else if (tabuleiro.getPosicoes(!this.getEhBranca(), j, i)) {
				break;
			}
		}

		for (int i = this.getPosicao()[0] + 1; i < 8; i++) {
			int j = this.getPosicao()[1] + (i - this.getPosicao()[0]);
			try {
				if (tabuleiro.getPosicoes(this.getEhBranca(), i, j)) {
					Peca peca = this.encontraPeca(this.getEhBranca(), i, j);
					peca.setDirecaoProtegida(Direcao.NE);
					break;
				} else if (tabuleiro.getPosicoes(!this.getEhBranca(), i, j)) {
					break;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				break;
			}
		}

		for (int i = this.getPosicao()[0] - 1; i >= 0; i--) {
			int j = this.getPosicao()[1] + (i - this.getPosicao()[0]);
			try {
				if (tabuleiro.getPosicoes(this.getEhBranca(), i, j)) {
					Peca peca = this.encontraPeca(this.getEhBranca(), i, j);
					peca.setDirecaoProtegida(Direcao.SW);
					break;
				} else if (tabuleiro.getPosicoes(!this.getEhBranca(), i, j)) {
					break;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				break;
			}
		}

		for (int i = this.getPosicao()[0] + 1; i < 8; i++) {
			int j = this.getPosicao()[1] - (i - this.getPosicao()[0]);
			try {
				if (tabuleiro.getPosicoes(this.getEhBranca(), i, j)) {
					Peca peca = this.encontraPeca(this.getEhBranca(), i, j);
					peca.setDirecaoProtegida(Direcao.SE);
					break;
				} else if (tabuleiro.getPosicoes(!this.getEhBranca(), i, j)) {
					break;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				break;
			}
		}

		for (int i = this.getPosicao()[0] - 1; i >= 0; i--) {
			int j = this.getPosicao()[1] - (i - this.getPosicao()[0]);
			try {
				if (tabuleiro.getPosicoes(this.getEhBranca(), i, j)) {
					Peca peca = this.encontraPeca(this.getEhBranca(), i, j);
					peca.setDirecaoProtegida(Direcao.NW);
					break;
				} else if (tabuleiro.getPosicoes(!this.getEhBranca(), i, j)) {
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
