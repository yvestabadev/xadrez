package br.com.akconsultor.xadrez.tabuleiro;

import java.util.ArrayList;
import java.util.List;

import br.com.akconsultor.xadrez.pecas.Bispo;
import br.com.akconsultor.xadrez.pecas.Cavalo;
import br.com.akconsultor.xadrez.pecas.Dama;
import br.com.akconsultor.xadrez.pecas.Peca;
import br.com.akconsultor.xadrez.pecas.Rei;
import br.com.akconsultor.xadrez.pecas.Torre;
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
	private Boolean checkmate = false;
	private Integer[] reiBranco = new Integer[2];
	private Integer[] reiPreto = new Integer[2];
	private Rei reiBrancoPeca;
	private Rei reiPretoPeca;
	private List<Direcao> direcoesCheck = new ArrayList<Direcao>();
	private Peca pecaAmeaca;

	private Boolean roquePequenoPreto = true;
	private Boolean roquePequenoBranco = true;
	private Boolean roqueGrandePreto = true;
	private Boolean roqueGrandeBranco = true;

	private Boolean atencaoRoquePequenoPreto = false;
	private Boolean atencaoRoquePequenoBranco = false;
	private Boolean atencaoRoqueGrandePreto = false;
	private Boolean atencaoRoqueGrandeBranco = false;

	
	public Boolean getCheckmate() {
		return checkmate;
	}
	
	public Boolean getAtencaoRoquePequenoPreto() {
		return atencaoRoquePequenoPreto;
	}

	public void setAtencaoRoquePequenoPreto(Boolean atencaoRoquePequenoPreto) {
		this.atencaoRoquePequenoPreto = atencaoRoquePequenoPreto;
	}

	public Boolean getAtencaoRoquePequenoBranco() {
		return atencaoRoquePequenoBranco;
	}

	public void setAtencaoRoquePequenoBranco(Boolean atencaoRoquePequenoBranco) {
		this.atencaoRoquePequenoBranco = atencaoRoquePequenoBranco;
	}

	public Boolean getAtencaoRoqueGrandePreto() {
		return atencaoRoqueGrandePreto;
	}

	public void setAtencaoRoqueGrandePreto(Boolean atencaoRoqueGrandePreto) {
		this.atencaoRoqueGrandePreto = atencaoRoqueGrandePreto;
	}

	public Boolean getAtencaoRoqueGrandeBranco() {
		return atencaoRoqueGrandeBranco;
	}

	public void setAtencaoRoqueGrandeBranco(Boolean atencaoRoqueGrandeBranco) {
		this.atencaoRoqueGrandeBranco = atencaoRoqueGrandeBranco;
	}

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
		if (ehBranca) {
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
		atencaoRoqueGrandeBranco = false;
		atencaoRoqueGrandePreto = false;
		atencaoRoquePequenoBranco = false;
		atencaoRoquePequenoPreto = false;
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

			if (atencaoRoqueGrandeBranco && coluna == 2 && linha == 0) {
				Peca torre = this.encontrarPeca(true, 0, 0);
				this.posicoesBrancas[0][0] = false;
				torre.setPosicao(3, 0);
				this.posicoesBrancas[3][0] = true;
			} else if (atencaoRoquePequenoBranco && coluna == 6 && linha == 0) {
				Peca torre = this.encontrarPeca(true, 0, 0);
				this.posicoesBrancas[7][0] = false;
				torre.setPosicao(5, 0);
				this.posicoesBrancas[5][0] = true;
			}

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

			// verifica checkmate
			if (this.check) {
				Integer contador = this.pecasPretas.size();
				for (Peca p : this.pecasPretas) {

					p.verificaDestino();
					Boolean breakAll = false;
					for (int i = 0; i < 8; i++) {
						for (int j = 0; j < 8; i++) {
							if (this.acionarMovimento[i][j]) {
								breakAll = true;
								break;
							}
						}
						if (breakAll) {
							break;
						}
					}
					if (breakAll) {
						break;
					}
					contador--;
					if (contador == 0) {
						this.checkmate = true;
					}
				}
			}

		} else if (!jogador.getJogaComBranco() && !this.vezDasBrancas && this.acionarMovimento[coluna][linha]) {
			this.posicoesPretas[peca.getPosicao()[0]][peca.getPosicao()[1]] = false;
			peca.setPosicao(coluna, linha);
			this.posicoesPretas[peca.getPosicao()[0]][peca.getPosicao()[1]] = true;

			if (atencaoRoqueGrandePreto && coluna == 2 && linha == 7) {
				Peca torre = this.encontrarPeca(false, 0, 7);
				this.posicoesPretas[0][7] = false;
				torre.setPosicao(3, 7);
				this.posicoesPretas[3][7] = true;
			} else if (atencaoRoquePequenoPreto && coluna == 6 && linha == 7) {
				Peca torre = this.encontrarPeca(false, 7, 7);
				this.posicoesPretas[7][7] = false;
				torre.setPosicao(5, 7);
				this.posicoesPretas[5][7] = true;
			}

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

			// verifica checkmate
			if (this.check) {
				Integer contador = this.pecasBrancas.size();
				for (Peca p : this.pecasBrancas) {

					p.verificaDestino();
					Boolean breakAll = false;
					for (int i = 0; i < 8; i++) {
						for (int j = 0; j < 8; i++) {
							if (this.acionarMovimento[i][j]) {
								breakAll = true;
								break;
							}
						}
						if (breakAll) {
							break;
						}
					}
					if (breakAll) {
						break;
					}
					contador--;
					if (contador == 0) {
						this.checkmate = true;
					}
				}

			}
		}

		this.resetAcionarMovimento();

	}

	private void resetCheck() {
		this.lugaresAmeacados = new boolean[8][8];
		this.resetDirecoesCheck();
		this.pecaAmeaca = null;
		this.check = false;
	}

	public Peca encontrarPeca(Boolean ehBranca, Integer coluna, Integer linha) {
		List<Peca> pecas;
		if (ehBranca) {
			pecas = this.pecasBrancas;
		} else {
			pecas = this.pecasPretas;
		}

		for (Peca p : pecas) {
			if (p.getPosicao()[0] == coluna && p.getPosicao()[1] == linha) {
				return p;
			}
		}

		return null;

	}

	public boolean getRoqueGrande(Boolean ehBranca) {
		if (ehBranca) {
			return this.roqueGrandeBranco;
		} else {
			return this.roqueGrandePreto;
		}
	}

	public boolean getRoquePequeno(Boolean ehBranca) {
		if (ehBranca) {
			return this.roquePequenoBranco;
		} else {
			return this.roquePequenoPreto;
		}
	}

	public void invalidaRoqueGrande(Boolean ehBranca) {
		if (ehBranca) {
			this.roqueGrandeBranco = false;
		} else {
			this.roqueGrandePreto = false;
		}
	}

	public void invalidaRoquePequeno(Boolean ehBranca) {
		if (ehBranca) {
			this.roquePequenoBranco = false;
		} else {
			this.roquePequenoPreto = false;
		}
	}

	public void promovePeao(Peca peca, Class<? extends Peca> p) {
		Integer[] posicaoPeca = peca.getPosicao();
		Peca novaPeca;
		if (peca.getEhBranca()) {
			this.pecasBrancas.remove(peca);
			if (p == Dama.class) {
				novaPeca = new Dama(true, posicaoPeca[0], posicaoPeca[1], this);
				this.getPecasBrancas().add(novaPeca);
			} else if (p == Cavalo.class) {
				novaPeca = new Cavalo(true, posicaoPeca[0], posicaoPeca[1], this);
				this.getPecasBrancas().add(novaPeca);
			} else if (p == Torre.class) {
				novaPeca = new Torre(true, posicaoPeca[0], posicaoPeca[1], this);
				this.getPecasBrancas().add(novaPeca);
			} else {
				novaPeca = new Bispo(true, posicaoPeca[0], posicaoPeca[1], this);
				this.getPecasBrancas().add(novaPeca);
			}
		} else {
			this.pecasPretas.remove(peca);
			if (p == Dama.class) {
				novaPeca = new Dama(false, posicaoPeca[0], posicaoPeca[1], this);
				this.getPecasPretas().add(novaPeca);
			} else if (p == Cavalo.class) {
				novaPeca = new Cavalo(false, posicaoPeca[0], posicaoPeca[1], this);
				this.getPecasPretas().add(novaPeca);
			} else if (p == Torre.class) {
				novaPeca = new Torre(false, posicaoPeca[0], posicaoPeca[1], this);
				this.getPecasPretas().add(novaPeca);
			} else {
				novaPeca = new Bispo(false, posicaoPeca[0], posicaoPeca[1], this);
				this.getPecasPretas().add(novaPeca);
			}
		}

	}

}
