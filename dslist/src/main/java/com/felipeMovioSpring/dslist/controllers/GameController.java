package com.felipeMovioSpring.dslist.controllers;


import com.felipeMovioSpring.dslist.DTO.GameDTO;
import com.felipeMovioSpring.dslist.DTO.GameMinDTO;
import com.felipeMovioSpring.dslist.entities.Game;
import com.felipeMovioSpring.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // configurando a classe como um controlador
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAll(){
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }

    // End Point para buscar um jogo pelo id
    @GetMapping(value = "/{id}")
    public GameDTO findById( @PathVariable Long id){  // O @PathVariable é usado para extrair o valor do id da URL
        GameDTO result = gameService.findById(id);
        return result;
    }
}
