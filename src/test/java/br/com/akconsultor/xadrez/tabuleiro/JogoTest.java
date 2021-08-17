package br.com.akconsultor.xadrez.tabuleiro;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.akconsultor.xadrez.pecas.Peca;

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

		assertTrue(tabuleiro.getPosicoesBrancas(3, 1));
		
		//primeiro movimento

		tabuleiro.move(j1, peca, 3, 3);

		assertTrue(!tabuleiro.getPosicoesBrancas(3, 1));
		assertTrue(tabuleiro.getPosicoesBrancas(3, 3));
		
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

		assertTrue(tabuleiro.getPosicoesPretas(4, 6));
		
		//movendo peca preta
		tabuleiro.move(j2, peca, 4, 4);
		
		assertTrue(!tabuleiro.getPosicoesPretas(4, 6));
		assertTrue(tabuleiro.getPosicoesPretas(4, 4));
		
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
		assertTrue(tabuleiro.getPosicoesBrancas(4, 4));
		assertTrue(tabuleiro.getPecasPretas().size() == 15);
		assertTrue(tabuleiro.getPecasBrancas().size() == 16);
		
		tabuleiro.getPecasPretas().forEach(p -> {
			if (p.getPosicao()[0] == 5 && p.getPosicao()[1] == 6) {
				peca = p;
			}
		});
		
		tabuleiro.verifica(j2, peca);
		tabuleiro.move(j2, peca, 5, 5);
		
		assertTrue(tabuleiro.getPosicoesPretas(5, 5));
		
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
		
		assertTrue(!tabuleiro.getPosicoesBrancas(4, 4));
		assertTrue(tabuleiro.getPecasBrancas().size() == 15);
		
		
		
		

	}

}