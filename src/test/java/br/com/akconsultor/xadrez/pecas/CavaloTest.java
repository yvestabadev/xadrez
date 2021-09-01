package br.com.akconsultor.xadrez.pecas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;
@SuppressWarnings("unused")
class CavaloTest {
	
	Tabuleiro tabuleiro = new Tabuleiro(1);
	Cavalo cavalo = new Cavalo(true, 3, 3, tabuleiro);

	@Test
	void tabuleiroVazio() {
		cavalo.verificaDestino();
		assertTrue(tabuleiro.getAcionarMovimento()[1][2]);
		assertTrue(tabuleiro.getAcionarMovimento()[2][1]);
		assertTrue(tabuleiro.getAcionarMovimento()[4][5]);
		assertTrue(tabuleiro.getAcionarMovimento()[5][4]);
		assertTrue(tabuleiro.getAcionarMovimento()[2][5]);
		assertTrue(tabuleiro.getAcionarMovimento()[1][4]);
		assertTrue(tabuleiro.getAcionarMovimento()[5][2]);
		assertTrue(tabuleiro.getAcionarMovimento()[4][1]);
		assertTrue(!tabuleiro.getAcionarMovimento()[4][6]);
	}
	
	@Test
	void comCavaloBranco() {
		Cavalo novoCavalo = new Cavalo(true, 4, 5, tabuleiro);
		cavalo.verificaDestino();
		assertTrue(tabuleiro.getAcionarMovimento()[1][2]);
		assertTrue(tabuleiro.getAcionarMovimento()[2][1]);
		assertTrue(!tabuleiro.getAcionarMovimento()[4][5]);
		assertTrue(tabuleiro.getAcionarMovimento()[5][4]);
		assertTrue(tabuleiro.getAcionarMovimento()[2][5]);
		assertTrue(tabuleiro.getAcionarMovimento()[1][4]);
		assertTrue(tabuleiro.getAcionarMovimento()[5][2]);
		assertTrue(tabuleiro.getAcionarMovimento()[4][1]);
	}
	
	@Test
	void comCavaloPreto() {
		Cavalo novoCavalo = new Cavalo(false, 4, 5, tabuleiro);
		cavalo.verificaDestino();
		assertTrue(tabuleiro.getAcionarMovimento()[1][2]);
		assertTrue(tabuleiro.getAcionarMovimento()[2][1]);
		assertTrue(tabuleiro.getAcionarMovimento()[4][5]);
		assertTrue(tabuleiro.getAcionarMovimento()[5][4]);
		assertTrue(tabuleiro.getAcionarMovimento()[2][5]);
		assertTrue(tabuleiro.getAcionarMovimento()[1][4]);
		assertTrue(tabuleiro.getAcionarMovimento()[5][2]);
		assertTrue(tabuleiro.getAcionarMovimento()[4][1]);
	}
	
	@Test
	void movimentoCavaloPreto() {
		Cavalo novoCavalo = new Cavalo(false, 4, 5, tabuleiro);
		novoCavalo.verificaDestino();
		assertTrue(tabuleiro.getAcionarMovimento()[3][3]);
		assertTrue(tabuleiro.getAcionarMovimento()[2][4]);
		assertTrue(tabuleiro.getAcionarMovimento()[5][7]);
		assertTrue(tabuleiro.getAcionarMovimento()[6][6]);
		assertTrue(tabuleiro.getAcionarMovimento()[2][6]);
		assertTrue(tabuleiro.getAcionarMovimento()[3][7]);
		assertTrue(tabuleiro.getAcionarMovimento()[5][3]);
		assertTrue(tabuleiro.getAcionarMovimento()[6][4]);
	}
	
	@Test
	void outroCavaloPreto() {
		Cavalo novoCavalo = new Cavalo(false, 4, 5, tabuleiro);
		Cavalo outroCavalo = new Cavalo(false, 6, 6, tabuleiro);
		novoCavalo.verificaDestino();
		assertTrue(tabuleiro.getAcionarMovimento()[3][3]);
		assertTrue(tabuleiro.getAcionarMovimento()[2][4]);
		assertTrue(tabuleiro.getAcionarMovimento()[5][7]);
		assertTrue(!tabuleiro.getAcionarMovimento()[6][6]);
		assertTrue(tabuleiro.getAcionarMovimento()[2][6]);
		assertTrue(tabuleiro.getAcionarMovimento()[3][7]);
		assertTrue(tabuleiro.getAcionarMovimento()[5][3]);
		assertTrue(tabuleiro.getAcionarMovimento()[6][4]);
	}

}
