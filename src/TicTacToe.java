
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static int bodyScore = 0;
    static int crinaScore = 0;
    static Scanner input = new Scanner(System.in);


    public static void main(String [] args){

        char [][] game = {{'_','|','_','|','_'},{'_', '|', '_','|','_'},{' ','|',' ','|',' '}};
        printBoard(game);
        boolean gameOver = false;
        boolean playAgain = true;

        while(playAgain) {
            while (!gameOver) {
                System.out.println("Welcome to Tic Tac Toe!!");
                playerMove(game);
                gameOver = isGameOver(game);
                if (gameOver) {
                    break;
                }

                crinaMove(game);
                gameOver = isGameOver(game);
                if (gameOver) {
                    break;
                }
            }
            System.out.println("Player Score: " +bodyScore);
            System.out.println("Computer Score: "+ crinaScore);
            System.out.println("Would you like to play again? Y/N");
            input.nextLine();
            String result = input.nextLine();

            switch (result){
                case "Y":
                case "y":
                    playAgain = true;
                    System.out.println("Dope! Let's play again");
                    resetBoard(game);
                    gameOver = false;
                    printBoard(game);
                    break;

                case "N":
                case "n":
                    playAgain = false;
                    System.out.println("Thanks for playing");
                    break;
                default:
                    break;
            }

        }
    }


    public static void printBoard(char [][] gameBoard){

        for(char[] row : gameBoard){
            for( char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }


    public static void updateBoard( int position, int player, char [][] gameBoard){

        char character;

        if(player==1){
            character = 'X';
        }else{
            character = 'O';
        }

        switch (position){

            case 1:
                gameBoard[0][0] = character;
                printBoard(gameBoard);
                break;
            case 2:
                gameBoard[0][2] = character;
                printBoard(gameBoard);
                break;
            case 3:
                gameBoard[0][4] = character;
                printBoard(gameBoard);
                break;
            case 4:
                gameBoard[1][0] = character;
                printBoard(gameBoard);
                break;
            case 5:
                gameBoard[1][2] = character;
                printBoard(gameBoard);
                break;
            case 6:
                gameBoard[1][4] = character;
                printBoard(gameBoard);
                break;
            case 7:
                gameBoard[2][0] = character;
                printBoard(gameBoard);
                break;
            case 8:
                gameBoard[2][2] = character;
                printBoard(gameBoard);
                break;
            case 9:
                gameBoard[2][4] = character;
                printBoard(gameBoard);
                break;
            default:
                break;

        }

    }


    public static void playerMove(char[][] gameBoard){

        System.out.println("Please make a move. (1-9)");


        int move = input.nextInt();

        boolean result = isValidMove(move,gameBoard);

        while(!result){
            System.out.println(" Invalid Move. Try again");
            move = input.nextInt();
            result = isValidMove(move,gameBoard);
        }

        System.out.println("Body moved at position " + move);
        updateBoard(move,1,gameBoard);


    }


    public static boolean isValidMove(int move, char[][] game){

        switch (move){
            case 1:
                if(game[0][0] == '_'){
                    return true;
                } else{
                    return false;
                }
            case 2:
                if(game[0][2] == '_'){
                    return true;
                } else{
                    return false;
                }
            case 3:
                if(game[0][4] == '_'){
                    return true;
                } else{
                    return false;
                }

            case 4:
                if(game[1][0] == '_'){
                    return true;
                } else{
                    return false;
                }
            case 5:
                if(game[1][2] == '_'){
                    return true;
                } else{
                    return false;
                }
            case 6:
                if(game[1][4] == '_'){
                    return true;
                } else{
                    return false;
                }
            case 7:
                if(game[2][0] == ' '){
                    return true;
                } else{
                    return false;
                }
            case 8:
                if(game[2][2] == ' '){
                    return true;
                } else{
                    return false;
                }
            case 9:
                if(game[2][4] == ' '){
                    return true;
                } else{
                    return false;
                }

            default:
                return false;
        }

    }

    public static void crinaMove(char [][] gameBoard){

        Random rand = new Random();
        int move = rand.nextInt(9)+1;

        boolean result = isValidMove(move,gameBoard);

        while(!result){
            move = rand.nextInt(9)+1;
            result = isValidMove(move, gameBoard);
        }

        System.out.println("Crina moved at position "+ move);
        updateBoard(move,2,gameBoard);
    }


    public static boolean isGameOver(char [][] game){

        //Horizontal Win
        if(game[0][0] == 'X'&& game[0][2] == 'X' && game [0][4] == 'X' ){
            System.out.println("Body Wins");
            bodyScore++;
            return true;
        }
        if(game[0][0] == 'O'&& game[0][2] == 'O' && game [0][4] == 'O' ){
            System.out.println("Crina Wins");
            crinaScore++;
            return true;
        }
        if(game[1][0] == 'X'&& game[1][2] == 'X' && game [1][4] == 'X' ){
            System.out.println("Body Wins");
            bodyScore++;
            return true;
        }
        if(game[1][0] == 'O'&& game[1][2] == 'O' && game [1][4] == 'O' ){
            System.out.println("Crina Wins");
           crinaScore++;
            return true;
        }
        if(game[2][0] == 'X'&& game[2][2] == 'X' && game [2][4] == 'X' ){
            System.out.println("Body Wins");
          bodyScore++;
            return true;
        }
        if(game[2][0] == 'O'&& game[2][2] == 'O' && game [2][4] == 'O' ) {
            System.out.println("Crina Wins");
           crinaScore++;
            return true;
        }

        //Vertical Wins

        if(game[0][0] == 'X'&& game[1][0] == 'X' && game [2][0] == 'X' ){
            System.out.println("Body Wins");
          bodyScore++;
            return true;
        }
        if(game[0][0] == 'O'&& game[1][0] == 'O' && game [2][0] == 'O' ){
            System.out.println("Crina Wins");
            crinaScore++;
            return true;
        }

        if(game[0][2] == 'X'&& game[1][2] == 'X' && game [2][2] == 'X' ){
            System.out.println("Body Wins");
            bodyScore++;
            return true;
        }
        if(game[0][2] == 'O'&& game[1][2] == 'O' && game [2][2] == 'O' ){
            System.out.println("Crina Wins");
            crinaScore++;
            return true;
        }

        if(game[0][4] == 'X'&& game[1][4] == 'X' && game [2][4] == 'X' ){
            System.out.println("Body Wins");
            bodyScore++;
            return true;
        }
        if(game[0][4] == 'O'&& game[1][4] == 'O' && game [2][4] == 'O' ){
            System.out.println("Crina Wins");
            bodyScore++;
            return true;
        }

        //Diagonal Wins
        if(game[0][0] == 'X'&& game[1][2] == 'X' && game [2][4] == 'X' ){
            System.out.println("Body Wins");
            crinaScore++;
            return true;
        }
        if(game[0][0] == 'O'&& game[1][2] == 'O' && game [2][4] == 'O' ){
            System.out.println("Crina Wins");
            bodyScore++;
            return true;
        }

        if(game[2][0] == 'X'&& game[1][2] == 'X' && game [0][4] == 'X' ){
            System.out.println("Body Wins");
            crinaScore++;
            return true;
        }
        if(game[2][0] == 'O'&& game[1][2] == 'O' && game [0][4] == 'O' ){
            System.out.println("Crina Wins");
            bodyScore++;
            return true;
        }

        if(game[0][0] != '_' && game[0][2] != '_' && game[0][4] != '_' && game[1][0] !='_'&&
                game[1][2] != '_' && game[1][4] != '_' && game[2][0] != ' ' && game[2][2] != ' ' && game[2][4] != ' '){
            System.out.println("Its a tie");
            return true;
        }




        return false;}

    public static void resetBoard(char [][] gameBoard){
        gameBoard[0][0] = '_';
        gameBoard[0][2] = '_';
        gameBoard[0][4] = '_';
        gameBoard[1][0] = '_';
        gameBoard[1][2] = '_';
        gameBoard[1][4] = '_';
        gameBoard[2][0] = ' ';
        gameBoard[2][2] = ' ';
        gameBoard[2][4] = ' ';

    }
}
