package br.com.akconsultor.xadrez.dto;

public class MovimentoVerificaDto {

	private Long jogoId;
	private Boolean ehBranca;
	private Integer coluna;
	private Integer linha;

	public Long getJogoId() {
		return jogoId;
	}

	public Boolean getEhBranca() {
		return ehBranca;
	}

	public Integer getColuna() {
		return coluna;
	}

	public Integer getLinha() {
		return linha;
	}

}
