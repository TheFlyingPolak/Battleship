package battleship;

import java.util.Scanner;

public class Input{
    private int x;
    private int y;
    
    public Input(){
	
    }
    
    public void enterCoordinates(){
	String coordinate;
	String xAsString;
	char yAsChar;
	
	Scanner scanner = new Scanner(System.in);
	while(true){
		System.out.print("Enter coordinates: ");
		coordinate = scanner.next();
		yAsChar = coordinate.charAt(0);
		if (yAsChar >= 'A' && yAsChar <= 'J')
		    y = yAsChar - 'A';
		else if (yAsChar >= 'a' && yAsChar <= 'j')
		    y = yAsChar - 'a';
		else{
		    System.out.println("Error: Row character does not match the characters on the board");
		    continue;
		}
		
		xAsString = coordinate.substring(1, coordinate.length());
		try{
		    x = Integer.parseInt(xAsString) - 1;
		    if (x < 0 || x > 9){
			System.out.println("Error: Column number does not match the numbers on the board");
			continue;
		    }
		}
		catch (NumberFormatException e){
		    System.out.println("Error: Input string does not match expected format");
		    continue;
		}
		break;
	    }
    }
    
    public ShipDirection enterDirection(){
	String string;
	Scanner scanner = new Scanner(System.in);
	
	do{
            System.out.print("Enter direction: ");
            string = scanner.next().toLowerCase();
			
            if (!string.equals("north") && !string.equals("south") && !string.equals("east") && !string.equals("west") && !string.equals("n") && !string.equals("s") && !string.equals("e") && !string.equals("w"))
                System.out.println("Invalid input. Please enter (n)orth, (s)outh, (e)ast or (w)est");
            else{
                switch(string){
		    case "n":
                    case "north":   return ShipDirection.NORTH;
		    case "s":
                    case "south":   return ShipDirection.SOUTH;
		    case "e":
                    case "east":    return ShipDirection.EAST;
		    case "w":
                    case "west":    return ShipDirection.WEST;
                }
            }
        }while (!string.equals("east") && !string.equals("west") && !string.equals("north") && !string.equals("south") && !string.equals("n") && !string.equals("s") && !string.equals("e") && !string.equals("w"));
	return ShipDirection.NORTH;
    }
    
    public int getX(){
	return x;
    }
    
    public int getY(){
	return y;
    }
}
