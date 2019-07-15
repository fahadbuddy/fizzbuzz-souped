package uk.co.emiratesfinancial.fizzbuzzsouped.service;

import org.junit.Test;
import uk.co.emiratesfinancial.fizzbuzzsouped.core.FizzBuzzFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class FizzBuzzServiceTest {

  @Test
  public void whenCalculateV1_thenUsesV1Calculator_To_Generate_Numbers() {
    // arrange
    FizzBuzzService service = new FizzBuzzService(new FizzBuzzFactory());

    // act
    List<String> numbers =  service.generateV1FizzBuzzNumbers();

    // assert
    assertThat(numbers).isNotEmpty();
    assertThat(numbers.get(2)).isEqualTo("Fizz");
    assertThat(numbers.get(4)).isEqualTo("Buzz");
    assertThat(numbers.get(12)).isEqualTo("13");
    assertThat(numbers.get(14)).isEqualTo("FizzBuzz");
  }

  @Test
  public void whenCalculateV2_thenUsesV2Calculator_To_Generate_Numbers() {
    // arrange
    FizzBuzzService service = new FizzBuzzService(new FizzBuzzFactory());

    // act
    List<String> numbers =  service.generateV2FizzBuzzNumbers();

    // assert
    assertThat(numbers).isNotEmpty();
    assertThat(numbers.get(2)).isEqualTo("Fizz");
    assertThat(numbers.get(4)).isEqualTo("Buzz");
    // Number 13 ==> Fizz
    assertThat(numbers.get(12)).isEqualTo("Fizz");
    // Number 52 ==> Buzz
    assertThat(numbers.get(51)).isEqualTo("Buzz");
  }
}