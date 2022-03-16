package com.codegym.games.snake;
import com.codegym.engine.cell.*;
import java.util.List;
import java.util.ArrayList;

public class Snake {
    
    private List<GameObject> snakeParts = new ArrayList<>();
    private int initialSize = 3;
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    
    public Snake(int x, int y) {
        GameObject first = new GameObject(x, y);
        GameObject second = new GameObject(x+1, y);
        GameObject third = new GameObject(x+2, y);
        
        snakeParts.add(first);
        snakeParts.add(second);
        snakeParts.add(third);
    }
    
    public void draw(Game game) {
        
        for (int i = 0; i < snakeParts.length; i++) {
            if (i == 0)
                game.setCellValue(snakePart.x, snakePart.y, HEAD_SIGN);
            else
                game.setCellValue(snakePart.x, snakePart.y, BODY_SIGN);
        }
        
    }
}