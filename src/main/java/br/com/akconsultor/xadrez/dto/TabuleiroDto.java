package br.com.akconsultor.xadrez.dto;

import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;

@SuppressWarnings("unused")
public class TabuleiroDto {
	

	private Boolean cheque;
	private Boolean checkmate;
	
	public TabuleiroDto(Boolean cheque, Boolean checkmate) {

		this.cheque = cheque;
		this.checkmate = checkmate;
	}

}
