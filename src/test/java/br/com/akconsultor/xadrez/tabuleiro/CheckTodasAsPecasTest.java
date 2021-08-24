package br.com.akconsultor.xadrez.tabuleiro;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.akconsultor.xadrez.pecas.Bispo;
import br.com.akconsultor.xadrez.pecas.Cavalo;
import br.com.akconsultor.xadrez.pecas.Dama;
import br.com.akconsultor.xadrez.pecas.Peca;
import br.com.akconsultor.xadrez.pecas.Rei;
import br.com.akconsultor.xadrez.pecas.Torre;

class CheckTodasAsPecasTest {

	/*
	 * eh importante ter um tabuleiro "laranja" para receber as pecas do jogo e um
	 * vazio para poder adicionar as pecas que quiser aonde quiser
	 */
	Tabuleiro nd = new Tabuleiro();
	Tabuleiro tabuleiro = new Tabuleiro();
	Jogador j1 = new Jogador("a", true, nd);
	Jogador j2 = new Jogador("b", false, nd);

	Peca pecaAtacante;
	Peca pecaDefensora;
	Peca reiPreto = new Rei(false, 3, 3, tabuleiro);

	void adicionarPeca() {
		tabuleiro.getPecasBrancas().add(pecaAtacante);
		tabuleiro.getPecasPretas().add(pecaDefensora);
		tabuleiro.getPecasPretas().add(reiPreto);
	}

	@Test
	void torreEntraNaFrenteE() {
		pecaDefensora = new Torre(false, 4, 4, tabuleiro);
		pecaAtacante = new Dama(true, 6, 4, tabuleiro);
		adicionarPeca();

		tabuleiro.verifica(j1, pecaAtacante);
		tabuleiro.move(j1, pecaAtacante, 6, 3);

		tabuleiro.verifica(j2, pecaDefensora);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 4 && j == 3) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}

	}

	@Test
	void torreEntraNaFrenteW() {
		pecaDefensora = new Torre(false, 2, 5, tabuleiro);
		pecaAtacante = new Dama(true, 4, 6, tabuleiro);
		adicionarPeca();

		tabuleiro.verifica(j1, pecaAtacante);
		tabuleiro.move(j1, pecaAtacante, 1, 3);

		tabuleiro.verifica(j2, pecaDefensora);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 2 && j == 3) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}

	}

	@Test
	void torreEntraNaFrenteN() {
		pecaDefensora = new Torre(false, 3, 5, tabuleiro);
		pecaAtacante = new Dama(true, 4, 6, tabuleiro);
		adicionarPeca();

		tabuleiro.verifica(j1, pecaAtacante);
		tabuleiro.move(j1, pecaAtacante, 3, 5);

		tabuleiro.verifica(j2, pecaDefensora);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 3 && j == 4) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}

	}

	@Test
	void torreEntraNaFrenteS() {
		pecaDefensora = new Torre(false, 3, 1, tabuleiro);
		pecaAtacante = new Dama(true, 4, 2, tabuleiro);
		adicionarPeca();

		tabuleiro.verifica(j1, pecaAtacante);
		tabuleiro.move(j1, pecaAtacante, 3, 1);

		tabuleiro.verifica(j2, pecaDefensora);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 3 && j == 2) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}

	}

	@Test
	void torreEntraNaFrenteNE() {
		pecaDefensora = new Torre(false, 4, 6, tabuleiro);
		pecaAtacante = new Dama(true, 6, 5, tabuleiro);
		adicionarPeca();

		tabuleiro.verifica(j1, pecaAtacante);
		tabuleiro.move(j1, pecaAtacante, 5, 5);

		tabuleiro.verifica(j2, pecaDefensora);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 4 && j == 4) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}

	}

	@Test
	void torreEntraNaFrenteNW() {
		pecaDefensora = new Torre(false, 4, 4, tabuleiro);
		pecaAtacante = new Dama(true, 6, 5, tabuleiro);
		adicionarPeca();

		tabuleiro.verifica(j1, pecaAtacante);
		tabuleiro.move(j1, pecaAtacante, 1, 5);

		tabuleiro.verifica(j2, pecaDefensora);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 2 && j == 4) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}

	}

	@Test
	void torreEntraNaFrenteSE() {
		pecaDefensora = new Torre(false, 4, 4, tabuleiro);
		pecaAtacante = new Dama(true, 5, 5, tabuleiro);
		adicionarPeca();

		tabuleiro.verifica(j1, pecaAtacante);
		tabuleiro.move(j1, pecaAtacante, 5, 1);

		tabuleiro.verifica(j2, pecaDefensora);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 4 && j == 2) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}

	}

	@Test
	void torreEntraNaFrenteSW() {
		pecaDefensora = new Torre(false, 2, 4, tabuleiro);
		pecaAtacante = new Dama(true, 1, 5, tabuleiro);
		adicionarPeca();

		tabuleiro.verifica(j1, pecaAtacante);
		tabuleiro.move(j1, pecaAtacante, 1, 1);

		tabuleiro.verifica(j2, pecaDefensora);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 2 && j == 2) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}

	}

	@Test
	void bispoEntraNaFrenteE() {
		pecaDefensora = new Bispo(false, 3, 2, tabuleiro);
		pecaAtacante = new Dama(true, 6, 4, tabuleiro);
		adicionarPeca();

		tabuleiro.verifica(j1, pecaAtacante);
		tabuleiro.move(j1, pecaAtacante, 6, 3);

		tabuleiro.verifica(j2, pecaDefensora);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 4 && j == 3) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}

	}

	@Test
	void bispoEntraNaFrenteW() {
		pecaDefensora = new Bispo(false, 3, 4, tabuleiro);
		pecaAtacante = new Dama(true, 4, 6, tabuleiro);
		adicionarPeca();

		tabuleiro.verifica(j1, pecaAtacante);
		tabuleiro.move(j1, pecaAtacante, 1, 3);

		tabuleiro.verifica(j2, pecaDefensora);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 2 && j == 3) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}

	}

	@Test
	void bispoEntraNaFrenteN() {
		pecaDefensora = new Bispo(false, 4, 3, tabuleiro);
		pecaAtacante = new Dama(true, 4, 6, tabuleiro);
		adicionarPeca();

		tabuleiro.verifica(j1, pecaAtacante);
		tabuleiro.move(j1, pecaAtacante, 3, 5);

		tabuleiro.verifica(j2, pecaDefensora);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 3 && j == 4) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}

	}

	@Test
	void bispoEntraNaFrenteS() {
		pecaDefensora = new Bispo(false, 4, 1, tabuleiro);
		pecaAtacante = new Dama(true, 4, 2, tabuleiro);
		adicionarPeca();

		tabuleiro.verifica(j1, pecaAtacante);
		tabuleiro.move(j1, pecaAtacante, 3, 1);

		tabuleiro.verifica(j2, pecaDefensora);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 3 && j == 2) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}

	}

	@Test
	void bispoEntraNaFrenteNE() {
		pecaDefensora = new Bispo(false, 5, 3, tabuleiro);
		pecaAtacante = new Dama(true, 6, 5, tabuleiro);
		adicionarPeca();

		tabuleiro.verifica(j1, pecaAtacante);
		tabuleiro.move(j1, pecaAtacante, 5, 5);

		tabuleiro.verifica(j2, pecaDefensora);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 4 && j == 4) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}

	}

	@Test
	void bispoEntraNaFrenteNW() {
		pecaDefensora = new Bispo(false, 1, 3, tabuleiro);
		pecaAtacante = new Dama(true, 6, 5, tabuleiro);
		adicionarPeca();

		tabuleiro.verifica(j1, pecaAtacante);
		tabuleiro.move(j1, pecaAtacante, 1, 5);

		tabuleiro.verifica(j2, pecaDefensora);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 2 && j == 4) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}

	}

	@Test
	void bispoEntraNaFrenteSE() {
		pecaDefensora = new Bispo(false, 3, 1, tabuleiro);
		pecaAtacante = new Dama(true, 5, 5, tabuleiro);
		adicionarPeca();

		tabuleiro.verifica(j1, pecaAtacante);
		tabuleiro.move(j1, pecaAtacante, 5, 1);

		tabuleiro.verifica(j2, pecaDefensora);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 4 && j == 2) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}

	}

	@Test
	void bispoEntraNaFrenteSW() {
		pecaDefensora = new Bispo(false, 3, 1, tabuleiro);
		pecaAtacante = new Dama(true, 1, 5, tabuleiro);
		adicionarPeca();

		tabuleiro.verifica(j1, pecaAtacante);
		tabuleiro.move(j1, pecaAtacante, 1, 1);

		tabuleiro.verifica(j2, pecaDefensora);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 2 && j == 2) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}

	}

	@Test
	void cavaloEntraNaFrenteE() {
		pecaDefensora = new Cavalo(false, 2, 4, tabuleiro);
		pecaAtacante = new Dama(true, 6, 4, tabuleiro);
		adicionarPeca();

		tabuleiro.verifica(j1, pecaAtacante);
		tabuleiro.move(j1, pecaAtacante, 6, 3);

		tabuleiro.verifica(j2, pecaDefensora);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 4 && j == 3) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}

	}

	@Test
	void cavaloEntraNaFrenteW() {
		pecaDefensora = new Cavalo(false, 1, 1, tabuleiro);
		pecaAtacante = new Dama(true, 4, 6, tabuleiro);
		adicionarPeca();

		tabuleiro.verifica(j1, pecaAtacante);
		tabuleiro.move(j1, pecaAtacante, 1, 3);

		tabuleiro.verifica(j2, pecaDefensora);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 2 && j == 3) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}

	}

	@Test
	void cavaloEntraNaFrenteN() {
		pecaDefensora = new Cavalo(false, 2, 2, tabuleiro);
		pecaAtacante = new Dama(true, 4, 6, tabuleiro);
		adicionarPeca();

		tabuleiro.verifica(j1, pecaAtacante);
		tabuleiro.move(j1, pecaAtacante, 3, 5);

		tabuleiro.verifica(j2, pecaDefensora);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 3 && j == 4) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}

	}

	@Test
	void cavaloEntraNaFrenteS() {
		pecaDefensora = new Cavalo(false, 5, 3, tabuleiro);
		pecaAtacante = new Dama(true, 4, 2, tabuleiro);
		adicionarPeca();

		tabuleiro.verifica(j1, pecaAtacante);
		tabuleiro.move(j1, pecaAtacante, 3, 1);

		tabuleiro.verifica(j2, pecaDefensora);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 3 && j == 2) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}

	}

	@Test
	void cavaloEntraNaFrenteNE() {
		pecaDefensora = new Cavalo(false, 5, 2, tabuleiro);
		pecaAtacante = new Dama(true, 6, 5, tabuleiro);
		adicionarPeca();

		tabuleiro.verifica(j1, pecaAtacante);
		tabuleiro.move(j1, pecaAtacante, 5, 5);

		tabuleiro.verifica(j2, pecaDefensora);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 4 && j == 4) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}

	}

	@Test
	void cavaloEntraNaFrenteNW() {
		pecaDefensora = new Cavalo(false, 1, 2, tabuleiro);
		pecaAtacante = new Dama(true, 6, 5, tabuleiro);
		adicionarPeca();

		tabuleiro.verifica(j1, pecaAtacante);
		tabuleiro.move(j1, pecaAtacante, 1, 5);

		tabuleiro.verifica(j2, pecaDefensora);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 2 && j == 4) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}

	}

	@Test
	void cavaloEntraNaFrenteSE() {
		pecaDefensora = new Cavalo(false, 3, 4, tabuleiro);
		pecaAtacante = new Dama(true, 5, 5, tabuleiro);
		adicionarPeca();

		tabuleiro.verifica(j1, pecaAtacante);
		tabuleiro.move(j1, pecaAtacante, 5, 1);

		tabuleiro.verifica(j2, pecaDefensora);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 4 && j == 2) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}

	}

	@Test
	void cavaloEntraNaFrenteSW() {
		pecaDefensora = new Cavalo(false, 0, 1, tabuleiro);
		pecaAtacante = new Dama(true, 1, 5, tabuleiro);
		adicionarPeca();

		tabuleiro.verifica(j1, pecaAtacante);
		tabuleiro.move(j1, pecaAtacante, 1, 1);

		tabuleiro.verifica(j2, pecaDefensora);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 2 && j == 2) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}

	}

	@Test
	void damaEntraNaFrenteE() {
		pecaDefensora = new Dama(false, 4, 4, tabuleiro);
		pecaAtacante = new Dama(true, 6, 4, tabuleiro);
		adicionarPeca();

		tabuleiro.verifica(j1, pecaAtacante);
		tabuleiro.move(j1, pecaAtacante, 6, 3);

		tabuleiro.verifica(j2, pecaDefensora);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 4 && j == 3) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else if (i == 5 && j == 3) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}

	}

	@Test
	void damaEntraNaFrenteW() {
		pecaDefensora = new Dama(false, 2, 5, tabuleiro);
		pecaAtacante = new Dama(true, 4, 6, tabuleiro);
		adicionarPeca();

		tabuleiro.verifica(j1, pecaAtacante);
		tabuleiro.move(j1, pecaAtacante, 1, 3);

		tabuleiro.verifica(j2, pecaDefensora);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 2 && j == 3) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}

	}

	@Test
	void damaEntraNaFrenteN() {
		pecaDefensora = new Dama(false, 3, 5, tabuleiro);
		pecaAtacante = new Dama(true, 4, 6, tabuleiro);
		adicionarPeca();

		tabuleiro.verifica(j1, pecaAtacante);
		tabuleiro.move(j1, pecaAtacante, 3, 5);

		tabuleiro.verifica(j2, pecaDefensora);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 3 && j == 4) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}

	}

	@Test
	void damaEntraNaFrenteS() {
		pecaDefensora = new Dama(false, 3, 1, tabuleiro);
		pecaAtacante = new Dama(true, 4, 2, tabuleiro);
		adicionarPeca();

		tabuleiro.verifica(j1, pecaAtacante);
		tabuleiro.move(j1, pecaAtacante, 3, 1);

		tabuleiro.verifica(j2, pecaDefensora);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 3 && j == 2) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}

	}

	@Test
	void damaEntraNaFrenteNE() {
		pecaDefensora = new Dama(false, 4, 6, tabuleiro);
		pecaAtacante = new Dama(true, 6, 5, tabuleiro);
		adicionarPeca();

		tabuleiro.verifica(j1, pecaAtacante);
		tabuleiro.move(j1, pecaAtacante, 5, 5);

		tabuleiro.verifica(j2, pecaDefensora);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 4 && j == 4) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else if (i == 5 && j == 5) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}

	}

	@Test
	void damaEntraNaFrenteNW() {
		pecaDefensora = new Dama(false, 4, 4, tabuleiro);
		pecaAtacante = new Dama(true, 6, 5, tabuleiro);
		adicionarPeca();

		tabuleiro.verifica(j1, pecaAtacante);
		tabuleiro.move(j1, pecaAtacante, 1, 5);

		tabuleiro.verifica(j2, pecaDefensora);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 2 && j == 4) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}

	}

	@Test
	void damaEntraNaFrenteSE() {
		pecaDefensora = new Dama(false, 4, 4, tabuleiro);
		pecaAtacante = new Dama(true, 5, 5, tabuleiro);
		adicionarPeca();

		tabuleiro.verifica(j1, pecaAtacante);
		tabuleiro.move(j1, pecaAtacante, 5, 1);

		tabuleiro.verifica(j2, pecaDefensora);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 4 && j == 2) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}

	}

	@Test
	void damaEntraNaFrenteSW() {
		pecaDefensora = new Dama(false, 2, 4, tabuleiro);
		pecaAtacante = new Dama(true, 1, 5, tabuleiro);
		adicionarPeca();

		tabuleiro.verifica(j1, pecaAtacante);
		tabuleiro.move(j1, pecaAtacante, 1, 1);

		tabuleiro.verifica(j2, pecaDefensora);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 2 && j == 2) {
					assertTrue(tabuleiro.getAcionarMovimento()[i][j]);
				} else {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}

	}

	
}
