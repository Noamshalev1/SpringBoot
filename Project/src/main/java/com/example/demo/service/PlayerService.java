package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService implements IPlayerService{
    private Player DTOPlayer;
    @Autowired
    public PlayerService(Player DTOPlayer) {
        this.DTOPlayer = DTOPlayer;
    }
    @Override
    public String[] getPlayer(String id) {
        return this.DTOPlayer.getPlayer(id);
    }

    @Override
    public List<String[]> getAllPlayers() {
        return this.DTOPlayer.getPlayers();
    }

}
