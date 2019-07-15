package uk.co.emiratesfinancial.fizzbuzzsouped.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FizzBuzzControllerTest {


  @Autowired
  MockMvc mockMvc;

  @Test
  public void whenCalculateV1_thenGeneratesV1() throws Exception {

    mockMvc.perform(get("/fizzBuzzV1"))
           .andDo(print())
           .andExpect(status().isOk());
  }

  @Test
  public void whenCalculateV2_thenGeneratesV2() throws Exception {

    mockMvc.perform(get("/fizzBuzzV2"))
           .andDo(print())
           .andExpect(status().isOk());
  }
}