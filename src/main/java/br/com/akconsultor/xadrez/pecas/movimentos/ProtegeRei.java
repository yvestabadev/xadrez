package br.com.akconsultor.xadrez.pecas.movimentos;

import java.util.ArrayList;
import java.util.List;

import br.com.akconsultor.xadrez.pecas.Peca;
import br.com.akconsultor.xadrez.tabuleiro.Tabuleiro;

public interface ProtegeRei {

	public default boolean[][] corrigeDestino(boolean[][] destino, Peca peca, Tabuleiro tabuleiro) {
		boolean[][] resolveCheck = resolveCheck(peca, tabuleiro);
		boolean[][] retorno = new boolean[8][8];

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (destino[i][j] && resolveCheck[i][j]) {
					retorno[i][j] = true;
				}
			}
		}

		return retorno;
	}

	public default boolean[][] naoSaiDoRei(boolean[][] destino, Peca peca, Tabuleiro tabuleiro) {
		boolean[][] ficaNaFrente = naFrenteDoRei(peca, tabuleiro);
		boolean[][] retorno = new boolean[8][8];
		if (ficaNaFrente != null) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (destino[i][j] && ficaNaFrente[i][j]) {
						retorno[i][j] = true;
					}
				}
			}
			return retorno;
		}

		return null;
	}

	private boolean[][] resolveCheck(Peca peca, Tabuleiro tabuleiro) {
		boolean[][] podeMover = new boolean[8][8];
		Integer[] rei;
		Integer[] pecaAmeaca = tabuleiro.getPecaAmeaca().getPosicao();
		List<Direcao> direcoes = tabuleiro.getDirecoesCheck();

		if (peca.getEhBranca()) {
			rei = tabuleiro.getReiBranco();
		} else {
			rei = tabuleiro.getReiPreto();
		}

		if (tabuleiro.getDirecoesCheck().size() == 1) {

			Direcao direcao = direcoes.get(0);
			if (direcao == Direcao.NE) {
				for (int i = rei[0] - 1; i >= 0; i--) {
					int j = rei[1] + (i - rei[0]);
			
						podeMover[i][j] = true;
		
					if (i == pecaAmeaca[0] && j == pecaAmeaca[1]) {
						break;
					}

				}
			} else if (direcao == Direcao.NW) {
				for (int i = rei[0] + 1; i < 8; i++) {
					int j = rei[1] - (i - rei[0]);

						podeMover[i][j] = true;
				
					if (i == pecaAmeaca[0] && j == pecaAmeaca[1]) {
						break;
					}

				}

			} else if (direcao == Direcao.SE) {
				for (int i = rei[0] - 1; i >= 0; i--) {
					int j = rei[1] - (i - rei[0]);
						podeMover[i][j] = true;
				
					if (i == pecaAmeaca[0] && j == pecaAmeaca[1]) {
						break;
					}

				}

			} else if (direcao == Direcao.SW) {
				/*quando o metodo e acionado pelo controller precisa de try, catch, o que e errado
				O metodo nao esta caindo no break, mas mesmo com exception o atributo
				pecaAmeaca aparece corretamente no banco de dados*/
				
				for (int i = rei[0] + 1; i < 8; i++) {
					int j = rei[1] + (i - rei[0]);
					System.out.println("o laco esta percorrendo em " + i + " - " + j);
						if(j == 8) {
							System.out.println("a peca que ta bugando esta na posicao " + peca.getPosicao()[0] + " " + peca.getPosicao()[1] + peca + " " + peca.getEhBranca());
						}
						podeMover[i][j] = true;

					if (i == pecaAmeaca[0] && j == pecaAmeaca[1]) {
						System.out.println(i + " entrou no break " + j);
						return podeMover;
					}

				}

			} else if (direcao == Direcao.TRAS) {
				for (int i = rei[1] + 1; i < 8; i++) {
					int coluna = rei[0];
					podeMover[coluna][i] = true;
					if (i == pecaAmeaca[1]) {
						break;
					}
				}

			} else if (direcao == Direcao.FRENTE) {
				for (int i = rei[1] - 1; i >= 0; i--) {
					int coluna = rei[0];
					podeMover[coluna][i] = true;
					if (i == pecaAmeaca[1]) {
						break;
					}
				}

			} else if (direcao == Direcao.ESQUERDA) {
				for (int i = rei[0] + 1; i < 8; i++) {
					int linha = rei[1];
					podeMover[i][linha] = true;
					if (i == pecaAmeaca[0]) {
						break;
					}
				}

			} else if (direcao == Direcao.DIREITA) {
				for (int i = rei[0] - 1; i >= 0; i--) {
					int linha = rei[1];
					podeMover[i][linha] = true;
					if (i == pecaAmeaca[0]) {
						break;
					}
				}

			}

			podeMover[pecaAmeaca[0]][pecaAmeaca[1]] = true;
		}
		return podeMover;
	}

	private boolean[][] naFrenteDoRei(Peca peca, Tabuleiro tabuleiro) {
		boolean[][] podeMover = new boolean[8][8];
		Direcao direcaoProtegida = peca.getDirecaoProtegida();
		Integer coluna;
		Integer linha;
		/*
		 * posicoes que a peca que fica na frente do rei pode andar se a regra dela
		 * permitir
		 */
		List<Integer[]> posicoes = new ArrayList<Integer[]>();
		Peca pecaAdversaria;
		/* esse contador verifica se realmente precisa proteger a direcao */
		int cont = 0;

		if (peca.getEhBranca()) {
			coluna = tabuleiro.getReiBranco()[0];
			linha = tabuleiro.getReiBranco()[1];
		} else {
			coluna = tabuleiro.getReiPreto()[0];
			linha = tabuleiro.getReiPreto()[1];
		}

		if (direcaoProtegida != null) {
			/*
			 * ve a posicao da peca em relacao ao rei da sua cor e nao deixa sair da frente
			 * para que o rei nao fique em cheque
			 */
			if (direcaoProtegida == Direcao.FRENTE) {
				for (int i = linha + 1; i < 8; i++) {
					if (cont == 2) {
						return null;
					}
					posicoes.add(new Integer[] { coluna, i });
					if (tabuleiro.getPosicoes(peca.getEhBranca(), coluna, i)) {
						cont++;
					} else if (tabuleiro.getPosicoes(!peca.getEhBranca(), coluna, i)) {
						pecaAdversaria = this.adicionarAdversario(!peca.getEhBranca(), coluna, i, Direcao.LADOS,
								tabuleiro);
						if (pecaAdversaria == null) {
							return null;
						} else {
							for (Integer[] posicao : posicoes) {
								podeMover[posicao[0]][posicao[1]] = true;
							}

							return podeMover;
						}
					}
				}
				return null;
			}

			if (direcaoProtegida == Direcao.TRAS) {
				for (int i = linha - 1; i >= 0; i--) {
					if (cont == 2) {
						return null;
					}
					posicoes.add(new Integer[] { coluna, i });
					if (tabuleiro.getPosicoes(peca.getEhBranca(), coluna, i)) {
						cont++;
					} else if (tabuleiro.getPosicoes(!peca.getEhBranca(), coluna, i)) {
						pecaAdversaria = this.adicionarAdversario(!peca.getEhBranca(), coluna, i, Direcao.LADOS,
								tabuleiro);
						if (pecaAdversaria == null) {
							return null;
						} else {
							for (Integer[] posicao : posicoes) {
								podeMover[posicao[0]][posicao[1]] = true;
							}

							return podeMover;
						}
					}
				}
				return null;
			}

			if (direcaoProtegida == Direcao.DIREITA) {
				for (int i = coluna + 1; i < 8; i++) {
					if (cont == 2) {
						return null;
					}
					posicoes.add(new Integer[] { i, linha });
					if (tabuleiro.getPosicoes(peca.getEhBranca(), i, linha)) {
						cont++;
					} else if (tabuleiro.getPosicoes(!peca.getEhBranca(), i, linha)) {
						pecaAdversaria = this.adicionarAdversario(!peca.getEhBranca(), i, linha, Direcao.LADOS,
								tabuleiro);
						if (pecaAdversaria == null) {
							return null;
						} else {
							for (Integer[] posicao : posicoes) {
								podeMover[posicao[0]][posicao[1]] = true;
							}

							return podeMover;
						}
					}
				}
				return null;
			}

			if (direcaoProtegida == Direcao.ESQUERDA) {
				for (int i = coluna - 1; i >= 0; i--) {
					if (cont == 2) {
						return null;
					}
					posicoes.add(new Integer[] { i, linha });
					if (tabuleiro.getPosicoes(peca.getEhBranca(), i, linha)) {
						cont++;
					} else if (tabuleiro.getPosicoes(!peca.getEhBranca(), i, linha)) {
						pecaAdversaria = this.adicionarAdversario(!peca.getEhBranca(), i, linha, Direcao.LADOS,
								tabuleiro);
						if (pecaAdversaria == null) {
							return null;
						} else {
							for (Integer[] posicao : posicoes) {
								podeMover[posicao[0]][posicao[1]] = true;
							}

							return podeMover;
						}
					}
				}
				return null;
			}

			if (direcaoProtegida == Direcao.NE) {
				try {
					for (int i = coluna + 1; i < 8; i++) {
						int j = linha + (i - coluna);
						if (cont == 2) {
							return null;
						}
						posicoes.add(new Integer[] { i, j });
						if (tabuleiro.getPosicoes(peca.getEhBranca(), i, j)) {
							cont++;
						} else if (tabuleiro.getPosicoes(!peca.getEhBranca(), i, j)) {
							pecaAdversaria = this.adicionarAdversario(!peca.getEhBranca(), i, j, Direcao.DIAGONAL,
									tabuleiro);
							if (pecaAdversaria == null) {
								return null;
							} else {
								for (Integer[] posicao : posicoes) {
									podeMover[posicao[0]][posicao[1]] = true;
								}

								return podeMover;
							}
						}
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					return null;
				}
				return null;
			}

			if (direcaoProtegida == Direcao.SW) {
				try {
					for (int i = coluna - 1; i >= 0; i--) {
						int j = linha + (i - coluna);
						if (cont == 2) {
							return null;
						}
						posicoes.add(new Integer[] { i, j });
						if (tabuleiro.getPosicoes(peca.getEhBranca(), i, j)) {
							cont++;
						} else if (tabuleiro.getPosicoes(!peca.getEhBranca(), i, j)) {
							pecaAdversaria = this.adicionarAdversario(!peca.getEhBranca(), i, j, Direcao.DIAGONAL,
									tabuleiro);
							if (pecaAdversaria == null) {
								return null;
							} else {
								for (Integer[] posicao : posicoes) {
									podeMover[posicao[0]][posicao[1]] = true;
								}

								return podeMover;
							}
						}
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					return null;
				}
				return null;
			}

			if (direcaoProtegida == Direcao.NW) {
				try {
					for (int i = coluna - 1; i >= 0; i--) {
						int j = linha - (i - coluna);
						if (cont == 2) {
							return null;
						}
						posicoes.add(new Integer[] { i, j });
						if (tabuleiro.getPosicoes(peca.getEhBranca(), i, j)) {
							cont++;
						} else if (tabuleiro.getPosicoes(!peca.getEhBranca(), i, j)) {
							pecaAdversaria = this.adicionarAdversario(!peca.getEhBranca(), i, j, Direcao.DIAGONAL,
									tabuleiro);
							if (pecaAdversaria == null) {
								return null;
							} else {
								for (Integer[] posicao : posicoes) {
									podeMover[posicao[0]][posicao[1]] = true;
								}

								return podeMover;
							}
						}
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					return null;
				}
				return null;
			}

			if (direcaoProtegida == Direcao.SE) {
				try {
					for (int i = coluna + 1; i < 8; i++) {
						int j = linha - (i - coluna);
						if (cont == 2) {
							return null;
						}
						posicoes.add(new Integer[] { i, j });
						if (tabuleiro.getPosicoes(peca.getEhBranca(), i, j)) {
							cont++;
						} else if (tabuleiro.getPosicoes(!peca.getEhBranca(), i, j)) {
							pecaAdversaria = this.adicionarAdversario(!peca.getEhBranca(), i, j, Direcao.DIAGONAL,
									tabuleiro);
							if (pecaAdversaria == null) {
								return null;
							} else {
								for (Integer[] posicao : posicoes) {
									podeMover[posicao[0]][posicao[1]] = true;
								}

								return podeMover;
							}
						}
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					return null;
				}
				return null;
			}
		}

		return null;
	}

	private Peca adicionarAdversario(Boolean ehBranca, Integer coluna, Integer linha, Direcao direcao,
			Tabuleiro tabuleiro) {
		Peca peca = tabuleiro.encontrarPeca(ehBranca, coluna, linha);
		List<Direcao> direcoes = peca.getDirecoes();
		for (Direcao d : direcoes) {
			if (d == direcao) {
				return peca;
			}
		}

		return null;
	}

}
