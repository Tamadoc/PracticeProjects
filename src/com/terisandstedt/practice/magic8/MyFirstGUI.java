package com.terisandstedt.practice.magic8;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MyFirstGUI {

    public static void main(String[] args) {

        // Create the app window
        JFrame frame = new JFrame("Chat Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);

        // Create the Menu bar
        JMenuBar menuBar = new JMenuBar();

        // Build the File menu
        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        // File menu items
        JMenuItem menuItem = new JMenuItem("Open");
        menu.add(menuItem);

        menuItem = new JMenuItem("Save as");
        menu.add(menuItem);

        // Build the help menu
        menu = new JMenu("Help");
        menuBar.add(menu);

        // No help menu items

        // Create content area with margin
        JPanel contentPanel = new JPanel(new BorderLayout());
        frame.add(contentPanel);
        Border border = BorderFactory.createEmptyBorder(5,5,5,5);
        contentPanel.setBorder(border);

        // Create display area with beveled border and add it to the content area
        JTextArea textArea = new JTextArea("This is a non-editable chat window that will show your message history" +
                                                   ".\n\nNone of the buttons or menu items in this GUI work. This is " +
                                                   "just to learn how to build a GUI.\n\nMaking it do stuff is the " +
                                                   "next step in my learning journey.");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        border = BorderFactory.createLoweredBevelBorder();
        textArea.setBorder(border);
        contentPanel.add(textArea);

        // Create UI elements
        JPanel entryPanel = new JPanel();

        // Create message entry field and label
        JLabel label = new JLabel("Enter Text");
        entryPanel.add(label);

        JTextField textField = new JTextField(20);
        entryPanel.add(textField);

        // Create buttons
        JButton button = new JButton("Send");
        entryPanel.add(button);

        button = new JButton("Reset");
        entryPanel.add(button);

        // Format and show frame (window)
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(contentPanel, BorderLayout.CENTER);
        frame.getContentPane().add(entryPanel, BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null); // Positions window in the center of the screen
        frame.setVisible(true);
    }
}
