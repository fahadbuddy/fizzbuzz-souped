package uk.co.emiratesfinancial.fizzbuzzsouped.core;

import org.junit.Test;

import java.util.*;

import static java.lang.Integer.*;
import static org.assertj.core.api.Assertions.*;

public class FizzBuzzCalculatorTest {

  @Test
  public void test_when_1_then_1() {

    // arrange
    String expected = "1";
    FizzBuzzCalculator calculator = new FizzBuzzCalculator(null, null);

    // act
    String actual = calculator.calculate(valueOf(expected));

    // assert
    assertThat(actual).isEqualToIgnoringCase(expected);
  }

  @Test
  public void test_when_3_then_Fizz() {

    // arrange
    String expected = "Fizz";
    List<FizzBuzzStrategy> satisfyEachConditionGroup = new ArrayList<>();
    satisfyEachConditionGroup.add(new DivisibleByThreeFizzBuzzStrategy());
    FizzBuzzCalculator calculator = new FizzBuzzCalculator(satisfyEachConditionGroup, null);

    // act
    String actual = calculator.calculate(3);

    // assert
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void test_when_15_then_FizzBuzz() {

    // arrange
    String expected = "FizzBuzz";
    List<FizzBuzzStrategy> satisfyEachConditionGroup = new ArrayList<>();
    satisfyEachConditionGroup.add(new DivisibleByThreeFizzBuzzStrategy());
    satisfyEachConditionGroup.add(new DivisibleByFiveFizzBuzzStrategy());
    FizzBuzzCalculator calculator = new FizzBuzzCalculator(satisfyEachConditionGroup, null);

    // act
    String actual = calculator.calculate(15);

    // assert
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void test_when_131_then_Fizz() {

    // arrange
    String expected = "Fizz";
    List<FizzBuzzStrategy> satisfyOneConditionOfGroup = new ArrayList<>();
    satisfyOneConditionOfGroup.add(new DivisibleByThreeFizzBuzzStrategy());
    satisfyOneConditionOfGroup.add(new ContainsThreeFizzBuzzStrategy());
    FizzBuzzCalculator calculator = new FizzBuzzCalculator(null, Arrays.asList(satisfyOneConditionOfGroup));

    // act
    String actual = calculator.calculate(3);

    // assert
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void test_when_1351_then_FizzBuzz() {

    // arrange
    String expected = "FizzBuzz";
    List<FizzBuzzStrategy> satisfyOneConditionOfGroup = new ArrayList<>();
    satisfyOneConditionOfGroup.add(new DivisibleByThreeFizzBuzzStrategy());
    satisfyOneConditionOfGroup.add(new ContainsThreeFizzBuzzStrategy());

    List<FizzBuzzStrategy> satisfyOneConditionOfGroup2 = new ArrayList<>();
    satisfyOneConditionOfGroup2.add(new DivisibleByFiveFizzBuzzStrategy());
    satisfyOneConditionOfGroup2.add(new ContainsFiveFizzBuzzStrategy());

    FizzBuzzCalculator calculator = new FizzBuzzCalculator(null, Arrays.asList(satisfyOneConditionOfGroup, satisfyOneConditionOfGroup2));

    // act
    String actual = calculator.calculate(1351);

    // assert
    assertThat(actual).isEqualTo(expected);
  }

}