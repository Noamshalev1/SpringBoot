package com.example.demo.service;
import com.example.demo.exception.DuplicatePlayerException;
import com.example.demo.exception.PlayerNotFoundException;
import com.example.demo.model.DeadPlayer;
import com.example.demo.model.Player;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@Service
public class LoadDataService {
    private Map<String, Player> playerMap;
    private static final Logger log = LoggerFactory.getLogger(LoadDataService.class);

    @PostConstruct
    public void loadPlayersData() {
        playerMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\PC\\Documents\\GitHub\\SpringBoot\\Project\\src\\main\\resources\\player.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] playerData = line.split(",");
                if (playerData.length < 24) {
                    System.out.println("Skipping invalid line: " + line);
                    continue; // Skip this line
                }

                String playerId = playerData[0]; // Assuming the first column is the player ID
                int year, month, day;
                // Create a LocalDate object
                LocalDate birthDate;
                try{
                    year = Integer.parseInt(playerData[1]);
                    month = Integer.parseInt(playerData[2]);
                    day = Integer.parseInt(playerData[3]);
                    birthDate = LocalDate.of(year, month, day);
                }catch (Exception e){
                    log.info(e.getMessage());
                    continue; // Skip this player
                }
                String birthCountry = playerData[4];
                String birthState = playerData[5];
                String birthCity = playerData[6];
                String nameFirst = playerData[13];
                String nameLast = playerData[14];
                String nameGiven = playerData[15];
                int weight = !playerData[16].isEmpty() ? Integer.parseInt(playerData[16]): 0;
                int height = !playerData[17].isEmpty() ? Integer.parseInt(playerData[17]): 0;
                String bats = playerData[18];
                String _throws = playerData[19];
                // for debut and finalGame there are two kinds of date
                String debut = playerData[20];
                String finalGame = playerData[21];
                String retroID = playerData[22];
                String bbrefID = playerData[23];
                // Create the player depends on "deathDate" column
                Player p;
                if(!playerData[7].isEmpty()){
                    try {
                        year = Integer.parseInt(playerData[7].trim());
                        month = Integer.parseInt(playerData[8].trim());
                        day = Integer.parseInt(playerData[9].trim());
                        LocalDate deathDate = LocalDate.of(year, month, day);
                        String deathCountry = playerData[10];
                        String deathState = playerData[11];
                        String deathCity = playerData[12];
                        p = new DeadPlayer(playerId, birthDate, birthCountry, birthState, birthCity, nameFirst, nameLast,
                                nameGiven, weight, height, bats, _throws, debut, finalGame, retroID, bbrefID,
                                deathDate, deathCountry, deathState, deathCity);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid date format in death date fields: " + e.getMessage());
                        continue;  // Skip to the next line in the file
                    }
                }
                else {
                    p = new Player(playerId, birthDate, birthCountry, birthState, birthCity, nameFirst, nameLast,
                            nameGiven, weight, height, bats, _throws, debut, finalGame, retroID, bbrefID);
                }
                playerMap.put(playerId, p);
            }
        } catch (IOException e) {
            log.info(e.getMessage());
        }
    }

    public List<Player> getPlayers() {
        Collection<Player> values = playerMap.values();
        if (values.isEmpty()){
            throw new PlayerNotFoundException("No players");
        }
        else{
            return new ArrayList<>(values);
        }
    }

    public Player getPlayerById(String id){
        if (playerMap.get(id) == null){
            throw new PlayerNotFoundException("Player with id: " + id +" doesn't exist");
        }
        else{
            return playerMap.get(id);
        }
    }

    /**
     * Now we can  only save a not-dead player
     * @param player (send as JSON format and cast to a player)
     */
    public void savePlayer(Player player){
        if (player == null){
            throw new PlayerNotFoundException("Player object is empty");
        }
        else{
            if (playerMap.get(player.getPlayerID()) == null){
                playerMap.put(player.getPlayerID(), player);
            }
            else{
                throw new DuplicatePlayerException("Player with id: " + player.getPlayerID() + " is already exist ");
            }
        }
    }

    /**
     * Now we can only update a not-dead player
     * @param player (send as JSON format and cast to a player)
     */
    public void updatePlayer(Player player){
        if (player == null){
            throw new PlayerNotFoundException("Player object is empty");
        }
        else{
            if (playerMap.get(player.getPlayerID()) == null){
                throw new PlayerNotFoundException("Player with id: " + player.getPlayerID() + " doesn't exist");
            }
            else{
                playerMap.put(player.getPlayerID(), player);
            }
        }
    }
}

