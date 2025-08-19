package com.felipeMovioSpring.dslist.controllers;

import com.felipeMovioSpring.dslist.DTO.GameListDTO;
import com.felipeMovioSpring.dslist.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Controlador para listas de jogos
@RestController
@RequestMapping(value = "/lists")  // End Point para listas de jogos
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }
}
