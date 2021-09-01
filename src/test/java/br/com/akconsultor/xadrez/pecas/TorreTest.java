package br.com.akconsultor.xadrez.pecas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;
@SuppressWarnings("unused")
class TorreTest {

	Tabuleiro tabuleiro = new Tabuleiro(1);
	Torre torre = new Torre(true, 4, 4, tabuleiro);



	@Test
	void destinoTorreSemOutraPecaNoTabuleiro() {
		torre.verificaDestino();
		assertTrue(tabuleiro.getAcionarMovimento()[4][5]);
		assertTrue(tabuleiro.getAcionarMovimento()[4][6]);
		assertTrue(tabuleiro.getAcionarMovimento()[4][7]);
		assertTrue(tabuleiro.getAcionarMovimento()[4][3]);
		assertTrue(tabuleiro.getAcionarMovimento()[4][2]);
		assertTrue(tabuleiro.getAcionarMovimento()[4][1]);
		assertTrue(tabuleiro.getAcionarMovimento()[4][0]);
		assertTrue(tabuleiro.getAcionarMovimento()[3][4]);
		assertTrue(tabuleiro.getAcionarMovimento()[2][4]);
		assertTrue(tabuleiro.getAcionarMovimento()[1][4]);
		assertTrue(tabuleiro.getAcionarMovimento()[0][4]);
		assertTrue(tabuleiro.getAcionarMovimento()[5][4]);
		assertTrue(tabuleiro.getAcionarMovimento()[6][4]);
		assertTrue(tabuleiro.getAcionarMovimento()[7][4]);
		assertTrue(!tabuleiro.getAcionarMovimento()[5][5]);

	}

	@Test
	void destinoTorreComPecaBrancaNoCaminho() {
		Torre outraTorre = new Torre(true, 5, 4, tabuleiro);
		torre.verificaDestino();
		assertTrue(!tabuleiro.getAcionarMovimento()[5][4]);
		assertTrue(!tabuleiro.getAcionarMovimento()[6][4]);
		assertTrue(!tabuleiro.getAcionarMovimento()[7][4]);
	}

	@Test
	void destinoTorreComPecaPretaNoCaminho() {
		Torre outraTorre = new Torre(false, 5, 4, tabuleiro);
		torre.verificaDestino();

		assertTrue(tabuleiro.getAcionarMovimento()[5][4]);

		assertTrue(!tabuleiro.getAcionarMovimento()[6][4]);
		assertTrue(!tabuleiro.getAcionarMovimento()[7][4]);
	}
	
	@Test
	void destinoTorrePreta() {
		Torre outraTorre = new Torre(false, 5, 4, tabuleiro);
		outraTorre.verificaDestino();

		assertTrue(tabuleiro.getAcionarMovimento()[4][4]);

		assertTrue(!tabuleiro.getAcionarMovimento()[3][4]);
		assertTrue(!tabuleiro.getAcionarMovimento()[2][4]);
	}
	
	@Test
	void destinoTorrePretaComPretaNoCaminho() {
		Torre outraTorre = new Torre(false, 5, 4, tabuleiro);
		Torre outraTorrePreta = new Torre(false, 7, 4, tabuleiro);
		outraTorre.verificaDestino();

		assertTrue(tabuleiro.getAcionarMovimento()[6][4]);

		assertTrue(!tabuleiro.getAcionarMovimento()[7][4]);
		assertTrue(tabuleiro.getAcionarMovimento()[4][4]);
	}

}
