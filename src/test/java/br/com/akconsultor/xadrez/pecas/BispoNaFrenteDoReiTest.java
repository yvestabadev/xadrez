package br.com.akconsultor.xadrez.pecas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.akconsultor.xadrez.tabuleiro.Jogador;
import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;

class BispoNaFrenteDoReiTest {
	/*eh importante  ter um tabuleiro "laranja" para receber as pecas do jogo e um vazio para
	poder adicionar as pecas que quiser aonde quiser*/ 
	Tabuleiro nd = new Tabuleiro(1);
	Tabuleiro tabuleiro = new Tabuleiro(1);
	Jogador j1 = new Jogador("a", true, nd);
	Jogador j2 = new Jogador("b", false, nd);

	Peca reiPreto = new Rei(false, 3, 3, tabuleiro);
	Peca reiBranco = new Rei(true, 6, 6, tabuleiro);
	Peca torreBranca;
	Peca bispoPreto;

	@BeforeEach
	void adicionarTabuleiro() {
		tabuleiro.getPecasBrancas().add(reiBranco);
		tabuleiro.getPecasPretas().add(reiPreto);
	}

	@Test
	void naoPodeSairDaFrenteN() {
		bispoPreto = new Bispo(false, 3, 4, tabuleiro);
		tabuleiro.getPecasPretas().add(bispoPreto);
		torreBranca = new Torre(true, 4, 5, tabuleiro);
		tabuleiro.getPecasBrancas().add(torreBranca);

		tabuleiro.verifica(j1, torreBranca);
		tabuleiro.move(j1, torreBranca, 3, 5);

		tabuleiro.verifica(j2, bispoPreto);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
			}
		}
	}

	@Test
	void naoPodeSairDaFrenteS() {
		bispoPreto = new Bispo(false, 3, 2, tabuleiro);
		tabuleiro.getPecasPretas().add(bispoPreto);
		torreBranca = new Torre(true, 4, 1, tabuleiro);
		tabuleiro.getPecasBrancas().add(torreBranca);

		tabuleiro.verifica(j1, torreBranca);
		tabuleiro.move(j1, torreBranca, 3, 1);

		tabuleiro.verifica(j2, bispoPreto);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
			}
		}
	}

	@Test
	void naoPodeSairDaFrenteW() {
		bispoPreto = new Bispo(false, 2, 3, tabuleiro);
		tabuleiro.getPecasPretas().add(bispoPreto);
		torreBranca = new Torre(true, 1, 4, tabuleiro);
		tabuleiro.getPecasBrancas().add(torreBranca);

		tabuleiro.verifica(j1, torreBranca);
		tabuleiro.move(j1, torreBranca, 1, 3);

		tabuleiro.verifica(j2, bispoPreto);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
			}
		}
	}

	@Test
	void naoPodeSairDaFrenteE() {
		bispoPreto = new Bispo(false, 4, 3, tabuleiro);
		tabuleiro.getPecasPretas().add(bispoPreto);
		torreBranca = new Torre(true, 5, 4, tabuleiro);
		tabuleiro.getPecasBrancas().add(torreBranca);

		tabuleiro.verifica(j1, torreBranca);
		tabuleiro.move(j1, torreBranca, 5, 3);

		tabuleiro.verifica(j2, bispoPreto);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
			}
		}
	}

	@Test
	void naoPodeSairDaFrenteNE() {
		bispoPreto = new Bispo(false, 4, 4, tabuleiro);
		tabuleiro.getPecasPretas().add(bispoPreto);
		torreBranca = new Dama(true, 4, 6, tabuleiro);
		tabuleiro.getPecasBrancas().add(torreBranca);

		tabuleiro.verifica(j1, torreBranca);
		tabuleiro.move(j1, torreBranca, 5, 5);

		tabuleiro.verifica(j2, bispoPreto);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 5 && j == 5) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}
	}

	@Test
	void naoPodeSairDaFrenteNW() {
		bispoPreto = new Bispo(false, 2, 4, tabuleiro);
		tabuleiro.getPecasPretas().add(bispoPreto);
		torreBranca = new Dama(true, 4, 6, tabuleiro);
		tabuleiro.getPecasBrancas().add(torreBranca);

		tabuleiro.verifica(j1, torreBranca);
		tabuleiro.move(j1, torreBranca, 0, 6);

		tabuleiro.verifica(j2, bispoPreto);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 0 && j == 6) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else if (i == 1 && j == 5) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}
	}
	
	@Test
	void naoPodeSairDaFrenteSW() {
		bispoPreto = new Bispo(false, 2, 2, tabuleiro);
		tabuleiro.getPecasPretas().add(bispoPreto);
		torreBranca = new Dama(true, 2, 0, tabuleiro);
		tabuleiro.getPecasBrancas().add(torreBranca);

		tabuleiro.verifica(j1, torreBranca);
		tabuleiro.move(j1, torreBranca, 0, 0);

		tabuleiro.verifica(j2, bispoPreto);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 0 && j == 0) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else if (i == 1 && j == 1) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}
	}
	
	@Test
	void naoPodeSairDaFrenteSE() {
		bispoPreto = new Bispo(false, 4, 2, tabuleiro);
		tabuleiro.getPecasPretas().add(bispoPreto);
		torreBranca = new Dama(true, 2, 0, tabuleiro);
		tabuleiro.getPecasBrancas().add(torreBranca);

		tabuleiro.verifica(j1, torreBranca);
		tabuleiro.move(j1, torreBranca, 6, 0);

		tabuleiro.verifica(j2, bispoPreto);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 6 && j == 0) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else if (i == 5 && j == 1) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}
		
		tabuleiro.move(j2, bispoPreto, 6, 0);
		
		tabuleiro.verifica(j1, reiBranco);
		tabuleiro.move(j1, reiBranco, 6, 5);
		
		tabuleiro.verifica(j2, bispoPreto);
		
		assertTrue(tabuleiro.getAcionarMovimento()[7][1]);
		assertTrue(tabuleiro.getAcionarMovimento()[5][1]);
		assertTrue(tabuleiro.getAcionarMovimento()[4][2]);
	}


}
