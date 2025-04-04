package org.example.programming_assignment_2;

import java.util.List;

public class Hamburger {
    private String meat;
    private String cheese;
    private List<String> toppings;
    private List<String> sauces;
    private String bun;

    public Hamburger(String meat, String cheese, List<String> toppings, List<String> sauces, String bun) {
        this.meat = meat;
        this.cheese = cheese;
        this.toppings = toppings;
        this.sauces = sauces;
        this.bun = bun;
    }

    public String getMeat() {
        return meat;
    }

    public String getCheese() {
        return cheese;
    }

    public List getToppings() {
        return toppings;
    }

    public List getSauces() {
        return sauces;
    }

    public String getBun() {
        return bun;
    }

    public double getPrice() {
        double price = 0.00;

        /*Price for meat*/
        if (meat.contains("Beef")) {
            price += 3.00;
        } else if (meat.contains("Chicken")) {
            price += 2.50;
        } else if (meat.contains("Veggie")) {
            price += 2.00;
        }

        /* Price for cheese */
        if (cheese.contains("American")) {
            price += 0.50;
        } else if (cheese.contains("Cheddar") || cheese.contains("Pepper Jack") || cheese.contains("Colby Jack")) {
            price += 0.75;
        }

        /* Price for toppings */
        for (String topping : toppings) {
            if (topping.contains("Lettuce") || topping.contains("Tomato") || topping.contains("Onions")) {
                price += 0.50;
            } else if (topping.contains("Bacon")) {
                price += 1.00;
            } else if (topping.contains("Egg")) {
                price += 1.50;
            }
        }

        /* Price for buns */
        if (bun.contains("Sesame")) {
            price += 1.00;
        } else if (bun.contains("Whole Wheat")) {
            price += 1.50;
        } else if (bun.contains("Gluten-Free")) {
            price += 1.75;
        }

        return price;
    }
}
