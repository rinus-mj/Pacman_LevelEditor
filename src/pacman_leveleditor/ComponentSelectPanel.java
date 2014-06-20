/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman_leveleditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ivanweller
 */
class ComponentSelectPanel extends JPanel {

    private LevelComponent selectedComponent;

    private View currentView;

    private LevelComponent[][] levelComponents;

    private final int ROWS = 10;
    private final int COLS = 2;

    private JPanel componentPanel;
    private JPanel selectedComponentPanel;

    public ComponentSelectPanel(View view) {

        this.currentView = view;
        setBackground(Color.BLACK);
        this.selectedComponent = view.selectedComponent;
        initComponents();
        createLevelComponents();

        selectedComponentPanel.add(selectedComponent, BorderLayout.CENTER);
        selectedComponent.setVisible(true);

        repaint();

    }

    private void initComponents() {
        setLayout(new BorderLayout());

        componentPanel = new JPanel(new GridLayout(ROWS, COLS));
        componentPanel.setPreferredSize(new Dimension(80, 400));
        selectedComponentPanel = new JPanel(new BorderLayout());
        selectedComponentPanel.setPreferredSize(new Dimension(80, 80));
        levelComponents = new LevelComponent[ROWS][COLS];
        JLabel lable = new JLabel("Selected Component");
        selectedComponentPanel.add(lable, BorderLayout.NORTH);

        add(componentPanel, BorderLayout.NORTH);
        add(selectedComponentPanel, BorderLayout.CENTER);

    }

    private void createLevelComponents() {
        int index = 0;
        for (int x = 0; x < ROWS; x++) {
            for (int y = 0; y < COLS; y++) {
                if (index < ComponentType.values().length) {
                    LevelComponent component = new LevelComponent(ComponentType.values()[index], this, selectedComponent);
                    levelComponents[x][y] = component;

                    componentPanel.add(component);
                }
                index++;

            }
        }

    }


}
