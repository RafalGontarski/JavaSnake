package org.example;

import org.example.logic.GameLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameFrame extends JFrame {
    private GameLogic gameLogic;
    private Timer timer;

    public GameFrame()  {
        initGame();
    }

    private void initGame() {
        gameLogic = new GameLogic();
        timer = new Timer(140, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gameLogic.isInGame()) {
                    gameLogic.checkApple();
                    gameLogic.checkCollision();
                    gameLogic.move();
                }
                repaint();
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();

                if (key == KeyEvent.VK_LEFT) {
                    gameLogic.getSnake().setDirection(new Point(-GameLogic.SIZE, 0));
                } else if (key == KeyEvent.VK_RIGHT) {
                    gameLogic.getSnake().setDirection(new Point(GameLogic.SIZE, 0));
                } else if (key == KeyEvent.VK_UP) {
                    gameLogic.getSnake().setDirection(new Point(0, -GameLogic.SIZE));
                } else if (key == KeyEvent.VK_DOWN) {
                    gameLogic.getSnake().setDirection(new Point(0, GameLogic.SIZE));
                }
            }
        });
    }
}
