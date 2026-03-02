package com.matthewpittendreigh.portfolio;


public class GameController {
    private Board gameBoard;
    private GameView gameView;

    public GameController(int dim) {
        // Board object initialization
        gameBoard = new Board(dim);
        gameView = new GameView(this);
        gameView.renderGame(EightQueens.root);
    }
    
    public int getDimension() {
        return this.gameBoard.dim;
    }

    public void toggleQueen(int row, int column) {
        if(gameBoard.boardArray[row][column]) //on press of tile that is already a queen
        {
            gameBoard.boardArray[row][column] = false;
            gameBoard.numLeft++;
            
            // Call gameview remove piece
            gameView.removeQueen(row, column, gameBoard.numLeft);
        }
        else //on press of empty tile
        {
            if(gameBoard.numLeft > 0)
            {
                gameBoard.boardArray[row][column] = true;
                gameBoard.numLeft--;
                
                if(gameBoard.numLeft == 0)
                {
                    checkWinState();
                }

                // Call gameview place piece
                gameView.placeQueen(row, column, gameBoard.numLeft);
            }
        }
    }

    // Check for win-state
    public void checkWinState() {
        //checking and displaying win sequence
        if(gameBoard.checkCorrect()) 
        {
            PrimaryController.startWin();
        }
    }
}
