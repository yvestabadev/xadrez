package br.com.akconsultor.xadrez.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.akconsultor.xadrez.tabuleiro.Jogo;
@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long>{

}
