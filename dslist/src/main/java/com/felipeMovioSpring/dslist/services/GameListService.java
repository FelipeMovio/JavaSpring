package com.felipeMovioSpring.dslist.services;

import com.felipeMovioSpring.dslist.DTO.GameDTO;
import com.felipeMovioSpring.dslist.DTO.GameListDTO;
import com.felipeMovioSpring.dslist.DTO.GameMinDTO;
import com.felipeMovioSpring.dslist.entities.Game;
import com.felipeMovioSpring.dslist.entities.GameList;
import com.felipeMovioSpring.dslist.repositories.GameListRepository;
import com.felipeMovioSpring.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    
    @Autowired  // O @Autowired é usado para injetar a dependência do GameRepository no Game
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();

    }


}
