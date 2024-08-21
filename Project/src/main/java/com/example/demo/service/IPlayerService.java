package com.example.demo.service;
import com.example.demo.model.Player;
import java.util.List;

public interface IPlayerService {
    Player getPlayerById(String id);
    List<Player> getAllPlayers();
    void savePlayer(Player player);
    void updatePlayer(Player player);

}
