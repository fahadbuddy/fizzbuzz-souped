package uk.co.emiratesfinancial.fizzbuzzsouped.core;

public class DivisibleByFiveFizzBuzzStrategy implements FizzBuzzStrategy {
  @Override
  public String calculate(final int i) {

    if (i % 5 == 0) {
      return "Buzz";
    }

    return "";
  }
}
