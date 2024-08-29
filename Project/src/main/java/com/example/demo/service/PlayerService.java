package com.example.demo.service;
import com.example.demo.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlayerService implements IPlayerService{
    @Autowired
    private LoadDataService DAO;

    public PlayerService(LoadDataService DAO) {
        this.DAO = DAO;
    }
    @Override
    public Player getPlayerById(String id) {
        return this.DAO.getPlayerById(id);
    }

    @Override
    public List<Player> getAllPlayers() {
        return this.DAO.getPlayers();
    }

    @Override
    public void savePlayer(Player player) {
        DAO.savePlayer(player);
    }

    @Override
    public void updatePlayer(Player player) {
        DAO.updatePlayer(player);
    }

}
