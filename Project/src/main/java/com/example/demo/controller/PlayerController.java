package com.example.demo.controller;
import com.example.demo.model.Player;
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

    private IPlayerService DTO;
    @Autowired
    public PlayerController(IPlayerService service) {
        this.DTO = service;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Player getPlayer(@PathVariable String id) {
        return DTO.getPlayerById(id);
    }
    @GetMapping(produces = "application/json")
    public List<Player> getAllPlayers() {
        return DTO.getAllPlayers();
    }


}
