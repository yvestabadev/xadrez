package br.com.akconsultor.xadrez.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.akconsultor.xadrez.dto.MovimentoDto;
import br.com.akconsultor.xadrez.dto.MovimentoVerificaDto;
import br.com.akconsultor.xadrez.dto.TabuleiroDto;
import br.com.akconsultor.xadrez.service.JogoService;
import br.com.akconsultor.xadrez.tabuleiro.Jogo;


@RestController
@RequestMapping("{id}")
public class JogoController {
	
	@Autowired
	private JogoService service;
	
	@CacheEvict(value = "jogo")
	@GetMapping("/novoJogo")
	public ResponseEntity<Long> novoJogo(){
		service.novoJogo();
		return ResponseEntity.ok(Jogo.getId());
	}
	
	@PostMapping("/verifica")
	public ResponseEntity<boolean[][]> verificaDestino(@RequestBody MovimentoVerificaDto mov){
		boolean podeMover[][] = service.verificaDestino(mov);
		return ResponseEntity.ok(podeMover);
	}
	
	@PostMapping("/move")
	public ResponseEntity<TabuleiroDto> move(@RequestBody MovimentoDto mov){
		return ResponseEntity.ok(service.move(mov));
	}
	
	

}
