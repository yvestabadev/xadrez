package br.com.akconsultor.xadrez.tabuleiro;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.akconsultor.xadrez.pecas.*;

class JogoTest {

	Jogo jogo = new Jogo("um", "dois");
	Tabuleiro tabuleiro = jogo.getTabuleiro();
	Jogador j1 = jogo.getJogador1();
	Jogador j2 = jogo.getJogador2();
	Peca peca = null;

	@Test
	void capturas() {

		tabuleiro.getPecasBrancas().forEach(p -> {
			if (p.getPosicao()[0] == 3 && p.getPosicao()[1] == 1) {
				peca = p;
			}
		});

		tabuleiro.verifica(j1, peca);
		
		//verificando destino do primeiro movimento

		assertTrue(tabuleiro.getAcionarMovimento()[3][2]);
		assertTrue(tabuleiro.getAcionarMovimento()[3][3]);
		assertTrue(!tabuleiro.getAcionarMovimento()[3][4]);
		assertTrue(!tabuleiro.getAcionarMovimento()[3][5]);

		assertTrue(tabuleiro.getPosicoes(true, 3, 1));
		
		//primeiro movimento

		tabuleiro.move(j1, peca, 3, 3);

		assertTrue(!tabuleiro.getPosicoes(true, 3, 1));
		assertTrue(tabuleiro.getPosicoes(true, 3, 3));
		
		//verificando primeiro movimento das pretas

		tabuleiro.getPecasPretas().forEach(p -> {
			if (p.getPosicao()[0] == 4 && p.getPosicao()[1] == 6) {
				peca = p;
			}
		});
		
		tabuleiro.verifica(j2, peca);
		
		assertTrue(tabuleiro.getAcionarMovimento()[4][5]);
		assertTrue(tabuleiro.getAcionarMovimento()[4][4]);
		assertTrue(!tabuleiro.getAcionarMovimento()[4][3]);
		assertTrue(!tabuleiro.getAcionarMovimento()[4][2]);

		assertTrue(tabuleiro.getPosicoes(false, 4, 6));
		
		//movendo peca preta
		tabuleiro.move(j2, peca, 4, 4);
		
		assertTrue(!tabuleiro.getPosicoes(false, 4, 6));
		assertTrue(tabuleiro.getPosicoes(false, 4, 4));
		
		//tentando verificar destino do jogador que nao e a vez dele
		
		tabuleiro.verifica(j2, peca);
		
		assertTrue(!tabuleiro.getAcionarMovimento()[4][3]);
		
		tabuleiro.getPecasBrancas().forEach(p -> {
			if (p.getPosicao()[0] == 3 && p.getPosicao()[1] == 3) {
				peca = p;
			}
		});
		
		tabuleiro.verifica(j1, peca);
		tabuleiro.move(j1, peca, 4, 4);
		assertTrue(tabuleiro.getPosicoes(true, 4, 4));
		assertTrue(tabuleiro.getPecasPretas().size() == 15);
		assertTrue(tabuleiro.getPecasBrancas().size() == 16);
		
		tabuleiro.getPecasPretas().forEach(p -> {
			if (p.getPosicao()[0] == 5 && p.getPosicao()[1] == 6) {
				peca = p;
			}
		});
		
		tabuleiro.verifica(j2, peca);
		tabuleiro.move(j2, peca, 5, 5);
		
		assertTrue(tabuleiro.getPosicoes(false,5, 5));
		
		tabuleiro.getPecasBrancas().forEach(p -> {
			if (p.getPosicao()[0] == 7 && p.getPosicao()[1] == 1) {
				peca = p;
			}
		});
		
		tabuleiro.verifica(j1, peca);
		tabuleiro.move(j1, peca, 7, 2);
		
		tabuleiro.getPecasPretas().forEach(p -> {
			if (p.getPosicao()[0] == 5 && p.getPosicao()[1] == 5) {
				peca = p;
			}
		});
		
		tabuleiro.verifica(j2, peca);
		tabuleiro.move(j2, peca, 4, 4);
		
		assertTrue(!tabuleiro.getPosicoes(true, 4, 4));
		assertTrue(tabuleiro.getPecasBrancas().size() == 15);
		
		
		
		

	}
	
	@Test
	void check() {
		tabuleiro.getPecasBrancas().forEach(p -> {
			if (p.getPosicao()[0] == 5 && p.getPosicao()[1] == 1) {
				peca = p;
			}
		});
		
		tabuleiro.verifica(j1, peca);
		tabuleiro.move(j1, peca, 5, 3);
		
		tabuleiro.getPecasPretas().forEach(p -> {
			if (p.getPosicao()[0] == 4 && p.getPosicao()[1] == 6) {
				peca = p;
			}
		});
		
		tabuleiro.verifica(j2, peca);
		tabuleiro.move(j2, peca, 4, 4);
		
		assertTrue(tabuleiro.getPosicoes(true, 5, 3));
		assertTrue(tabuleiro.getPosicoes(false, 4, 4));
		
		tabuleiro.getPecasBrancas().forEach(p -> {
			if (p.getPosicao()[0] == 5 && p.getPosicao()[1] == 3) {
				peca = p;
			}
		});
		
		tabuleiro.verifica(j1, peca);
		tabuleiro.move(j1, peca, 4, 4);
		
		tabuleiro.getPecasPretas().forEach(p -> {
			if (p.getPosicao()[0] == 3 && p.getPosicao()[1] == 7) {
				peca = p;
			}
		});
		
		tabuleiro.verifica(j2, peca);
		tabuleiro.move(j2, peca, 7, 3);
		
		assertTrue(tabuleiro.getCheck());
		
		tabuleiro.getPecasBrancas().forEach(p -> {
			if (p.getPosicao()[0] == 6 && p.getPosicao()[1] == 1) {
				peca = p;
			}
		});
		

		
		tabuleiro.verifica(j1, peca);
		
		assertTrue(tabuleiro.getAcionarMovimento()[6][2]);
		assertTrue(!tabuleiro.getAcionarMovimento()[6][3]);
		
		tabuleiro.move(j1, peca, 6, 2);
		
		assertTrue(!tabuleiro.getCheck());
		
		tabuleiro.getPecasPretas().forEach(p -> {
			if (p.getPosicao()[0] == 7 && p.getPosicao()[1] == 3) {
				peca = p;
			}
		});
		
		tabuleiro.verifica(j2, peca);
		tabuleiro.move(j2, peca, 6, 2);
		
		assertTrue(tabuleiro.getPecasBrancas().size() == 15);
		assertTrue(tabuleiro.getCheck());
		
		tabuleiro.getPecasBrancas().forEach(p -> {
			if (p.getPosicao()[0] == 0 && p.getPosicao()[1] == 1) {
				peca = p;
			}
		});
		
		tabuleiro.verifica(j1, peca);
		assertTrue(!tabuleiro.getAcionarMovimento()[6][2]);
		
		tabuleiro.getPecasBrancas().forEach(p -> {
			if (p.getPosicao()[0] == 7 && p.getPosicao()[1] == 1) {
				peca = p;
			}
		});
		
		tabuleiro.verifica(j1, peca);
		assertTrue(tabuleiro.getAcionarMovimento()[6][2]);
		assertTrue(!tabuleiro.getAcionarMovimento()[7][2]);
		
		
		
	}

	@Test
	void roque() {
		Peca reiBranco = tabuleiro.encontrarPeca(true, 4, 0);
		
		tabuleiro.verifica(j1, reiBranco);		
		assertTrue(!tabuleiro.getAcionarMovimento()[6][0]);
		
		Peca peaoRei = tabuleiro.encontrarPeca(true, 4, 1);
		tabuleiro.verifica(j1, peaoRei);
		tabuleiro.move(j1, peaoRei, 4, 3);
		
		Peca p1 = tabuleiro.encontrarPeca(false, 0, 6);
		tabuleiro.verifica(j2, p1);
		tabuleiro.move(j2, p1, 0, 5);
		
		tabuleiro.verifica(j1, reiBranco);		
		assertTrue(!tabuleiro.getAcionarMovimento()[6][0]);
		
		Peca bispo = tabuleiro.encontrarPeca(true, 5, 0);
		tabuleiro.verifica(j1, bispo);
		tabuleiro.move(j1, bispo, 4, 1);
		
		tabuleiro.verifica(j2, p1);
		tabuleiro.move(j2, p1, 0, 4);
		
		tabuleiro.verifica(j1, reiBranco);		
		assertTrue(!tabuleiro.getAcionarMovimento()[6][0]);
		
		Peca cavalo = tabuleiro.encontrarPeca(true, 6, 0);
		tabuleiro.verifica(j1, cavalo);
		tabuleiro.move(j1, cavalo, 5, 2);
		
		tabuleiro.verifica(j2, p1);
		tabuleiro.move(j2, p1, 0, 3);
		
		tabuleiro.verifica(j1, reiBranco);		
		assertTrue(tabuleiro.getAcionarMovimento()[6][0]);
		
		Peca peaoTorre = tabuleiro.encontrarPeca(true, 7, 1);
		tabuleiro.verifica(j1, peaoTorre);
		tabuleiro.move(j1, peaoTorre, 7, 3);
		
		tabuleiro.verifica(j2, p1);
		tabuleiro.move(j2, p1, 0, 2);
		
		Peca torre = tabuleiro.encontrarPeca(true, 7, 0);
		tabuleiro.verifica(j1, torre);
		tabuleiro.move(j1, torre, 7, 2);
	
		
		assertTrue(tabuleiro.getPosicoes(true, 7, 2));
		assertTrue(torre.getPosicao()[1] == 2);
		
		tabuleiro.verifica(j2, p1);
		tabuleiro.move(j2, p1, 1, 1);
		
		tabuleiro.verifica(j1, reiBranco);
		
		assertTrue(!tabuleiro.getAcionarMovimento()[6][0]);
		
		
	}
	
	@Test
	void reiMexeNaoPodeRoque() {
		Peca peaoRei = tabuleiro.encontrarPeca(true, 4, 1);
		tabuleiro.verifica(j1, peaoRei);
		tabuleiro.move(j1, peaoRei, 4, 3);
		
		Peca p1 = tabuleiro.encontrarPeca(false, 0, 6);
		tabuleiro.verifica(j2, p1);
		tabuleiro.move(j2, p1, 0, 5);
		
		Peca reiBranco = tabuleiro.encontrarPeca(true, 4, 0);
		tabuleiro.verifica(j1, reiBranco);
		tabuleiro.move(j1, reiBranco, 4, 1);
		
		assertTrue(!tabuleiro.getRoqueGrande(true));
		assertTrue(!tabuleiro.getRoquePequeno(true));
		assertTrue(tabuleiro.getRoqueGrande(false));
		assertTrue(tabuleiro.getRoquePequeno(false));
	}
	
	@Test
	void promocaoPeao() {
		
		assertTrue(tabuleiro.getPecasBrancas().size() == 16);
		Peca peaoTorreBranca = tabuleiro.encontrarPeca(true, 0, 1);
		tabuleiro.verifica(j1, peaoTorreBranca);
		tabuleiro.move(j1, peaoTorreBranca, 0, 3);
		
		Peca peaoTorrePreta = tabuleiro.encontrarPeca(false, 7, 6);
		tabuleiro.verifica(j2, peaoTorrePreta);
		tabuleiro.move(j2, peaoTorrePreta, 7, 4);
		
		tabuleiro.verifica(j1, peaoTorreBranca);
		tabuleiro.move(j1, peaoTorreBranca, 0, 4);
		
		tabuleiro.verifica(j2, peaoTorrePreta);
		tabuleiro.move(j2, peaoTorrePreta, 7, 3);
		
		tabuleiro.verifica(j1, peaoTorreBranca);
		tabuleiro.move(j1, peaoTorreBranca, 0, 5);
		
		tabuleiro.verifica(j2, peaoTorrePreta);
		tabuleiro.move(j2, peaoTorrePreta, 7, 2);
		
		tabuleiro.verifica(j1, peaoTorreBranca);
		assertTrue(!tabuleiro.getAcionarMovimento()[0][6]);
		tabuleiro.move(j1, peaoTorreBranca, 1, 6);
		
		tabuleiro.verifica(j2, peaoTorrePreta);
		assertTrue(!tabuleiro.getAcionarMovimento()[7][1]);
		tabuleiro.move(j2, peaoTorrePreta, 6, 1);
		
		assertTrue(tabuleiro.getPecasBrancas().size() == 15);
		
		tabuleiro.verifica(j1, peaoTorreBranca);
		tabuleiro.move(j1, peaoTorreBranca, 0, 7);
		
		tabuleiro.promovePeao(peaoTorreBranca, Dama.class);
		
		assertTrue(tabuleiro.getPecasBrancas().size() == 15);
		
		tabuleiro.verifica(j2, peaoTorrePreta);
		tabuleiro.move(j2, peaoTorrePreta, 7, 0);
		
		
		tabuleiro.promovePeao( peaoTorrePreta, Dama.class);
		
		Peca damaBranca = tabuleiro.encontrarPeca(true, 0, 7);
		tabuleiro.verifica(j1, damaBranca);
		
		assertTrue(tabuleiro.getAcionarMovimento()[1][7]);
		assertTrue(tabuleiro.getAcionarMovimento()[0][6]);
		assertTrue(tabuleiro.getAcionarMovimento()[1][6]);
		assertTrue(tabuleiro.getAcionarMovimento()[2][5]);
		assertTrue(tabuleiro.getAcionarMovimento()[3][4]);
		assertTrue(tabuleiro.getAcionarMovimento()[4][3]);
		assertTrue(tabuleiro.getPecasBrancas().size() == 14);
		assertTrue(tabuleiro.getPecasPretas().size() == 14);
		
		tabuleiro.move(j1, damaBranca, 1, 7);
		assertTrue(tabuleiro.getPecasPretas().size() == 13);
		
		Peca damaPreta = tabuleiro.encontrarPeca(false, 7, 0);
		
		tabuleiro.verifica(j2, damaPreta);
		assertTrue(tabuleiro.getAcionarMovimento()[7][1]);
		assertTrue(tabuleiro.getAcionarMovimento()[6][0]);
		assertTrue(tabuleiro.getAcionarMovimento()[6][1]);
		assertTrue(tabuleiro.getAcionarMovimento()[5][2]);
		
		
	}
	
	@Test
	void naoPodeRoqueComCasaQueVaiPassarEmCheck() {
		Peca pecaBranca = tabuleiro.encontrarPeca(true, 4, 1);
		tabuleiro.verifica(j1, pecaBranca);
		tabuleiro.move(j1, pecaBranca, 4, 3);
		
		Peca peaoPreto = tabuleiro.encontrarPeca(false, 3, 6);
		tabuleiro.verifica(j2, peaoPreto);
		tabuleiro.move(j2, peaoPreto, 3, 4);
		
		pecaBranca = tabuleiro.encontrarPeca(true, 5, 0);
		tabuleiro.verifica(j1, pecaBranca);
		tabuleiro.move(j1, pecaBranca, 0, 5);
		
		tabuleiro.verifica(j2, peaoPreto);
		tabuleiro.move(j2, peaoPreto, 4, 3);
		assertTrue(tabuleiro.getPecasBrancas().size() == 15);
		
		pecaBranca = tabuleiro.encontrarPeca(true, 6, 0);
		tabuleiro.verifica(j1, pecaBranca);
		tabuleiro.move(j1, pecaBranca, 7, 2);
		
		tabuleiro.verifica(j2, peaoPreto);
		tabuleiro.move(j2, peaoPreto, 4, 2);
		
		tabuleiro.verifica(j1, pecaBranca);
		tabuleiro.move(j1, pecaBranca, 6, 4);
		
		tabuleiro.verifica(j2, peaoPreto);
		tabuleiro.move(j2, peaoPreto, 4, 1);
		
		assertTrue(tabuleiro.getPosicoes(false, 4, 1));
		
		pecaBranca = tabuleiro.encontrarPeca(true, 4, 0);
		tabuleiro.verifica(j1, pecaBranca);
		assertTrue(tabuleiro.getAcionarMovimento()[4][1]);
		assertTrue(!tabuleiro.getAcionarMovimento()[5][0]);
		assertTrue(!tabuleiro.getAcionarMovimento()[6][0]);
		
	}
}
