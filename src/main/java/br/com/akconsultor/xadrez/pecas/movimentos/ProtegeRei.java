package br.com.akconsultor.xadrez.pecas.movimentos;

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
		Integer[] reiBranco = tabuleiro.getReiBranco();
		Integer[] reiPreto = tabuleiro.getReiPreto();
		Integer[] pecaAmeaca = tabuleiro.getPecaAmeaca().getPosicao();
		List<Direcao> direcoes = tabuleiro.getDirecoesCheck();

		if (tabuleiro.getDirecoesCheck().size() == 1) {
			if (peca.getEhBranca()) {

				Direcao direcao = direcoes.get(0);
				if (direcao == Direcao.NE) {
					for (int i = reiBranco[0] - 1; i >= 0; i--) {
						int j = reiBranco[1] + (i - reiBranco[0]);
						podeMover[i][j] = true;
						if (tabuleiro.getPosicoesPretas(i, j)) {
							break;
						}

					}
				} else if (direcao == Direcao.NW) {
					for (int i = reiBranco[0] + 1; i < 8; i++) {
						int j = reiBranco[1] - (i - reiBranco[0]);
						podeMover[i][j] = true;
						if (tabuleiro.getPosicoesPretas(i, j)) {
							break;
						}

					}

				} else if (direcao == Direcao.SE) {
					for (int i = reiBranco[0] - 1; i >= 0; i--) {
						int j = reiBranco[1] - (i - reiBranco[0]);
						podeMover[i][j] = true;
						if (tabuleiro.getPosicoesPretas(i, j)) {
							break;
						}

					}

				} else if (direcao == Direcao.SW) {
					for (int i = reiBranco[0] + 1; i < 8; i++) {
						int j = reiBranco[1] + (i - reiBranco[0]);
						podeMover[i][j] = true;
						if (tabuleiro.getPosicoesPretas(i, j)) {
							break;
						}

					}

				} else if (direcao == Direcao.TRAS) {
					for (int i = reiBranco[1] + 1; i < 8; i++) {
						int coluna = reiBranco[0];
						podeMover[coluna][i] = true;
						if (tabuleiro.getPosicoesPretas(coluna, i)) {
							break;
						}
					}

				} else if (direcao == Direcao.FRENTE) {
					for (int i = reiBranco[1] - 1; i >= 0; i--) {
						int coluna = reiBranco[0];
						podeMover[coluna][i] = true;
						if (tabuleiro.getPosicoesPretas(coluna, i)) {
							break;
						}
					}

				} else if (direcao == Direcao.ESQUERDA) {
					for (int i = reiBranco[0] + 1; i < 8; i++) {
						int linha = reiBranco[1];
						podeMover[i][linha] = true;
						if (tabuleiro.getPosicoesPretas(i, linha)) {
							break;
						}
					}

				} else if (direcao == Direcao.DIREITA) {
					for (int i = reiBranco[0] - 1; i >= 0; i--) {
						int linha = reiBranco[1];
						podeMover[i][linha] = true;
						if (tabuleiro.getPosicoesPretas(i, linha)) {
							break;
						}
					}

				}
			}

			else {

				Direcao direcao = direcoes.get(0);
				if (direcao == Direcao.NE) {
					for (int i = reiPreto[0] - 1; i >= 0; i--) {
						int j = reiPreto[1] + (i - reiPreto[0]);
						podeMover[i][j] = true;
						if (tabuleiro.getPosicoesPretas(i, j)) {
							break;
						}

					}
				} else if (direcao == Direcao.NW) {
					for (int i = reiPreto[0] + 1; i < 8; i++) {
						int j = reiPreto[1] - (i - reiPreto[0]);
						podeMover[i][j] = true;
						if (tabuleiro.getPosicoesPretas(i, j)) {
							break;
						}

					}

				} else if (direcao == Direcao.SE) {
					for (int i = reiPreto[0] - 1; i >= 0; i--) {
						int j = reiPreto[1] - (i - reiPreto[0]);
						podeMover[i][j] = true;
						if (tabuleiro.getPosicoesPretas(i, j)) {
							break;
						}

					}

				} else if (direcao == Direcao.SW) {
					for (int i = reiPreto[0] + 1; i < 8; i++) {
						int j = reiPreto[1] + (i - reiPreto[0]);
						podeMover[i][j] = true;
						if (tabuleiro.getPosicoesPretas(i, j)) {
							break;
						}

					}

				} else if (direcao == Direcao.TRAS) {
					for (int i = reiPreto[1] + 1; i < 8; i++) {
						int coluna = reiPreto[0];
						podeMover[coluna][i] = true;
						if (tabuleiro.getPosicoesPretas(coluna, i)) {
							break;
						}
					}

				} else if (direcao == Direcao.FRENTE) {
					for (int i = reiPreto[1] - 1; i >= 0; i--) {
						int coluna = reiPreto[0];
						podeMover[coluna][i] = true;
						if (tabuleiro.getPosicoesPretas(coluna, i)) {
							break;
						}
					}

				} else if (direcao == Direcao.ESQUERDA) {
					for (int i = reiPreto[0] + 1; i < 8; i++) {
						int linha = reiPreto[1];
						podeMover[i][linha] = true;
						if (tabuleiro.getPosicoesPretas(i, linha)) {
							break;
						}
					}

				} else if (direcao == Direcao.DIREITA) {
					for (int i = reiPreto[0] - 1; i >= 0; i--) {
						int linha = reiPreto[1];
						podeMover[i][linha] = true;
						if (tabuleiro.getPosicoesPretas(i, linha)) {
							break;
						}
					}

				}
			}
			
			podeMover[pecaAmeaca[0]][pecaAmeaca[1]] = true;
		}
		return podeMover;
	}
	
	public default boolean[][] naFrenteDoRei(Peca peca, Tabuleiro tabuleiro){
		boolean[][] podeMover = new boolean[8][8];
		Direcao direcaoRei;
		Integer[] reiBranco = tabuleiro.getReiBranco();
		Integer[] reiPreto = tabuleiro.getReiPreto();
		Integer[] posicao = peca.getPosicao();
		Boolean reiAEsquerda = reiBranco[0] < posicao[0];
		Boolean reiAbaixo = reiBranco[1] < posicao[1];
		Boolean reiColunaIgual = reiBranco[0] == posicao[0];
		Boolean reiLinhaIgual = reiBranco[1] == posicao[1];
		
		if(peca.getEhBranca()) {
			if(reiColunaIgual && reiAbaixo) {
				direcaoRei = Direcao.TRAS;
			} else if(reiColunaIgual && !reiAbaixo) {
				direcaoRei = Direcao.FRENTE;
			} else if(reiLinhaIgual && reiAEsquerda) {
				direcaoRei = Direcao.ESQUERDA;
			} else if(reiLinhaIgual && !reiAEsquerda) {
				direcaoRei = Direcao.DIREITA;
			}
			
			if(!reiColunaIgual && !reiLinhaIgual) {
				if(reiAbaixo && reiAEsquerda) {
					direcaoRei = Direcao.SW;
				} else if(reiAbaixo && !reiAEsquerda) {
					direcaoRei = Direcao.SE;
				} else if(!reiAbaixo && reiAEsquerda) {
					direcaoRei = Direcao.NW;
				} else if(!reiAbaixo && !reiAEsquerda) {
					direcaoRei = Direcao.NE;
				}
			}
		
		}
		
		
		
		return podeMover;
	}

}
