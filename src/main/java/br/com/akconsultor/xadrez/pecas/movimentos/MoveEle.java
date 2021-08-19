package br.com.akconsultor.xadrez.pecas.movimentos;

import br.com.akconsultor.xadrez.pecas.Peca;
import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;

public interface MoveEle {

	public default boolean[][] moveEle(Peca peca, Tabuleiro tabuleiro) {

		boolean[][] podeMover = new boolean[8][8];
		Integer[] posicao = peca.getPosicao();

			try {
				if (!tabuleiro.getPosicoes(peca.getEhBranca(),posicao[0] + 1, posicao[1] + 2)) {
					podeMover[posicao[0] + 1][posicao[1] + 2] = true;
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}
			
			try {
				if (!tabuleiro.getPosicoes(peca.getEhBranca(),posicao[0] + 2, posicao[1] + 1)) {
					podeMover[posicao[0] + 2][posicao[1] + 1] = true;
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}
			
			try {
				if (!tabuleiro.getPosicoes(peca.getEhBranca(),posicao[0] - 1, posicao[1] - 2)) {
					podeMover[posicao[0] - 1][posicao[1] - 2] = true;
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}
			
			try {
				if (!tabuleiro.getPosicoes(peca.getEhBranca(),posicao[0] - 2, posicao[1] - 1)) {
					podeMover[posicao[0] - 2][posicao[1] - 1] = true;
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}
			
			try {
				if (!tabuleiro.getPosicoes(peca.getEhBranca(),posicao[0] + 1, posicao[1] - 2)) {
					podeMover[posicao[0] + 1][posicao[1] - 2] = true;
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}
			
			try {
				if (!tabuleiro.getPosicoes(peca.getEhBranca(),posicao[0] + 2, posicao[1] - 1)) {
					podeMover[posicao[0] + 2][posicao[1] - 1] = true;
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}
			
			try {
				if (!tabuleiro.getPosicoes(peca.getEhBranca(),posicao[0] - 1, posicao[1] + 2)) {
					podeMover[posicao[0] - 1][posicao[1] + 2] = true;
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}
			
			try {
				if (!tabuleiro.getPosicoes(peca.getEhBranca(),posicao[0] - 2, posicao[1] + 1)) {
					podeMover[posicao[0] - 2][posicao[1] + 1] = true;
				}
			} catch (ArrayIndexOutOfBoundsException e) {

			}

		return podeMover;

	}
	
	public default void verificaCheck(Peca peca, Tabuleiro tabuleiro) {
		boolean[][] podeMover = moveEle(peca, tabuleiro);
		if(podeMover[tabuleiro.getReiPreto()[0]][tabuleiro.getReiPreto()[1]]) {
			tabuleiro.adicionarDirecoesCheck(Direcao.ELE);
			tabuleiro.setPecaAmeaca(peca);
		}
	}

}
