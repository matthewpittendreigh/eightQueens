package com.matthewpittendreigh.portfolio;

import javafx.scene.layout.StackPane;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MenuView {
    public static StackPane render(StackPane root) {
        //clear pane elements
        root.getChildren().clear();
        
        //instantiation of main menu elements
        Label titleLabel = new Label("Eight Queens Puzzle");
        Button fourQueensButton = new Button("Four Queens");
        Button fiveQueensButton = new Button("Five Queens");
        Button sixQueensButton = new Button("Six Queens");
        Button sevenQueensButton = new Button("Seven Queens");
        Button eightQueensButton = new Button("Eight Queens");
        Button aboutPageButton = new Button("About");
        
        //main menu vbox initialization and manipulation
        VBox mainMenuBox = new VBox(33, titleLabel, fourQueensButton,fiveQueensButton, 
            sixQueensButton, sevenQueensButton, eightQueensButton, aboutPageButton);
        mainMenuBox.setAlignment(Pos.CENTER);
        titleLabel.setAlignment(Pos.CENTER);
        
        //main menu title bar manipulation 
        titleLabel.setPrefSize(500, 100);
        titleLabel.setFont(Font.font("paletino", FontWeight.BOLD, 50));
        titleLabel.setTextFill(Paint.valueOf("ffffff"));
        
        //main menu object manipulation
        Button[] setupArray = {fourQueensButton, fiveQueensButton, sixQueensButton, 
            sevenQueensButton, eightQueensButton, aboutPageButton};
        for(int i = 0; i < setupArray.length; i++)
        {
            setupArray[i].setPrefSize(350, 60);
            setupArray[i].setFont(Font.font("paletino", FontWeight.BOLD, 30));
            setupArray[i].setTextFill(Paint.valueOf("353535"));
            setupArray[i].getStyleClass().add("mainButtonArchtype");
        }
        
        //display
        root.getChildren().add(mainMenuBox);
        
        //button handlers
        fourQueensButton.setOnAction(e -> PrimaryController.startGame(4));
        fiveQueensButton.setOnAction(e -> PrimaryController.startGame(5));
        sixQueensButton.setOnAction(e -> PrimaryController.startGame(6));
        sevenQueensButton.setOnAction(e -> PrimaryController.startGame(7));
        eightQueensButton.setOnAction(e -> PrimaryController.startGame(8));
        aboutPageButton.setOnAction(e -> PrimaryController.startAbout());

        return root;
    }
}
