package br.com.akconsultor.xadrez.pecas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;

class BispoTest {
	
	
	Tabuleiro tabuleiro = new Tabuleiro();
	Bispo bispo = new Bispo(true, 3, 3, tabuleiro);;

	@Test
	void tabuleiroVazio() {
		bispo.verificaDestino();
		assertTrue(tabuleiro.getAcionarMovimento()[4][4]);
		assertTrue(tabuleiro.getAcionarMovimento()[5][5]);
		assertTrue(tabuleiro.getAcionarMovimento()[6][6]);
		assertTrue(tabuleiro.getAcionarMovimento()[7][7]);
		assertTrue(tabuleiro.getAcionarMovimento()[4][2]);
		assertTrue(tabuleiro.getAcionarMovimento()[5][1]);
		assertTrue(tabuleiro.getAcionarMovimento()[6][0]);
		assertTrue(tabuleiro.getAcionarMovimento()[2][4]);
		assertTrue(tabuleiro.getAcionarMovimento()[1][5]);
		assertTrue(tabuleiro.getAcionarMovimento()[0][6]);
	}
	
	@Test
	void outroBispoBranco() {
		Bispo outroBispo = new Bispo(true, 6, 6, tabuleiro);
		bispo.verificaDestino();
		assertTrue(!tabuleiro.getAcionarMovimento()[6][6]);
		assertTrue(!tabuleiro.getAcionarMovimento()[7][7]);
	}
	
	@Test
	void outroBispoPreto() {
		Bispo outroBispo = new Bispo(false, 6, 6, tabuleiro);
		bispo.verificaDestino();
		assertTrue(tabuleiro.getAcionarMovimento()[6][6]);
		assertTrue(!tabuleiro.getAcionarMovimento()[7][7]);
	}
	
	@Test
	void bispoPreto() {
		Bispo outroBispo = new Bispo(false, 6, 6, tabuleiro);
		outroBispo.verificaDestino();
		assertTrue(tabuleiro.getAcionarMovimento()[5][5]);
		assertTrue(tabuleiro.getAcionarMovimento()[4][4]);
		assertTrue(tabuleiro.getAcionarMovimento()[3][3]);
		assertTrue(!tabuleiro.getAcionarMovimento()[2][2]);
	}
	
	@Test
	void maisBispoPreto() {
		Bispo outroBispo = new Bispo(false, 6, 6, tabuleiro);
		Bispo bispoPreto = new Bispo(false, 4, 4, tabuleiro);
		outroBispo.verificaDestino();
		assertTrue(tabuleiro.getAcionarMovimento()[5][5]);
		assertTrue(!tabuleiro.getAcionarMovimento()[4][4]);
		assertTrue(!tabuleiro.getAcionarMovimento()[3][3]);
		assertTrue(!tabuleiro.getAcionarMovimento()[2][2]);
	}
	

}
