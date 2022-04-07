package com.codegym.games.snake;
import com.codegym.engine.cell.*;
import java.util.List;
import java.time.format.SignStyle;
import java.util.ArrayList;

public class Snake {
    
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    
    private List<GameObject> snakeParts = new ArrayList<>();
    private int size = 3;
    private Direction direction = Direction.LEFT;
    public boolean isAlive = true;
    
    public Snake(int x, int y) {
        GameObject first = new GameObject(x, y);
        GameObject second = new GameObject(x+1, y);
        GameObject third = new GameObject(x+2, y);
        
        snakeParts.add(first);
        snakeParts.add(second);
        snakeParts.add(third);
    }
    
    public void draw(Game game) {
        Color snakeColor = (this.isAlive) ? Color.BLACK : Color.RED;
        String snakeSign;

        for (int i = 0; i < snakeParts.size(); i++) {
            snakeSign = (i == 0) ? HEAD_SIGN : BODY_SIGN;
            game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, snakeSign, snakeColor, 75);
        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public GameObject createNewHead() {
        GameObject oldHead = snakeParts.get(0);
        if (direction == Direction.LEFT)
            return new GameObject(oldHead.x - 1, oldHead.y);
        else if (direction == Direction.RIGHT)
            return new GameObject(oldHead.x + 1, oldHead.y);
        else if (direction == Direction.UP)
            return new GameObject(oldHead.x, oldHead.y - 1);
        else
            return new GameObject(oldHead.x, oldHead.y + 1);
    }

    public void removeTail() {
        int lastPartIndex = snakeParts.size()-1;
        snakeParts.remove(lastPartIndex);
    }
    
    public void move() {
        
    }
}