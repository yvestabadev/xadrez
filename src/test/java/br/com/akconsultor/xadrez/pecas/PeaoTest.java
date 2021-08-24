package br.com.akconsultor.xadrez.pecas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;
@SuppressWarnings("unused")
class PeaoTest {
	
	Tabuleiro tabuleiro = new Tabuleiro();
	Peao peao = new Peao(true, 3, 1, tabuleiro);
	

	@Test
	void tabuleiroVazio() {
		peao.verificaDestino();
		assertTrue(tabuleiro.getAcionarMovimento()[3][2]);
		assertTrue(tabuleiro.getAcionarMovimento()[3][3]);
		assertTrue(!tabuleiro.getAcionarMovimento()[3][4]);
		assertTrue(!tabuleiro.getAcionarMovimento()[4][1]);

	}
	
	@Test
	void peaoNaFrente() {
		Peao novoPeao = new Peao(true, 3, 3, tabuleiro);
		peao.verificaDestino();
		assertTrue(tabuleiro.getAcionarMovimento()[3][2]);
		assertTrue(!tabuleiro.getAcionarMovimento()[3][3]);

	}
	
	@Test
	void peaoLogoAFrente() {
		Peao novoPeao = new Peao(true, 3, 2, tabuleiro);
		peao.verificaDestino();
		assertTrue(!tabuleiro.getAcionarMovimento()[3][2]);
		assertTrue(!tabuleiro.getAcionarMovimento()[3][3]);

	}
	
	@Test
	void peaoPretoNaFrente() {
		Peao novoPeao = new Peao(false, 3, 3, tabuleiro);
		peao.verificaDestino();
		assertTrue(tabuleiro.getAcionarMovimento()[3][2]);
		assertTrue(!tabuleiro.getAcionarMovimento()[3][3]);

	}
	
	@Test
	void peaoPretoMovendo() {
		Peao novoPeao = new Peao(false, 3, 6, tabuleiro);
		novoPeao.verificaDestino();
		assertTrue(tabuleiro.getAcionarMovimento()[3][5]);
		assertTrue(tabuleiro.getAcionarMovimento()[3][4]);
		assertTrue(!tabuleiro.getAcionarMovimento()[3][3]);

	}
	
	@Test
	void peaoPretoMovendoComBrancoNaFrente() {
		Peao novoPeao = new Peao(false, 3, 6, tabuleiro);
		Peao outroBranco = new Peao(true, 3, 4, tabuleiro);
		novoPeao.verificaDestino();
		assertTrue(tabuleiro.getAcionarMovimento()[3][5]);
		assertTrue(!tabuleiro.getAcionarMovimento()[3][4]);

	}
	
	@Test
	void peaoPretoMovendoComPretoNaFrente() {
		Peao novoPeao = new Peao(false, 3, 6, tabuleiro);
		Peao outroPreto = new Peao(false, 3, 4, tabuleiro);
		novoPeao.verificaDestino();
		assertTrue(tabuleiro.getAcionarMovimento()[3][5]);
		assertTrue(!tabuleiro.getAcionarMovimento()[3][4]);

	}
	
	@Test
	void peaoPretoMovendoComPretoLogoAFrente() {
		Peao novoPeao = new Peao(false, 3, 6, tabuleiro);
		Peao outroPreto = new Peao(false, 3, 5, tabuleiro);
		novoPeao.verificaDestino();
		assertTrue(!tabuleiro.getAcionarMovimento()[3][5]);
		assertTrue(!tabuleiro.getAcionarMovimento()[3][4]);

	}
	
	@Test
	void capturaPeaoPreto() {
		Peao p1 = new Peao(false, 4, 2, tabuleiro);
		Peao p2 = new Peao(false, 2, 2, tabuleiro);
		peao.verificaDestino();
		assertTrue(tabuleiro.getAcionarMovimento()[4][2]);
		assertTrue(tabuleiro.getAcionarMovimento()[2][2]);
	}
	
	@Test
	void peaoBrancoNaoCapturaBranco() {
		Peao p1 = new Peao(true, 4, 2, tabuleiro);
		Peao p2 = new Peao(true, 2, 2, tabuleiro);
		peao.verificaDestino();
		assertTrue(!tabuleiro.getAcionarMovimento()[4][2]);
		assertTrue(!tabuleiro.getAcionarMovimento()[2][2]);
	}
	
	@Test
	void capturaPeaoBranco() {
		Peao p1 = new Peao(true, 4, 4, tabuleiro);
		Peao p2 = new Peao(true, 2, 4, tabuleiro);
		Peao peaoQueCaptura = new Peao(false, 3, 5, tabuleiro);
		peaoQueCaptura.verificaDestino();
		assertTrue(tabuleiro.getAcionarMovimento()[4][4]);
		assertTrue(tabuleiro.getAcionarMovimento()[2][4]);
	}
	
	@Test
	void pretoNaoCapturaPreto() {
		Peao p1 = new Peao(false, 4, 4, tabuleiro);
		Peao p2 = new Peao(false, 2, 4, tabuleiro);
		Peao peaoQueCaptura = new Peao(false, 3, 5, tabuleiro);
		peaoQueCaptura.verificaDestino();
		assertTrue(!tabuleiro.getAcionarMovimento()[4][4]);
		assertTrue(!tabuleiro.getAcionarMovimento()[2][4]);
	}
	
	

}
