package com.example.demo.controller;

import com.example.demo.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("players")
public class PlayerController {

    private IPlayerService service;
    @Autowired
    public PlayerController(IPlayerService service) {
        this.service = service;
    }
    @GetMapping(value = "/{id}", produces = "application/json")
    public String[] getPlayer(@PathVariable String id) {
        return service.getPlayer(id);
    }
    @GetMapping(produces = "application/json")
    public List<String[]> getAllPlayers() {
        return service.getAllPlayers();
    }

}
