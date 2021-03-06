package com.codegym.games.snake;
import com.codegym.engine.cell.*;

public class SnakeGame extends Game {
    
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private int turnDelay; // ms/turn
    private Snake snake;
    
    @Override
    public void initialize() {
        setScreenSize(SnakeGame.WIDTH, SnakeGame.HEIGHT);
        createGame();
    }
    
    private void createGame() {
        turnDelay = 300;
        setTurnTimer(turnDelay);
        snake = new Snake(WIDTH / 2, HEIGHT / 2);
        drawScene();
    }
    
    private void drawScene() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                setCellValueEx(i, j, Color.DARKSEAGREEN, "");
            }
        }
        snake.draw(this);
    }
    
    @Override
    public void onTurn(int turnDelay) {
        snake.move();
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.LEFT)
            snake.setDirection(Direction.LEFT);
        else if (key == Key.RIGHT)
            snake.setDirection(Direction.RIGHT);
        else if (key == Key.UP)
            snake.setDirection(Direction.UP);
        else if (key == Key.DOWN)
            snake.setDirection(Direction.DOWN);
    }
}