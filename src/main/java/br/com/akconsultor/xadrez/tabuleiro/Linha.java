package br.com.akconsultor.xadrez.tabuleiro;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderColumn;

@Entity
public class Linha {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OrderColumn
	@ElementCollection
	private boolean[] bool = new boolean[8];
	
	public void setBool(boolean bool, int linha) {
		this.bool[linha] = bool;
	}
	
	public boolean getBool(int linha) {
		return bool[linha];
	}

}
