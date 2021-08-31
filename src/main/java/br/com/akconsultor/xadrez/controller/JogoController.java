package br.com.akconsultor.xadrez.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.akconsultor.xadrez.dto.MovimentoDto;
import br.com.akconsultor.xadrez.dto.MovimentoVerificaDto;
import br.com.akconsultor.xadrez.dto.TabuleiroDto;
import br.com.akconsultor.xadrez.service.JogoService;
import br.com.akconsultor.xadrez.tabuleiro.Jogo;


@RestController
public class JogoController {
	
	@Autowired
	private JogoService service;
	

	public Jogo jogar() {
		Jogo jogo = new Jogo("jogador1", "jogador2");
		System.out.println(jogo);
		return jogo;
	}
	
	
	@GetMapping("/novoJogo")
	public ResponseEntity<Long> novoJogo(){
		Jogo jogo = this.jogar();
		return ResponseEntity.ok(jogo.getId());
	}
	
	@PostMapping("/verifica")
	public ResponseEntity<boolean[][]> verificaDestino(@RequestBody MovimentoVerificaDto mov){
		Jogo jogo = this.jogar();
		boolean podeMover[][] = service.verificaDestino(mov, jogo);
		return ResponseEntity.ok(podeMover);
	}
	
	@PostMapping("/move")
	public ResponseEntity<TabuleiroDto> move(@RequestBody MovimentoDto mov){
		Jogo jogo = this.jogar();
		TabuleiroDto dto = service.move(mov, jogo);
		return ResponseEntity.ok(dto);
	}
	
	

}
