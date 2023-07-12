/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.rock;

/**
 *
 * @author DELL
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JLabel;

public class Rock extends JFrame { 
    
       //create label for Computerchoice and for result
    JLabel computerChoice,result;
    //create Lable for display a core
    JLabel computerScore,PlayerScore;
    int player_score=0;
    int computer_score=0;
    
    

ImageIcon image_bato,image_papel,image_gunting;
public void setup(){
image_bato=new ImageIcon(new ImageIcon("bato.png").getImage()
                .getScaledInstance(80,80,Image.SCALE_DEFAULT));
image_papel=new ImageIcon(new ImageIcon("papel.png").getImage()
                .getScaledInstance(80,80,Image.SCALE_DEFAULT));
image_gunting=new ImageIcon(new ImageIcon("gunting.png").getImage()
                .getScaledInstance(80,80,Image.SCALE_DEFAULT));   
        //create label
       // JLabel score=new JLabel("Scores");
       // score.setBounds(500,0,100,100);
        
        
        computerScore=new JLabel();
        computerScore.setText("Computer : 0");
        computerScore.setBounds(500,50,100,100);
        
        PlayerScore=new JLabel();
        PlayerScore.setText("Player :  0");
        PlayerScore.setBounds(500,30,100,100);
        
        
    computerChoice=new JLabel();
    computerChoice.setHorizontalTextPosition(JLabel.CENTER);
    computerChoice.setVerticalTextPosition(JLabel.BOTTOM);
    computerChoice.setBounds(250,90,100,100);
    
    result=new JLabel();
    result.setFont(new Font("Serif",Font.BOLD,20));
    result.setBounds(250,450,100,100); 
    
        JLabel label_computer=new JLabel();
        label_computer.setText("Computer");
        label_computer.setBounds(260,180,100,100);
        
        JLabel label_vs=new JLabel();
        label_vs.setText("VS");
        label_vs.setBounds(280,200,100,100);
        
        JLabel label_player=new JLabel();
        label_player.setText("Player");
        label_player.setBounds(265,225,105,105);
    
       JLabel label_bato=new JLabel();
       label_bato.setText("Bato"); 
       label_bato.setIcon(image_bato); //set icon of game
       label_bato.setHorizontalTextPosition(JLabel.CENTER);
       label_bato.setVerticalTextPosition(JLabel.BOTTOM); 
       label_bato.setBounds(150,300,100,100); 
       
        //add another components of the game
       
        JLabel label_papel=new JLabel();
       label_papel.setText("Papel"); 
       label_papel.setIcon(image_papel); //set icon of game
       label_papel.setHorizontalTextPosition(JLabel.CENTER);
       label_papel.setVerticalTextPosition(JLabel.BOTTOM); 
       label_papel.setBounds(250,300,100,100); 

       //add another components of the game
       
       JLabel label_gunting=new JLabel();
       label_gunting.setText("Gunting"); 
       label_gunting.setIcon(image_gunting); //set icon of game
       label_gunting.setHorizontalTextPosition(JLabel.CENTER);
       label_gunting.setVerticalTextPosition(JLabel.BOTTOM); 
       label_gunting.setBounds(350,300,100,100); 

        //add mouse Listener to Labels
        label_bato.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                //call calculate method
                calculate(label_bato.getText());
        }
        });
        label_papel.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                //call calculate method
                calculate(label_papel.getText());
        }
        });
        label_gunting.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                //call calculate method
                calculate(label_gunting.getText());
        }
        });
       //add components in the frame
       add(label_bato);  
       add(label_papel);
       add(label_gunting);
       add(computerChoice);
       add(result);
      // add(score);
       add(computerScore);
       add(PlayerScore);
       add(label_computer);
       add(label_vs);
       add(label_player);
       setLayout(null);        
      
}
  public void calculate(String player) {
    String[] list = {"Bato", "Papel", "Gunting"};
    int random_choice = (int) ((Math.random() * 10) % 3);
    String computer = list[random_choice];

    computerChoice.setText(computer);
    switch (random_choice) {
        case 0:
            computerChoice.setIcon(image_bato);
            break;
        case 1:
            computerChoice.setIcon(image_papel);
            break;
        default:
            computerChoice.setIcon(image_gunting);
            break;
    }

    String res = "";
    String winnerMessage = "";
    String loserAction = "";

    if (player.equals(computer)) {
        res = "Patas";
    } else if (player.equals("Bato")) {
        if (computer.equals("Papel")) {
            res = "Talo ka!";
            computer_score++;
            loserAction = "Do 10 push-ups.";
            winnerMessage = "Congratulations! You win! Here's a chocolate.";
        } else {
            res = "Panalo Ka!";
            player_score++;
            winnerMessage = "Congratulations! You win! Here's 100 pesos.";
            loserAction = "Take a 3-minute jog.";
        }
    } else if (player.equals("Papel")) {
        if (computer.equals("Gunting")) {
            res = "Talo ka!";
            computer_score++;
            loserAction = "Do 10 push-ups.";
            winnerMessage = "Congratulations! You win! Here's a chocolate.";
        } else {
            res = "Panalo Ka!";
            player_score++;
            winnerMessage = "Congratulations! You win! Here's 100 pesos.";
            loserAction = "Take a 3-minute jog.";
        }
    } else {
        if (computer.equals("Bato")) {
            res = "Talo ka!";
            computer_score++;
            loserAction = "Do 10 push-ups.";
            winnerMessage = "Congratulations! You win! Here's a chocolate.";
        } else {
            res = "Panalo ka!";
            player_score++;
            winnerMessage = "Congratulations! You win! Here's 100 pesos.";
            loserAction = "Take a 3-minute jog.";
        }
    }

   
    result.setText(res);
    PlayerScore.setText("Player: " + player_score);
    computerScore.setText("Computer: " + computer_score);

    // Check kung may nanalo na
     // Check if a player has won
    if (player_score >= 10 || computer_score >= 10) {
        String message;
        if (player_score > computer_score) {
            message = winnerMessage;
        } else if (player_score < computer_score) {
            message = "Better luck next time! " + loserAction;
        } else {
            message = "It's a tie!";
        }

        // Show a dialog with options to try again or exit
        int choice = JOptionPane.showOptionDialog(
                this,
                message,
                "Game Over",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new Object[]{"Try Again", "Exit"},
                null
        );

        if (choice == JOptionPane.YES_OPTION) {
            // Reset scores and continue playing
            player_score = 0;
            computer_score = 0;
            PlayerScore.setText("Player: " + player_score);
            computerScore.setText("Computer: " + computer_score);
        } else {
            // Exit the game
            System.exit(0);
        }
    }
}


    
    
  public static void main(String[] args) {
    JFrame startFrame = new JFrame("Rock Paper Scissors Game");
    startFrame.setSize(300, 200);
    startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    startFrame.setLayout(null);

    JButton startButton = new JButton("Start");
    startButton.setBounds(50, 50, 80, 30);
    startButton.addActionListener(e -> {
        startFrame.dispose(); // Isara ang window ng "Start" button
        Rock game = new Rock();
        game.setTitle("BATO, PAPEL, GUNTING");
        game.setBounds(300, 200, 600, 600);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.getContentPane().setBackground(new Color(173, 216, 230)); // Light blue color

        game.setup();
        game.setResizable(false);
        game.setVisible(true);
    });

    JButton exitButton = new JButton("Exit");
    exitButton.setBounds(150, 50, 80, 30);
    exitButton.addActionListener(e -> System.exit(0));

    startFrame.add(startButton);
    startFrame.add(exitButton);
    startFrame.setVisible(true);
}

}
    
    


        
   


        
        
       
    

