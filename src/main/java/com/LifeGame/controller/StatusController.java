package com.LifeGame.controller;

import com.LifeGame.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Observer;

@Component
public class StatusController {

    private final Model model;

    @Autowired
    public StatusController(Model model) {
        this.model = model;
    }

    public void addObserver(Observer o) {
        this.model.addObserver(o);
    }

}
