package br.com.akconsultor.xadrez.tabuleiro;

import java.util.ArrayList;
import java.util.List;

import br.com.akconsultor.xadrez.pecas.Bispo;
import br.com.akconsultor.xadrez.pecas.Cavalo;
import br.com.akconsultor.xadrez.pecas.Dama;
import br.com.akconsultor.xadrez.pecas.Peao;
import br.com.akconsultor.xadrez.pecas.Peca;
import br.com.akconsultor.xadrez.pecas.Rei;
import br.com.akconsultor.xadrez.pecas.Torre;

public class Jogador {
	
	private String nome;
	private Boolean jogaComBranco;
	private Tabuleiro tabuleiro;
	private List<Peca> pecas = new ArrayList<Peca>();
	
	
	
	public Jogador(String nome, Boolean jogaComBranco, Tabuleiro tabuleiro) {
		this.nome = nome;
		this.jogaComBranco = jogaComBranco;
		this.tabuleiro = tabuleiro;
		if(this.jogaComBranco) {
			pecas.add(new Torre(true, 0, 0, tabuleiro));
			pecas.add(new Torre(true, 7, 0, tabuleiro));
			pecas.add(new Cavalo(true, 1, 0, tabuleiro));
			pecas.add(new Cavalo(true, 6, 0, tabuleiro));
			pecas.add(new Bispo(true, 2, 0, tabuleiro));
			pecas.add(new Bispo(true, 5, 0, tabuleiro));
			pecas.add(new Dama(true, 3, 0, tabuleiro));
			pecas.add(new Rei(true, 4, 0, tabuleiro));
			pecas.add(new Peao(true, 0, 1, tabuleiro));
			pecas.add(new Peao(true, 1, 1, tabuleiro));
			pecas.add(new Peao(true, 2, 1, tabuleiro));
			pecas.add(new Peao(true, 3, 1, tabuleiro));
			pecas.add(new Peao(true, 4, 1, tabuleiro));
			pecas.add(new Peao(true, 5, 1, tabuleiro));
			pecas.add(new Peao(true, 6, 1, tabuleiro));
			pecas.add(new Peao(true, 7, 1, tabuleiro));
			
			tabuleiro.setPecasBrancas(pecas);
		} else {
			pecas.add(new Torre(false, 0, 7, tabuleiro));
			pecas.add(new Torre(false, 7, 7, tabuleiro));
			pecas.add(new Cavalo(false, 1, 7, tabuleiro));
			pecas.add(new Cavalo(false, 6, 7, tabuleiro));
			pecas.add(new Bispo(false, 2, 7, tabuleiro));
			pecas.add(new Bispo(false, 5, 7, tabuleiro));
			pecas.add(new Dama(false, 3, 7, tabuleiro));
			pecas.add(new Rei(false, 4, 7, tabuleiro));
			pecas.add(new Peao(false, 0, 6, tabuleiro));
			pecas.add(new Peao(false, 1, 6, tabuleiro));
			pecas.add(new Peao(false, 2, 6, tabuleiro));
			pecas.add(new Peao(false, 3, 6, tabuleiro));
			pecas.add(new Peao(false, 4, 6, tabuleiro));
			pecas.add(new Peao(false, 5, 6, tabuleiro));
			pecas.add(new Peao(false, 6, 6, tabuleiro));
			pecas.add(new Peao(false, 7, 6, tabuleiro));
			
			tabuleiro.setPecasPretas(pecas);
		}
		
		
	}



	public Boolean getJogaComBranco() {
		return jogaComBranco;
	}
	

	

}
