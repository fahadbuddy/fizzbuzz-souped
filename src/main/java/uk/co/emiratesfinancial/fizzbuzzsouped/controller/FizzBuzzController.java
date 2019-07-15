package uk.co.emiratesfinancial.fizzbuzzsouped.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uk.co.emiratesfinancial.fizzbuzzsouped.service.FizzBuzzService;

import java.util.List;

/**
 * Main controller for the FizzBuzz applicaiton.
 */
@org.springframework.web.bind.annotation.RestController
@Api(value="FizzBuzz-er", description="FizzBuzz number generator, exposes /fizzBuzzV1 and /fizzBuzzV2 endpoints")
public class FizzBuzzController {

  @Autowired
  FizzBuzzService fizzBuzzService;

  @RequestMapping(path = "/fizzBuzzV1", method = RequestMethod.GET)
  @ApiOperation(value = "Calculate FizzBuzz using original rules", response = List.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Successfully generated FizzBuzz Numbers")})
  public List<String> calculateV1(){
    return fizzBuzzService.generateV1FizzBuzzNumbers();
  }

  @RequestMapping(path = "/fizzBuzzV2", method = RequestMethod.GET)
  @ApiOperation(value = "Calculate FizzBuzz using modified rules", response = List.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Successfully generated FizzBuzz Numbers")})
  public List<String> calculateV2(){
    return fizzBuzzService.generateV2FizzBuzzNumbers();
  }

}
