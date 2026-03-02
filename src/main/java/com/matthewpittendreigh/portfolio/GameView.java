package com.matthewpittendreigh.portfolio;

import javafx.scene.layout.StackPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.image.ImageView;

public class GameView {
    GameController game;
    GridPane gameGrid;
    HBox queensNumberBox;

    public GameView(GameController game) {
        this.game = game;
        this.gameGrid = new GridPane();
        this.queensNumberBox = new HBox(5);
    }

    public void renderGame(StackPane root) {
        int dim = this.game.getDimension();

        // queensNumberBox setup
        this.queensNumberBox.setAlignment(Pos.CENTER);
        for(int i = 0; i < dim; i++)
        {
            ImageView img = new ImageView("images/queen.png");
            img.setFitHeight(500/dim - 2.5);
            img.setFitWidth(500/dim - 2.5);
            this.queensNumberBox.getChildren().add(img);
        }
        
        // back button setup
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
        
        this.gameGrid.setHgap(5);
        this.gameGrid.setVgap(5);
        
        for(int i = 0; i<dim; i++)
        {
            for(int j = 0; j<dim; j++)
            {
                Button btn = new Button();
                btn.setOnAction(e -> {
                    int row = this.gameGrid.getRowIndex(btn);
                    int column = this.gameGrid.getColumnIndex(btn);
                    System.out.println("row: " + row + ", column: " + column);
                    game.toggleQueen(row, column);
                });
                btn.setPrefSize(500/dim - 2.5, 500/dim - 2.5);
                GridPane.setConstraints(btn, i, j);
                gameGrid.getChildren().add(btn);
            }
        }
        
        gameGrid.setAlignment(Pos.CENTER);
        
        // gameLayoutBox setup and display
        VBox gameLayoutBox = new VBox(20,backButtonAlignmentBox,gameGrid,queensNumberBox);
        gameLayoutBox.setAlignment(Pos.CENTER);
        root.getChildren().clear();
        root.getChildren().add(gameLayoutBox);
        
        // button handlers
        mainMenuButton.setOnAction(e -> {
            PrimaryController.startMenu();
        });
    }

    private Button getGridBtn(int row, int column){
        return (Button)this.gameGrid.getChildren().get(column*this.game.getDimension()+row);
    }

    public void placeQueen(int row, int column, int numLeft) {
        int dim = this.game.getDimension();
        ImageView buttonImg = new ImageView("images/queen.png");
        buttonImg.setFitHeight(500/dim -32.5);
        buttonImg.setFitWidth(500/dim -32.5);
        getGridBtn(row, column).setGraphic(buttonImg);
        
        ImageView img = new ImageView();
        img.setFitHeight(500/dim - 2.5);
        img.setFitWidth(500/dim - 2.5);
        this.queensNumberBox.getChildren().set(numLeft, img);
    }

    public void removeQueen(int row, int column, int numLeft) {
        int dim = this.game.getDimension();
        getGridBtn(row, column).setGraphic(null);
        
        ImageView img = new ImageView("images/queen.png");
        img.setFitHeight(500/dim - 2.5);
        img.setFitWidth(500/dim - 2.5);
        this.queensNumberBox.getChildren().set(numLeft-1, img);
    }

    /*public static void displayWinScreen() {
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
    }*/
}
