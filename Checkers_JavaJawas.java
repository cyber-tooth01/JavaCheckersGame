//Hugo Cordova, Samuel Ralph, Maximiliano Davila this program is made to play tic-tac-toe against local players
//Sam assisted int the UI and AI
//Hugo took care of all the features except AI and assisted with game logic
//Max wrote win conditions and game logic
//Showing Ishmael how to merge and pull request 

/*

Title

***************************
*        Checkers         *
***************************

Concept

This program provide a fun game that is
created to be enjoyed that is Checkers,
where you vs a player or a AI can play
and win but also lose

 */

import java.util.Scanner;

    


public class Checkers_JavaJawas {

    //Requirements that help run the program
    public static final String RED_Color = "\u001B[31m";
    public static final String BLACK_Color = "\u001B[30m";
    public static final String reset = "\u001B[0m";
    static final char EMPTY = '-';
    static final char RED = 'R';
    static final char BLACK = 'B';
    static char[][] board = new char[8][8];
    static boolean isRedTurn = true; // Red goes first
    // Add this constant to represent a king
    static final char RED_KING = 'K';
    static final char BLACK_QUEEN = 'Q';
    public static int scoreX = 0;
    public static int scoreO = 0;

    public static void main(String[] args) {

        //Declare the variables
        Scanner in = new Scanner(System.in);
        int optiontoChosePLayer = 0;

        initializeBoard();


        //Title to the game
        try {
            Thread.sleep(150);
            System.out.println("_______            |         _______  |                     |       ");
            Thread.sleep(150);
            System.out.println("|         __   ____|  ____  |         |_____   ____   ____  | /    ");
            Thread.sleep(150);
            System.out.println("|        /  \\  |   | |___|  |         |    |  |___|  |      |/       ");
            Thread.sleep(150);
            System.out.println("|_______ \\__/  |___| |___   |_______  |    |  |___   |____  |  \\    ");
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Explain the program to the user
        println("\nDeveloped by Samuel Ralph, Dávila, and Hugo Cordova");
        println("\nAlso known as the JavaJawas");
        println("\nThis game is called CODE CHECK and its");
        println(" a checkers name. In this game ");
        println("you play vs a player or an AI ");
        println("where you can win but also lose");



        while (true) {
            //Reset core game values
            initializeBoard();

            //Menu of selections of game-modes
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
                println("\nThe board in this game is on two axes, one x and one y.\nVertically, it goes from 0 to 7, and horizontally it goes 0 to 7.");

                //Clear char array
                initializeBoard();

                //Use non-AI game loop
                playGame();


                println(" ");



            }

            //Vs an ai machine
            if (optiontoChosePLayer == 2) {

                //Option 2: AI player
                print("\nYou chose to play against the computer");

                //Clear char array
                initializeBoard();

                //Use AI version of game loop
                playGameAI();


                println(" ");

                //Print scoreboard
                println("Wins for 'O' player: " + scoreO);
                println("Wins for 'X' player: " + scoreX);


            }

            if (optiontoChosePLayer == 3) {
                println("Have a nice day my friend");
                break;
            }
        }
    }


    
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
    
            System.out.println("\n");
    
            System.out.println("----- Code Check-----");

            System.out.print("  ");
            for(int j = 0; j < 8; j++){
                System.out.print(j + " ");
            }
            System.out.println();
    
            for (int i = 0; i < 8; i++) {
                System.out.print(i + "|");
                for (int j = 0; j < 8; j++) {
                    if(board[i][j] == 'R'){
                        System.out.print(RED_Color + board[i][j] + reset + " ");
                    } else if (board[i][j] == 'B') {
                        System.out.print(BLACK_Color + board[i][j] + reset + " ");
                    } else if (board[i][j] == 'Q') {
                        System.out.println(BLACK_Color + board[i][j] + reset + " ");
                    } else if (board[i][j] == 'K') {
                        System.out.println(RED_Color + board[i][j] + reset + " ");
                    } else{
                        System.out.print(board[i][j] + " ");
                    }

                }
                System.out.println();



            }
        }

        public static void switchTurn() {
            isRedTurn = !isRedTurn;
        }
    
        public static boolean isValidMove(int row1, int col1, int row2, int col2) {
                
            if(board[row1][col1] == RED || board[row1][col1] == BLACK){    
                // Check if its within the board bounds
                if (row1 < 0 || row1 > 7 || col1 < 0 || col1 > 7 ||
                    row2 < 0 || row2 > 7 || col2 < 0 || col2 > 7) {
                    return false;
                }

                // Check if the destination cell is empty
                if (board[row2][col2] != EMPTY) {
                    return false;
                }

                // Check if the move is diagonal
                int rowDiff = Math.abs(row2 - row1);
                int colDiff = Math.abs(col2 - col1);
                if (rowDiff != 1 || colDiff != 1) {
                    // Check if it's a capture
                    if (rowDiff == 2 && colDiff == 2) {
                        int midRow = (row1 + row2) / 2;
                        int midCol = (col1 + col2) / 2;
                        // Check if there's an opponent's piece to capture
                        if ((isRedTurn && board[midRow][midCol] != BLACK) || (!isRedTurn && board[midRow][midCol] != RED)) {
                            return false;
                        }
                        return true;
                    }
                    return false;
                }

                // Check if the piece is moving in the correct direction based on the player's turn
                if (isRedTurn && row2 <= row1 || !isRedTurn && row2 >= row1) {
                    return false;
                }

                // Check if the piece belongs to the player
                if (isRedTurn && board[row1][col1] != RED || !isRedTurn && board[row1][col1] != BLACK) {
                    return false;
                }
            
            }    

            if(board[row1][col1] == RED_KING || board[row1][col1] == BLACK_QUEEN){

                if (row1 < 0 || row1 > 7 || col1 < 0 || col1 > 7 || row2 < 0 || row2 > 7 || col2 < 0 || col2 > 7) {
                    return false;
                }

                // Check if the destination cell is empty
                if (board[row2][col2] != EMPTY) {
                    return false;
                }

                // Check if the move is diagonal
                int rowDiff = Math.abs(row2 - row1);
                int colDiff = Math.abs(col2 - col1);
                if (rowDiff != 1 || colDiff != 1) {
                    // Check if it's a capture
                    if (rowDiff == 2 && colDiff == 2) {
                        int midRow = (row1 + row2) / 2;
                        int midCol = (col1 + col2) / 2;
                        // Check if there's an opponent's piece to capture
                        return (isRedTurn && board[midRow][midCol] == BLACK) || (isRedTurn && board[midRow][midCol] == BLACK_QUEEN) || (!isRedTurn && board[midRow][midCol] == RED) || (!isRedTurn && board[midRow][midCol] == RED_KING);
                    }
                    return false;
                }

                // Check if the piece belongs to the player
                if (isRedTurn && board[row1][col1] != RED || !isRedTurn && board[row1][col1] != BLACK) {
                    return false;
                }

            }     

            // Valid move
            return true;
            
        }



        
    
        public static void makeMove(int row1, int col1, int row2, int col2) {
            
            
            // Check if the move is valid
            if (isValidMove(row1, col1, row2, col2) == false) {
                System.out.println("Invalid move, try again.");
            return;
            }

            // Perform the move
            if(board[row1][col1] == RED || board[row1][col1] == BLACK){
                board[row1][col1] = EMPTY;
                if (isRedTurn){
                    board[row2][col2] = RED;
                }
                if (!isRedTurn){
                    board[row2][col2] = BLACK;
                }
            }

            if(board[row1][col1] == RED_KING || board[row1][col1] == BLACK_QUEEN){
                board[row1][col1] = EMPTY;
                if (isRedTurn){
                    board[row2][col2] = RED_KING;
                }
                if (!isRedTurn){
                    board[row2][col2] = BLACK_QUEEN;
                }
            }

            

            if (board[7][col2] == RED){
                board[7][col2] = RED_KING;
            }
            if (board[0][col2] == BLACK){
                board[0][col2] = BLACK_QUEEN;
            }

            // Check for captures
            int midRow = (row1 + row2) / 2;
            int midCol = (col1 + col2) / 2;
            if (Math.abs(row2 - row1) == 2 && Math.abs(col2 - col1) == 2) {
                // Capture occurred, remove the opponent's piece
                board[midRow][midCol] = EMPTY;
            }
            // Switch turn
            switchTurn();
            
        }
    
        public static void playGame(){
    
            Scanner scanner = new Scanner(System.in);
    
            while (true) {
    
                printBoard();
                System.out.println("");

                if (isRedTurn) {
                    System.out.println("Red's turn");
                } else {
                    System.out.println("Black's turn");
                }

                System.out.println("Select X coordinate of the piece you want to move (0-7): ");
                int col1 = scanner.nextInt();
                
                System.out.println("Select Y coordinate of the piece you want to move (0-7): "); 
                int row1 = scanner.nextInt();
    
                System.out.println("Select X coordinate of where you want to move (0-7): ");
                int col2 = scanner.nextInt();
                
                System.out.println("Select Y coordinate of where you want to move (0-7): "); 
                int row2 = scanner.nextInt();
                
                

                
                if (isValidMove(row1, col1, row2, col2)) {
    
                    makeMove(row1, col1, row2, col2);
                    
    
                } else {
                    System.out.println("Invalid move, try again.");
                }

                if(CheckForWin().equals("RedWinner")){
                    System.out.println("Congratulations Red! You won!");
                    break;
                } else if (CheckForWin().equals("BlackWInner")) {
                    System.out.println("Congratulations Black! You won!");
                    break;
                }
            }

        }

        public static String CheckForWin(){
            String RedWin = "RedWinner";
            String BlackWin = "BlackWinner";

            for (char[] chars : board) {
                for (int secondNum = 0; secondNum < board.length; secondNum++) {
                    if (chars[secondNum] != 'R') {
                        return BlackWin;
                    } else if (chars[secondNum] != 'B') {
                        return RedWin;
                    }
                }
            }
            return null;
        }
        public static void playGameAI(){
    
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
        public static void print (String msg){
            System.out.print(msg);
        }
    
        //Shortcut to use println
        public static void println (String msg){
            System.out.println(msg);
        }
    
        
    }

    
