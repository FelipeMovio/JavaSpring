package com.felipeMovioSpring.dslist.services;

import com.felipeMovioSpring.dslist.DTO.GameDTO;
import com.felipeMovioSpring.dslist.DTO.GameMinDTO;
import com.felipeMovioSpring.dslist.entities.Game;
import com.felipeMovioSpring.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired // Injetando o GameRepository para acessar os métodos de busca no banco de dados
    // O @Autowired é usado para injetar a dependência do GameRepository no Game
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){ // Busca um jogo pelo id no banco de dados
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }


    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){ // Busca todos os jogos no banco de dados
        // Converte a lista de Game para uma lista de GameMinDTO
        // Usando o método map para transformar cada Game em GameMinDTO
        // E depois coletando os resultados em uma lista
        // O método toList() é usado para coletar os resultados em uma lista
      List<Game> result = gameRepository.findAll();
      List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }
}
