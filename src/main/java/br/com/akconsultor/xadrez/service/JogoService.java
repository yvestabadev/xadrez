package br.com.akconsultor.xadrez.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.akconsultor.xadrez.dto.ChequeEMate;
import br.com.akconsultor.xadrez.dto.MovimentoDto;
import br.com.akconsultor.xadrez.dto.MovimentoVerificaDto;
import br.com.akconsultor.xadrez.pecas.Peca;
import br.com.akconsultor.xadrez.repository.JogoRepository;
import br.com.akconsultor.xadrez.tabuleiro.Jogador;
import br.com.akconsultor.xadrez.tabuleiro.Jogo;
import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;

@Service
public class JogoService {

	@Autowired
	private JogoRepository repository;
	
	
	public Long novoJogo() {
		Jogo jogo = new Jogo("jogador1", "jogador2");
		repository.save(jogo);
		return jogo.getId();
	}
	
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

	public ChequeEMate move(MovimentoDto mov, Jogo jogo) {
		ChequeEMate bool = new ChequeEMate();
		Tabuleiro tabuleiro = jogo.getTabuleiro();
		Jogador jogadorBranco = jogo.getJogador1();
		Jogador jogadorPreto = jogo.getJogador2();
		Peca peca = tabuleiro.encontrarPeca(mov.getEhBranca(), mov.getColunaAtual(), mov.getLinhaAtual());
		
		Integer coluna = mov.getColunaDestino();
		Integer linha = mov.getLinhaDestino();
		
		
		
		if(mov.getEhBranca()) {
			tabuleiro.verifica(jogadorBranco, peca);
			tabuleiro.move(jogadorBranco, peca, coluna, linha);			
		} else {
			tabuleiro.verifica(jogadorPreto, peca);
			tabuleiro.move(jogadorPreto, peca, coluna, linha);
		}
		
		bool.setCheck(tabuleiro.getCheck());
		bool.setCheckmate(tabuleiro.getCheckmate());
		
	
		
		return bool;
		
	}

}
