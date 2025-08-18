package com.felipeMovioSpring.dslist.DTO;


import com.felipeMovioSpring.dslist.entities.Game;

public class GameMinDTO {

    private Long id; // id
    private String title; // titulo
    private Integer year; // ano
    private String imgUrl;
    private String shortDescription; // pequena descrição

    public GameMinDTO(){

    }

    public GameMinDTO(Game entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.year = entity.getYear();
        this.imgUrl = entity.getImgUrl();
        this.shortDescription = entity.getShortDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
