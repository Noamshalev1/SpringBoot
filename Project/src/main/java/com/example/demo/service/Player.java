package com.example.demo.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Player {
    private Map<String, String[]> playerMap = new HashMap<>();

    @PostConstruct
    public void loadPlayersData() {
        try (BufferedReader br = new BufferedReader(new FileReader("player.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] playerData = line.split(",");
                String playerId = playerData[0]; // Assuming the first column is the player ID
                playerMap.put(playerId, playerData);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String[]> getPlayers() {
        return (List<String[]>) playerMap.values();
    }

    public String[] getPlayer(String id) {
        return playerMap.get(id);

    }
}
