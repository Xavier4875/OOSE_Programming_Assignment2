package org.example.programming_assignment_2;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class RestaurantController {
    @FXML
    private Label welcomeText;

    @FXML
    private Button burgerButton;
    private Button finalizeButton;

    @FXML
    private VBox comboBoxContainer;
    private ComboBox<String> meatComboBox;
    private ComboBox<String> cheeseComboBox;
    private List<CheckBox> toppingCheckBoxes = new ArrayList<>();
    private List<CheckBox> sauceCheckBoxes = new ArrayList<>();
    private ComboBox<String> bunComboBox;
    private List<Hamburger> burgers = new ArrayList<>();  /* Track all created burgers */

    @FXML
    protected void onHamburgerButtonClick() {
        burgerButton.setVisible(false);

        /* Set the welcome text */
        welcomeText.setText("Please choose your hamburger components:");

        /* Clear any existing ComboBoxes (in case the button is clicked again) */
        comboBoxContainer.getChildren().clear();

        /* Create ComboBox for meat selection */
        meatComboBox = new ComboBox<>();
        meatComboBox.getItems().addAll("Beef ($3.00)", "Chicken ($2.50)", "Veggie ($2.00)");
        meatComboBox.setValue("Beef ($3.00)"); /* Default value */

        cheeseComboBox = new ComboBox<>();
        cheeseComboBox.getItems().addAll("American ($0.50)", "Cheddar ($0.75)", "Pepper Jack ($0.75)", "Colby Jack ($0.75)");
        cheeseComboBox.setValue("American ($0.50)"); /* Default value */

        /* Create CheckboxesBox for topping selection */
        CheckBox pickleCheckBox = new CheckBox("Pickles (free)");
        CheckBox lettuceCheckBox = new CheckBox("Lettuce ($0.50)");
        CheckBox tomatoCheckBox = new CheckBox("Tomato ($0.50)");
        CheckBox onionsCheckBox = new CheckBox("Onions (0.50)");
        CheckBox baconCheckBox = new CheckBox("Bacon ($1.00)");
        CheckBox eggCheckBox = new CheckBox("Fried Egg ($1.50)");

        /* Create CheckBoxes for sauce selection */
        CheckBox originalCheckBox = new CheckBox("Original Sauce (free)");
        CheckBox ketchupCheckBox = new CheckBox("Ketchup (free)");
        CheckBox mustardCheckBox = new CheckBox("Mustard (free)");
        CheckBox honeyMustardCheckBox = new CheckBox("Honey Mustard (free)");
        CheckBox mayoCheckBox = new CheckBox("Mayonnaise (free)");

        /* Add the topping CheckBoxes to the list */
        toppingCheckBoxes.clear(); /* Clear previous checkboxes, if any */
        toppingCheckBoxes.add(pickleCheckBox);
        toppingCheckBoxes.add(lettuceCheckBox);
        toppingCheckBoxes.add(tomatoCheckBox);
        toppingCheckBoxes.add(onionsCheckBox);
        toppingCheckBoxes.add(baconCheckBox);
        toppingCheckBoxes.add(eggCheckBox);

        /* Add the sauce CheckBoxes to the list */
        sauceCheckBoxes.clear(); /* Clear previous checkboxes, if any */
        sauceCheckBoxes.add(originalCheckBox);
        sauceCheckBoxes.add(ketchupCheckBox);
        sauceCheckBoxes.add(mustardCheckBox);
        sauceCheckBoxes.add(honeyMustardCheckBox);
        sauceCheckBoxes.add(mayoCheckBox);


        /* Create ComboBox for bun selection */
        bunComboBox = new ComboBox<>();
        bunComboBox.getItems().addAll("Sesame ($1.00)", "Whole Wheat ($1.25)", "Gluten-Free ($1.75)", "No Bun (free)");
        bunComboBox.setValue("Sesame ($1.00)"); // Default value

        finalizeButton = new Button("Finalize Hamburger");
        finalizeButton.setOnAction(e -> createHamburger());

        /* Add ComboBoxes to the VBox container */
        comboBoxContainer.getChildren().addAll(meatComboBox, cheeseComboBox, pickleCheckBox, lettuceCheckBox, tomatoCheckBox, onionsCheckBox, baconCheckBox, eggCheckBox, originalCheckBox, ketchupCheckBox, mustardCheckBox, honeyMustardCheckBox, mayoCheckBox, bunComboBox, finalizeButton);

        /* Make the VBox visible now that it contains the ComboBoxes */
        comboBoxContainer.setVisible(true);

    }

    private void createHamburger() {
        comboBoxContainer.setVisible(false);
        comboBoxContainer.getChildren().clear();
        finalizeButton.setVisible(false);
        String selectedMeat = meatComboBox.getValue();
        String selectedCheese = cheeseComboBox.getValue();

        List<String> selectedToppings = new ArrayList<>();
        for (CheckBox checkBox : toppingCheckBoxes) {
            if (checkBox.isSelected()) {
                selectedToppings.add(checkBox.getText());
            }
        }

        List<String> selectedSauces = new ArrayList<>();
        for (CheckBox checkBox : sauceCheckBoxes) {
            if (checkBox.isSelected()) {
                selectedSauces.add(checkBox.getText());
            }
        }

        String selectedBun = bunComboBox.getValue();

        Hamburger userBurger = new Hamburger(selectedMeat, selectedCheese, selectedToppings, selectedSauces, selectedBun);
        burgers.add(userBurger);

        welcomeText.setText("Your Hamburger: " +
                "\nMeat: " + userBurger.getMeat() +
                "\nCheese: " + userBurger.getCheese() +
                "\nToppings: " + userBurger.getToppings() +
                "\nSauces: "+ userBurger.getSauces() +
                "\nBun: " + userBurger.getBun());

        /* Ask if they want to create another burger */
        Button addAnotherButton = new Button("Add Another Burger");
        addAnotherButton.setOnAction(e -> onHamburgerButtonClick());
        comboBoxContainer.getChildren().add(addAnotherButton);

        /* Display total price button */
        Button totalPriceButton = new Button("Show Final Price");
        totalPriceButton.setOnAction(e -> showFinalPrice());
        comboBoxContainer.getChildren().add(totalPriceButton);

        comboBoxContainer.setVisible(true);
    }

    private void showFinalPrice() {
        comboBoxContainer.getChildren().clear();
        comboBoxContainer.setVisible(false);

        double burgerPrice;
        double totalPrice = 0.00;

        for (Hamburger burger : burgers) {
            burgerPrice = burger.getPrice();
            totalPrice += burgerPrice;
        }

        StringBuilder finalOrder = new StringBuilder("Your final order:\n");

        for (Hamburger burger : burgers) {
            finalOrder.append("Meat: ").append(burger.getMeat()).append("\n");
            finalOrder.append("Cheese: ").append(burger.getCheese()).append("\n");
            finalOrder.append("Toppings: ").append(burger.getToppings()).append("\n");
            finalOrder.append("Sauces: ").append(burger.getSauces()).append("\n");
            finalOrder.append("Bun: ").append(burger.getBun()).append("\n");
            finalOrder.append("-------------------------------\n");
        }

        String formattedPrice = String.format("%.2f", totalPrice);

        finalOrder.append("\nYour total price: $").append(formattedPrice).append("\n");

        Label orderSummary = new Label(finalOrder.toString());

        VBox finalPage = new VBox(20);
        finalPage.getChildren().addAll(orderSummary);

        Scene finalScene = new Scene(finalPage, 400, 400);
        Stage primaryStage = (Stage) comboBoxContainer.getScene().getWindow();
        primaryStage.setScene(finalScene);
    }
}