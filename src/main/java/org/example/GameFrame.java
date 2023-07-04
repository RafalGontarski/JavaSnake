package org.example;

import org.example.logic.GameLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                }
            }
        });
    }
}
