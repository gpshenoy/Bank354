/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank354;

import bank354.util.Bank;
import bank354.util.BankUtility;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author gshenoy
 */
public class Bank354 extends Application {

    @Override
    public void start(Stage primaryStage) {

        Label depositLabel = new Label("A/C Balance " + Bank.get().getDeposit().toString());
        depositLabel.getStyleClass().add("deposit");
        Label amountLabel = new Label("Enter amount");
        final TextField amountTextField = new TextField();
        amountTextField.setMaxWidth(100);

        Button btn = new Button();
        btn.setText("Deposit");
        btn.getStyleClass().add("myButtons");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (amountTextField.getText().isEmpty()) {
                    return;
                }
                BankUtility.deposit(Double.parseDouble(amountTextField.getText()));
                depositLabel.setText("A/C Balance " + Bank.get().getDeposit().toString());
            }
        });

        Button withdraw = new Button();
        withdraw.setText("Withdraw");
        withdraw.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (amountTextField.getText().isEmpty()) {
                    return;
                }
                BankUtility.withdraw(Double.parseDouble(amountTextField.getText()));
                depositLabel.setText("A/C Balance " + Bank.get().getDeposit().toString());
            }
        });

        Button interestBtn = new Button();
        interestBtn.setText("10.8% ROI");
        interestBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                BankUtility.roi();
                depositLabel.setText("A/C Balance " + Bank.get().getDeposit().toString());
            }
        });

        VBox root = new VBox();

        root.getChildren().add(depositLabel);

        HBox hBox1 = new HBox();
        hBox1.getChildren().add(amountLabel);
        hBox1.getChildren().add(amountTextField);
        hBox1.setSpacing(5);

        root.getChildren().add(hBox1);

        HBox hBox = new HBox();
        hBox.getChildren().add(btn);
        hBox.getChildren().add(withdraw);
        hBox.getChildren().add(interestBtn);
        hBox.setSpacing(5);

        root.getChildren().add(hBox);

        root.getChildren().add(new Separator());

        Label currenciesLabel = new Label("Currency");
        final Label showConvertedDeposit = new Label();
        ObservableList<String> allCurrencies = FXCollections.observableArrayList();
        allCurrencies.add("EUR");
        allCurrencies.add("USD");
        allCurrencies.add("INR");

        final ComboBox<String> currenciesCombo = new ComboBox<>(allCurrencies);
        currenciesCombo.setValue("EUR");

        Button showInNewCurrency = new Button("Convert");
        showInNewCurrency.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                showConvertedDeposit.setText("Conversion: " + BankUtility.toCurrency(currenciesCombo.getValue()));
            }
        });

        HBox hBox2 = new HBox();
        hBox2.getChildren().add(currenciesLabel);
        hBox2.getChildren().add(currenciesCombo);
        hBox2.getChildren().add(showInNewCurrency);
        hBox2.setSpacing(5);
        hBox2.setAlignment(Pos.BOTTOM_LEFT);

        root.getChildren().add(hBox2);
        root.getChildren().add(showConvertedDeposit);

        HBox hBox3 = new HBox();

        Label addCTextLabel = new Label("Add New Currency");
        final TextField addCTextField = new TextField("");
        addCTextField.setMaxWidth(100);

        Label addERTextLabel = new Label("Exchange Rate");
        final TextField addERTextField = new TextField("");
        addERTextField.setMaxWidth(100);
        Button addBtn = new Button();
        addBtn.setText("Add");
        addBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                if (addCTextField.getText().isEmpty() || addERTextField.getText().isEmpty()) {
                    return;
                }

                BankUtility.addNewCurrency(addCTextField.getText(), Double.parseDouble(addERTextField.getText()));
                allCurrencies.add(addCTextField.getText());
            }
        });

        hBox3.getChildren().add(addCTextLabel);
        hBox3.getChildren().add(addCTextField);
        hBox3.getChildren().add(addERTextLabel);
        hBox3.getChildren().add(addERTextField);
        hBox3.getChildren().add(addBtn);
        hBox3.setSpacing(5);
        hBox3.setAlignment(Pos.BOTTOM_LEFT);

        root.getChildren().add(new Separator());
        root.getChildren().add(hBox3);

        root.setSpacing(10);
        root.setPadding(new Insets(10, 10, 10, 10));

        Scene scene = new Scene(root, 500, 500);
        scene.getStylesheets().add("bank354/myStyle.css");

        primaryStage.setTitle("Bank 354");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
