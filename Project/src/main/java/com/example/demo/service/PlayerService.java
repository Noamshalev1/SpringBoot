package com.example.demo.service;
import com.example.demo.model.Player;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlayerService implements IPlayerService{
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

}
