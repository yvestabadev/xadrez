package br.com.akconsultor.xadrez.dto;

import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;

@SuppressWarnings("unused")
public class TabuleiroDto {
	
	private Boolean pecaMoveu;
	private Boolean check;
	private Boolean checkmate;
	
	public TabuleiroDto(Tabuleiro tabuleiro, Boolean pecaMoveu) {
		this.pecaMoveu = pecaMoveu;
		this.check = tabuleiro.getCheck();
		this.checkmate = tabuleiro.getCheckmate();
	}

}
