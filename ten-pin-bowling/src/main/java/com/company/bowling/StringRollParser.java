package com.company.bowling;

import com.company.bowling.roll.Roll;
import com.company.bowling.roll.RollParser;

import java.util.ArrayList;

public class StringRollParser implements RollParser {
    @Override
    public ArrayList<Roll> parse(Object rolls) {
        String parsedRolls = (String) rolls;
        ArrayList<Roll> result = new ArrayList<>();
        for (int i = 0; i < parsedRolls.length(); i++) {
            result.add(createRoll(parsedRolls, i));
        }
        return result;
    }

    private Roll createRoll(String rolls, int i) {
        int score = scoreOf(i, rolls);
        return new Roll(score);
    }

    private int scoreOf(int numberOfRoll, String rolls) {
        char score = rolls.charAt(numberOfRoll);
        if (score == '-') {
            return 0;
        }
        if (score == '/') {
            return 10 - scoreOf(numberOfRoll - 1, rolls);
        }
        if (score == 'X') {
            return 10;
        }
        return Character.getNumericValue(score);
    }
}
