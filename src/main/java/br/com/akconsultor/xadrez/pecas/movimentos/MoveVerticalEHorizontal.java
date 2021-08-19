package br.com.akconsultor.xadrez.pecas.movimentos;

import br.com.akconsultor.xadrez.pecas.Peca;
import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;

public interface MoveVerticalEHorizontal {

	public default boolean[][] moveLado(Peca peca, Tabuleiro tabuleiro) {
		boolean[][] podeMover = new boolean[8][8];
		Integer[] posicao = peca.getPosicao();
		
			for (int i = posicao[0] + 1; i < 8; i++) {

				if (tabuleiro.getPosicoes(peca.getEhBranca(),i, posicao[1])) {
					break;
				} else if (tabuleiro.getPosicoes(!peca.getEhBranca(),i, posicao[1])) {
					podeMover[i][posicao[1]] = true;
					break;
				}

				podeMover[i][posicao[1]] = true;
			}

			for (int i = posicao[0] - 1; i >= 0; i--) {

				if (tabuleiro.getPosicoes(peca.getEhBranca(),i, posicao[1])) {
					break;
				} else if (tabuleiro.getPosicoes(!peca.getEhBranca(),i, posicao[1])) {
					podeMover[i][posicao[1]] = true;
					break;
				}

				podeMover[i][posicao[1]] = true;
			}
			
			for (int i = posicao[1] + 1; i < 8; i++) {

				if (tabuleiro.getPosicoes(peca.getEhBranca(),posicao[0], i)) {
					break;
				} else if (tabuleiro.getPosicoes(!peca.getEhBranca(),posicao[0], i)) {
					podeMover[posicao[0]][i] = true;
					break;
				}

				podeMover[posicao[0]][i] = true;
			}
			for (int i = posicao[1] - 1; i >= 0; i--) {

				if (tabuleiro.getPosicoes(peca.getEhBranca(),posicao[0], i)) {
					break;
				} else if (tabuleiro.getPosicoes(!peca.getEhBranca(),posicao[0], i)) {
					podeMover[posicao[0]][i] = true;
					break;
				}

				podeMover[posicao[0]][i] = true;
			}
		
		return podeMover;
	}
	
	public default void verificaCheckLado(Peca peca, Tabuleiro tabuleiro) {
		
		Integer[] reiBranco = tabuleiro.getReiBranco();
		Integer[] reiPreto = tabuleiro.getReiPreto();
		Integer[] posicaoPeca = peca.getPosicao();
		boolean podeMover[][] = moveLado(peca, tabuleiro);

		if (peca.getEhBranca()) {
			
			if (podeMover[reiPreto[0]][reiPreto[1]]) {
				if (reiPreto[0] < posicaoPeca[0]) {
					tabuleiro.adicionarDirecoesCheck(Direcao.ESQUERDA);
				} else if (reiPreto[1] > posicaoPeca[1]) {
					tabuleiro.adicionarDirecoesCheck(Direcao.FRENTE);
				} else if (reiPreto[0] > posicaoPeca[0]) {
					tabuleiro.adicionarDirecoesCheck(Direcao.DIREITA);
				} else {
					tabuleiro.adicionarDirecoesCheck(Direcao.TRAS);
				}
				
				tabuleiro.setPecaAmeaca(peca);
			}

		} else {

			if (podeMover[reiBranco[0]][reiBranco[1]]) {
				if (reiBranco[0] < posicaoPeca[0]) {
					tabuleiro.adicionarDirecoesCheck(Direcao.ESQUERDA);
				} else if (reiBranco[1] > posicaoPeca[1]) {
					tabuleiro.adicionarDirecoesCheck(Direcao.FRENTE);
				} else if (reiBranco[0] > posicaoPeca[0]) {
					tabuleiro.adicionarDirecoesCheck(Direcao.DIREITA);
				} else {
					tabuleiro.adicionarDirecoesCheck(Direcao.TRAS);
				}

			}
			
			tabuleiro.setPecaAmeaca(peca);
		}
		
	}
}
