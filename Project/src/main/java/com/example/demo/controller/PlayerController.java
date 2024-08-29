package com.example.demo.controller;
import com.example.demo.model.Player;
import com.example.demo.service.IPlayerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
@RestController
@RequestMapping("players")
public class PlayerController {

    private IPlayerService DTO;
    @Autowired
    public PlayerController(IPlayerService service) {
        DTO = service;
    }

    @GetMapping(value = "/{id}")
    public Player getPlayer(@PathVariable String id) {
        return DTO.getPlayerById(id);
    }
    @GetMapping
    public List<Player> getAllPlayers() {
        return DTO.getAllPlayers();
    }
    @PostMapping
    public ResponseEntity<String> savePlayer(@Valid @RequestBody Player player) {
        try {
            DTO.savePlayer(player);
            return ResponseEntity.status(HttpStatus.CREATED).body("Player saved successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save player: " + e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity<String> updatePlayer(@Valid @RequestBody Player player) {
        try {
            DTO.updatePlayer(player);
            return ResponseEntity.status(HttpStatus.OK).body("Player updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update player: " + e.getMessage());
        }
    }

}
