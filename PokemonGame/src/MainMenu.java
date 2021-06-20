import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


    //*MAIN CLASS*//
    public class MainMenu extends JFrame implements ActionListener //MainMenu inherits from JFrame and implements the Action Listener interface
    {
        JMenu gameMenu;
        JMenu pokemonMenu;
        private static JMenuItem pGame, qGame;
        private static JMenuItem pAddPokemon;

        //MAIN CLASS//
        public static void main(String[] args) {
            MainMenu frame = new MainMenu(); //calling the MainMenu JFrame window
            frame.setVisible(true); //making it visible
        }


        //CONSTRUCTOR//
        public MainMenu() {
            Container pane; //content pane variable

            setTitle("Pokemon");
            setSize(600, 200);
            setResizable(false);               //window properties
            setLocation(250, 200);

            setDefaultCloseOperation(EXIT_ON_CLOSE);

            pane = getContentPane(); //calling the content pane
            pane.setLayout(new FlowLayout()); //setting the layout of the JFrame to FlowLayout

            playGameMenu();
            addPokemonMenu();

            JMenuBar menu = new JMenuBar(); //creating an instance of the JMenuBar class
            setJMenuBar(menu); //setting the JMenuBar up
            menu.add(Box.createHorizontalGlue()); //this line of code was got from https://stackoverflow.com/questions/8560810/aligning-jmenu-on-the-right-corner-of-jmenubar-in-java-swing
            //right aligns menu bar

            menu.setBackground(Color.lightGray);    //added components to the JMenu bar
            menu.add(gameMenu);
            menu.add(pokemonMenu);

            JLabel label = new JLabel("Welcome to Shane's Pokemon Game"); //main header
            Font font = new Font("monospaced", Font.PLAIN, 28); //font for the header
            label.setFont(font); //applying the font to the header
            pane.add(label); //adding label to the JFrame
        }


        //Action Event Code (Buttons)//
        public void actionPerformed (ActionEvent e) //coded with the help of John Brosnan notes
        {
            if (e.getSource() == pAddPokemon) { //if pGame (Add Book) is clicked
                JOptionPane.showMessageDialog(null, "Re-directing you to Add Pokemon Page"); //display this message
                AddPokemon add = new AddPokemon(); //create an instance of the AddBook class
                add.setVisible(true); //make the AddBook JFrame visible
                this.setVisible(false);//hide the current MainMenu JFrame window
            }

            if (e.getSource() == pGame) { //if pGame (Add Book) is clicked
                JOptionPane.showMessageDialog(null, "Re-directing you to Play Game Page"); //display this message
                PlayGame play = new PlayGame(); //create an instance of the AddBook class
                play.setVisible(true); //make the AddBook JFrame visible
                this.setVisible(false);//hide the current MainMenu JFrame window
            }

            if (e.getSource() == qGame) { //if quit game is is clicked
                System.exit(0);
            }
        }



        //JMENUBAR COMPONENTS//
        public void playGameMenu () { //coded with the help of John Brosnan notes

            gameMenu = new JMenu("Play Game"); //creating 'Play Game' in the JMenuBar

            pGame = new JMenuItem("Play Game");
            pGame.addActionListener(this); //adding an action listener to 'pGame' (Add Book)
            gameMenu.add(pGame); //adding the JMenuItem to the books option in the menu bar

            JMenuItem qGame = new JMenuItem("Quit Game");
            qGame.addActionListener(this); //adding an action listener to 'pGame' (Add Book)
            gameMenu.add(qGame); //adding the JMenuItem to the books option in the menu bar
            
        }


        private void addPokemonMenu () {

            pokemonMenu = new JMenu("Pokemons"); //creating orders

            pAddPokemon = new JMenuItem("Add Pokemon");
            pAddPokemon.addActionListener(this);
            pokemonMenu.add(pAddPokemon);
        }
    }

