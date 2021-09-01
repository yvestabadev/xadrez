package br.com.akconsultor.xadrez.dto;

public class MovimentoDto {
	
	private Long jogoId;
	private Boolean ehBranca;
	private Integer colunaAtual;
	private Integer linhaAtual;
	private Integer colunaDestino;
	private Integer linhaDestino;
	
	public Long getJogoId() {
		return jogoId;
	}
	
	public Boolean getEhBranca() {
		return ehBranca;
	}
	public Integer getColunaAtual() {
		return colunaAtual;
	}
	public Integer getLinhaAtual() {
		return linhaAtual;
	}
	public Integer getColunaDestino() {
		return colunaDestino;
	}
	public Integer getLinhaDestino() {
		return linhaDestino;
	}
	
	

}
