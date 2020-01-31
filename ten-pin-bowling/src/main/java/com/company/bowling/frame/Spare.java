package com.company.bowling.frame;

import com.company.bowling.roll.Roll;

public class Spare extends Frame {
    public Spare(Roll firstRoll, Roll secondRoll) {
        super(firstRoll, secondRoll);
    }

    @Override
    public boolean isSpare() {
        return true;
    }
}
