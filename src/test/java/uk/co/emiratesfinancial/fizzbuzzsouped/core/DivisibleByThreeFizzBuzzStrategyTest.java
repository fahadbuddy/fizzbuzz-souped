package uk.co.emiratesfinancial.fizzbuzzsouped.core;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class DivisibleByThreeFizzBuzzStrategyTest {

  @Test
  public void when_3_then_returns_Fizz() {

    // arrange
    DivisibleByThreeFizzBuzzStrategy strategy = new DivisibleByThreeFizzBuzzStrategy();

    // act
    String actual = strategy.calculate(3);

    // assert
    assertThat(actual).isEqualTo("Fizz");
  }

  @Test
  public void when_not_3_then_returns_EmptyString() {

    // arrange
    DivisibleByThreeFizzBuzzStrategy strategy = new DivisibleByThreeFizzBuzzStrategy();

    // act
    String actual = strategy.calculate(-1);

    // assert
    assertThat(actual).isEqualTo("");
  }
}