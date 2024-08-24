package com.example.demo.model;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.time.LocalDate;

/**
 * This class holds details about Player (alive)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Player {

    @NotBlank
    protected String playerID;
    @Past(message = "Birthdate must be a past date")
    protected LocalDate birthDate;
    @NotBlank
    protected String birthCountry;
    @NotBlank
    protected String birthState;
    @NotBlank
    protected String birthCity;
    @NotBlank
    protected String nameFirst;
    @NotBlank
    protected String nameLast;
    @NotBlank
    protected String nameGiven;
    @Positive
    protected int weight;
    @Positive
    protected int height;
    @NotBlank
    protected String bats;
    @NotBlank
    protected String _throws;
    @NotBlank
    protected String debut;
    @NotBlank
    protected String finalGame;
    @NotBlank
    protected String retroID;
    @NotBlank
    protected String bbrefID;

    public boolean isDead() {
        return false;
    }
}