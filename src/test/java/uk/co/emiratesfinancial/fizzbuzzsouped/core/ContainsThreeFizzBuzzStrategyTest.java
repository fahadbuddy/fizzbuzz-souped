package uk.co.emiratesfinancial.fizzbuzzsouped.core;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class ContainsThreeFizzBuzzStrategyTest {

  @Test
  public void when_3_then_returns_Fizz() {

    // arrange
    FizzBuzzStrategy strategy = new ContainsThreeFizzBuzzStrategy();

    // act
    String actual = strategy.calculate(3);

    // assert
    assertThat(actual).isEqualTo("Fizz");
  }

  @Test
  public void when_not_3_then_returns_EmptyString() {

    // arrange
    FizzBuzzStrategy strategy = new ContainsThreeFizzBuzzStrategy();

    // act
    String actual = strategy.calculate(-1);

    // assert
    assertThat(actual).isEqualTo("");
  }

}