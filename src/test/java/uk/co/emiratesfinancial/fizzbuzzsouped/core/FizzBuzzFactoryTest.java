package uk.co.emiratesfinancial.fizzbuzzsouped.core;


import org.junit.*;

import static org.assertj.core.api.Assertions.*;

public class FizzBuzzFactoryTest {

  @Test
  public void whenCreateV1_thenBuildsFizzBuzzV1() {
    // arrange, act
    FizzBuzzCalculator v1Calculator = FizzBuzzFactory.createV1Calculator();
    // assert
    assertThat(v1Calculator).isNotNull();
    assertThat(v1Calculator.getSatisfyAllConditionsOfGroup()).isPresent();
    assertThat(v1Calculator.getSatisfyOneConditionOfGroupList()).isEmpty();
    assertThat(v1Calculator.getSatisfyAllConditionsOfGroup().get()).hasSize(2);
    assertThat(v1Calculator.getSatisfyAllConditionsOfGroup().get()).hasOnlyElementsOfTypes(DivisibleByFiveFizzBuzzStrategy.class, DivisibleByThreeFizzBuzzStrategy.class);
  }

  @Test
  public void whenCreateV1CalledTwice_thenCachedV1Retreived() {
    // arrange, act
    FizzBuzzCalculator v1Calculator = FizzBuzzFactory.createV1Calculator();
    FizzBuzzCalculator v1Calculator2 = FizzBuzzFactory.createV1Calculator();
    // assert
    assertThat(v1Calculator).isEqualTo(v1Calculator2);
  }

  @Test
  public void whenCreateV2_thenBuildsFizzBuzzV2() {
    // arrange, act
    FizzBuzzCalculator v2Calculator = FizzBuzzFactory.createV2Calculator();
    // assert
    assertThat(v2Calculator).isNotNull();
    assertThat(v2Calculator.getSatisfyAllConditionsOfGroup()).isEmpty();
    assertThat(v2Calculator.getSatisfyOneConditionOfGroupList()).isPresent();
    assertThat(v2Calculator.getSatisfyOneConditionOfGroupList().get()).hasSize(2);
    assertThat(v2Calculator.getSatisfyOneConditionOfGroupList().get().get(0)).hasOnlyElementsOfTypes(DivisibleByThreeFizzBuzzStrategy.class, ContainsThreeFizzBuzzStrategy.class);
    assertThat(v2Calculator.getSatisfyOneConditionOfGroupList().get().get(1)).hasOnlyElementsOfTypes(DivisibleByFiveFizzBuzzStrategy.class, ContainsFiveFizzBuzzStrategy.class);
  }

  @Test
  public void whenCreateV2CalledTwice_thenCachedV2Retreived() {
    // arrange, act
    FizzBuzzCalculator v2Calculator = FizzBuzzFactory.createV2Calculator();
    FizzBuzzCalculator v2Calculator2 = FizzBuzzFactory.createV2Calculator();

    // assert
    assertThat(v2Calculator).isEqualTo(v2Calculator2);
  }

}