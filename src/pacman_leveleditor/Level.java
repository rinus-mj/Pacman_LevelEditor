/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman_leveleditor;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author ivanweller
 */
public class Level extends JPanel {

    private LevelComponent[][] levelMap;
    private View view;
    private LevelComponent selectedComponent;

    private final int HEIGHT = 31;
    private final int WIDTH = 28;

    public Level(View view) {
        this.view = view;
        this.selectedComponent = view.selectedComponent;
        levelMap = new LevelComponent[HEIGHT][WIDTH];
        initComponents();
        setBackground(Color.BLACK);

    }

    private void initComponents() {

        setLayout(new GridLayout(HEIGHT, WIDTH));

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {

                levelMap[i][j] = new LevelComponent(ComponentType.Empty, this, selectedComponent);
                add(levelMap[i][j]);
            }
        }

    }

    public void TextToLevel(char[][] levelMap) {
        removeAll();

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                System.out.print(levelMap[i][j]);
            }
            System.out.println("");
        }

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                switch (levelMap[i][j]) {
                    case '-':
                        add(new LevelComponent(ComponentType.Empty, this, selectedComponent));
                        break;
                    case 'P':
                        add(new LevelComponent(ComponentType.Pacman, this, selectedComponent));
                        break;
                    case 'a':
                        add(new LevelComponent(ComponentType.GhostOrange, this, selectedComponent));
                        break;
                    case 'b':
                        add(new LevelComponent(ComponentType.GhostPink, this, selectedComponent));
                        break;
                    case 'c':
                        add(new LevelComponent(ComponentType.GhostRed, this, selectedComponent));
                        break;
                    case 'd':
                        add(new LevelComponent(ComponentType.GhostCyan, this, selectedComponent));
                        break;
                    case '0':
                        add(new LevelComponent(ComponentType.Pellet, this, selectedComponent));
                        break;
                    case '2':
                        add(new LevelComponent(ComponentType.SuperPellet, this, selectedComponent));
                        break;
                    case 'S':
                        add(new LevelComponent(ComponentType.WallHorizontal, this, selectedComponent));
                        break;
                    case 'A':
                        add(new LevelComponent(ComponentType.WallVertical, this, selectedComponent));
                        break;
                    case 'Q':
                        add(new LevelComponent(ComponentType.WallUpLeftCorner, this, selectedComponent));
                        break;
                    case 'W':
                        add(new LevelComponent(ComponentType.WallUpRightCorner, this, selectedComponent));
                        break;
                    case 'R':
                        add(new LevelComponent(ComponentType.WallDownLeftCorner, this, selectedComponent));
                        break;
                    case 'E':
                        add(new LevelComponent(ComponentType.WallDownRightCorner, this, selectedComponent));
                        break;
                    case 'G':
                        add(new LevelComponent(ComponentType.WallTLeft, this, selectedComponent));
                        break;
                    case 'H':
                        add(new LevelComponent(ComponentType.WallTRight, this, selectedComponent));
                        break;
                    case 'I':
                        add(new LevelComponent(ComponentType.WallTUp, this, selectedComponent));
                        break;
                    case 'J':
                        add(new LevelComponent(ComponentType.WallTDown, this, selectedComponent));
                        break;
                    case 'D':
                        add(new LevelComponent(ComponentType.WallEmpty, this, selectedComponent));
                        break;
                    case 'w':
                        add(new LevelComponent(ComponentType.Empty, this, selectedComponent));
                        break;
                }

            }
        }
    }

    public char[][] LevelToText() {
        char[][] levelMap = new char[HEIGHT][WIDTH];
        int index = 0;
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {

                Component a = getComponent(index);
                if (a instanceof LevelComponent) {
                    LevelComponent c = (LevelComponent) a;

                    switch (c.getType()) {
                        case Empty:
                            levelMap[i][j] = '-';
                            break;
                        case Pacman:
                            levelMap[i][j] = 'P';
                            break;
                        case GhostOrange:
                            levelMap[i][j] = 'a';
                            break;
                        case GhostPink:
                            levelMap[i][j] = 'b';
                            break;
                        case GhostRed:
                            levelMap[i][j] = 'c';
                            break;
                        case GhostCyan:
                            levelMap[i][j] = 'd';
                            break;
                        case Pellet:
                            levelMap[i][j] = '0';
                            break;
                        case SuperPellet:
                            levelMap[i][j] = '2';
                            break;
                        case WallHorizontal:
                            levelMap[i][j] = 'S';
                            break;
                        case WallVertical:
                            levelMap[i][j] = 'A';
                            break;
                        case WallUpLeftCorner:
                            levelMap[i][j] = 'Q';
                            break;
                        case WallUpRightCorner:
                            levelMap[i][j] = 'W';
                            break;
                        case WallDownLeftCorner:
                            levelMap[i][j] = 'R';
                            break;
                        case WallDownRightCorner:
                            levelMap[i][j] = 'E';
                            break;
                        case WallTUp:
                            levelMap[i][j] = 'I';
                            break;
                        case WallTDown:
                            levelMap[i][j] = 'J';
                            break;
                        case WallTLeft:
                            levelMap[i][j] = 'G';
                            break;
                        case WallTRight:
                            levelMap[i][j] = 'H';
                            break;
                        case WallEmpty:
                            levelMap[i][j] = 'D';
                            break;

                    }
                }
                index++;
            }
        }
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                System.out.print(levelMap[i][j]);
            }
            System.out.println("");
        }
        return levelMap;

    }

    public void clearLevel() {
        removeAll();
        initComponents();

    }

}
