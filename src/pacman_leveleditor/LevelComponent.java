/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman_leveleditor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author ivanweller
 */
public class LevelComponent extends JComponent implements MouseListener {

    private ComponentType type;
    private JPanel panel;
    private LevelComponent selectedComponent;
    private int xPos = 0;
    private int yPos = 0;

    private final int CELLSIZE = 26;

    public LevelComponent(ComponentType type, JPanel panel, LevelComponent selectedComponent) {
        this.type = type;
        this.panel = panel;
        this.selectedComponent = selectedComponent;

        addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        switch (type) {
            case Empty:
                drawEmpty(g);
                break;
            case Pacman:
                drawPacman(g);
                break;
            case GhostOrange:
                drawGhost(g, Color.ORANGE);
                break;
            case GhostPink:
                drawGhost(g, Color.PINK);
                break;
            case GhostRed:
                drawGhost(g, Color.RED);
                break;
            case GhostCyan:
                drawGhost(g, Color.CYAN);
                break;
            case Pellet:
                drawPellet(g);
                break;
            case SuperPellet:
                drawSuperPellet(g);
                break;
            case WallHorizontal:
                drawHorizontalLine(g);
                break;
            case WallVertical:
                drawVerticalLine(g);
                break;
            case WallUpLeftCorner:
                drawLeftUpCorner(g);
                break;
            case WallUpRightCorner:
                drawRightUpCorner(g);
                break;
            case WallDownLeftCorner:
                drawLeftDownCorner(g);
                break;
            case WallDownRightCorner:
                drawRightDownCorner(g);
                break;
            case WallTUp:
                drawLeftUpCorner(g);
                drawRightUpCorner(g);
                break;
            case WallTDown:
                drawLeftDownCorner(g);
                drawRightDownCorner(g);
                break;
            case WallTLeft:
                drawLeftUpCorner(g);
                drawLeftDownCorner(g);
                break;
            case WallTRight:
                drawRightUpCorner(g);
                drawRightDownCorner(g);
                break;
            case WallEmpty:
                break;
        }
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
        g.setColor(color);
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

    private void drawEmpty(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(
                0,
                0,
                CELLSIZE,
                CELLSIZE
        );
        g.setColor(Color.WHITE);
        g.drawRect(
                0,
                0,
                CELLSIZE,
                CELLSIZE
        );
    }

    public ComponentType getType() {
        return type;
    }
    

    public String toString() {
        return type.toString();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //
    }

    @Override
    public void mouseReleased(MouseEvent e) {
   
        if (panel instanceof ComponentSelectPanel && selectedComponent != null) {
            selectedComponent.type = this.type;
        } else if (panel instanceof Level && selectedComponent != null) {
            this.type = selectedComponent.type;
        }
        if (panel != null) {
            panel.repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //
    }

}
