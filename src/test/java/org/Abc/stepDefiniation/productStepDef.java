package org.Abc.stepDefiniation;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.Abc.context.TestContext;
import org.Abc.PageInitializer.PageInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class productStepDef extends PageInitializer {

    public static Logger logger = LogManager.getLogger(productStepDef.class);
    private final TestContext context;

    public productStepDef(TestContext context) {
        this.context = context;
    }

    @Then("the user adds the following products to the cart:")
    public void the_user_adds_the_following_products_to_the_cart(DataTable dataTable) {

        List<String> products = dataTable.asList();
        context.set("cartItems", products);

        for (String product : products) {
            homePage.searchProduct(product);
            searchResultsPage.clickOnProduct(product);
            productPage.addToCart();

            // Optional: Navigate back to homepage before next iteration
            driver.get(hooks.getConfigValue("url"));
        }
    }

    @And("the user removes the following products from the cart:")
    public void theUserRemovesTheFollowingProductsFromTheCart(DataTable dataTable) {
        List<String> toRemove = dataTable.asList();
        List<String> currentCart = new ArrayList<>(context.get("cartItems", List.class));
        cartPage.openCart();
        for (String product : toRemove) {
            cartPage.removeProduct(product);
            currentCart.remove(product);
        }

        // Update context
        context.set("cartItems", currentCart);
    }

    @Then("the cart should contain the following products:")
    public void theCartShouldContainTheFollowingProducts(DataTable expectedTable) {
        List<String> expected = expectedTable.asList();
        List<String> actual = cartPage.getCartItems();
        assert expected.containsAll(actual) && actual.containsAll(expected) :
                "Expected: " + expected + ", but found: " + actual;

    }
}
