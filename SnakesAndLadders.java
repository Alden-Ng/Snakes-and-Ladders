/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alden
 */
public class SnakesAndLadders {

    //create variables 
    public static final int NUM_PLAYERS = 2;
    public static final int NUM_SQUARES = 100;

    private SnLSquare[] board;
    private int[] players;
    private Dice dice;

    //setting default game with 2 players
    public SnakesAndLadders() {
        this(NUM_PLAYERS);
    }

    //setting game with n players
    public SnakesAndLadders(int nPlayers) {
        if (nPlayers < 2) {
           // throw new IllegalArgumentException("Must have at least 2 players");
        }
        board = new SnLSquare[NUM_SQUARES];
        players = new int[nPlayers];
        dice = new Dice();
        
        for (int i = 0; i < players.length; i++) {
            players[i] = 1;
        }
        makeBoard();
    }

    //creating the board with different squares
    // I understand it is most part of the UML diagram but just makes the constructor more organized 
    private void makeBoard(){
        for(int i = 0; i < NUM_SQUARES; i++){
            board[i] = new SnLSquare(i + 1);
        }
        board[3] = new LadderSquare(4, 14);
        board[8] = new LadderSquare(9, 31);
        board[19] = new LadderSquare(20, 38);
        board[27] = new LadderSquare(28, 84);
        board[39] = new LadderSquare(40, 59);
        board[62] = new LadderSquare(63, 81);
        board[70] = new LadderSquare(71, 91);
        board[16] = new SnakeSquare(17, 7);
        board[53] = new SnakeSquare(54, 34);
        board[61] = new SnakeSquare(62, 18);
        board[63] = new SnakeSquare(64, 60);
        board[86] = new SnakeSquare(87, 26);
        board[92] = new SnakeSquare(93, 73);
        board[94] = new SnakeSquare(95, 75);
        board[98] = new SnakeSquare(99, 78);
    }
    
    //rolls the dice and moves the player onto the new board position
    //if it rolls a double, return true and call takeTurn again with same player
    public boolean takeTurn(int player) {
        int roll = dice.roll();
        if (players[player] + roll > 100) {
            int track = 0;
            for (int i = players[player]; i < 100; i++) {
                track++;
            }
            track = roll - track;
            players[player] = 100 - track;
        } else {
            players[player] += roll;
        }
        System.out.println("Player "+(player)+" rolled "+roll);
        players[player] = board[players[player] - 1].landOn();

        return dice.hasDoubles();
    }

    //checks if the player has landed on square 100
    public boolean isPlayerWinner(int player) {
        return players[player] == 100;
    }

    //checks if a player won
    public int getWinner() {
        for (int i = 0; i < players.length; i++) {
            if (players[i] == 100) {
                return i;
            }
        }
        return -1;
    }

    //returns which square the player is currently on
    public int getPlayerPosition(int player) {
        return players[player];
    }

    //prints the board
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < NUM_SQUARES; i++) {
            s += "|" + board[i].toString();
            if ((i + 1) % 10 == 0) {
                s += "\n";
            }
        }
        return s;
    }

    public String toStringCurrentPositions() {
        String s = "";
        for (int i = 0; i < players.length; i++) {
            s += i + ":" + board[players[i] - 1] + " ";
        }
        return s;
    }

    //main function creating a Snakes and Ladders game
    public static void main(String args[]) {
        SnakesAndLadders game = new SnakesAndLadders();
        System.out.println(game.toString());
        int i = 0;
        while (game.getWinner() == -1){
            while(game.takeTurn(i)){ 
                System.out.println(game.toStringCurrentPositions());
            }
            System.out.println(game.toStringCurrentPositions());
            i++;
            if(i==game.players.length){
                i=0;
            }
        }
        System.out.println("Player "+(game.getWinner())+" wins.");
    }
}
