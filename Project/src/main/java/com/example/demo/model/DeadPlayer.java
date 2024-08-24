package com.example.demo.model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.time.LocalDate;

/**
 * A death player which add more fileds
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class DeadPlayer extends Player{
    @Past
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date must be in the format YYYY-MM-DD")
    private LocalDate deathDate;
    @NotBlank
    private String deathCountry;
    @NotBlank
    private String deathState;
    @NotBlank
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

}
