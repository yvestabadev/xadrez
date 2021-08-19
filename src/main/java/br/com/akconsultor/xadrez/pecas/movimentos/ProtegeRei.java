package br.com.akconsultor.xadrez.pecas.movimentos;

import java.util.ArrayList;
import java.util.List;

import br.com.akconsultor.xadrez.pecas.Peca;
import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;

public interface ProtegeRei {

	public default boolean[][] corrigeDestino(boolean[][] destino, Peca peca, Tabuleiro tabuleiro) {
		boolean[][] resolveCheck = resolveCheck(peca, tabuleiro);
		boolean[][] retorno = new boolean[8][8];

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (destino[i][j] && resolveCheck[i][j]) {
					retorno[i][j] = true;
				}
			}
		}

		return retorno;
	}

	public default boolean[][] resolveCheck(Peca peca, Tabuleiro tabuleiro) {
		boolean[][] podeMover = new boolean[8][8];
		Integer[] rei;
		Integer[] pecaAmeaca = tabuleiro.getPecaAmeaca().getPosicao();
		List<Direcao> direcoes = tabuleiro.getDirecoesCheck();
		
		if(peca.getEhBranca()) {
			rei = tabuleiro.getReiBranco();
		} else {
			rei = tabuleiro.getReiPreto();
		}

		if (tabuleiro.getDirecoesCheck().size() == 1) {
			

				Direcao direcao = direcoes.get(0);
				if (direcao == Direcao.NE) {
					for (int i = rei[0] - 1; i >= 0; i--) {
						int j = rei[1] + (i - rei[0]);
						podeMover[i][j] = true;
						if (tabuleiro.getPosicoes(!peca.getEhBranca(),i, j)) {
							break;
						}

					}
				} else if (direcao == Direcao.NW) {
					for (int i = rei[0] + 1; i < 8; i++) {
						int j = rei[1] - (i - rei[0]);
						podeMover[i][j] = true;
						if (tabuleiro.getPosicoes(!peca.getEhBranca(),i, j)) {
							break;
						}

					}

				} else if (direcao == Direcao.SE) {
					for (int i = rei[0] - 1; i >= 0; i--) {
						int j = rei[1] - (i - rei[0]);
						podeMover[i][j] = true;
						if (tabuleiro.getPosicoes(!peca.getEhBranca(),i, j)) {
							break;
						}

					}

				} else if (direcao == Direcao.SW) {
					for (int i = rei[0] + 1; i < 8; i++) {
						int j = rei[1] + (i - rei[0]);
						podeMover[i][j] = true;
						if (tabuleiro.getPosicoes(!peca.getEhBranca(),i, j)) {
							break;
						}

					}

				} else if (direcao == Direcao.TRAS) {
					for (int i = rei[1] + 1; i < 8; i++) {
						int coluna = rei[0];
						podeMover[coluna][i] = true;
						if (tabuleiro.getPosicoes(!peca.getEhBranca(),coluna, i)) {
							break;
						}
					}

				} else if (direcao == Direcao.FRENTE) {
					for (int i = rei[1] - 1; i >= 0; i--) {
						int coluna = rei[0];
						podeMover[coluna][i] = true;
						if (tabuleiro.getPosicoes(!peca.getEhBranca(),coluna, i)) {
							break;
						}
					}

				} else if (direcao == Direcao.ESQUERDA) {
					for (int i = rei[0] + 1; i < 8; i++) {
						int linha = rei[1];
						podeMover[i][linha] = true;
						if (tabuleiro.getPosicoes(!peca.getEhBranca(),i, linha)) {
							break;
						}
					}

				} else if (direcao == Direcao.DIREITA) {
					for (int i = rei[0] - 1; i >= 0; i--) {
						int linha = rei[1];
						podeMover[i][linha] = true;
						if (tabuleiro.getPosicoes(!peca.getEhBranca(),i, linha)) {
							break;
						}
					}

				}
			
			
			podeMover[pecaAmeaca[0]][pecaAmeaca[1]] = true;
		}
		return podeMover;
	}
	
	public default boolean[][] naFrenteDoRei(Peca peca, Tabuleiro tabuleiro){
		boolean[][] podeMover = new boolean[8][8];
		Direcao direcaoProtegida = peca.getDirecaoProtegida();
		Integer coluna = peca.getPosicao()[0];
		Integer linha = peca.getPosicao()[1];
		List<Integer[]> posicoes = new ArrayList<Integer[]>();
		Peca pecaAdversaria;
		
		if(direcaoProtegida != null) {
			if(direcaoProtegida == Direcao.VERTICAL) {
				for(int i = linha + 1; i < 8; i++) {
					posicoes.add(new Integer[]{coluna, i});
				
				}
			}
		}
		
		return null;
	}

}
