package org.example;

import org.example.logic.GameLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class GameFrame extends JFrame {

    private GameLogic gameLogic;
    private Timer timer;
    private JPanel gamePanel;

    public GameFrame() {
        initGame();
    }

    private void initGame() {
        gameLogic = new GameLogic();
        timer = new Timer(140, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (gameLogic.isInGame()) {
                    gameLogic.checkApple();
                    gameLogic.checkCollision();
                    gameLogic.move();
                }
                gamePanel.repaint();
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

        gamePanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Displaying points
                String scoreText = "Score: " + GameLogic.getScore();
                g.setColor(Color.BLACK);
                g.drawString(scoreText, 10, GameLogic.HEIGHT - 10);

                if (gameLogic.isInGame()) {
                    g.setColor(Color.RED);
                    Point applePos = gameLogic.getApple().getPosition();
                    g.fillOval(applePos.x, applePos.y, GameLogic.SIZE, GameLogic.SIZE);

                    LinkedList<Point> snakeBody = gameLogic.getSnake().getBody();
                    for (int z = 0; z < snakeBody.size(); z++) {
                        if (z == 0) {
                            g.setColor(Color.GREEN);
                        } else {
                            g.setColor(Color.YELLOW);
                        }
                        Point pos = snakeBody.get(z);
                        g.fillRect(pos.x, pos.y, GameLogic.SIZE, GameLogic.SIZE);
                    }
                }
                if (!gameLogic.isInGame()) {
                    String msg = "Game Over";
                    Font font = new Font("SAN_SERIF", Font.BOLD, 14);
                    FontMetrics metrics = getFontMetrics(font);

                    g.setColor(Color.BLACK);
                    g.setFont(font);
                    g.drawString(msg, (GameLogic.WIDTH - metrics.stringWidth(msg)) / 2, GameLogic.HEIGHT / 2);
                }


            }
        };
        gamePanel.setPreferredSize(new Dimension(GameLogic.WIDTH, GameLogic.HEIGHT));
        add(gamePanel);
        pack();

        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
        setFocusable(true);

        timer.start();
    }
}

