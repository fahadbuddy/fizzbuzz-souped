package uk.co.emiratesfinancial.fizzbuzzsouped.core;

import org.springframework.stereotype.Component;

import java.util.*;


/**
 * Creates V1 calculator as per initial FizzBuzz requirements, which only checks if the number is divisible by three or five
 *
 * Creates V2 calculator as per extended requirements to check if the number is divisible or contains three or five.
 *
 * Uses double checked locking to lazily iniatlize v1 and v2 calculators, and then cache them.
 */
@Component
public class FizzBuzzFactory {


  private static volatile FizzBuzzCalculator v1Calculator;
  private static volatile FizzBuzzCalculator v2Calculator;

  public static FizzBuzzCalculator createV1Calculator() {

    if (v1Calculator == null ) {
      synchronized (FizzBuzzFactory.class) {
        if (v1Calculator == null) {
          v1Calculator = new FizzBuzzCalculator(Arrays.asList(new DivisibleByThreeFizzBuzzStrategy(), new DivisibleByFiveFizzBuzzStrategy()), null);
        }
      }
    }

    return v1Calculator;
  }

  public static FizzBuzzCalculator createV2Calculator() {

    if (v2Calculator == null) {
      synchronized (FizzBuzzFactory.class) {
        if (v2Calculator == null) {
          List<FizzBuzzStrategy> containsThreeOrIsDivisibleByThree = Arrays.asList(new ContainsThreeFizzBuzzStrategy(), new DivisibleByThreeFizzBuzzStrategy());
          List<FizzBuzzStrategy> containsFiveOrIsDivisibleByFive = Arrays.asList(new ContainsFiveFizzBuzzStrategy(), new DivisibleByFiveFizzBuzzStrategy());
          List<List<FizzBuzzStrategy>> strategies = new ArrayList<>();
          strategies.add(containsThreeOrIsDivisibleByThree);
          strategies.add(containsFiveOrIsDivisibleByFive);

          v2Calculator = new FizzBuzzCalculator(null, strategies);
        }
      }
    }

    return v2Calculator;
  }
}
