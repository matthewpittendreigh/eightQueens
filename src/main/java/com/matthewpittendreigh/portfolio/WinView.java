package com.matthewpittendreigh.portfolio;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.image.ImageView;

public class WinView {
    public static void render(StackPane root)
    {
        ImageView backImageView = new ImageView("images/backIcon3.png");
        backImageView.setFitHeight(48);
        backImageView.setFitWidth(48);

        Button mainMenuButton = new Button("  Return to Main Menu", backImageView);
        mainMenuButton.setPrefSize(300, 60);
        mainMenuButton.setFont(Font.font("paletino", FontWeight.BOLD, 20));
        mainMenuButton.setTextFill(Paint.valueOf("353535"));
        mainMenuButton.setId("mainMenuButton");

        HBox backButtonAlignmentBox = new HBox(mainMenuButton);
        backButtonAlignmentBox.setPadding(new Insets(0,0,30,40));
        backButtonAlignmentBox.setAlignment(Pos.TOP_LEFT);

        Label winLabel = new Label("Congrats you've won!");
        winLabel.setAlignment(Pos.CENTER);
        winLabel.setPrefSize(500, 100);
        winLabel.setFont(Font.font("paletino", FontWeight.BOLD, 33));
        winLabel.setTextFill(Paint.valueOf("ffffff"));
        VBox winLayoutBox = new VBox(20,backButtonAlignmentBox,winLabel);
        winLayoutBox.setAlignment(Pos.CENTER);
        backButtonAlignmentBox.setPadding(new Insets(0,0,100,0));
        backButtonAlignmentBox.setAlignment(Pos.CENTER);
        root.getChildren().clear();
        root.getChildren().add(winLayoutBox);

        // button handlers
        mainMenuButton.setOnAction(e -> {
            PrimaryController.startMenu();
        });
    }
}
