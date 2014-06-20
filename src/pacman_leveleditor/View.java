/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman_leveleditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ivanweller
 */
public class View extends JFrame {

    public LevelComponent selectedComponent;
    
    private Level levelPanel;
    private ComponentSelectPanel csPanel;

    private Container contentPane;

    private JPanel controlPanel;

    private JButton loadLevelButton;
    private JButton saveLevelButton;
    private JButton newLevelButton;

    public static final int FRAME_WIDTH = 900;
    public static final int FRAME_HEIGHT = 900;

    public View() {

        selectedComponent = new LevelComponent(ComponentType.Pacman, null, null);
        initComponents();
    }

    private void initComponents() {

        levelPanel = new Level(this);
        csPanel = new ComponentSelectPanel(this);

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setTitle("Pacman Level Editor v0.1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        setBackground(Color.DARK_GRAY);

        newLevelButton = new JButton("New Level");
        newLevelButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newLevelButtonActionPerformed(evt);
            }
        });

        saveLevelButton = new JButton("Save Level");
        saveLevelButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }

        });

        loadLevelButton = new JButton("Load Level");
        loadLevelButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        controlPanel.setBackground(Color.BLACK);

        controlPanel.add(newLevelButton);
        controlPanel.add(saveLevelButton);
        controlPanel.add(loadLevelButton);

        contentPane.add(controlPanel, BorderLayout.NORTH);
        contentPane.add(levelPanel, BorderLayout.CENTER);
        contentPane.add(csPanel, BorderLayout.EAST);

        setFocusable(true);

    }
    
    public LevelComponent getSelectedComponent(){
        return selectedComponent;
    }

    private void newLevelButtonActionPerformed(ActionEvent evt) {
        levelPanel.clearLevel();
        revalidate();

    }

    private void saveButtonActionPerformed(ActionEvent evt) {
        
        new FileManager().safeLevel(levelPanel.LevelToText());
    }
    
    private void loadButtonActionPerformed(ActionEvent evt){
        try{
            char[][] levelMap = new FileManager().loadLevel();
            if(levelMap != null){
                levelPanel.TextToLevel(levelMap);
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
        revalidate();
        
    }
}
