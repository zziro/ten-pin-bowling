package com.company.bowling;

import com.company.bowling.Bowling;
import com.company.bowling.StringRollParser;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BowlingShouldTest {

	@Test
	public void scores_300_a_perfect_game() {
		assertThat(scoreOf("XXXXXXXXXXXX"), is(300));
	}

	@Test
	public void scores_90_when_second_ball_of_each_fram_misses_last_remaining_pin() {
		assertThat(scoreOf("9-9-9-9-9-9-9-9-9-9-"), is(90));
	}

	@Test
	public void scores_150_all_the_turns_with_spare_and_the_last_bonus_5() {
		assertThat(scoreOf("5/5/5/5/5/5/5/5/5/5/5"), is(150));
	}

	@Test
	public void score_0_when_failing_all_the_rolls() {
		assertThat(scoreOf("--------------------"), is(0));
	}

	@Test
	public void score_1_when_the_first_roll_throw_one_pin_and_miss_others_rolls() {
		assertThat(scoreOf("1-------------------"), is(1));
	}

	@Test
	public void score_2_when_the_first_roll_throw_two_pin_and_miss_others_rolls() {
		assertThat(scoreOf("2-------------------"), is(2));
	}

	@Test
	public void score_20_when_all_rolls_throw_one_pin() {
		assertThat(scoreOf("11111111111111111111"), is(20));
	}

	@Test
	public void score_10_when_the_first_turn_do_a_spare_and_miss_other_rolls() {
		assertThat(scoreOf("3/------------------"), is(10));
	}

	@Test
	public void score_10_when_the_first_turn_do_a_strike_and_miss_other_rolls() {
		assertThat(scoreOf("X------------------"), is(10));
	}

	@Test
	public void get_next_throw_of_bonus_after_spare() {
		assertThat(scoreOf("3/3-----------------"), is(16));
	}

	@Test
	public void not_be_a_spare_the_score_of_10_in_two_consecutive_rolls_but_in_different_turns() {
		assertThat(scoreOf("3553----------------"), is(16));
	}

	@Test
	public void be_next_two_rolls_of_bonus_after_strike() {
		assertThat(scoreOf("X53----------------"), is(26));
	}

	private int scoreOf(String rolls) {
		Bowling bowling = new Bowling(new StringRollParser());
		return bowling.scoreOf(rolls);
	}

}
