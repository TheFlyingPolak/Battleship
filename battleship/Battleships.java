package battleship;

import java.util.Scanner;

public class Battleships {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player p1, p2;
        Scanner input;
        input = new Scanner(System.in);
	int gameType;
	
	System.out.println("Welcome to the game of Battleships!");
	System.out.println("Select your game mode:");
	System.out.println("1- Demo	(1 cruiser, 2 destroyers)");
	System.out.println("2- Casual	(1 battleship, 2 cruisers, 3 destroyers");
	System.out.println("3- Complete	(1 carrier, 2 battleships, 3 cruisers, 4 destroyers");
	do{
	    gameType = input.nextInt();
	    if (gameType < 1 || gameType > 3){
		System.out.println("Error: You must enter a number between 1 and 3");
	    }
	}while (gameType < 1 || gameType > 3);
        
        System.out.print("Player 1, enter your name: ");
        p1 = new Player(input.next(), gameType);
        
        System.out.print("Player 2, enter your name: ");
        p2 = new Player(input.next(), gameType);
        
        System.out.println(p1.getName() + " vs " + p2.getName() + "\n");
	
        p1.setShips(p1.ships);
	pressAnyKeyToContinue();
	print20Newlines();
	p2.setShips(p2.ships);
	pressAnyKeyToContinue();
	print20Newlines();
	
	System.out.println("The game begins now!");
	
	while (true){
	    System.out.println(p1.getName() + ", your turn!");
	    pressAnyKeyToContinue();
	    print20Newlines();
	    System.out.println("=================  " + p1.getName() + "  =================");
	    p1.printGrids();
	    if (p1.attack(p2)){
		System.out.println(p1.getName() + " is the winner!");
		break;
	    }
	    
	    System.out.println(p2.getName() + ", your turn");
	    pressAnyKeyToContinue();
	    print20Newlines();
	    System.out.println("=================  " + p2.getName() + "  =================");
	    p2.printGrids();
	    if(p2.attack(p1)){
		System.out.println(p2.getName() + " is the winner!");
		break;
	    }
	}
	
        input.close();
	System.exit(0);
    }
    
    public static void pressAnyKeyToContinue(){
	System.out.println("Press ENTER to continue...");
	try{
	    System.in.read();
	}
	catch(Exception e)
	{}
    }
    
    public static void print20Newlines(){
	for (int i = 0; i < 20; i++){
	    System.out.println();
	}
    }
}
