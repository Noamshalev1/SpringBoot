package com.example.demo.model;
import java.time.LocalDate;

/**
 * This class holds details about Player (alive)
 */
public class Player {

    protected String playerID;
    protected LocalDate birthDate;
    protected String birthCountry;
    protected String birthState;
    protected String birthCity;
    protected String nameFirst;
    protected String nameLast;
    protected String nameGiven;
    protected int weight;
    protected int height;
    protected String bats;
    protected String _throws;
    protected String debut;
    protected String finalGame;
    protected String retroID;
    protected String bbrefID;
    public Player(String playerID, LocalDate birthDate, String birthCountry, String birthState,
                  String birthCity, String nameFirst, String nameLast, String nameGiven, int weight,
                  int height, String bats, String _throws, String debut, String finalGame,
                  String retroID, String bbrefID) {
        this.playerID = playerID;
        this.birthDate = birthDate;
        this.birthCountry = birthCountry;
        this.birthState = birthState;
        this.birthCity = birthCity;
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.nameGiven = nameGiven;
        this.weight = weight;
        this.height = height;
        this.bats = bats;
        this._throws = _throws;
        this.debut = debut;
        this.finalGame = finalGame;
        this.retroID = retroID;
        this.bbrefID = bbrefID;
    }
    public boolean isDead(){
        return false;
    }
    public String getPlayerID() {
        return playerID;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public String getBirthState() {
        return birthState;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public String getNameLast() {
        return nameLast;
    }

    public String getNameGiven() {
        return nameGiven;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public String getBats() {
        return bats;
    }

    public String get_throws() {
        return _throws;
    }

    public String getDebut() {
        return debut;
    }

    public String getFinalGame() {
        return finalGame;
    }

    public String getRetroID() {
        return retroID;
    }

    public String getBbrefID() {
        return bbrefID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public void setBirthState(String birthState) {
        this.birthState = birthState;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }

    public void setNameGiven(String nameGiven) {
        this.nameGiven = nameGiven;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setBats(String bats) {
        this.bats = bats;
    }

    public void set_throws(String _throws) {
        this._throws = _throws;
    }

    public void setDebut(String debut) {
        this.debut = debut;
    }

    public void setFinalGame(String finalGame) {
        this.finalGame = finalGame;
    }

    public void setRetroID(String retroID) {
        this.retroID = retroID;
    }

    public void setBbrefID(String bbrefID) {
        this.bbrefID = bbrefID;
    }
}
