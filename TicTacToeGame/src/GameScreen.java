import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JFrame {
    public char currentPlayer = 'X';

    JButton row1Column1 = new JButton(""); //metodlarda kullanmak istediklerimi burda tanımladım
    JButton row1Column2 = new JButton("");
    JButton row1Column3 = new JButton("");
    JButton row2Column1 = new JButton("");
    JButton row2Column2 = new JButton("");
    JButton row2Column3 = new JButton("");
    JButton row3Column1 = new JButton("");
    JButton row3Column2 = new JButton("");
    JButton row3Column3 = new JButton("");
    JPanel scoreAndNewGamePartPanel = new JPanel();
    JLabel scoreLabel = new JLabel("");
    JPanel gamePanel = new JPanel();
    public GameScreen(){

        //frame(main window)
        this.setTitle("Tic-Tac-Toe Game"); //sets title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit from application (DO_NOTHING_ON_CLOSE çarpıya bassak da uygulama kapanmaz)
        this.setResizable(false); //prevent frame from being resized
        this.setSize(750,500); //sets the x-dimension, and y-dimension of frame

        this.setLayout(new GridLayout(1,2,2,2));

        this.setLocationRelativeTo(null);
        this.setLocation(getX(), getY());

        this.setIconImage(new ImageIcon(getClass().getResource("tic-tac-toe.png")).getImage());
        this.setVisible(true);
        //------------------------------------------------------------------------------------------------

        //Panel for score and newGameButton parts
        scoreAndNewGamePartPanel.setBackground(new Color(139, 189, 238, 255));
        scoreAndNewGamePartPanel.setBounds(0, 0, 250, 250);
        scoreAndNewGamePartPanel.setLayout(new GridLayout(2,1,2,2));

        //score label
        scoreLabel.setVisible(false);
        scoreLabel.setFont(new Font("Comic Sans",Font.BOLD,50));
        scoreLabel.setForeground(new Color(0xFFEFED65, true));
        scoreLabel.setLayout(null);
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreAndNewGamePartPanel.add(scoreLabel);

        JButton newGameButton = new JButton("New Game");
        newGameButton.setBounds(100, 100, 50, 50); //butonun yeri ve uzunluk-genişliği
        scoreAndNewGamePartPanel.add(newGameButton);

        //JPanel
        gamePanel.setBackground(new Color(139, 189, 238, 255));
        gamePanel.setBounds(0, 0, 300, 250);
        gamePanel.setLayout(new GridLayout(3,3,0,0));

        //butonların içindeki yazının fontu(times new roman vb) , kalın,altıçizili/italik vb., yazı boyutu
        row1Column1.setFont(new Font("Comic Sans",Font.BOLD,25));row1Column2.setFont(new Font("Comic Sans",Font.BOLD,25));
        row1Column3.setFont(new Font("Comic Sans",Font.BOLD,25));row2Column1.setFont(new Font("Comic Sans",Font.BOLD,25));
        row2Column2.setFont(new Font("Comic Sans",Font.BOLD,25));row2Column3.setFont(new Font("Comic Sans",Font.BOLD,25));
        row3Column1.setFont(new Font("Comic Sans",Font.BOLD,25));row3Column2.setFont(new Font("Comic Sans",Font.BOLD,25));
        row3Column3.setFont(new Font("Comic Sans",Font.BOLD,25));

        gamePanel.add(row1Column1);gamePanel.add(row1Column2);gamePanel.add(row1Column3);gamePanel.add(row2Column1);gamePanel.add(row2Column2);
        gamePanel.add(row2Column3);gamePanel.add(row3Column1);gamePanel.add(row3Column2);gamePanel.add(row3Column3);

        //action listeners for putting X and O's to buttons
        row1Column1.addActionListener(e -> handleButtonClick(row1Column1));
        row1Column2.addActionListener(e -> handleButtonClick(row1Column2));
        row1Column3.addActionListener(e -> handleButtonClick(row1Column3));
        row2Column1.addActionListener(e -> handleButtonClick(row2Column1));
        row2Column2.addActionListener(e -> handleButtonClick(row2Column2));
        row2Column3.addActionListener(e -> handleButtonClick(row2Column3));
        row3Column1.addActionListener(e -> handleButtonClick(row3Column1));
        row3Column2.addActionListener(e -> handleButtonClick(row3Column2));
        row3Column3.addActionListener(e -> handleButtonClick(row3Column3));

        //action listener for new game button
        newGameButton.addActionListener(e -> handleNewGameButtonClick());

        this.add(gamePanel);
        this.add(scoreAndNewGamePartPanel);

    }
    public void handleButtonClick(JButton button) {
        if (button.getText().isEmpty()) {
            button.setText(String.valueOf(currentPlayer));

            if ((row1Column1.getText().equals(row1Column2.getText()) && row1Column2.getText().equals(row1Column3.getText()) && !row1Column1.getText().isEmpty()) ||
                    (row2Column1.getText().equals(row2Column2.getText()) && row2Column2.getText().equals(row2Column3.getText()) && !row2Column1.getText().isEmpty()) ||
                    (row3Column1.getText().equals(row3Column2.getText()) && row3Column2.getText().equals(row3Column3.getText()) && !row3Column1.getText().isEmpty()) ||
                    (row1Column1.getText().equals(row2Column1.getText()) && row2Column1.getText().equals(row3Column1.getText()) && !row1Column1.getText().isEmpty()) ||
                    (row1Column2.getText().equals(row2Column2.getText()) && row2Column2.getText().equals(row3Column2.getText()) && !row1Column2.getText().isEmpty()) ||
                    (row1Column3.getText().equals(row2Column3.getText()) && row2Column3.getText().equals(row3Column3.getText()) && !row1Column3.getText().isEmpty()) ||
                    (row1Column1.getText().equals(row2Column2.getText()) && row2Column2.getText().equals(row3Column3.getText()) && !row1Column1.getText().isEmpty()) ||
                    (row1Column3.getText().equals(row2Column2.getText()) && row2Column2.getText().equals(row3Column1.getText()) && !row1Column3.getText().isEmpty())) {

                scoreLabel.setText(currentPlayer + " won!");
                scoreLabel.setVisible(true);
                clearButtonsText();
            }

            togglePlayer();
        }
    }
    public void handleNewGameButtonClick(){
        clearButtonsText();
        scoreLabel.setText("");
        currentPlayer = 'X';
    }
    public void clearButtonsText(){
        row1Column1.setText("");row1Column2.setText("");row1Column3.setText("");row2Column1.setText("");row2Column2.setText("");
        row2Column3.setText("");row3Column1.setText("");row3Column2.setText("");row3Column3.setText("");
    }
    public void togglePlayer(){
        if(currentPlayer == 'X'){
            currentPlayer = 'O';
        }else{
            currentPlayer = 'X';
        }
    }

    public static void main(String[] args) {
        try {
            // Use either light or dark theme
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        new GameScreen();
    }


}
