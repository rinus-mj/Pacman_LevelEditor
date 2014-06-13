/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman_leveleditor;

import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author ivanweller
 */
public class Level extends JPanel {

    private LevelComponent[][] levelMap;

    private final int HEIGHT = 30;
    private final int WIDTH = 28;

    public Level() {

        levelMap = new LevelComponent[WIDTH][HEIGHT];
        initComponents();

    }

    private void initComponents() {

        setLayout(new GridLayout(WIDTH, HEIGHT));

        for (int i = 0; i < WIDTH - 1; i++) {
            for (int j = 0; j < HEIGHT - 1; j++) {

                levelMap[i][j] = new LevelComponent(i, j, ComponentType.Empty);
                add(levelMap[i][j]);
            }
        }

    }

    public void placeComponent(LevelComponent lc, int x, int y) {

        levelMap[x][y] = lc;

    }

}
