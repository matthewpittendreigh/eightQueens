package com.matthewpittendreigh.portfolio;


public class PrimaryController {
    // Call game view
    public static void startGame(int dim) {
        GameController game = new GameController(dim);
        GameView.renderGame(EightQueens.root, game);
    }

    // Call main menu view
    public static void startMenu() {
        MenuView.render(EightQueens.root);
    }

    // Call about view
    public static void startAbout() {
        AboutView.render(EightQueens.root);
    }
}
