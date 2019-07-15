package uk.co.emiratesfinancial.fizzbuzzsouped.core;

import java.util.List;
import java.util.Optional;

import static java.lang.String.*;
import static org.springframework.util.ObjectUtils.*;

/**
 * FizzBuzz Calculator contains the logic for applying rules.
 *
 * It supports two paradigms:
 *  1 - Rules that all need to be applied (e.g. check number is divisble by 3 and check number is divisible by 5)
 *  2 - Rules that should be applied once from a given set (e.g. check number is divisible by 3 OR contains 3)
 */
public class FizzBuzzCalculator {


  private final Optional<List<List<FizzBuzzStrategy>>> satisfyOneConditionOfGroupList;
  private final Optional<List<FizzBuzzStrategy>> satisfyAllConditionsOfGroup;

  public Optional<List<List<FizzBuzzStrategy>>> getSatisfyOneConditionOfGroupList() {

    return satisfyOneConditionOfGroupList;
  }

  public Optional<List<FizzBuzzStrategy>> getSatisfyAllConditionsOfGroup() {

    return satisfyAllConditionsOfGroup;
  }

  public FizzBuzzCalculator(final List<FizzBuzzStrategy> satisfyAllConditionsOfGroup, final List<List<FizzBuzzStrategy>> satisfyOneConditionOfGroupList) {
    this.satisfyAllConditionsOfGroup = Optional.ofNullable(satisfyAllConditionsOfGroup);
    this.satisfyOneConditionOfGroupList = Optional.ofNullable(satisfyOneConditionOfGroupList);
  }

  public String calculate(final int i) {

    StringBuilder builder = new StringBuilder();

    satisfyAllConditionsOfGroup.ifPresent((rules) -> {
      rules.stream().forEach((strategy) -> builder.append(strategy.calculate(i)));
      });


    satisfyOneConditionOfGroupList.ifPresent((rules) -> {
      rules.stream().forEach((conditionGroup) -> processConditionGroup(conditionGroup, builder, i));
    });


    String result = builder.length() > 0 ? builder.toString() : valueOf(i);

    return result;
  }

  private void processConditionGroup(final List<FizzBuzzStrategy> conditionGroup, final StringBuilder builder, int i) {
      conditionGroup.stream().anyMatch((strategy) -> {
        String result = strategy.calculate(i);
        if (!isEmpty(result)) {
          builder.append(result);
          return true;
        }
        return false;
      });

  }
}
