package br.com.akconsultor.xadrez.pecas;

import br.com.akconsultor.xadrez.pecas.movimentos.Direcao;
import br.com.akconsultor.xadrez.pecas.movimentos.MoveVerticalEHorizontal;
import br.com.akconsultor.xadrez.pecas.movimentos.ProtegeRei;
import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;

public class Torre extends Peca implements MoveVerticalEHorizontal, ProtegeRei {

	private Integer[] posicaoInicial;

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
		
		this.posicaoInicial = new Integer[] {coluna, linha};

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

		Integer[] posicaoInicialGrande;

		if (super.getEhBranca()) {
			posicaoInicialGrande = new Integer[] { 0, 0 };
		} else {
			posicaoInicialGrande = new Integer[] { 0, 7 };
		}
		
		boolean ehGrande = posicaoInicialGrande == this.posicaoInicial;
		
		//essa parte do codigo esta com problemas porque nao esta entrando no segundo if
		if (tabuleiro.getRoqueGrande(super.getEhBranca()) && ehGrande) {
			if (this.posicaoInicial[0] != super.getPosicao()[0] ||
					this.posicaoInicial[1] != super.getPosicao()[1]) {
				tabuleiro.invalidaRoqueGrande(super.getEhBranca());
			}
		}

		if (tabuleiro.getRoquePequeno(super.getEhBranca()) && !ehGrande) {
			if (this.posicaoInicial[0] != super.getPosicao()[0] ||
					this.posicaoInicial[1] != super.getPosicao()[1]) {
				tabuleiro.invalidaRoquePequeno(super.getEhBranca());
			}
		}

	}

}
