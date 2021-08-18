package br.com.akconsultor.xadrez.pecas;

import br.com.akconsultor.xadrez.pecas.movimentos.Direcao;
import br.com.akconsultor.xadrez.pecas.movimentos.MoveDiagonal;
import br.com.akconsultor.xadrez.pecas.movimentos.MoveVerticalEHorizontal;
import br.com.akconsultor.xadrez.pecas.movimentos.ProtegeRei;
import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;

public class Dama extends Peca implements MoveDiagonal, MoveVerticalEHorizontal, ProtegeRei {

	public Dama(Boolean ehBranca, Integer coluna, Integer linha, Tabuleiro tabuleiro) {
		super.setEhBranca(ehBranca);
		super.setPosicao(coluna, linha);
		super.setTabuleiro(tabuleiro);
		this.adicionarDirecoes(Direcao.DIAGONAL);
		this.adicionarDirecoes(Direcao.LADOS);
		if (ehBranca) {
			tabuleiro.setPosicoesBrancas(this, coluna, linha);
		} else {
			tabuleiro.setPosicoesPretas(this, coluna, linha);
		}

	}

	@Override
	public void verificaDestino() {

		if (tabuleiro.getCheck()) {
			boolean[][] movimento = moveLado(this, tabuleiro);
			boolean[][] movimento2 = moveDiagonal(this, tabuleiro);

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (movimento2[i][j]) {
						movimento[i][j] = true;
					}
				}
			}

			boolean[][] destino = corrigeDestino(movimento, this, tabuleiro);
			tabuleiro.complementarMovimento(destino);
		} else {
			tabuleiro.complementarMovimento(moveLado(this, tabuleiro));
			tabuleiro.complementarMovimento(moveDiagonal(this, tabuleiro));
		}

	}

	@Override
	public void ameacaCasas() {
		tabuleiro.complementarAmeaca(moveLado(this, tabuleiro));
		tabuleiro.complementarAmeaca(moveDiagonal(this, tabuleiro));
		verificaCheck(this, tabuleiro);
		verificaCheckLado(this, tabuleiro);
	}

}
