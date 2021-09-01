package br.com.akconsultor.xadrez.pecas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;

import br.com.akconsultor.xadrez.pecas.movimentos.Direcao;
import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Peca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ElementCollection
	@JoinTable(name = "posicao_peca")
	@OrderColumn
	private Integer[] posicao = new Integer[2];
	private Boolean ehBranca;
	@ElementCollection(targetClass = Direcao.class)
	@JoinTable(name = "direcoes_peca", joinColumns = @JoinColumn (name = "peca_id"))
	@Enumerated(EnumType.STRING)
	protected List<Direcao> direcoes = new ArrayList<Direcao>();
	@ManyToOne
	protected Tabuleiro tabuleiro;
	private Direcao direcaoProtegida;
	
	public Peca() {
		
	}
	
	public void resetDirecaoProtegida() {
		this.direcaoProtegida = null;
	}

	public Direcao getDirecaoProtegida() {
		return direcaoProtegida;
	}

	public void setDirecaoProtegida(Direcao direcaoProtegida) {
		this.direcaoProtegida = direcaoProtegida;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void adicionarDirecoes(Direcao direcao) {
		direcoes.add(direcao);
	}
	
	public List<Direcao> getDirecoes() {
		return direcoes;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public Integer[] getPosicao() {
		return posicao;
	}

	public void setPosicao(Integer coluna, Integer linha) {
		this.posicao[0] = coluna;
		this.posicao[1] = linha;
	}

	public Boolean getEhBranca() {
		return ehBranca;
	}

	public void setEhBranca(Boolean ehBranca) {
		this.ehBranca = ehBranca;
	}

	public abstract void verificaDestino();

	public abstract void ameacaCasas();

}
