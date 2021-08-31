package br.com.akconsultor.xadrez.service;

import org.springframework.stereotype.Service;

import br.com.akconsultor.xadrez.dto.MovimentoDto;
import br.com.akconsultor.xadrez.dto.MovimentoVerificaDto;
import br.com.akconsultor.xadrez.dto.TabuleiroDto;
import br.com.akconsultor.xadrez.pecas.Peca;
import br.com.akconsultor.xadrez.tabuleiro.Jogador;
import br.com.akconsultor.xadrez.tabuleiro.Jogo;
import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;

@Service
public class JogoService {

	
//	@Cacheable(value = "jogo")
//	public Jogo novoJogo() {
//		Jogo jogo = new Jogo("jogador1", "jogador2");
//		
//		return jogo;
//	}
	
	public boolean[][] verificaDestino(MovimentoVerificaDto mov, Jogo jogo) {
	
		Tabuleiro tabuleiro = jogo.getTabuleiro();
		Jogador jogadorBranco = jogo.getJogador1();
		Jogador jogadorPreto = jogo.getJogador2();
		Peca peca = tabuleiro.encontrarPeca(mov.getEhBranca(), mov.getColuna(), mov.getLinha());
		
		if(mov.getEhBranca()) {
		tabuleiro.verifica(jogadorBranco, peca);
		} else {
		tabuleiro.verifica(jogadorPreto, peca);
		}
		
		return tabuleiro.getAcionarMovimento();
	}

	public TabuleiroDto move(MovimentoDto mov, Jogo jogo) {
		
		Tabuleiro tabuleiro = jogo.getTabuleiro();
		Jogador jogadorBranco = jogo.getJogador1();
		Jogador jogadorPreto = jogo.getJogador2();
		Peca peca = tabuleiro.encontrarPeca(mov.getEhBranca(), mov.getColunaAtual(), mov.getLinhaAtual());
		
		Integer coluna = mov.getColunaDestino();
		Integer linha = mov.getLinhaDestino();
		
		if(mov.getEhBranca()) {
			tabuleiro.move(jogadorBranco, peca, coluna, linha);			
		} else {
			tabuleiro.move(jogadorPreto, peca, coluna, linha);
		}
		
		return new TabuleiroDto(tabuleiro, tabuleiro.getPosicoes(mov.getEhBranca(), coluna, linha));
		
	}

}
