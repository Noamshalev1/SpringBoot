package com.example.demo.service;

import com.example.demo.exception.PlayerNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collection;

@Component
public class Player {
    private Map<String, String[]> playerMap = new HashMap<>();;

    @PostConstruct
    public void loadPlayersData() {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\PC\\Documents\\GitHub\\SpringBoot\\Project\\src\\main\\resources\\player.csv"))) {
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
        Collection<String[]> values = playerMap.values();
        if (values.isEmpty()){
            throw new PlayerNotFoundException("No players");
        }
        else{
            return new ArrayList<>(values);
        }
    }

    public String[] getPlayer(String id) {
        if (playerMap.get(id) == null){
            throw new PlayerNotFoundException("Id " + id + " is invalid");
        }
        else{
            return playerMap.get(id);
        }

    }
}
