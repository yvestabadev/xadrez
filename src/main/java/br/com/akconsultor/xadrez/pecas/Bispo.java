package br.com.akconsultor.xadrez.pecas;

import javax.persistence.Entity;

import br.com.akconsultor.xadrez.pecas.movimentos.Direcao;
import br.com.akconsultor.xadrez.pecas.movimentos.MoveDiagonal;
import br.com.akconsultor.xadrez.pecas.movimentos.ProtegeRei;
import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;
@Entity
public class Bispo extends Peca implements MoveDiagonal, ProtegeRei {

	public Bispo(Boolean ehBranca, Integer coluna, Integer linha, Tabuleiro tabuleiro) {
		super.setEhBranca(ehBranca);
		super.setPosicao(coluna, linha);
		super.setTabuleiro(tabuleiro);
		this.adicionarDirecoes(Direcao.DIAGONAL);
		if (ehBranca) {
			tabuleiro.setPosicoesBrancas(this, coluna, linha);
		} else {
			tabuleiro.setPosicoesPretas(this, coluna, linha);
		}

	}

	@Override
	public void verificaDestino() {
		boolean[][] movimento = moveDiagonal(this, tabuleiro);
		
		if (tabuleiro.getCheck()) {
			boolean[][] destino = corrigeDestino(movimento, this, tabuleiro);
			tabuleiro.complementarMovimento(destino);
		} else {
			
			boolean[][] precisaProteger = naoSaiDoRei(movimento, this, tabuleiro);

			if (precisaProteger == null) {
				tabuleiro.complementarMovimento(movimento);
			} else {
				tabuleiro.complementarMovimento(precisaProteger);
			}
		}

	}

	@Override
	public void ameacaCasas() {
		tabuleiro.complementarAmeaca(moveDiagonal(this, tabuleiro));
		verificaCheck(this, tabuleiro);
	}

}
