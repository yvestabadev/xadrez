package br.com.akconsultor.xadrez.pecas;

import br.com.akconsultor.xadrez.pecas.movimentos.Direcao;
import br.com.akconsultor.xadrez.pecas.movimentos.MoveVerticalEHorizontal;
import br.com.akconsultor.xadrez.pecas.movimentos.ProtegeRei;
import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;

public class Torre extends Peca implements MoveVerticalEHorizontal, ProtegeRei {

	public Torre(Boolean ehBranca, Integer coluna, Integer linha, Tabuleiro tabuleiro) {
		super.setEhBranca(ehBranca);
		super.setPosicao(coluna, linha);
		super.setTabuleiro(tabuleiro);
		this.adicionarDirecoes(Direcao.LADOS);
		if (ehBranca) {
			tabuleiro.setPosicoesBrancas(this, coluna, linha);
		} else {
			tabuleiro.setPosicoesPretas(this, coluna, linha);
		}

	}

	@Override
	public void verificaDestino() {
		boolean[][] movimento = moveLado(this, tabuleiro);

		if (tabuleiro.getCheck()) {
			boolean[][] destino = corrigeDestino(movimento, this, tabuleiro);
			tabuleiro.complementarMovimento(destino);
		} else {
			boolean[][] precisaProteger = naoSaiDoRei(movimento, this, tabuleiro);

			if (precisaProteger == null) {
				tabuleiro.complementarMovimento(moveLado(this, tabuleiro));
			} else {
				tabuleiro.complementarMovimento(precisaProteger);
			}
		}
	}

	@Override
	public void ameacaCasas() {
		tabuleiro.complementarAmeaca(moveLado(this, tabuleiro));
		verificaCheckLado(this, tabuleiro);

	}

}
