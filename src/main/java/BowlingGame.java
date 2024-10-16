package main.java;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private static final int FIRST_ROLL = 1;
    private static final int SECOND_ROLL = 0;

    private static int totalRollCount = 0;
    private static int frame = 0;
    private static int rollCount = FIRST_ROLL;
    private static int pinNow = 10;
    private static int score = 0;
    private static boolean isSpare = false;
    private static List<Integer> strikeArray = new ArrayList<>();


    public void roll(int pins) {
        if(pins < 0 || pinNow < pins) {
            throw new IllegalArgumentException("Pins in one frame must be between 0 and 10asd");
        }

        totalRollCount++;

        if(totalRollCount > 21) {
            throw new IllegalArgumentException("Total roll count must be less than 20");
        }

        if(frame < 10){
            score += pins;
        }

        if(isSpare){ // Spare Bonus
            score += pins;
            isSpare = false;
        }

        for(int i = 0; i < strikeArray.size(); i++){
            if(strikeArray.get(i) > 0){
                strikeArray.set(i, strikeArray.get(i) - 1);
                score += pins;
            }
        }

        if(rollCount == SECOND_ROLL){
            if(pinNow == pins) { // SPARE
                isSpare = true;
                pinNow = 10;
            }
            else pinNow = 10; // NO SPARE
            rollCount = FIRST_ROLL;
            frame++;
        }
        else{ // FIRST ROLL
            if(pins == 10) { // STRIKE
                if(frame < 10) {
                    strikeArray.add(2);
                    if(frame != 9) totalRollCount++;
                }
                frame++;
            }
            else{
                strikeArray.add(0);
                rollCount = SECOND_ROLL;
                pinNow -= pins;
            }
        }
    }

    public int getScore(){
        return score;
    }
}
