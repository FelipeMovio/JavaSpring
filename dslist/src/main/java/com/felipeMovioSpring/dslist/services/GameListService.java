package com.felipeMovioSpring.dslist.services;

import com.felipeMovioSpring.dslist.DTO.GameDTO;
import com.felipeMovioSpring.dslist.DTO.GameListDTO;
import com.felipeMovioSpring.dslist.DTO.GameMinDTO;
import com.felipeMovioSpring.dslist.entities.Game;
import com.felipeMovioSpring.dslist.entities.GameList;
import com.felipeMovioSpring.dslist.projections.GameMinProjection;
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

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();

    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId); // buscando alista na memoria.
        GameMinProjection obj = list.remove(sourceIndex); // removendo o objeto da lista na posição souceIndex.
        list.add(destinationIndex, obj); // adicionando o objeto removido na posição destineyionIndex.

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex; // definindo o menor índice
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex; // definindo o maior índice

        for ( int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }


}
