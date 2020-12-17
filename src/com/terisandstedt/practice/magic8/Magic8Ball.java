package com.terisandstedt.practice.magic8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Exercise from: https://dev.to/samborick/100-project-ideas-oda
 * Magic 8 Ball - with bonus GUI
 * <p>
 * Simulate a magic 8-ball.
 * - Allow the user to enter their question.
 * - Display an in progress message(i.e. "thinking").
 * - Create 20 responses, and show a random response.
 * - Allow the user to ask another question or quit.
 * <p>
 * Bonus: Add a gui.
 * - It must have a box for users to enter the question.
 * - It must have at least 4 buttons:
 * - ask
 * - clear (the text box)
 * - play again
 * - quit (this must close the window)
 */
public class Magic8Ball {

    public static void main(String[] args) {

        Magic8GUI appGUI = new Magic8GUI();
        appGUI.OpenWindow();
    }
}

class Magic8GUI implements ActionListener {

    Font italicFont = new Font("Serif", Font.ITALIC, 28);
    JTextField questionField;
    JLabel answerField;
    boolean hasAsked = false;

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "ask":
                if (questionField.getText().isEmpty() || hasAsked ) {
                    answerField.setText("Write a question in the text box");
                }
                else {
                    answerField.setText(getAnswer());
                    questionField.setEditable(false);
                    questionField.setCaretColor(Color.LIGHT_GRAY);
                    hasAsked = true;
                }
                break;
            case "quit":
                System.exit(0);
                break;
            default:
                answerField.setText(" ");
                questionField.setText("");
                questionField.setEditable(true);
                questionField.grabFocus();
                questionField.setCaretColor(Color.BLACK);
                hasAsked = false;
                break;
        }
    }

    void OpenWindow() {
        JFrame window = new JFrame("Magic 8-Ball");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(420, 430);
        window.setLocationRelativeTo(null);
        window.setUndecorated(true);

        JPanel contentPanel = getContentPanel();
        JPanel buttonPanel = getButtonPanel();

        window.add(contentPanel);
        window.add(buttonPanel, BorderLayout.PAGE_END);
        window.setVisible(true);
    }

    private JPanel getContentPanel() {
        // Create and format content panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBackground(Color.BLACK);
        panel.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0));

        // Create prompt text
        JLabel prompt = new JLabel("State your question");
        prompt.setAlignmentX(Component.CENTER_ALIGNMENT);
        prompt.setForeground(Color.LIGHT_GRAY);
        prompt.setFont(italicFont);

        // Create number 8
        JLabel eight = new JLabel("8");
        eight.setAlignmentX(Component.CENTER_ALIGNMENT);
        eight.setForeground(Color.LIGHT_GRAY);
        eight.setFont(new Font("Serif", Font.BOLD, 160));

        // Create answer text
        answerField = new JLabel();
        answerField.setText(" ");
        answerField.setAlignmentX(Component.CENTER_ALIGNMENT);
        answerField.setForeground(Color.LIGHT_GRAY);
        answerField.setFont(italicFont);

        // Add components to display
        panel.add(prompt);
        panel.add(eight);
        panel.add(answerField);
        panel.add(getInputPanel());

        return panel;
    }

    private JPanel getInputPanel() {
        // Create and format input panel
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        // Create question field
        questionField = new JTextField(30);
        questionField.setText("");
        questionField.addActionListener(this);
        questionField.setActionCommand("ask");
        questionField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        questionField.setBackground(Color.LIGHT_GRAY);

        panel.add(questionField);

        return panel;
    }

    private JPanel getButtonPanel() {
        //Create and format button panel
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 20, 10, 20));

        JPanel input = createInputButtons();
        JPanel app = createAppButtons();

        panel.add(input);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(app);

        return panel;
    }

    private JPanel createInputButtons() {
        //Create and format button panel
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        // Create buttons
        JButton askButton = new JButton("Ask question");
        JButton clearButton = new JButton("       Clear       ");

        // Add action listeners
        askButton.addActionListener(this);
        askButton.setActionCommand("ask");
        clearButton.addActionListener(this);
        clearButton.setActionCommand("clear");

        // Add buttons, centered and with space between them
        panel.add(Box.createHorizontalGlue());
        panel.add(askButton);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        panel.add(clearButton);
        panel.add(Box.createHorizontalGlue());

        return panel;
    }

    private JPanel createAppButtons() {
        //Create and format button panel
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        //panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        // Create buttons
        JButton redoButton = new JButton("Redo");
        JButton quitButton = new JButton("Quit");

        // Add action listeners
        redoButton.addActionListener(this);
        redoButton.setActionCommand("redo");
        quitButton.addActionListener(this);
        quitButton.setActionCommand("quit");

        // Add buttons, right-aligned and with space between them
        panel.add(Box.createHorizontalGlue());
        panel.add(redoButton);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        panel.add(quitButton);

        return panel;
    }

    private String getAnswer(){
        Random random = new Random();
        String[] answers = {
                "Yes",
                "Absolutely",
                "No doubt about it",
                "Of course",
                "Always",
                "The outlook is good",
                "Almost certainly",
                "Maybe",
                "The truth is unclear",
                "There's a 50/50 chance",
                "You know the truth already",
                "Possibly",
                "Unlikely",
                "No",
                "Not at this time",
                "Never",
                "It's doubtful",
                "Not a chance",
                "Sorry, not gonna happen",
                "Probably not"
        };

        return answers[random.nextInt(answers.length)];
    }
}