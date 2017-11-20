package battleship;

import java.util.Scanner;

public class Battleships {
    public static void main(String[] args) {
        Player p1, p2;
        Scanner input;
        input = new Scanner(System.in);
		int gameType = 0;
		Input inputObject = new Input();
	
		System.out.println("Welcome to the game of Battleships!");
		System.out.println("Select your game mode:");
		System.out.println("1- Demo	(1 cruiser, 2 destroyers)");
		System.out.println("2- Casual	(1 battleship, 2 cruisers, 3 destroyers");
		System.out.println("3- Complete	(1 carrier, 2 battleships, 3 cruisers, 4 destroyers");
		do{
			try{
				gameType = Integer.parseInt(input.nextLine());
				if (gameType < 1 || gameType > 3)
					System.out.print("Error: You must enter a number between 1 and 3");
			}
			catch (NumberFormatException ex){
				System.out.print(ex.getMessage() + "\nEnter again: ");
			}
		}while (gameType < 1 || gameType > 3);
        
        System.out.print("Player 1, enter your name: ");
        p1 = new Player(input.nextLine(), gameType);
        
        System.out.print("Player 2, enter your name: ");
        p2 = new Player(input.nextLine(), gameType);
        
        System.out.println(p1.getName() + " -- vs -- " + p2.getName() + "\n");
		System.out.println("In this game, coordinates are entered as two alphanumeric characters (e.g. B5).\nDirections are entered as north (n), south (s), east (e) or west (w)");
		pressEnterToContinue();
	
		p1.setShips(p1.ships, inputObject);
		pressEnterToContinue();
		print20Newlines();
		p2.setShips(p2.ships, inputObject);
		pressEnterToContinue();
		print20Newlines();
	
		System.out.println("The game begins now!");
	
		while (true){
		    System.out.println(p1.getName() + ", your turn!");
			pressEnterToContinue();
			print20Newlines();
			System.out.println("=================  " + p1.getName() + "  =================");
			p1.printGrids();
			if (p1.attack(p2, inputObject)){
			System.out.println(p1.getName() + " is the winner!");
			break;
			}
	    
			System.out.println(p2.getName() + ", your turn");
			pressEnterToContinue();
			print20Newlines();
			System.out.println("=================  " + p2.getName() + "  =================");
			p2.printGrids();
			if(p2.attack(p1, inputObject)){
			System.out.println(p2.getName() + " is the winner!");
			break;
			}
		}
	
        input.close();
		System.exit(0);
    }
    
	/*	Method to prompt the user to press ENTER to continue running the program  */
    public static void pressEnterToContinue(){
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
