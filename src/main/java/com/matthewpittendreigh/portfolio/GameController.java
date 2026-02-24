package com.matthewpittendreigh.portfolio;

public class GameController {
    private Board gameBoard;

    public GameController(int dim) {
        // Board object initialization
        gameBoard = new Board(dim);
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
        }
        else //on press of empty tile
        {
            if(gameBoard.numLeft > 0)
            {
                gameBoard.boardArray[row][column] = true;
                gameBoard.numLeft--;
                
                // Call gameview place piece
            }
        }
    }
}
