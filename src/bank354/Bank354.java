/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank354;

import bank354.util.Bank;
import bank354.util.BankUtility;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author gshenoy
 */
public class Bank354 extends Application {

    @Override
    public void start(Stage primaryStage) {

        Label depositLabel = new Label("Your deposit is: " + Bank.get().getDeposit().toString());
        Label amountLabel = new Label("Enter amount");
        final TextField amountTextField = new TextField();
        amountTextField.setMaxWidth(100);

        Button btn = new Button();
        btn.setText("Deposit");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                BankUtility.deposit(Long.parseLong(amountTextField.getText()));
                depositLabel.setText("Your deposit is: " + Bank.get().getDeposit().toString());
            }
        });

        Button withdraw = new Button();
        withdraw.setText("Withdraw");
        withdraw.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                BankUtility.withdraw(Long.parseLong(amountTextField.getText()));
                depositLabel.setText("Your deposit is: " + Bank.get().getDeposit().toString());
            }
        });

        VBox root = new VBox();
               
        root.getChildren().add(depositLabel);
        root.getChildren().add(amountLabel);
        root.getChildren().add(amountTextField);
        
        HBox hBox = new HBox();
        hBox.getChildren().add(btn);
        hBox.getChildren().add(withdraw);
        
        root.getChildren().add(hBox);

        Scene scene = new Scene(root, 500, 500);

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
