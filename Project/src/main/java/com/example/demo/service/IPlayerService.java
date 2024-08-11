package com.example.demo.service;

import java.util.List;

public interface IPlayerService {
    String[] getPlayer(String id);

    List<String[]> getAllPlayers();

}
