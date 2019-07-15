package uk.co.emiratesfinancial.fizzbuzzsouped.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uk.co.emiratesfinancial.fizzbuzzsouped.core.FizzBuzzCalculator;
import uk.co.emiratesfinancial.fizzbuzzsouped.core.FizzBuzzFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class FizzBuzzService {

  Logger LOGGER = LoggerFactory.getLogger(FizzBuzzService.class);

  private final FizzBuzzFactory factory;

  public FizzBuzzService(final FizzBuzzFactory fizzBuzzFactory) {
    this.factory = fizzBuzzFactory;
  }

  public List<String> generateV1FizzBuzzNumbers() {
    LOGGER.info("generating V1 FizzBuzz Numbers");

    return generateFizzBuzzNumbers(factory.createV1Calculator());
  }

  public List<String> generateV2FizzBuzzNumbers() {
    LOGGER.info("generating V2 FizzBuzz Numbers");

    return generateFizzBuzzNumbers(factory.createV2Calculator());
  }

  private List<String> generateFizzBuzzNumbers(final FizzBuzzCalculator calculator) {

    return IntStream.rangeClosed(1, 100)
                    .mapToObj(calculator::calculate)
                    .collect(Collectors.toList());
  }
}
