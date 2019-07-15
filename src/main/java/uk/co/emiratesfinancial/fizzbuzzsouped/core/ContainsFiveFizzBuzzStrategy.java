package uk.co.emiratesfinancial.fizzbuzzsouped.core;

public class ContainsFiveFizzBuzzStrategy implements FizzBuzzStrategy {
    @Override
    public String calculate(final int i) {

      if (String.valueOf(i).contains("5")) {
        return "Buzz";
      }

      return "";
    }
}
