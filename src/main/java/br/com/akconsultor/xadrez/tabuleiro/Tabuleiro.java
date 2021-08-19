package br.com.akconsultor.xadrez.tabuleiro;

import java.util.ArrayList;
import java.util.List;

import br.com.akconsultor.xadrez.pecas.Peca;
import br.com.akconsultor.xadrez.pecas.Rei;
import br.com.akconsultor.xadrez.pecas.movimentos.Direcao;

public class Tabuleiro {

	private boolean[][] posicoesBrancas = new boolean[8][8];
	private boolean[][] posicoesPretas = new boolean[8][8];
	private boolean[][] acionarMovimento = new boolean[8][8];
	private boolean[][] lugaresAmeacados = new boolean[8][8];
	private List<Peca> pecasBrancas = new ArrayList<Peca>();
	private List<Peca> pecasPretas = new ArrayList<Peca>();
	private Boolean vezDasBrancas = true;
	private Peca pecaCapturada;
	private Boolean check = false;
	private Integer[] reiBranco = new Integer[2];
	private Integer[] reiPreto = new Integer[2];
	private Rei reiBrancoPeca;
	private Rei reiPretoPeca;
	private List<Direcao> direcoesCheck = new ArrayList<Direcao>();
	private Peca pecaAmeaca;
	
	public void setReiBrancoPeca(Rei reiBrancoPeca) {
		this.reiBrancoPeca = reiBrancoPeca;
	}
	
	public void setReiPretoPeca(Rei reiPretoPeca) {
		this.reiPretoPeca = reiPretoPeca;
	}

	public void setPecaAmeaca(Peca pecaAmeaca) {
		this.pecaAmeaca = pecaAmeaca;
	}

	public Peca getPecaAmeaca() {
		return pecaAmeaca;
	}

	private void resetDirecoesCheck() {
		direcoesCheck.removeAll(direcoesCheck);
	}

	public List<Direcao> getDirecoesCheck() {
		return direcoesCheck;
	}

	public void adicionarDirecoesCheck(Direcao direcao) {
		this.direcoesCheck.add(direcao);
	}

	public void setReiBranco(Integer coluna, Integer linha) {
		this.reiBranco[0] = coluna;
		this.reiBranco[1] = linha;
	}

	public void setReiPreto(Integer coluna, Integer linha) {
		this.reiPreto[0] = coluna;
		this.reiPreto[1] = linha;
	}

	public Integer[] getReiBranco() {
		return reiBranco;
	}

	public Integer[] getReiPreto() {
		return reiPreto;
	}

	public Boolean getCheck() {
		return check;
	}

	public boolean[][] getLugaresAmeacados() {
		return lugaresAmeacados;
	}
	
	public boolean getPosicoes(Boolean ehBranca, Integer coluna, Integer linha) {
		if(ehBranca) {
			return posicoesBrancas[coluna][linha];
		} else {
			return posicoesPretas[coluna][linha];
		}
	}

//	public boolean getPosicoesBrancas(Integer coluna, Integer linha) {
//		return posicoesBrancas[coluna][linha];
//	}

	public void setPosicoesBrancas(Peca peca, Integer coluna, Integer linha) {
		this.posicoesBrancas[coluna][linha] = true;
	}

//	public boolean getPosicoesPretas(Integer coluna, Integer linha) {
//		return posicoesPretas[coluna][linha];
//	}

	public void setPosicoesPretas(Peca peca, Integer coluna, Integer linha) {
		this.posicoesPretas[coluna][linha] = true;
	}

	public boolean[][] getAcionarMovimento() {
		return acionarMovimento;
	}

	public void resetAcionarMovimento() {
		this.acionarMovimento = new boolean[8][8];
	}

	public List<Peca> getPecasBrancas() {
		return pecasBrancas;
	}

	public void setPecasBrancas(List<Peca> pecasBrancas) {
		this.pecasBrancas = pecasBrancas;
	}

	public List<Peca> getPecasPretas() {
		return pecasPretas;
	}

	public void setPecasPretas(List<Peca> pecasPretas) {
		this.pecasPretas = pecasPretas;
	}

	public void complementarMovimento(boolean[][] movimento) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (movimento[i][j]) {
					this.acionarMovimento[i][j] = true;
				}
			}
		}
	}

	public void complementarAmeaca(boolean[][] movimento) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (movimento[i][j]) {
					this.lugaresAmeacados[i][j] = true;
				}
			}
		}
	}

	public void verifica(Jogador jogador, Peca peca) {
		this.resetAcionarMovimento();
		if (jogador.getJogaComBranco() && this.vezDasBrancas) {
			peca.verificaDestino();
		} else if (!jogador.getJogaComBranco() && !this.vezDasBrancas) {
			peca.verificaDestino();
		}
	}

	public void move(Jogador jogador, Peca peca, Integer coluna, Integer linha) {
		if (jogador.getJogaComBranco() && this.vezDasBrancas && this.acionarMovimento[coluna][linha]) {
			this.posicoesBrancas[peca.getPosicao()[0]][peca.getPosicao()[1]] = false;
			peca.setPosicao(coluna, linha);
			this.posicoesBrancas[peca.getPosicao()[0]][peca.getPosicao()[1]] = true;

			// verifica captura

			this.pecasPretas.forEach(adversario -> {
				if (adversario.getPosicao()[0] == peca.getPosicao()[0]
						&& adversario.getPosicao()[1] == peca.getPosicao()[1]) {
					this.pecaCapturada = adversario;
				}
			});

			if (pecaCapturada != null) {
				this.pecasPretas.remove(pecaCapturada);
				this.posicoesPretas[peca.getPosicao()[0]][peca.getPosicao()[1]] = false;
				this.pecaCapturada = null;
			}

			// verifica check
			this.resetCheck();
			this.pecasBrancas.forEach(p -> {
				p.ameacaCasas();
				p.resetDirecaoProtegida();
			});
			if (this.lugaresAmeacados[reiPreto[0]][reiPreto[1]]) {
				this.check = true;
			}
			
			reiPretoPeca.pedeProtecao();

			this.vezDasBrancas = false;

		} else if (!jogador.getJogaComBranco() && !this.vezDasBrancas && this.acionarMovimento[coluna][linha]) {
			this.posicoesPretas[peca.getPosicao()[0]][peca.getPosicao()[1]] = false;
			peca.setPosicao(coluna, linha);
			this.posicoesPretas[peca.getPosicao()[0]][peca.getPosicao()[1]] = true;

			// verifica captura
			this.pecasBrancas.forEach(adversario -> {
				if (adversario.getPosicao()[0] == peca.getPosicao()[0]
						&& adversario.getPosicao()[1] == peca.getPosicao()[1]) {
					this.pecaCapturada = adversario;
				}
			});

			if (pecaCapturada != null) {
				pecasBrancas.remove(pecaCapturada);
				this.posicoesBrancas[peca.getPosicao()[0]][peca.getPosicao()[1]] = false;
				pecaCapturada = null;
			}

			// verifica check
			this.resetCheck();
			this.pecasPretas.forEach(p -> {
				p.ameacaCasas();
				p.resetDirecaoProtegida();
			});

			if (this.lugaresAmeacados[reiBranco[0]][reiBranco[1]]) {
				this.check = true;
			}
			
			reiBrancoPeca.pedeProtecao();

			this.vezDasBrancas = true;

		}

		this.resetAcionarMovimento();

	}

	private void resetCheck() {
		this.lugaresAmeacados = new boolean[8][8];
		this.resetDirecoesCheck();
		this.pecaAmeaca = null;
		this.check = false;
	}

}
