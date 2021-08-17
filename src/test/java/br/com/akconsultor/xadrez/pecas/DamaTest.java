package br.com.akconsultor.xadrez.pecas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;

class DamaTest {
	
	
	Tabuleiro tabuleiro = new Tabuleiro();
	Dama dama = new Dama(true, 3, 3, tabuleiro);;
	

	@Test
	void tabuleiroVazio() {
		dama.verificaDestino();
		assertTrue(tabuleiro.getAcionarMovimento()[4][4]);
		assertTrue(tabuleiro.getAcionarMovimento()[5][5]);
		assertTrue(tabuleiro.getAcionarMovimento()[6][6]);
		assertTrue(tabuleiro.getAcionarMovimento()[7][7]);
		assertTrue(tabuleiro.getAcionarMovimento()[3][4]);
		assertTrue(tabuleiro.getAcionarMovimento()[3][5]);
		assertTrue(tabuleiro.getAcionarMovimento()[3][2]);
		assertTrue(tabuleiro.getAcionarMovimento()[3][1]);
		assertTrue(tabuleiro.getAcionarMovimento()[2][3]);
		assertTrue(tabuleiro.getAcionarMovimento()[5][3]);
		assertTrue(tabuleiro.getAcionarMovimento()[6][3]);
		assertTrue(tabuleiro.getAcionarMovimento()[2][2]);
		assertTrue(tabuleiro.getAcionarMovimento()[1][1]);
	}
	
	@Test
	void damaPretaNoCaminho() {
		Dama outraDama = new Dama(false, 5, 3, tabuleiro);
		dama.verificaDestino();
		assertTrue(tabuleiro.getAcionarMovimento()[5][3]);
		assertTrue(!tabuleiro.getAcionarMovimento()[6][3]);
	}
	
	@Test
	void damaBrancaNoCaminho() {
		Dama outraDama = new Dama(true, 5, 3, tabuleiro);
		dama.verificaDestino();
		assertTrue(!tabuleiro.getAcionarMovimento()[5][3]);
		assertTrue(!tabuleiro.getAcionarMovimento()[6][3]);
	}
	
	@Test
	void movimentoPreta() {
		Dama outraDama = new Dama(false, 5, 3, tabuleiro);
		outraDama.verificaDestino();
		assertTrue(tabuleiro.getAcionarMovimento()[3][3]);
		assertTrue(!tabuleiro.getAcionarMovimento()[2][3]);
	}
	
	@Test
	void movimentoPretaComPretaNoCaminho() {
		Dama outraDama = new Dama(false, 5, 3, tabuleiro);
		Dama maisOutraDama = new Dama(false, 7, 3, tabuleiro);

		outraDama.verificaDestino();
		assertTrue(tabuleiro.getAcionarMovimento()[6][3]);
		assertTrue(!tabuleiro.getAcionarMovimento()[7][3]);
	}

}
