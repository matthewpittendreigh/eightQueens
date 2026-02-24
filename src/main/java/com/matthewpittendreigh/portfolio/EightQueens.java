package com.matthewpittendreigh.portfolio;

import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class EightQueens extends Application {
    static StackPane root = new StackPane();
    
    @Override
    public void start(Stage primaryStage) {

        PrimaryController.startMenu();
        
        Scene scene = new Scene(root, 650, 800);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("EightQueensStyle.css").toExternalForm());
        primaryStage.setTitle("Eight Queens");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}