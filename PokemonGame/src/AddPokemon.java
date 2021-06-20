import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

    //MAIN CLASS//
    public class AddPokemon extends JFrame implements ActionListener { //AddPokemon inherits from the JFrame class (super class inheritance) and implements the ActionListener interface

        //GLOBAL VARIABLES
        static ArrayList<Pokemon> Pokemons = new ArrayList<>(); //declares the ArrayList (of type <Pokemon>) Pokemons

        public static ArrayList<Pokemon> getPokemons() {  //ArrayList Getters
            return Pokemons;
        } //gets the ArrayList Pokemons

        JMenu homeMenu; //Pokemons JMenu global variable
      
        static JFrame frame = new JFrame("Shane's Pokemon Game");
        private static JMenuItem goBack; //global variables for JMenuItems
        private static JButton add;// view; //global variable for button that triggers that adds Pokemon to the arraylist
        JTextField titlejt; //global variables for textboxes

        //MAIN METHOD//
        public static void main(String[] args) { //Main Method
            AddPokemon frame = new AddPokemon(); //creating the AddPokemon JFrame window
            frame.setVisible(true); //making the window visible

        }

        //CONSTRUCTOR//
        public AddPokemon() {

            //loading up the data from the arraylist
            try {
                File p = new File("allPokemons2.dat"); //loads the File allPokemons2.dat which the ArrayList is saved to
                FileInputStream fis = new FileInputStream(p); //instances of FileInputStream and ObjectInputStream
                ObjectInputStream ois = new ObjectInputStream(fis);

                Pokemons = (ArrayList<Pokemon>)ois.readObject(); //reading the objects in the ArrayList
                ois.close();

                /* for(Pokemon b: Pokemons)         //for loop used to display the contents of the ArrayList
                {
                    JOptionPane.showMessageDialog(null,b);
                }*/
                JOptionPane.showMessageDialog(null,getPokemons());

            }

            catch (Exception ox){ //exception for the try catch. If the try fails...
                JOptionPane.showMessageDialog(null,"Exception Occurred"); //display this message/exception
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
            JLabel header = new JLabel("Add A Pokemon"); //header label
            Font font = new Font("monospaced", Font.PLAIN, 24);//header font

            //JLABELS
            JLabel title = new JLabel("Please enter the name of the Pokemon you would like to add:"); //title label

            //JTEXTFIELDS
            titlejt = new JTextField(20); //title JTextField

            //JBUTTONS
            add = new JButton("Add Pokemon"); //arraylist button (DECLARED GLOBALLY)
            add.addActionListener(this); //actionlistener for add Pokemons button(this)

            //JMENU METHODS
            homeMenu(); //calling JMenuBar components methods


            JMenuBar menu = new JMenuBar(); //creating an instance of the JMenuBar class
            setJMenuBar(menu); //setting the JMenuBar to the variable name 'menu'
            menu.add(Box.createHorizontalGlue()); //right aligning the JMenuBar. this line of code was got from https://stackoverflow.com/questions/8560810/aligning-jmenu-on-the-right-corner-of-jmenubar-in-java-swing


            menu.setBackground(Color.lightGray);    //setting the JMenuBar background color to grey
            menu.add(homeMenu); //adding the JMenu components to the JMenuBar

            header.setFont(font); //applying the font to the header

            //ADDING THE JTEXTFIELDS, JLABELS AND JBUTTONS TO THE CONTENT PANE//
            pane.add(titlejt);
            pane.add(title);
            pane.add(add);

            //BEGINNING OF ABSOLUTE POSITIONING//
            Insets insets = pane.getInsets();   //creating an instance of the insets class and applying it to the content pane
            Dimension size = header.getPreferredSize(); //using the getPrefferedSize(pre-written method) to create a suitable size for the visit store button
            header.setBounds(200 + insets.left, 40 + insets.top, //setting the dimensions
                    size.width, size.height);

            size = titlejt.getPreferredSize();
            titlejt.setBounds(400 + insets.left, 150 + insets.top,
                    size.width, size.height);
            size = title.getPreferredSize();
            title.setBounds(325 + insets.left, 100 + insets.top,
                    size.width, size.height);
            
            size = add.getPreferredSize();
            add.setBounds(450 + insets.left, 200 + insets.top,
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

            else if (e.getSource() == add) { //if 'add Pokemon' JButton is clicked

                //VALIDATION//

                if (titlejt.getText().equals("")) { //if the JTextfield for title is empty
                    JOptionPane.showMessageDialog(null, "Title can't be empty"); //display this message
                }

                        else {

                            String title; //declaring variables
                            title = titlejt.getText(); //getting the text from their respective JTextfield


                            ArrayList<Pokemon> Pokemons = AddPokemon.getPokemons(); //getting the ArrayList, Pokemons
                            Pokemon b1 = new Pokemon(title); //creating a new Pokemon using my instantiable class 'Pokemon' (b1) and adding to them

                            Pokemons.add(b1); //adding my new Pokemon object to my Pokemons arraylist



                                JOptionPane.showMessageDialog(null, getPokemons());

                            //resetting all the JTextfields after the new Pokemon has been added
                            titlejt.setText("");

                            //saving my new Pokemon object to the arraylist        //coded with the help of John Brosnan notes
                            try {
                                //TRYING TO SAVE A Pokemon TO MY ARRAYLIST//
                                File f = new File("allPokemons2.dat"); //creating the new file to save to
                                FileOutputStream fos = new FileOutputStream(f); //creating the output stream to the file
                                ObjectOutputStream oos = new ObjectOutputStream(fos); //creating the object output stream and connecting it to the file output stream which takes the object to the file

                                oos.writeObject(Pokemons); //writing my Pokemons array to the object output stream
                                oos.close(); //closing the stream

                            }
                            catch (Exception ex) {//exception code if saving fails
                                System.out.println("Exception occurred");
                                System.out.println(ex);
                            }

                        } 
                    }
                }

        private void homeMenu () {

            homeMenu = new JMenu("Home");

            goBack = new JMenuItem("Return to Main Menu");
            goBack.addActionListener(this);
            homeMenu.add(goBack);
        }
    }
    
