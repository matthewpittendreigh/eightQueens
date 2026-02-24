package com.matthewpittendreigh.portfolio;

import javafx.scene.layout.StackPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.image.ImageView;

public class AboutView {
    public static void render(StackPane root)
    {
        //clear pane elements
        root.getChildren().clear();
        
        //back button setup
        ImageView backImageView = new ImageView("images/backIcon3.png");
        backImageView.setFitHeight(48);
        backImageView.setFitWidth(48);
        Button mainMenuButton = new Button("  Return to Main Menu", backImageView);
        mainMenuButton.setPrefSize(300, 60);
        mainMenuButton.setFont(Font.font("paletino", FontWeight.BOLD, 20));
        mainMenuButton.setTextFill(Paint.valueOf("353535"));
        mainMenuButton.setId("mainMenuButton");
        HBox backButtonAlignmentBox = new HBox(mainMenuButton);
        backButtonAlignmentBox.setPadding(new Insets(20,0,15,40));
        backButtonAlignmentBox.setAlignment(Pos.TOP_LEFT);
        
        //button handlers
        mainMenuButton.setOnAction(e -> {
            
            PrimaryController.startMenu();
        
        });
        
        //about page label manipulation 
        Label titleLabel = new Label("About the Eight Queens Puzzle");
        titleLabel.setPrefSize(500, 50);
        titleLabel.setFont(Font.font("paletino", FontWeight.BOLD, 25));
        titleLabel.setTextFill(Paint.valueOf("ffffff"));
        titleLabel.setAlignment(Pos.CENTER);
        
        //text box setup and manipulation
        Label textBox1 = new Label("The Eight Queens Puzzle challenges the player "
        + "to determine a pattern for placing 8 queens on a standard 8 by 8 chess "
        + "board so that no two queens threaten eachother. The problem can be "
        + "generalized to placing n queens on an n by n chess board. So, in "
        + "preparation for tackling the full Eight Queens Problem, some smaller "
        + "puzzles have been included. ");
        Insets textBoxPadding = new Insets(0,20,0,20);
        textBox1.setPadding(textBoxPadding);
        textBox1.setWrapText(true);
        textBox1.setFont(Font.font("paletino", FontWeight.BOLD, 20));
        textBox1.setTextFill(Paint.valueOf("ffffff"));
        
        //eight queens solution
        ImageView solutionImageView = new ImageView("images/8QueensSolution.png");
        solutionImageView.setFitHeight(275);
        solutionImageView.setFitWidth(275);
        
        Label textBox2 = new Label("Here is a solution to the Eight Queens Problem. "
        + "There are 92 total solutions, however most of these are reflections or "
        + "rotations of other solutions. Excluding these repeats there are 12 "
        + "distinct solutions.");
        textBox2.setPadding(textBoxPadding);
        textBox2.setWrapText(true);
        textBox2.setFont(Font.font("paletino", FontWeight.BOLD, 20));
        textBox2.setTextFill(Paint.valueOf("ffffff"));
        
        //about page vbox initialization and manipulation
        VBox aboutPageBox = new VBox(15,backButtonAlignmentBox,titleLabel,textBox1,solutionImageView,textBox2);
        aboutPageBox.setAlignment(Pos.CENTER);
        
        root.getChildren().add(aboutPageBox);
        
    }
}
