package uk.co.emiratesfinancial.fizzbuzzsouped.core;

public class ContainsThreeFizzBuzzStrategy implements FizzBuzzStrategy {
  @Override
  public String calculate(final int i) {

    if (String.valueOf(i).contains("3")) {
      return "Fizz";
    }

    return "";
  }
}
