
package eightqueens;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class EightQueens extends Application {
    
    static Board gameBoard;
    static StackPane root = new StackPane();
    
    @Override
    public void start(Stage primaryStage) {

        startMainMenu();
        
        Scene scene = new Scene(root, 650, 800);
        scene.getStylesheets().add(getClass().getResource("EightQueensStyle.css").toExternalForm());
        primaryStage.setTitle("Eight Queens");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public static void startGame(int dim) {
        //board object setup
        gameBoard = new Board(dim);
        gameBoard.initialize();
        root.getChildren().clear();
        
        //queensNumberBox setup
        HBox queensNumberBox = new HBox(5);
        queensNumberBox.setAlignment(Pos.CENTER);
        for(int i = 0; i < dim; i++)
        {
            ImageView img = new ImageView("images/queen.png");
            img.setFitHeight(500/dim - 2.5);
            img.setFitWidth(500/dim - 2.5);
            queensNumberBox.getChildren().add(img);
        }
        
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
        backButtonAlignmentBox.setPadding(new Insets(0,0,30,40));
        backButtonAlignmentBox.setAlignment(Pos.TOP_LEFT);
        
        //gameGrid setup
        GridPane gameGrid = new GridPane();
        gameGrid.setHgap(5);
        gameGrid.setVgap(5);
        
        for(int i = 0; i<dim; i++)
        {
            for(int j = 0; j<dim; j++)
            {
                Button btn = new Button();
                btn.setOnAction(e -> {
                    int row = gameGrid.getRowIndex(btn);
                    int column = gameGrid.getColumnIndex(btn);
                    if(gameBoard.boardArray[row][column]) //on press of tile that is already a queen
                    {
                        gameBoard.boardArray[row][column] = false;
                        btn.setGraphic(null);
                        gameBoard.numLeft++;
                        ImageView img = new ImageView("images/queen.png");
                        img.setFitHeight(500/dim - 2.5);
                        img.setFitWidth(500/dim - 2.5);
                        queensNumberBox.getChildren().set(gameBoard.numLeft-1, img);
                    }
                    else //on press of empty tile
                    {
                        if(gameBoard.numLeft > 0)
                        {
                            gameBoard.boardArray[row][column] = true;
                            ImageView buttonImg = new ImageView("images/queen.png");
                            buttonImg.setFitHeight(500/dim -32.5);
                            buttonImg.setFitWidth(500/dim -32.5);
                            btn.setGraphic(buttonImg);
                            gameBoard.numLeft--;
                            
                            ImageView img = new ImageView();
                            img.setFitHeight(500/dim - 2.5);
                            img.setFitWidth(500/dim - 2.5);
                            queensNumberBox.getChildren().set(gameBoard.numLeft, img);
                        }
                    }
                   
                    //checking and displaying win sequence
                    if(gameBoard.checkCorrect() && gameBoard.numLeft == 0) 
                    {
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
                    }
                });
                btn.setPrefSize(500/dim - 2.5, 500/dim - 2.5);
                GridPane.setConstraints(btn, i, j);
                gameGrid.getChildren().add(btn);
            }
        }
        
        gameGrid.setAlignment(Pos.CENTER);
        
        //gameLayoutBox setup and display
        VBox gameLayoutBox = new VBox(20,backButtonAlignmentBox,gameGrid,queensNumberBox);
        gameLayoutBox.setAlignment(Pos.CENTER);
        root.getChildren().add(gameLayoutBox);
        
        //button handlers
        mainMenuButton.setOnAction(e -> {
            
            startMainMenu();
        
        });
    }
    
    public static void startMainMenu(){
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
        fourQueensButton.setOnAction(e -> startGame(4));
        fiveQueensButton.setOnAction(e -> startGame(5));
        sixQueensButton.setOnAction(e -> startGame(6));
        sevenQueensButton.setOnAction(e -> startGame(7));
        eightQueensButton.setOnAction(e -> startGame(8));
        aboutPageButton.setOnAction(e -> startAboutPage());
    }
    
    public static void startAboutPage()
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
            
            startMainMenu();
        
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
