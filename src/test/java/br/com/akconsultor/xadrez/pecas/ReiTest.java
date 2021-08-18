package br.com.akconsultor.xadrez.pecas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;

class ReiTest {
	
	Tabuleiro tabuleiro = new Tabuleiro();
	Rei rei = new Rei(true, 3, 3, tabuleiro);

	@Test
	void movimento() {
		rei.verificaDestino();
		assertTrue(tabuleiro.getAcionarMovimento()[4][4]);
		assertTrue(tabuleiro.getAcionarMovimento()[3][4]);
		assertTrue(tabuleiro.getAcionarMovimento()[2][4]);
		assertTrue(tabuleiro.getAcionarMovimento()[4][2]);
		assertTrue(tabuleiro.getAcionarMovimento()[3][2]);
		assertTrue(tabuleiro.getAcionarMovimento()[2][2]);
		assertTrue(tabuleiro.getAcionarMovimento()[2][3]);
		assertTrue(tabuleiro.getAcionarMovimento()[4][3]);
		assertTrue(!tabuleiro.getAcionarMovimento()[5][3]);


	}
	

}
