package uk.co.emiratesfinancial.fizzbuzzsouped.core;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class DivisibleByFiveFizzBuzzStrategyTest {

  @Test
  public void when_5_then_returns_Buzz() {

    // arrange
    FizzBuzzStrategy strategy = new DivisibleByFiveFizzBuzzStrategy();

    // act
    String actual = strategy.calculate(5);

    // assert
    assertThat(actual).isEqualTo("Buzz");
  }

  @Test
  public void when_not_5_then_returns_EmptyString() {

    // arrange
    FizzBuzzStrategy strategy = new DivisibleByFiveFizzBuzzStrategy();

    // act
    String actual = strategy.calculate(3);

    // assert
    assertThat(actual).isEqualTo("");
  }


}