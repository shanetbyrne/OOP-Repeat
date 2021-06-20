import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

//MAIN CLASS//
    public class PlayGame extends JFrame implements ActionListener { //AddPokemon inherits from the JFrame class (super class inheritance) and implements the ActionListener interface

    //GLOBAL VARIABLES
   /*
    public static ArrayList<Pokemon> getPokemons() {  //ArrayList Getters
        return Pokemons;
    } //gets the ArrayList Pokemons
*/
    JMenu homeMenu; //Pokemons JMenu global variable

    static JFrame frame = new JFrame("Shane's Pokemon Game");
    private static JMenuItem goBack;  //global variables for JMenuItems
    private static JButton add;
    static JTextField pokemonJT;
    static ArrayList<Pokemon> Pokemons = new ArrayList<>(); //declares the ArrayList (of type <Pokemon>) Pokemons

    public static ArrayList<Pokemon> getPokemons() {  //ArrayList Getters
        return Pokemons;
    } //gets the ArrayList Pokemons


    //MAIN METHOD//
    public static void main(String[] args) { //Main Method
        PlayGame frame = new PlayGame(); //creating the AddPokemon JFrame window
        frame.setVisible(true); //making the window visible
    }

    //CONSTRUCTOR//
    public PlayGame() {

        //loading up the data from the arraylist
        try {
            File p = new File("allPokemons2.dat"); //loads the File allPokemons2.dat which the ArrayList is saved to
            FileInputStream fis = new FileInputStream(p); //instances of FileInputStream and ObjectInputStream
            ObjectInputStream ois = new ObjectInputStream(fis);

            Pokemons = (ArrayList<Pokemon>) ois.readObject(); //reading the objects in the ArrayList
            ois.close();

                /* for(Pokemon b: Pokemons) //for loop used to display the contents of the ArrayList
                {
                    JOptionPane.showMessageDialog(null,b);
                }*/
            JOptionPane.showMessageDialog(null, getPokemons());

            /*

        JTextArea textArea = new JTextArea();
        textArea.setText(pokemons);
        textArea.setBounds(10, 79, 172, 339);   //Tried using the data that was saved onto the database and display it on this page
        frame.getContentPane().add(textArea);       But couldn't get it working

        for(String p : pokemons){
            textArea.append(p + "\n");
        }
        */

        } catch (Exception ox) { //exception for the try catch. If the try fails...
            JOptionPane.showMessageDialog(null, "Exception Occurred"); //display this message/exception
            System.out.println(ox);
        }

        Container pane;  //creating the local variable for the content pane

        setTitle("Shane's Pokemon Game");
        setSize(1000, 600);
        setResizable(false);                   //WINDOW PROPERTIES
        setLocation(250, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //CONTENT PANE AND HEADER LABEL
        pane = getContentPane();  //getting the content pane
        pane.setLayout(null); //setting the layout to null for absolute positioning
        JLabel header = new JLabel("Play Shane's Pokemon Game"); //header label
        Font font = new Font("monospaced", Font.PLAIN, 24);//header font

        //JLABEL
        JLabel instruction = new JLabel("Please type the Pokemon that you would like to play as into the textbox."); //header label
        //JMENU METHODS
        homeMenu(); //calling JMenuBar components methods


        JMenuBar menu = new JMenuBar(); //creating an instance of the JMenuBar class
        setJMenuBar(menu); //setting the JMenuBar to the variable name 'menu'
        menu.add(Box.createHorizontalGlue()); //right aligning the JMenuBar. this line of code was got from https://stackoverflow.com/questions/8560810/aligning-jmenu-on-the-right-corner-of-jmenubar-in-java-swing


        //JTextArea
        JTextArea textArea = new JTextArea("""
                Charizard
                Gengar
                Alakazam
                Blastoise""");
        textArea.setBounds(400, 100, 150, 150);
        // textArea.setVisible(true);
        textArea.setEditable(false);
        pane.add(textArea);

        menu.setBackground(Color.lightGray);    //setting the JMenuBar background color to grey
        menu.add(homeMenu); //adding the JMenu components to the JMenuBar

        //JLabel
        pane.add(instruction);

        //JTextField
        pokemonJT = new JTextField(20);
        pane.add(pokemonJT);

        //JButtons
        add = new JButton("Select Pokemon"); //arraylist button (DECLARED GLOBALLY)
        add.addActionListener(this); //actionlistener for add Pokemons button(this)
        pane.add(add);

        header.setFont(font); //applying the font to the header

        //BEGINNING OF ABSOLUTE POSITIONING//
        Insets insets = pane.getInsets();   //creating an instance of the insets class and applying it to the content pane
        Dimension size = header.getPreferredSize(); //using the getPrefferedSize(pre-written method) to create a suitable size for the visit store button
        header.setBounds(200 + insets.left, 40 + insets.top, //setting the dimensions
                size.width, size.height);

        size = instruction.getPreferredSize(); //using the getPrefferedSize(pre-written method) to create a suitable size for the visit store button
        instruction.setBounds(280 + insets.left, 275 + insets.top, //setting the dimensions
                size.width, size.height);

        size = pokemonJT.getPreferredSize(); //using the getPrefferedSize(pre-written method) to create a suitable size for the visit store button
        pokemonJT.setBounds(365 + insets.left, 300 + insets.top, //setting the dimensions
                size.width, size.height);

        size = add.getPreferredSize(); //using the getPrefferedSize(pre-written method) to create a suitable size for the visit store button
        add.setBounds(400 + insets.left, 350 + insets.top, //setting the dimensions
                size.width, size.height);


        //END OF ABSOLUTE POSITIONING

        /*
        JTextArea textArea = new JTextArea();
        textArea.setText(pokemons);                                                             //Tried displaying the pokemon that was
        textArea.setBounds(10, 79, 172, 339); //trying to display arraylist onto the textarea     saved on the database and displaying in
        frame.getContentPane().add(textArea);                                                     in a JTextArea but kept getting errors

        for(String p : pokemons){
            textArea.append(p + "\n");
        }
        */
    }

    public void actionPerformed(ActionEvent e) { //event handler
        if (e.getSource() == goBack) { //   if 'aPokemons' button is clicked
            JOptionPane.showMessageDialog(null, "Re-directing you to the Main Menu"); //display this message

            MainMenu menu = new MainMenu(); //create a new instance of AddPokemon class

            menu.setVisible(true); //set AddPokemons JFrame window to visible
            this.setVisible(false); //hide the current page i.e. this page
        }

        if (e.getSource() == add) { //   if 'aPokemons' button is clicked
            /*if (!(pokemonJT.equals("gengar")) || !(pokemonJT.equals("Gengar"))) {
                JOptionPane.showMessageDialog(null, "Invalid Pokemon - Please enter a pokemon from the textarea.");  //
                return;
            }

            /*else if (!pokemonJT.equals("charizard") || !pokemonJT.equals("Charizard")) {
                JOptionPane.showMessageDialog(null, "Invalid Pokemon - Please enter a pokemon from the textarea.");
                return;
            }                                                                    //Tried doing validation of pokemon name entered
                                                                                         but didn't work so I left it commented


            else if (!pokemonJT.equals("blastoise") || !pokemonJT.equals("Blastoise")) {
                JOptionPane.showMessageDialog(null, "Invalid Pokemon - Please enter a pokemon from the textarea.");
                return;
            }


            else if (!pokemonJT.equals("alakazam") || !pokemonJT.equals("Alakazam")) {
                JOptionPane.showMessageDialog(null, "Invalid Pokemon - Please enter a pokemon from the textarea.");
                return;
            }*/
                String player1 = pokemonJT.getText();
                JOptionPane.showMessageDialog(null, "Player 1 is " + player1 + "\nGenerating player 2's Pokemon."); //display this message


                String[] pokemons = {"Charizard",
                        "Blastoise",
                        "Gengar",
                        "Alakazam"};

                Random rand = new Random();
                int r = rand.nextInt(pokemons.length);
                String player2 = pokemons[r];

                JOptionPane.showMessageDialog(null, "Player 2 is " + player2);


                GamePage game = new GamePage(); //create a new instance of AddPokemon class

                game.setVisible(true); //set AddPokemons JFrame window to visible
                this.setVisible(false); //hide the current page i.e. this page
            }
        }

    private void homeMenu() {

        homeMenu = new JMenu("Home");

        goBack = new JMenuItem("Return to Main Menu");
        goBack.addActionListener(this);
        homeMenu.add(goBack);
    }

}