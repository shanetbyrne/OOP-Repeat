import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

//MAIN CLASS//
public class GamePage extends JFrame implements ActionListener { //AddPokemon inherits from the JFrame class (super class inheritance) and implements the ActionListener interface

    //GLOBAL VARIABLES
    static ArrayList<Pokemon> Pokemons = new ArrayList<>(); //declares the ArrayList (of type <Pokemon>) Pokemons

    public static ArrayList<Pokemon> getPokemons() {  //ArrayList Getters
        return Pokemons;
    } //gets the ArrayList Pokemons


    JMenu homeMenu; //Pokemons JMenu global variable

    static JFrame frame = new JFrame("Shane's Pokemon Game");
    private static JMenuItem goBack; //global variables for JMenuItems
    private static JButton p1Punch, p1Kick, p1Bite, p1Slash, p2Kick, p2Punch, p2Bite, p2Slash;
    int player1Health = 100, player2Health = 100;
    //MAIN METHOD//
    public static void main(String[] args) { //Main Method
        GamePage frame = new GamePage(); //creating the AddPokemon JFrame window
        frame.setVisible(true); //making the window visible

    }

    //CONSTRUCTOR//
    public GamePage() {

        Container pane;  //creating the local variable for the content pane

        setTitle("Shane's Pokemon Game");
        setSize(1000, 600);
        setResizable(false);                   //WINDOW PROPERTIES
        setLocation(250, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //CONTENT PANE AND HEADER LABEL
        pane = getContentPane();  //getting the content pane
        pane.setLayout(null); //setting the layout to null for absolute positioning
        JLabel header = new JLabel("Let the Games Begin"); //header label
        Font font = new Font("monospaced", Font.PLAIN, 24);//header font

        //JLABELS
        JLabel title = new JLabel("You are player 1. You have 4 attack moves.  Choose between punch, kick, bite and slash."); //title label
        JLabel player1 = new JLabel("Player 1");
        JLabel player2 = new JLabel("Player 2");

        //JBUTTONS
        p1Punch = new JButton("Punch"); //arraylist button (DECLARED GLOBALLY)
        p1Punch.addActionListener(this); //actionlistener for add Pokemons button(this)

        p1Kick = new JButton("Kick"); //arraylist button (DECLARED GLOBALLY)
        p1Kick.addActionListener(this); //actionlistener for add Pokemons button(this)

        p1Bite = new JButton("Bite"); //arraylist button (DECLARED GLOBALLY)
        p1Bite.addActionListener(this); //actionlistener for add Pokemons button(this)

        p1Slash = new JButton("Slash"); //arraylist button (DECLARED GLOBALLY)
        p1Slash.addActionListener(this); //actionlistener for add Pokemons button(this)

        p2Punch = new JButton("Punch"); //arraylist button (DECLARED GLOBALLY)
        p2Punch.addActionListener(this); //actionlistener for add Pokemons button(this)

        p2Kick = new JButton("Kick"); //arraylist button (DECLARED GLOBALLY)
        p2Kick.addActionListener(this); //actionlistener for add Pokemons button(this)

        p2Bite = new JButton("Bite"); //arraylist button (DECLARED GLOBALLY)
        p2Bite.addActionListener(this); //actionlistener for add Pokemons button(this)

        p2Slash = new JButton("Slash"); //arraylist button (DECLARED GLOBALLY)
        p2Slash.addActionListener(this); //actionlistener for add Pokemons button(this)

        //JMENU METHODS
        homeMenu(); //calling JMenuBar components methods


        JMenuBar menu = new JMenuBar(); //creating an instance of the JMenuBar class
        setJMenuBar(menu); //setting the JMenuBar to the variable name 'menu'
        menu.add(Box.createHorizontalGlue()); //right aligning the JMenuBar. this line of code was got from https://stackoverflow.com/questions/8560810/aligning-jmenu-on-the-right-corner-of-jmenubar-in-java-swing


        menu.setBackground(Color.lightGray);    //setting the JMenuBar background color to grey
        menu.add(homeMenu); //adding the JMenu components to the JMenuBar

        header.setFont(font); //applying the font to the header

        //ADDING THE JLABELS AND JBUTTONS TO THE CONTENT PANE//
        pane.add(title);
        pane.add(player1);
        pane.add(player2);

        pane.add(p1Bite);
        pane.add(p1Kick);
        pane.add(p1Slash);
        pane.add(p1Punch);

        pane.add(p2Bite);
        pane.add(p2Kick);
        pane.add(p2Slash);
        pane.add(p2Punch);



        //BEGINNING OF ABSOLUTE POSITIONING//
        Insets insets = pane.getInsets();   //creating an instance of the insets class and applying it to the content pane
        Dimension size = header.getPreferredSize(); //using the getPrefferedSize(pre-written method) to create a suitable size for the visit store button
        header.setBounds(200 + insets.left, 40 + insets.top, //setting the dimensions
                size.width, size.height);

        size = player1.getPreferredSize();
        player1.setBounds(265 + insets.left, 150 + insets.top,
                size.width, size.height);

        size = player2.getPreferredSize();
        player2.setBounds(665 + insets.left, 150 + insets.top,
                size.width, size.height);

        size = title.getPreferredSize();
        title.setBounds(250 + insets.left, 100 + insets.top,
                size.width, size.height);

        size = p1Bite.getPreferredSize();
        p1Bite.setBounds(200 + insets.left, 200 + insets.top,
                size.width, size.height);

        size = p1Kick.getPreferredSize();
        p1Kick.setBounds(200 + insets.left, 300 + insets.top,
                size.width, size.height);

        size = p1Punch.getPreferredSize();
        p1Punch.setBounds(300 + insets.left, 200 + insets.top,
                size.width, size.height);

        size = p1Slash.getPreferredSize();
        p1Slash.setBounds(300 + insets.left, 300 + insets.top,
                size.width, size.height);

        size = p2Bite.getPreferredSize();
        p2Bite.setBounds(600 + insets.left, 200 + insets.top,
                size.width, size.height);

        size = p2Kick.getPreferredSize();
        p2Kick.setBounds(700 + insets.left, 200 + insets.top,
                size.width, size.height);

        size = p2Punch.getPreferredSize();
        p2Punch.setBounds(600 + insets.left, 300 + insets.top,
                size.width, size.height);

        size = p2Slash.getPreferredSize();
        p2Slash.setBounds(700 + insets.left, 300 + insets.top,
                size.width, size.height);

        //END OF ABSOLUTE POSITIONING

    }

    public void actionPerformed(ActionEvent e) { //event handler
        if (e.getSource() == goBack) { //   if 'goBack' button is clicked
            JOptionPane.showMessageDialog(null, "Re-directing you to the Main Menu"); //display this message

            MainMenu menu = new MainMenu(); //create a new instance of AddPokemon class

            menu.setVisible(true); //set AddPokemons JFrame window to visible
            this.setVisible(false); //hide the current page i.e. this page
        }

        if (e.getSource() == p1Punch) { //   if 'p1Punch' button is clicked
            punch(e);
            finishOpponent(e);
            return;

        }

        if (e.getSource() == p1Kick) { //   if 'p1Kick' button is clicked
            kick(e);
            finishOpponent(e);
            return;

        }

        if (e.getSource() == p1Bite) { //   if 'p1Bite' button is clicked
            bite(e);
            finishOpponent(e);
            return;

        }

        if (e.getSource() == p1Slash) { //   if 'p1Slash' button is clicked
            slash(e);
            finishOpponent(e);
            return;

        }


    }

    public void punch(ActionEvent e) { //event handler
        if (e.getSource() == p1Punch ) { //   if 'p1Punch' button is clicked
            player2Health = player2Health - 10;
            JOptionPane.showMessageDialog(null, "Player 1 has punched player 2.  Player 2's health is now " + player2Health); //display this message

            ArrayList<JButton> buttons = new ArrayList<>(); //declares the ArrayList (of type <Pokemon>) Pokemons

            buttons.add(p2Punch);
            buttons.add(p2Kick);
            buttons.add(p2Bite);
            buttons.add(p2Slash);

            Random rand = new Random();
            int r = rand.nextInt(buttons.size());
            JButton player2Action = buttons.get(r);
            if(player2Action == p2Punch){
                player1Health = player1Health - 10;
                return;
            }
            else if (player2Action == p2Kick){
                player1Health = player1Health - 20;
                return;
            }
            else if (player2Action == p2Bite){
                player1Health = player1Health - 40;
                return;
            }
            else if (player2Action == p2Slash){
                player1Health = player1Health - 30;
                return;
            }
        }
    }

    public void kick(ActionEvent e) { //event handler
        if (e.getSource() == p1Kick ) { //   if 'p1Kick' button is clicked
            player2Health = player2Health - 20;
            JOptionPane.showMessageDialog(null, "Player 1 has kicked player 2.  Player 2's health is now " + player2Health); //display this message

            ArrayList<JButton> buttons = new ArrayList<>(); //declares the ArrayList (of type <Pokemon>) Pokemons

            buttons.add(p2Punch);
            buttons.add(p2Kick);
            buttons.add(p2Bite);
            buttons.add(p2Slash);

            Random rand = new Random();
            int r = rand.nextInt(buttons.size());
            JButton player2Action = buttons.get(r);
            if(player2Action == p2Punch){
                player1Health = player1Health - 10;
                return;
            }
            else if (player2Action == p2Kick){
                player1Health = player1Health - 20;
                return;
            }
            else if (player2Action == p2Bite){
                player1Health = player1Health - 40;
                return;
            }
            else if (player2Action == p2Slash){
                player1Health = player1Health - 30;
                return;
            }
        }
    }
    public void bite(ActionEvent e) { //event handler
        if (e.getSource() == p1Bite ) { //   if 'p1Bite' button is clicked
            player2Health = player2Health - 40;
            JOptionPane.showMessageDialog(null, "Player 1 has bitten player 2.  Player 2's health is now " + player2Health); //display this message

            ArrayList<JButton> buttons = new ArrayList<>(); //declares the ArrayList (of type <Pokemon>) Pokemons

            buttons.add(p2Punch);
            buttons.add(p2Kick);
            buttons.add(p2Bite);
            buttons.add(p2Slash);

            Random rand = new Random();
            int r = rand.nextInt(buttons.size());
            JButton player2Action = buttons.get(r);
            if(player2Action == p2Punch){
                player1Health = player1Health - 10;
                return;
            }
            else if (player2Action == p2Kick){
                player1Health = player1Health - 20;
                return;
            }
            else if (player2Action == p2Bite){
                player1Health = player1Health - 40;
                return;
            }
            else if (player2Action == p2Slash){
                player1Health = player1Health - 30;
                return;
            }
        }
    }
    public void slash(ActionEvent e) { //event handler
        if (e.getSource() == p1Slash ) { //   if 'p1Slash' button is clicked
            player2Health = player2Health - 30;
            JOptionPane.showMessageDialog(null, "Player 1 has slashed player 2.  Player 2's health is now " + player2Health); //display this message

            ArrayList<JButton> buttons = new ArrayList<>(); //declares the ArrayList (of type <Pokemon>) Pokemons

            buttons.add(p2Punch);
            buttons.add(p2Kick);
            buttons.add(p2Bite);
            buttons.add(p2Slash);

            Random rand = new Random();
            int r = rand.nextInt(buttons.size());
            JButton player2Action = buttons.get(r);
            if(player2Action == p2Punch){
                player1Health = player1Health - 10;
            }
            else if (player2Action == p2Kick){
                player1Health = player1Health - 20;
            }
            else if (player2Action == p2Bite){
                player1Health = player1Health - 40;
            }
            else if (player2Action == p2Slash){
                player1Health = player1Health - 30;
            }
        }
    }

    public void finishOpponent(ActionEvent e) { //event handler
       if(player1Health <= 0){
           JOptionPane.showMessageDialog(null, "Loser! You are dead. Player 2 has won the game. ");
           System.exit(0);
       }
       else if (player2Health <= 0){
           JOptionPane.showMessageDialog(null, "Winner! You have killed player 2. You have won the game. ");
           System.exit(0);
       }
    }


    private void homeMenu () {

        homeMenu = new JMenu("Home");

        goBack = new JMenuItem("Return to Main Menu");
        goBack.addActionListener(this);
        homeMenu.add(goBack);
    }
}
