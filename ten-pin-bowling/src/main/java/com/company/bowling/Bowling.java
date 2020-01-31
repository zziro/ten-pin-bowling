package com.company.bowling;

import com.company.bowling.frame.Frame;
import com.company.bowling.line.Line;
import com.company.bowling.frame.FrameParser;
import com.company.bowling.line.LineScorer;
import com.company.bowling.roll.Roll;
import com.company.bowling.roll.RollParser;

import java.util.ArrayList;

public class Bowling {

    private final RollParser rollParser;
    private final FrameParser frameParser;

    public Bowling(RollParser parser) {
        this.rollParser = parser;
        this.frameParser = new FrameParser();
    }

    public int scoreOf(String rollsAsString) {
        ArrayList<Roll> rolls = rollParser.parse(rollsAsString);
        ArrayList<Frame> frames = frameParser.parse(rolls);
        LineScorer scorer = new LineScorer(new Line(frames));

        return scorer.score();
    }

}
