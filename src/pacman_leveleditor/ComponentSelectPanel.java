/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman_leveleditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author ivanweller
 */
class ComponentSelectPanel extends JPanel {

    private LevelComponent selectedComponent;

    private View currentView;

    private LevelComponent[][] levelComponents;

    private final int ROWS = 7;
    private final int COLS = 2;
    
    private JPanel componentPanel;
    private JPanel selectedComponentPanel;

    public ComponentSelectPanel(View view) {

        this.currentView = view;

        setPreferredSize(new Dimension(80, 240));
        setBackground(Color.BLACK);

        initComponents();
        createLevelComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        
        selectedComponent = new LevelComponent(0, 0, ComponentType.Empty);
        selectedComponent.setSize(40, 40);
        componentPanel = new JPanel(new GridLayout(ROWS, COLS));
        selectedComponentPanel = new JPanel();
        levelComponents = new LevelComponent[ROWS][COLS];
        
        selectedComponentPanel.add(selectedComponent);
        add(componentPanel, BorderLayout.CENTER);
        add(selectedComponentPanel, BorderLayout.SOUTH);

    }

    private void createLevelComponents() {
        int index = 0;
        for (int x = 0; x < ROWS; x++) {
            for (int y = 0; y < COLS; y++) {
                LevelComponent component = new LevelComponent(0, 0, ComponentType.values()[index]);
                levelComponents[x][y] = component;
                component.setSize(40, 40);
                componentPanel.add(component);
                index++;
            }
        }

    }

//    @Override
//    public void paintComponent(Graphics g) {
//        for (int x = 0; x < ROWS; x++) {
//            for (int y = 0; y < COLS; y++) {
//                levelComponents[x][y] = component;
//            }
//        }
//    }

    public void selectComponent() {

    }

}
