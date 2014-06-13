/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman_leveleditor;

import java.awt.Color;
import java.awt.Dimension;
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

    public ComponentSelectPanel(View view) {

        this.currentView = view;
        setLayout(new GridLayout(2, 7));
        setPreferredSize(new Dimension(currentView.FRAME_WIDTH, 35));
        setBackground(Color.BLACK);

        levelComponents = new LevelComponent[2][7];

        for (ComponentType type : ComponentType.values()) {
            levelComponents.
        }

    }

    public void selectComponent() {

    }

}
