/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman_leveleditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ivanweller
 */
public class View extends JFrame {

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

        initComponents();
    }

    private void initComponents() {

        levelPanel = new Level();
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
                newSaveButtonActionPerformed(evt);
            }

        });

        loadLevelButton = new JButton("Load Level");
        loadLevelButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSaveButtonActionPerformed(evt);
            }
        });

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        //controlPanel.setPreferredSize(new Dimension(FRAME_WIDTH, 35));
        controlPanel.setBackground(Color.BLACK);

        controlPanel.add(newLevelButton);
        controlPanel.add(saveLevelButton);
        controlPanel.add(loadLevelButton);

        contentPane.add(controlPanel, BorderLayout.NORTH);
        contentPane.add(levelPanel, BorderLayout.CENTER);
        contentPane.add(csPanel, BorderLayout.EAST);

        setFocusable(true);

    }

    private void newLevelButtonActionPerformed(ActionEvent evt) {
        levelPanel = null;
        Level level = new Level();
        initComponents();
    }

    private void newSaveButtonActionPerformed(ActionEvent evt) {

    }
}
