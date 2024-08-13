package com.example.demo.model;
import java.time.LocalDate;

/**
 * A death player which add more fileds
 */
public class DeadPlayer extends Player{

    private LocalDate deathDate;
    private String deathCountry;
    private String deathState;
    private String deathCity;

    public DeadPlayer(String playerID, LocalDate birthDate, String birthCountry, String birthState,
                      String birthCity, String nameFirst, String nameLast, String nameGiven, int weight,
                      int height, String bats, String _throws, String debut, String finalGame,
                      String retroID, String bbrefID, LocalDate deathDate, String deathCountry, String deathState, String deathCity)
    {
        super(playerID, birthDate, birthCountry, birthState, birthCity, nameFirst,nameLast, nameGiven,
                weight, height, bats, _throws,debut, finalGame, retroID, bbrefID);
        this.deathDate = deathDate;
        this.deathCountry = deathCountry;
        this.deathState = deathState;
        this.deathCity = deathCity;

    }

    @Override
    public boolean isDead(){
        return true;
    }

    public LocalDate getDeathDate(){
        return this.deathDate;
    }

    public String getDeathCountry() {
        return this.deathCountry;
    }

    public String getDeathState() {
        return this.deathState;
    }

    public String getDeathCity() {
        return this.deathCity;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public void setDeathCountry(String deathCountry) {
        this.deathCountry = deathCountry;
    }

    public void setDeathState(String deathState) {
        this.deathState = deathState;
    }

    public void setDeathCity(String deathCity) {
        this.deathCity = deathCity;
    }
}
