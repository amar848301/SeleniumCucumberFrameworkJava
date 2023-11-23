package stepDefinations;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import utilities.Base;

public class stepDefination extends Base {
	
	public String emails;
	public String passwords;
	public HomePage home;
	public String products;
	
	@Given("Login into account with given details")
	public void login_into_account_with_given_details(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps();
		emails = data.get(0).get("email");
		passwords = data.get(0).get("password");
		home = new HomePage();
		home.openUrl();
		home.Login(emails, passwords);
	}
	@When("add a single product in cart")
	public void add_a_single_product_in_cart(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps();
		products = data.get(0).get("productName");
	    home.openUrl();
	    home.addProductsToCart(products);
	}
	@Then("proceed to checkout")
	public void proceed_to_checkout() {
	    home.proceedToCheckout();
	}
}
