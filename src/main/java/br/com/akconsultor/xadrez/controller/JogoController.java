package br.com.akconsultor.xadrez.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.akconsultor.xadrez.dto.ChequeEMate;
import br.com.akconsultor.xadrez.dto.MovimentoDto;
import br.com.akconsultor.xadrez.dto.MovimentoVerificaDto;
import br.com.akconsultor.xadrez.repository.JogoRepository;
import br.com.akconsultor.xadrez.service.JogoService;
import br.com.akconsultor.xadrez.tabuleiro.Jogo;


@RestController
public class JogoController {
	
	@Autowired
	private JogoService service;
	
	@Autowired
	private JogoRepository repository;
	
	
	
	@GetMapping("/novoJogo")
	public ResponseEntity<Long> novoJogo(){		
		return ResponseEntity.ok(service.novoJogo());
	}
	
	@PostMapping("/verifica")
	public ResponseEntity<boolean[][]> verificaDestino(@RequestBody MovimentoVerificaDto mov){
		Jogo jogo = repository.findById(mov.getJogoId()).get();
		boolean podeMover[][] = service.verificaDestino(mov, jogo);
		return ResponseEntity.ok(podeMover);
	}
	
	@PostMapping("/move")
	public ResponseEntity<ChequeEMate> move(@RequestBody MovimentoDto mov){
		Jogo jogo = repository.findById(mov.getJogoId()).get();
		ChequeEMate bool = service.move(mov, jogo);
		repository.save(jogo);
		System.out.println("tentando mover");
		return ResponseEntity.ok(bool);
	}
	
	

}
