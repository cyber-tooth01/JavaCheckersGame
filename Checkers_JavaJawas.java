/*  CSI Checkers 2024
* Below you will find a template for creating your Checkers game.
*
* TO-DO comments:
* Notice the "TO-DO" (without the '-') code comments, so that you may keep track of the code that is left to
* be written. To see the list of TO-DO comments, go to View -> Tool Windows -> TO-DO.
* Make sure to remove the TO-DO (without the '-') word when the code implementation in
* that section of code has been completed
*
* The DEBUGGER is a powerful tool for troubleshooting your code, especially for logical errors. ]
*    Use it while you can!
*
* Make sure to personalize this Checkers game app.
*
* Happy coding!!!
*
* Template provided by prof. Reynaldo Belfort, S.J.
* */

//TODO: ^^^ Remove the comments above ^^^


//TODO << YOUR TEAM NAME HERE >>
    //TODO << YOUR TEAM MEMBERS HERE >>

//Hugo Cordova, Samuel Ralph, Maximiliano Davila this program is made to play Checkers against local players and AI
//Sam task is to do the UI for the board and the AI for the game, also do the debugging.
//Hugo Task is to do all the features in the game.
//Max (Team Leader): task to do the basic logic, commenting and help all around the team.

/*

Title 

***************************
*         Checkers        *
***************************

Concept 

This program provide a fun game that is 
created to be enjoyed that is Checkers,
where you vs a player or a AI can play
and win but also lose or draw

Board

 public static void initializeBoard() {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if ((i + j) % 2 != 0) {
                        if (i < 3) {
                            board[i][j] = RED;
                        } else if (i > 4) {
                            board[i][j] = BLACK;
                        } else {
                            board[i][j] = EMPTY;
                        }
                    } else {
                        board[i][j] = EMPTY;
                    }
                }
            }
        }



 */


    import java.util.Scanner;

    public class Checkers_JavaJawas {
    
        static final char EMPTY = '-';
        static final char RED = 'R';
        static final char BLACK = 'B';
        static char[][] board = new char[8][8];
        static boolean isRedTurn = true; // Red goes first
    
        public static void initializeBoard() {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if ((i + j) % 2 != 0) {
                        if (i < 3) {
                            board[i][j] = RED;
                        } else if (i > 4) {
                            board[i][j] = BLACK;
                        } else {
                            board[i][j] = EMPTY;
                        }
                    } else {
                        board[i][j] = EMPTY;
                    }
                }
            }
        }
    
        public static void printBoard() {
            //TODO: YOUR CODE HERE
    
            System.out.println("\n");
    
            System.out.println("----- YOUR BOARD HERE-----");
    
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }
    
        public static boolean isValidMove(int row1, int col1, int row2, int col2) {
            //TODO: YOUR CODE HERE
            return true;
        }
    
        public static void makeMove(int row1, int col1, int row2, int col2) {
            //TODO: YOUR CODE HERE
        }
    
        public static void playGame(){
    
            //TODO: MODIFY TEMPLATE CODE
    
            Scanner scanner = new Scanner(System.in);
    
            while (true) {
    
                printBoard();
    
                if (isRedTurn) {
                    System.out.println("Red's turn");
                } else {
                    System.out.println("Black's turn");
                }
    
                System.out.print("Enter move (row1 col1 row2 col2): ");
                int row1 = scanner.nextInt();
                int col1 = scanner.nextInt();
                int row2 = scanner.nextInt();
                int col2 = scanner.nextInt();
    
                if (isValidMove(row1, col1, row2, col2)) {
    
                    makeMove(row1, col1, row2, col2);
                    
    
                } else {
                    System.out.println("Invalid move, try again.");
                }
            }
        }
    
        
        public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int optiontoChosePLayer = 0;
    
            //TODO: ADJUST TEMPLATE CODE HERE

            System.out.println("");
    
            print("\n***************************");
            print("*         Checkers        *");
            print("***************************");
            
    
            System.out.println("\nThis game is made to play Checkers");
            System.out.println("where player can move their checks");
            System.out.println("with the numbers on the side in where");
            System.out.println("P is the checks and with that the game");
            System.out.println("Starts!!!!");

            //Menu of selections of gamemodes 
            println("\n-------- Menu -------");
            println("1. Versus a local player");
            println("2. Versus an AI machine");
            println("3. Quit");

            //Let the user decide the option
            println("Please choose an option:");
            optiontoChosePLayer = in.nextInt();

             //Vs a local player
             if (optiontoChosePLayer == 1) {

                //Option 1: Local player
                println("\nYou chose to play against a local player");
            
                //Initial set up
        
                initializeBoard();
        
                //Start the game
                playGame();

                
             }
        
           
        }

         //Shortcut to use print
         public static void print (String msg){
            System.out.print(msg);
        }

        //Shortcut to use println
        public static void println (String msg){
            System.out.println(msg);
        }

    }
    