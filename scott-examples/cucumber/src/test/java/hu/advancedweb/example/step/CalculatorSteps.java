package hu.advancedweb.example.step;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hu.advancedweb.example.Calculator;

public class CalculatorSteps {

	public static Calculator calculator;

	@Given("^a Calculator")
	public void a_calculator() throws Throwable {
		calculator = new Calculator();
	}
	
	@When("^I enter (\\d+)$")
	public void i_enter_a_number(int number) throws Throwable {
		calculator.enter(number);
	}

	@When("^I press PLUS")
	public void i_press_plus() throws Throwable {
		calculator.pressPlus();
	}

	@When("^I press MULTIPLY$")
	public void i_press_MULTIPLY() throws Throwable {
		calculator.pressMultiply();
	}

	@Then("^I should see (\\d+)$")
	public void i_should_see_the_result(int number) throws Throwable {
		int result = calculator.getResult();
		assertThat(result, equalTo(number));
	}

	@Then("^I should see (\\d+), (\\d+) and (\\d+) if I repeat the operation three times$")
	public void i_should_see_the_following_numbers(int first, int second, int third) throws Throwable {
		calculator.pressEnter();
		int result = calculator.getResult();
		assertThat(result, equalTo(first));

		calculator.pressEnter();
		result = calculator.getResult();
		assertThat(result, equalTo(second));
		
		calculator.pressEnter();
		// Oops. Accidentally pressing the button twice.
		calculator.pressEnter();
		result = calculator.getResult();
		assertThat(result, equalTo(third));
	}
}
