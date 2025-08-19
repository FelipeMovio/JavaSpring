package com.felipeMovioSpring.dslist.controllers;

import com.felipeMovioSpring.dslist.DTO.GameDTO;
import com.felipeMovioSpring.dslist.DTO.GameListDTO;
import com.felipeMovioSpring.dslist.DTO.GameMinDTO;
import com.felipeMovioSpring.dslist.services.GameListService;
import com.felipeMovioSpring.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Controlador para listas de jogos
@RestController
@RequestMapping(value = "/lists")  // End Point para listas de jogos
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList( @PathVariable Long listId) {
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }
}
