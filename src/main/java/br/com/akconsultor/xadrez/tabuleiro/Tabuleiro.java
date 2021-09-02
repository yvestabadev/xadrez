package br.com.akconsultor.xadrez.tabuleiro;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Transient;

import br.com.akconsultor.xadrez.pecas.Bispo;
import br.com.akconsultor.xadrez.pecas.Cavalo;
import br.com.akconsultor.xadrez.pecas.Dama;
import br.com.akconsultor.xadrez.pecas.Peca;
import br.com.akconsultor.xadrez.pecas.Rei;
import br.com.akconsultor.xadrez.pecas.Torre;
import br.com.akconsultor.xadrez.pecas.movimentos.Direcao;
@Entity
public class Tabuleiro {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(cascade = CascadeType.ALL)
	@OrderColumn
	private Linha[] posicoesBrancas = new Linha[8];	
	@OneToMany(cascade = CascadeType.ALL)
	@OrderColumn
	private Linha[] posicoesPretas = new Linha[8];
	@OneToMany(cascade = CascadeType.ALL)
	@OrderColumn
	private Linha[] lugaresAmeacados = new Linha[8];
	
	@Transient
	private boolean[][] acionarMovimento = new boolean[8][8];
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Peca> pecasBrancas = new ArrayList<Peca>();
	@OneToMany(cascade = CascadeType.ALL)
	private List<Peca> pecasPretas = new ArrayList<Peca>();
	private Boolean vezDasBrancas = true;
	@Transient
	private Peca pecaCapturada;
	@Column(name = "cheque")
	private Boolean check = false;
	private Boolean checkmate = false;
	@ElementCollection
	@JoinTable(name = "posicao_rei_branco")
	@OrderColumn
	private Integer[] reiBranco = new Integer[2];
	@ElementCollection
	@JoinTable(name = "posicao_rei_preto")
	@OrderColumn
	private Integer[] reiPreto = new Integer[2];
	@OneToOne
	private Peca reiBrancoPeca;
	@OneToOne
	private Peca reiPretoPeca;
	
	@ElementCollection(targetClass = Direcao.class)
	@JoinTable(name = "direcoes_check", joinColumns = @JoinColumn(name = "tabuleiro_id"))
	@Enumerated(EnumType.STRING)
	private List<Direcao> direcoesCheck = new ArrayList<Direcao>();
	@OneToOne
	private Peca pecaAmeaca;

	private Boolean roquePequenoPreto = true;
	private Boolean roquePequenoBranco = true;
	private Boolean roqueGrandePreto = true;
	private Boolean roqueGrandeBranco = true;

	private Boolean atencaoRoquePequenoPreto = false;
	private Boolean atencaoRoquePequenoBranco = false;
	private Boolean atencaoRoqueGrandePreto = false;
	private Boolean atencaoRoqueGrandeBranco = false;
	
	
	public Tabuleiro() {
		
	}
	
	public Tabuleiro(int qualquerCoisa) {
		for(int i = 0; i < 8; i++) {
			this.lugaresAmeacados[i] = new Linha();
			this.posicoesBrancas[i] = new Linha();
			this.posicoesPretas[i] = new Linha();
		}
	}

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

	public boolean getLugaresAmeacados(int coluna, int linha) {
		return lugaresAmeacados[coluna].getBool(linha);
	}

	public boolean getPosicoes(Boolean ehBranca, Integer coluna, Integer linha) {
		if (ehBranca) {
			return posicoesBrancas[coluna].getBool(linha);
		} else {
			return posicoesPretas[coluna].getBool(linha);
		}
	}



	public void setPosicoesBrancas(Peca peca, Integer coluna, Integer linha) {
		this.posicoesBrancas[coluna].setBool(true, linha);
	}


	public void setPosicoesPretas(Peca peca, Integer coluna, Integer linha) {
		this.posicoesPretas[coluna].setBool(true, linha);
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
					this.lugaresAmeacados[i].setBool(true, j);
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
			this.posicoesBrancas[peca.getPosicao()[0]].setBool(false, peca.getPosicao()[1]);
			peca.setPosicao(coluna, linha);
			this.posicoesBrancas[peca.getPosicao()[0]].setBool(true, peca.getPosicao()[1]);

			if (atencaoRoqueGrandeBranco && coluna == 2 && linha == 0) {
				Peca torre = this.encontrarPeca(true, 0, 0);
				this.posicoesBrancas[0].setBool(false, 0);
				torre.setPosicao(3, 0);
				this.posicoesBrancas[3].setBool(true, 0);
			} else if (atencaoRoquePequenoBranco && coluna == 6 && linha == 0) {
				Peca torre = this.encontrarPeca(true, 0, 0);
				this.posicoesBrancas[7].setBool(false, 0);
				torre.setPosicao(5, 0);
				this.posicoesBrancas[5].setBool(true, 0);
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
				this.posicoesPretas[peca.getPosicao()[0]].setBool(false, peca.getPosicao()[1]);
				this.pecaCapturada = null;
			}

			// verifica check
			this.resetCheck();
			this.pecasBrancas.forEach(p -> {
				p.ameacaCasas();
				p.resetDirecaoProtegida();
			});
			if (this.lugaresAmeacados[reiPreto[0]].getBool(reiPreto[1])) {
				this.check = true;
			}

			Rei rei = (Rei) reiPretoPeca;
			rei.pedeProtecao();

			this.vezDasBrancas = false;

			// verifica checkmate
			this.resetAcionarMovimento();
			if (this.check) {
				Integer contador = this.pecasPretas.size();
				for (Peca p : this.pecasPretas) {

					p.verificaDestino();
					Boolean breakAll = false;
					for (int i = 0; i < 8; i++) {
						for (int j = 0; j < 8; j++) {
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
			this.posicoesPretas[peca.getPosicao()[0]].setBool(false, peca.getPosicao()[1]);
			peca.setPosicao(coluna, linha);
			this.posicoesPretas[peca.getPosicao()[0]].setBool(true, peca.getPosicao()[1]);

			if (atencaoRoqueGrandePreto && coluna == 2 && linha == 7) {
				Peca torre = this.encontrarPeca(false, 0, 7);
				this.posicoesPretas[0].setBool(false, 7);
				torre.setPosicao(3, 7);
				this.posicoesPretas[3].setBool(true, 7);
			} else if (atencaoRoquePequenoPreto && coluna == 6 && linha == 7) {
				Peca torre = this.encontrarPeca(false, 7, 7);
				this.posicoesPretas[7].setBool(false, 7);
				torre.setPosicao(5, 7);
				this.posicoesPretas[5].setBool(true, 7);
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
				this.posicoesBrancas[peca.getPosicao()[0]].setBool(false, peca.getPosicao()[1]);
				pecaCapturada = null;
			}

			// verifica check
			this.resetCheck();
			this.pecasPretas.forEach(p -> {
				p.ameacaCasas();
				p.resetDirecaoProtegida();
			});

			if (this.lugaresAmeacados[reiBranco[0]].getBool(reiBranco[1])) {
				this.check = true;
			}

			Rei rei = (Rei) reiBrancoPeca;
			rei.pedeProtecao();

			this.vezDasBrancas = true;

			// verifica checkmate
			this.resetAcionarMovimento();
			if (this.check) {
				Integer contador = this.pecasBrancas.size();
				for (Peca p : this.pecasBrancas) {
					p.verificaDestino();
					Boolean breakAll = false;
					for (int i = 0; i < 8; i++) {
						for (int j = 0; j < 8; j++) {
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
		for(int i = 0; i < 8; i++) {
			this.lugaresAmeacados[i] = new Linha();
		}
		
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
	
	public void validaMovimento(int coluna, int linha) {
		this.acionarMovimento[coluna][linha] = true;
	}

}
