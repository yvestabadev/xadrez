package br.com.akconsultor.xadrez.tabuleiro;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.akconsultor.xadrez.pecas.Dama;
import br.com.akconsultor.xadrez.pecas.Peao;
import br.com.akconsultor.xadrez.pecas.Peca;
import br.com.akconsultor.xadrez.pecas.Rei;

class CheckTest {
	/*eh importante  ter um tabuleiro "laranja" para receber as pecas do jogo e um vazio para
	poder adicionar as pecas que quiser aonde quiser*/ 
	Tabuleiro nd = new Tabuleiro(1);
	Tabuleiro tabuleiro = new Tabuleiro(1);
	Jogador j1 = new Jogador("a", true, nd);
	Jogador j2 = new Jogador("b", false, nd);
	
	Peca reiPreto = new Rei(false, 3, 3, tabuleiro);
	Peca reiBranco = new Rei(true, 0, 0, tabuleiro);
	Peca damaPreta = new Dama(false, 1, 2, tabuleiro);
	Peca peaoBranco = new Peao(true, 2, 1, tabuleiro);
	
	@BeforeEach
	void adicionarTabuleiro() {
		tabuleiro.getPecasBrancas().add(reiBranco);
		tabuleiro.getPecasBrancas().add(peaoBranco);
		tabuleiro.getPecasPretas().add(damaPreta);
		tabuleiro.getPecasPretas().add(reiPreto);
	}

	@Test
	void situacaoDeCheckInvalidaAlgunsMovimentos() {
		tabuleiro.verifica(j1, peaoBranco);
		tabuleiro.move(j1, peaoBranco, 2, 2);
		
		assertTrue(tabuleiro.getPosicoes(true, 2, 2));
		assertTrue(tabuleiro.getReiPreto()[0] == 3 && tabuleiro.getReiPreto()[1] == 3);
		assertTrue(tabuleiro.getCheck());
		
		tabuleiro.verifica(j2, damaPreta);
		assertTrue(tabuleiro.getAcionarMovimento()[2][2]);
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(i != 2 || j != 2) {
					assertTrue(!tabuleiro.getAcionarMovimento()[i][j]);
				}
			}
		}
		
	}
	
	@Test
	void peaoPassaNaFrenteDaDamaEReiNaoPodeEntrarEmCheckComOProprioMovimento() {
		
		tabuleiro.verifica(j1, reiBranco);
		tabuleiro.move(j1, reiBranco, 0, 1);
		
		tabuleiro.verifica(j2, damaPreta);
		tabuleiro.move(j2, damaPreta, 3, 2);
		
		tabuleiro.verifica(j1, reiBranco);
		//rei nao pode entrar em check com o proprio movimento
		assertTrue(!tabuleiro.getAcionarMovimento()[0][2]);
		assertTrue(!tabuleiro.getAcionarMovimento()[1][2]);
		
		tabuleiro.move(j1, reiBranco, 1, 1);
		
		tabuleiro.verifica(j2, damaPreta);
		tabuleiro.move(j2, damaPreta, 3, 1);
		
		tabuleiro.verifica(j1, peaoBranco);
		//peao nao sai da frente do rei
		assertTrue(!tabuleiro.getAcionarMovimento()[2][2]);
		assertTrue(!tabuleiro.getAcionarMovimento()[2][3]);
	}

}
