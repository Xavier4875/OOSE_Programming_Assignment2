package org.example.programming_assignment2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import org.example.programming_assignment_2.Hamburger;

public class HamburgerTest {

    /* Check that the price of a burger increases by the correct amount after adding one topping */
    @Test
    public void testPriceWithToppings() {
        Hamburger burger = new Hamburger("Beef", "American", Arrays.asList(), Arrays.asList(), "Sesame");

        double startPrice = burger.getPrice();

        burger = new Hamburger ("Beef", "American", Arrays.asList("Bacon"), Arrays.asList(), "Sesame");

        double priceWithBacon = burger.getPrice();

        assertEquals(startPrice + 1.00, priceWithBacon, "Price should increase by 1.00 when bacon is added");
    }

    /* Check that the total price of a hamburger is equal to the sum of its parts */
    @Test
    public void testPriceAsSum() {
        Hamburger burger = new Hamburger("Beef", "Pepper Jack", Arrays.asList("Pickles", "Tomato", "Egg"), Arrays.asList("Original Sauce"), "Whole Wheat");

        double burgerPrice= burger.getPrice();

        double sumOfParts = 3.00 + 0.75 + 0.00 + 0.50 + 1.50 + 0.00 + 1.50;

        assertEquals(burgerPrice, sumOfParts, "The total price of a burger should be equal to the sum of its meat, cheese, toppings, sauces, and bun");
    }

    /* Check that the total price of the order is increased by the correct amount after assembling a new burger */
    @Test
    public void testTotalPrice() {
        double originalPrice = 0.00;
        double totalPrice = 0.00;

        Hamburger burger = new Hamburger("Beef", "Colby Jack", Arrays.asList("Pickles", "Lettuce", "bacon", "Egg"), Arrays.asList("Mayonnaise"), "Gluten-Free");

        originalPrice += burger.getPrice();
        totalPrice += burger.getPrice();

        Hamburger burgerTwo = new Hamburger("Chicken", "Cheddar", Arrays.asList("Pickles", "Bacon", "Egg"), Arrays.asList("Original Sauce"), "Sesame");

        totalPrice += burgerTwo.getPrice();

        double checkPrice = totalPrice - 2.50 - 0.75 - 0.00 - 1.00 - 1.50 - 0.00 - 1.00;

        assertEquals(originalPrice, checkPrice, "The total price should increase by the same amount as the price of the newly assembled burger");
    }

    /* Check that the price of the order is increased by the correct amount after assembling two burgers */
    @Test
    public void testTwoBurgers() {
        double originalPrice = 0.00;
        double totalPrice = 0.00;

        Hamburger burger = new Hamburger("Beef", "Colby Jack", Arrays.asList("Pickles", "Lettuce", "bacon", "Egg"), Arrays.asList("Mayonnaise"), "Gluten-Free");

        originalPrice += burger.getPrice();
        totalPrice += burger.getPrice();

        Hamburger burgerTwo = new Hamburger("Chicken", "Cheddar", Arrays.asList("Pickles", "Bacon", "Egg"), Arrays.asList("Original Sauce"), "Sesame");

        totalPrice += burgerTwo.getPrice();

        double checkPriceOne = 2.50 + 0.75 + 0.00 + 1.00 + 1.50 + 0.00 + 1.00;

        Hamburger burgerThree = new Hamburger("Veggie", "American", Arrays.asList("Pickles", "Lettuce", "Tomato"), Arrays.asList("Mayonnaise"), "No Bun");

        totalPrice += burgerThree.getPrice();

        double checkPriceTwo = 2.00 + 0.50 + 0.00 + 0.50 + 0.50 + 0.00 + 0.00;

        double totalCheckPrice = checkPriceOne + checkPriceTwo;

        assertEquals(totalPrice - totalCheckPrice, originalPrice, "The total price should increase by the combined cost of the two burgers that were added");
    }

    /* Test the prices of the meat options */
    @Test
    public void testMeat() {
        Hamburger burgerOne = new Hamburger("Beef", "", Arrays.asList(), Arrays.asList(), "");

        Hamburger burgerTwo = new Hamburger("Chicken", "", Arrays.asList(), Arrays.asList(), "");

        Hamburger burgerThree = new Hamburger("Veggie", "", Arrays.asList(), Arrays.asList(), "");

        assertEquals(burgerOne.getPrice(), 3.00, "The price of a beef patty should be 3.00");

        assertEquals(burgerTwo.getPrice(), 2.50, "The price of a chicken patty should be 2.50");

        assertEquals(burgerThree.getPrice(), 2.00, "The price of a veggie patty should be 2.00");
    }
}
