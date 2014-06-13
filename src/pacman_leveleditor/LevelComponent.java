/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman_leveleditor;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author ivanweller
 */
public class LevelComponent extends JComponent {

    private ComponentType type;
    private int xPos;
    private int yPos;

    private final int CELLSIZE = 26;

    public LevelComponent(int x, int y, ComponentType type) {

        xPos = x;
        yPos = y;

        this.type = type;
    }

    public void drawPacman(Graphics g) {
        //body
        g.setColor(Color.YELLOW);
        g.fillOval(
                xPos * CELLSIZE - 5,
                yPos * CELLSIZE - 5,
                CELLSIZE + 10,
                CELLSIZE + 10
        );
        //eye
        g.setColor(Color.WHITE);
        g.fillOval(
                xPos * CELLSIZE + 13,
                yPos * CELLSIZE - 1,
                10,
                10
        );
        //pupil
        g.setColor(Color.BLACK);
        g.fillOval(
                xPos * CELLSIZE + 16,
                yPos * CELLSIZE + 1,
                5,
                5
        );
        //mouth
        g.fillArc(
                xPos * CELLSIZE - 5,
                yPos * CELLSIZE - 5,
                CELLSIZE + 10,
                CELLSIZE + 10,
                -25,
                45
        );

    }

    public void drawGhost(Graphics g, Color color) {
        //body
        g.fillRoundRect(
                xPos * CELLSIZE - 5,
                yPos * CELLSIZE - 5,
                CELLSIZE + 10,
                CELLSIZE + 10,
                10, 5
        );
        // eyes
        g.setColor(Color.WHITE);
        // left eye
        g.fillOval(
                xPos * CELLSIZE,
                yPos * CELLSIZE,
                12,
                12
        );
        // right eye
        g.fillOval(
                xPos * CELLSIZE + 20,
                yPos * CELLSIZE,
                12,
                12
        );
        // pupils
        g.setColor(Color.BLACK);
        // left pupil
        g.fillOval(
                xPos * CELLSIZE + 4,
                yPos * CELLSIZE + 2,
                6,
                6
        );
        // right pupil
        g.fillOval(
                xPos * CELLSIZE + 24,
                yPos * CELLSIZE + 2,
                6,
                6
        );

    }

    public void drawPellet(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(
                xPos * CELLSIZE + CELLSIZE / 2 - 3,
                yPos * CELLSIZE + CELLSIZE / 2 - 3,
                6, 6
        );
    }

    public void drawSuperPellet(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(
                xPos * CELLSIZE + CELLSIZE / 2 - 10,
                yPos * CELLSIZE + CELLSIZE / 2 - 10,
                20, 20
        );
    }

    private void drawLeftUpCorner(Graphics g) {
        g.setColor(Color.cyan);
        g.drawArc(
                xPos * CELLSIZE + 9,
                yPos * CELLSIZE + 9,
                32,
                32,
                90,
                90
        );
        g.drawArc(
                xPos * CELLSIZE + 15,
                yPos * CELLSIZE + 15,
                20,
                20,
                90,
                90
        );
        g.setColor(Color.BLUE);
        g.drawArc(
                xPos * CELLSIZE + 8,
                yPos * CELLSIZE + 8,
                32,
                32,
                90,
                90
        );
        g.drawArc(
                xPos * CELLSIZE + 16,
                yPos * CELLSIZE + 16,
                20,
                20,
                90,
                90
        );
    }

    private void drawLeftDownCorner(Graphics g) {
        g.setColor(Color.cyan);
        g.drawArc(
                xPos * CELLSIZE + 9,
                yPos * CELLSIZE - 17,
                32,
                32,
                180,
                90
        );
        g.drawArc(
                xPos * CELLSIZE + 15,
                yPos * CELLSIZE - 11,
                20,
                20,
                180,
                90
        );
        g.setColor(Color.BLUE);
        g.drawArc(
                xPos * CELLSIZE + 8,
                yPos * CELLSIZE - 16,
                32,
                32,
                180,
                90
        );
        g.drawArc(
                xPos * CELLSIZE + 16,
                yPos * CELLSIZE - 11,
                19,
                19,
                180,
                90
        );
    }

    private void drawRightUpCorner(Graphics g) {
        g.setColor(Color.cyan);
        g.drawArc(
                xPos * CELLSIZE - 16,
                yPos * CELLSIZE + 9,
                31,
                31,
                0,
                90
        );
        g.drawArc(
                xPos * CELLSIZE - 11,
                yPos * CELLSIZE + 15,
                20,
                20,
                0,
                90
        );
        g.setColor(Color.BLUE);
        g.drawArc(
                xPos * CELLSIZE - 15,
                yPos * CELLSIZE + 8,
                31,
                31,
                0,
                90
        );
        g.drawArc(
                xPos * CELLSIZE - 12,
                yPos * CELLSIZE + 16,
                20,
                20,
                0,
                90
        );
    }

    private void drawRightDownCorner(Graphics g) {
        g.setColor(Color.cyan);
        g.drawArc(
                xPos * CELLSIZE - 17,
                yPos * CELLSIZE - 17,
                32,
                32,
                270,
                90
        );
        g.drawArc(
                xPos * CELLSIZE - 11,
                yPos * CELLSIZE - 11,
                20,
                20,
                270,
                90
        );
        g.setColor(Color.BLUE);
        g.drawArc(
                xPos * CELLSIZE - 17,
                yPos * CELLSIZE - 17,
                33,
                33,
                270,
                90
        );
        g.drawArc(
                xPos * CELLSIZE - 11,
                yPos * CELLSIZE - 11,
                19,
                19,
                270,
                90
        );

    }

    private void drawVerticalLine(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawLine(
                xPos * CELLSIZE + 8,
                yPos * CELLSIZE,
                xPos * CELLSIZE + 8,
                yPos * CELLSIZE + CELLSIZE
        );
        g.drawLine(
                xPos * CELLSIZE + 16,
                yPos * CELLSIZE,
                xPos * CELLSIZE + 16,
                yPos * CELLSIZE + CELLSIZE
        );
        g.setColor(Color.cyan);
        g.drawLine(
                xPos * CELLSIZE + 9,
                yPos * CELLSIZE,
                xPos * CELLSIZE + 9,
                yPos * CELLSIZE + CELLSIZE
        );
        g.drawLine(
                xPos * CELLSIZE + 15,
                yPos * CELLSIZE,
                xPos * CELLSIZE + 15,
                yPos * CELLSIZE + CELLSIZE
        );
    }

    private void drawHorizontalLine(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawLine(
                xPos * CELLSIZE,
                yPos * CELLSIZE + 8,
                xPos * CELLSIZE + CELLSIZE - 1,
                yPos * CELLSIZE + 8
        );
        g.drawLine(
                xPos * CELLSIZE,
                yPos * CELLSIZE + 16,
                xPos * CELLSIZE + CELLSIZE - 1,
                yPos * CELLSIZE + 16
        );

        g.setColor(Color.cyan);
        g.drawLine(
                xPos * CELLSIZE,
                yPos * CELLSIZE + 9,
                xPos * CELLSIZE + CELLSIZE - 1,
                yPos * CELLSIZE + 9
        );
        g.drawLine(
                xPos * CELLSIZE,
                yPos * CELLSIZE + 15,
                xPos * CELLSIZE + CELLSIZE - 1,
                yPos * CELLSIZE + 15
        );
    }

}
