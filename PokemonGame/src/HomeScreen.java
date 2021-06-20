import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;

    //MAIN CLASS//
    public class HomeScreen extends JFrame { //HomeScreen inherits from JFrame and implements the ActionListener Interface

        static JButton playGameButton, quitButton; //JButton global variables
        static JFrame frame = new JFrame();


        //CONSTRUCTOR
        public HomeScreen() { //CODED WITH THE HELP OF JOHN BROSNANS NOTES
            //creates the JFrame Window

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //making it closeable
            frame.setResizable(false); //choose not to resize it because of absolute positioning


            addComponentsToPane(frame.getContentPane()); //sets up the content pane using the addComponentsToPane method

            frame.setSize(900, 600); //JFrame size
            frame.setVisible(true); //making the JFrame visible


        }

        /**
         * Button Event Handling
         */

        //BUTTON EVENT HANDLING

        public static class ButtonEventHandler implements ActionListener { //implementing the ActionListener interface to the ButtonEventHandler class
            public void actionPerformed(ActionEvent e) { //actionPerformed method
                if (e.getSource() == playGameButton) { //if playGameButton is clicked
                    MainMenu menu = new MainMenu(); //create an instance of the class MainMenu(MainMenu JFrame)
                    menu.setVisible(true); //and make it visible

                    frame.setVisible(false); //hide the JFrame 'frame'
                }
                else if (e.getSource() == quitButton) {
                    JOptionPane.showMessageDialog(null, "The Program is Quiting Now");
                    System.exit(0);
                }

            }
        }

        /**
         * Container Pane
         * @param pane
         */

        //CONTAINER PANE
        public static void addComponentsToPane(Container pane) { //addComponentsToPane method
            pane.setLayout(null); //null layout required for absolute positioning because the dimensions for each object will be specific for absolute positioning

            playGameButton = new JButton("Enter the Game");   //'visit store' and 'quit' JButtons
            quitButton = new JButton("Quit");

            JLabel image = new JLabel(new ImageIcon("C:\\Users\\shane\\OneDrive\\Desktop\\OOPRepeat\\PokemonGame\\PokemonImage.jpg")); //displaying homescreen image using image icon in a JLabel
            //IMAGE REFERENCE: https://www.nintendolife.com/news/2012/10/feature_the_bizarre_history_of_pokemon_technology


            JLabel header = new JLabel("Welcome to Shane's Pokemon Game"); //page header
            Font font = new Font("monospaced", Font.PLAIN, 24); //header font

            playGameButton.setSize(30, 50); //declaring JButton sizes
            quitButton.setSize(30, 50);
            header.setFont(font); //applying the font to the header



            pane.add(playGameButton); //adding my visit store and quit JButtons to the content pane
            pane.add(quitButton);
            pane.add(image); //adding the main image to the content pane
            pane.add(header); //adding the header to the content pane


            //BEGINNING OF ABSOLUTE POSITIONING

            //INSETS CODE GOTTEN FROM https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/layout/AbsoluteLayoutDemoProject/src/layout/AbsoluteLayoutDemo.java
            ////https://docs.oracle.com/javase/tutorial/uiswing/layout/none.html

            Insets insets = pane.getInsets();       //creating an instance of the insets class and applying it to the content pane
            Dimension size = playGameButton.getPreferredSize();   //using the getPrefferedSize(pre-written method) to create a suitable size for the visit store button
            playGameButton.setBounds(300 + insets.left, 500 + insets.top, //setting the dimensions
                    size.width, size.height);
            size = quitButton.getPreferredSize();
            quitButton.setBounds(500 + insets.left, 500 + insets.top,
                    size.width, size.height);

            size = image.getPreferredSize();
            image.setBounds(205 + insets.left, 100 + insets.top,
                    size.width, size.height);
            size = header.getPreferredSize();
            header.setBounds(200 + insets.left, 60 + insets.top, size.width, size.height);

            //END OF ABSOLUTE POSITIONING

            ButtonEventHandler handler = new ButtonEventHandler(); //creating instances of the button event handler and adding an action listener to my visit store and quit buttons
            playGameButton.addActionListener(handler);

            ButtonEventHandler handler2 = new ButtonEventHandler();
            quitButton.addActionListener(handler2);
        }

        /**
         * Main Method
         * @param args
         */
        //Main Method//
        public static void main(String[] args) { //MAIN METHOD

            new HomeScreen(); //creates/calls the HomeScreen JFrame

        }
    }


