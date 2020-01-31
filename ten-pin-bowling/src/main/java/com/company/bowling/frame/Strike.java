package com.company.bowling.frame;

import com.company.bowling.roll.Roll;

public class Strike extends Frame {

    public Strike(Roll roll) {
        super(roll);
    }

    @Override
    public boolean isStrike() {
        return true;
    }
}
