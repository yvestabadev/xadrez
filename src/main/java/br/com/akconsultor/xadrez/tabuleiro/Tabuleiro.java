package br.com.akconsultor.xadrez.tabuleiro;

import java.util.ArrayList;
import java.util.List;

import br.com.akconsultor.xadrez.pecas.Peca;

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
	private Integer[] reiBranco;
	private Integer[] reiPreto;
	
	
	

	public void setReiBranco(Integer coluna, Integer linha) {
		this.reiBranco[0] = coluna;
		this.reiBranco[1] = linha;
	}

	public void setReiPreto(Integer coluna, Integer linha) {
		this.reiPreto[0] = coluna;
		this.reiPreto[1] = linha;
	}

	public Boolean getCheck() {
		return check;
	}

	public boolean[][] getLugaresAmeacados() {
		return lugaresAmeacados;
	}

	public boolean getPosicoesBrancas(Integer coluna, Integer linha) {
		return posicoesBrancas[coluna][linha];
	}

	public void setPosicoesBrancas(Peca peca, Integer coluna, Integer linha) {
		this.posicoesBrancas[coluna][linha] = true;
	}

	public boolean getPosicoesPretas(Integer coluna, Integer linha) {
		return posicoesPretas[coluna][linha];
	}

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
		if (jogador.getJogaComBranco() && this.vezDasBrancas) {
			peca.verificaDestino();
		} else if (!jogador.getJogaComBranco() && !this.vezDasBrancas) {
			peca.verificaDestino();
		}
	}

	public void move(Jogador jogador, Peca peca, Integer coluna, Integer linha) {
		if (jogador.getJogaComBranco() && this.vezDasBrancas
				&& this.acionarMovimento[coluna][linha]) {
			this.posicoesBrancas[peca.getPosicao()[0]][peca.getPosicao()[1]] = false;
			peca.setPosicao(coluna, linha);
			this.posicoesBrancas[peca.getPosicao()[0]][peca.getPosicao()[1]] = true;
			
			
			//verifica captura
			
			this.pecasPretas.forEach(adversario -> {
				if(adversario.getPosicao()[0] == peca.getPosicao()[0]
						&& adversario.getPosicao()[1] == peca.getPosicao()[1]) {
					this.pecaCapturada = adversario;
				}
			});
			
			if(pecaCapturada != null) {
				this.pecasPretas.remove(pecaCapturada);
				this.posicoesPretas[peca.getPosicao()[0]][peca.getPosicao()[1]] = false;
				this.pecaCapturada = null;
			}
			
			
			//verifica check
			this.pecasBrancas.forEach(p -> p.ameacaCasas());			
			;
			
			this.vezDasBrancas = false;
			
		} else if (!jogador.getJogaComBranco() && !this.vezDasBrancas
				&& this.acionarMovimento[coluna][linha]) {
			this.posicoesPretas[peca.getPosicao()[0]][peca.getPosicao()[1]] = false;
			peca.setPosicao(coluna, linha);
			this.posicoesPretas[peca.getPosicao()[0]][peca.getPosicao()[1]] = true;
			
			
			//verifica captura
			this.pecasBrancas.forEach(adversario -> {
				if(adversario.getPosicao()[0] == peca.getPosicao()[0]
						&& adversario.getPosicao()[1] == peca.getPosicao()[1]) {
					this.pecaCapturada = adversario;
				}
			});
			
			if(pecaCapturada != null) {
				pecasBrancas.remove(pecaCapturada);
				this.posicoesBrancas[peca.getPosicao()[0]][peca.getPosicao()[1]] = false;
				pecaCapturada = null;
			}
			
			
			//verifica check
			this.pecasPretas.forEach(p -> p.ameacaCasas());
			
			this.vezDasBrancas = true;
			
		}
		
		this.resetAcionarMovimento();
	}

}
