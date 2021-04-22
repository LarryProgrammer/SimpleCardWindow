/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

/**
 *
 * @author Larry Jackson
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCardWindow extends JFrame implements ActionListener {
    
    public static final int WIDTH = 300;
    public static final int HEIGHT = 300;
    
    CardLayout theCardsLayoutManager;
    JPanel theCardsPanel;
    JTextField userTextField;
    JTextField passwordTextField;
    JButton loginButton;
    JButton bobWordButton;
    JTextField bobEntryTextField;
    JTextArea bobDisplayTextArea;
    JButton bobReturnButton;
    JPanel fredCard;
    JPanel fredButtonPanel;
    JButton fredRedColorButton;
    JButton fredGreenColorButton;
    JButton fredReturnButton;
    

    //Creating the Window Frame
    public SimpleCardWindow() {
        
        super();
        //Setting the size of the Window
        setSize(WIDTH, HEIGHT);
        
        //Giving the title at the top of the frame
        setTitle("Card Layout Demo");
        theCardsPanel = new JPanel();
        theCardsLayoutManager = new CardLayout();
        theCardsPanel.setLayout(theCardsLayoutManager);
       
        // The login card layout first
        JPanel loginCard = new JPanel();
        loginCard.setLayout(new GridLayout(3, 1));
        
        //Adding a text field for the User to enter there name 
        userTextField = new JTextField("Enter user name here");
        
        //Adding a text field for the User to enter there password 
        passwordTextField = new JTextField("Enter password here");
        
        //Adding the login button
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        
        /*Add the user and password text field 
        as well as the login button to the login card*/
        loginCard.add(userTextField);
        loginCard.add(passwordTextField);
        loginCard.add(loginButton);
        theCardsPanel.add("loginCard", loginCard);
    
        
/****************************************************************/


        /* BOB'S CARD */
        JPanel bobCard = new JPanel();
        bobCard.setLayout(new BorderLayout());
        
        //Created a button labeled Append Word
        bobWordButton = new JButton("Append word");
        bobWordButton.addActionListener(this);
  
        //Text Field to enter in a word
        bobEntryTextField = new JTextField("Enter a word here");
        
        //Text Area to display the text
        bobDisplayTextArea = new JTextArea(5, 20);
        bobDisplayTextArea.setEditable(false);

        //Created a Return button
        bobReturnButton = new JButton("Return");
        bobReturnButton.addActionListener(this);
        
        //Placing all the text field and buttons on the frame
        JPanel bobEntryPanel = new JPanel();
        bobEntryPanel.setLayout(new GridLayout(1, 2));
        
        //Adding the Entry Text Field
        bobEntryPanel.add(bobEntryTextField);
        
        //Adding the Button
        bobEntryPanel.add(bobWordButton);
        bobCard.add(bobEntryPanel, BorderLayout.NORTH);
        
        //Center placement Text Area
        bobCard.add(bobDisplayTextArea, BorderLayout.CENTER);
        
        //Placing the Return button at the bottom
        bobCard.add(bobReturnButton, BorderLayout.SOUTH);
        theCardsPanel.add("bobCard", bobCard);
        
        
/****************************************************************/      
        

        /* FRED'S CARD */
        fredCard = new JPanel();
        fredCard.setLayout(new BorderLayout());
        
        //Created a button to make the background red
        fredRedColorButton = new JButton("Make background red");
        fredRedColorButton.addActionListener(this);
        
        //Created a button to make the background green
        fredGreenColorButton = new JButton("Make background green");
        fredGreenColorButton.addActionListener(this);
        
        //Created the return button to go back to the login frame
        fredReturnButton = new JButton("Return");
        fredReturnButton.addActionListener(this);
        
        //Placing the buttons on the frame
        fredButtonPanel = new JPanel();
        fredButtonPanel.add(fredGreenColorButton);
        fredButtonPanel.add(fredRedColorButton);
        
        //Placing the Red and Green Button in the center
        fredCard.add(fredButtonPanel, BorderLayout.CENTER);
        
        //Placing the Return button at the bottom
        fredCard.add(fredReturnButton, BorderLayout.SOUTH);
        theCardsPanel.add("fredCard", fredCard);
        getContentPane().add(theCardsPanel, BorderLayout.CENTER);
        
        //Place the frame in the center of the window
        setLocationRelativeTo(null);
        // Close out the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
/****************************************************************/

        
    @Override
    public void actionPerformed(ActionEvent e) {
       //define the action commands for the Login page
        if (e.getActionCommand().equals("Login")) {
            String id = userTextField.getText();
            String pass = passwordTextField.getText();
            
            /*User correctly types in Bob for the id name and muddy in the password text field
            will go to the Bob Card */
            if (id.equals("Bob") && pass.equals("mubby")) 
                theCardsLayoutManager.show(theCardsPanel, "bobCard");

             /*User correctly types in Fred for the id name and goolag in the password text field
            will go to the Fred Card */
             else if (id.equals("Fred") && pass.equals("goolag")) 
                theCardsLayoutManager.show(theCardsPanel, "fredCard");

        /* when user is finished on either card they can click the return
        button and this will return back to the login frame*/
        } else if (e.getActionCommand().equals("Return")) {
            theCardsLayoutManager.show(theCardsPanel, "loginCard");
                
        //Adds the word in the list
        } else if (e.getSource().equals(bobWordButton) ) {
            String add = bobEntryTextField.getText();
            bobDisplayTextArea.append(add + "\n");
            System.out.println("word is " + add);
              
        /* Change the color on the background to green
        when the "Make background green" button is clicked*/
        } else if (e.getSource().equals(fredGreenColorButton) ) {
            fredButtonPanel.setBackground(Color.GREEN);

        /* Change the color on the background to red
        when the "Make background red" button is clicked*/
        } else if (e.getSource().equals(fredRedColorButton)) {
            fredButtonPanel.setBackground(Color.RED);
             
        /*Throws an error if buttons doesn't work*/
        } else 
            System.out.println("Error in button interface.");
            
    }
    
    /* THE MAIN */
    public static void main(String[] args) {
        SimpleCardWindow window1 = new SimpleCardWindow();
        window1.setVisible(true);
    }   
}
