package com.example.demo.controller;
import com.example.demo.model.Player;
import com.example.demo.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    @PostMapping(produces = "application/json")
    public ResponseEntity<String> savePlayer(@RequestBody Player player) {
        try {
            this.DTO.savePlayer(player);
            return ResponseEntity.status(HttpStatus.CREATED).body("Player saved successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save player: " + e.getMessage());
        }
    }
    @PutMapping(produces = "application/json")
    public ResponseEntity<String> updatePlayer(@RequestBody Player player) {
        try {
            this.DTO.updatePlayer(player);
            return ResponseEntity.status(HttpStatus.OK).body("Player updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update player: " + e.getMessage());
        }
    }

}
