package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzSteps {

    private int input;
    private String result;

    @Given("the input number is {int}")
    public void the_input_number_is(int n) {
        this.input = n;
    }

    @When("I compute FizzBuzz")
    public void i_compute_FizzBuzz() {
        this.result = FizzBuzz.compute(this.input);
    }

    @Then("the result should be {string}")
    public void the_result_should_be(String expected) {
        assertEquals(expected, this.result);
    }
}
