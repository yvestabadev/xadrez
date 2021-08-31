package br.com.akconsultor.xadrez.pecas;

import javax.persistence.Entity;

import br.com.akconsultor.xadrez.pecas.movimentos.Direcao;
import br.com.akconsultor.xadrez.pecas.movimentos.MoveEle;
import br.com.akconsultor.xadrez.pecas.movimentos.ProtegeRei;
import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;
@Entity
public class Cavalo extends Peca implements MoveEle, ProtegeRei {

	public Cavalo(Boolean ehBranca, Integer coluna, Integer linha, Tabuleiro tabuleiro) {
		super.setEhBranca(ehBranca);
		super.setPosicao(coluna, linha);
		super.setTabuleiro(tabuleiro);
		this.adicionarDirecoes(Direcao.ELE);
		if (ehBranca) {
			tabuleiro.setPosicoesBrancas(this, coluna, linha);
		} else {
			tabuleiro.setPosicoesPretas(this, coluna, linha);
		}

	}

	@Override
	public void verificaDestino() {
		boolean[][] movimento = moveEle(this, tabuleiro);

		if (tabuleiro.getCheck()) {
			boolean[][] destino = corrigeDestino(movimento, this, tabuleiro);
			tabuleiro.complementarMovimento(destino);
		} else {
			boolean[][] precisaProteger = naoSaiDoRei(movimento, this, tabuleiro);

			if (precisaProteger == null) {
				tabuleiro.complementarMovimento(moveEle(this, tabuleiro));
			} else {
				tabuleiro.complementarMovimento(precisaProteger);
			}
		}
	}

	@Override
	public void ameacaCasas() {
		tabuleiro.complementarAmeaca(moveEle(this, tabuleiro));
		verificaCheck(this, tabuleiro);
	}

}
