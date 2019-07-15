package uk.co.emiratesfinancial.fizzbuzzsouped.core;

public class DivisibleByThreeFizzBuzzStrategy implements FizzBuzzStrategy {
  @Override
  public String calculate(final int i) {

    if (i % 3 == 0) {
      return "Fizz";
    }

    return "";
  }
}
