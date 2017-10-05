/*
    Class Player facilitates the players' names, primary and tracking grids, list of ships
    
*/

package battleship;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    public static int NUMBER_OF_SHIPS = 4;
    private String name;
    Grid primary;
    Grid tracking;
    List<Ship> ships;

    public Player(String x, int gameType){
        name = x;
        primary = new Grid();
        tracking = new Grid();
        
        ships = new ArrayList<>();
	switch (gameType){
	    case 1:
		for (int i = 0; i < 3; i++){
		    if (i == 0){
			ships.add(i, new Ship(ShipType.CRUISER));
		    }
		    else{
			ships.add(i, new Ship(ShipType.DESTROYER));
		    }
		}
		break;
	    case 2:
		for (int i = 0; i < 6; i++){
		    if (i == 0){
			ships.add(i, new Ship(ShipType.BATTLESHIP));
		    }
		    else if (i == 1 || i == 2){
			ships.add(i, new Ship(ShipType.CRUISER));
		    }
		    else{
			ships.add(i, new Ship(ShipType.DESTROYER));
		    }
		}
		break;
	    case 3:
		for (int i = 0; i < 10; i++){
		    if (i == 0){
		        ships.add(i, new Ship(ShipType.CARRIER));
		    }
		    else if (i == 1 || i == 2){
		        ships.add(i, new Ship(ShipType.BATTLESHIP));
		    }
		    else if (i > 2 && i < 6){
		        ships.add(i, new Ship(ShipType.CRUISER)); 
		    }
		    else{
		        ships.add(i, new Ship(ShipType.DESTROYER));
		    }
	        }
		break;
	}
    }
    
    public void setShips(List<Ship> ships){
        Ship ship;
        Scanner input = new Scanner(System.in);
        int x, y, size;
        ShipDirection direction = ShipDirection.NORTH;
        String string;
        for (int i = 0; i < this.ships.size(); i++){
	    this.printGrids();
            ship = ships.get(i);
            switch(ship.getType()){
                case DESTROYER:     string = "destroyer"; size = 2; break;
                case CRUISER:       string = "cruiser"; size = 3; break;
                case BATTLESHIP:    string = "battleship"; size = 4; break;
                case CARRIER:       string = "carrier"; size = 5; break;
                default:        string = "nothing"; size = 0; break;
            }
	    System.out.println(this.name + ":");
            do{
                System.out.println("Set your " + string + "!");
                do{
		    System.out.print("x: ");
		    x = input.nextInt();
		}while(x < 0 || x > 9);
		do{
		    System.out.print("y: ");
		    y = input.nextInt();
		}while(y < 0 || y > 9);
                string = input.nextLine();
                do{
                    System.out.print("direction: ");
                    string = input.nextLine();
                    if (!string.equals("north") && !string.equals("south") && !string.equals("east") && !string.equals("west"))
                        System.out.println("Invalid input. Please enter north, south, east or west");
                    else{
                        switch(string){
                            case "north":   direction = ShipDirection.NORTH; break;
                            case "south":   direction = ShipDirection.SOUTH; break;
                            case "east":    direction = ShipDirection.EAST; break;
                            case "west":    direction = ShipDirection.WEST; break;
                        }
                    }
                }while (!string.equals("east") && !string.equals("west") && !string.equals("north") && !string.equals("south"));
                if (this.primary.placeShip(size, x, y, direction)){
		    this.ships.get(i).setDirection(direction);
		    this.ships.get(i).setPosition(x, y);
                    break;
                } else {
                    System.out.println("Error: Ship cannot be placed here. Select a different position");
                }
            }while (true);
        }
	System.out.println("Your grid:");
	this.printGrids();
    }
    
    public String getName(){
        return name;
    }
    
    /*	This method defines all the functionality and calls the methods necessary to facilitate an attack on another player.
	@return true if all enemy ships have been destroyed, false otherwise  */
    public boolean attack(Player enemy){
	Scanner input = new Scanner(System.in);
	int x, y, returnNumber;
	do{
	    System.out.print(this.getName() + ", enter x: ");
	    x = input.nextInt();
	    System.out.print(this.getName() + ", enter y: ");
	    y = input.nextInt();
	
	    System.out.println("You are attacking position " + x + " " + y);
	    returnNumber = enemy.primary.checkAttack(x, y);
	    if (returnNumber == 1){
		for (int i = 0; i < enemy.ships.size(); i++){
		    if (enemy.ships.get(i).verifyPosition(x, y)){
			System.out.println("It's a hit!");
			if (enemy.ships.get(i).decrementHealth()){
			    enemy.ships.remove(i);
			    if (enemy.ships.isEmpty())
				return true;
			}
		    }
		}
		this.tracking.draw(x, y, 'X');
	    }else if (returnNumber == -1){
		System.out.println("You have already attacked this field. Choose a different one");
	    }
	    else if (returnNumber == 0){
		System.out.println("You missed!");
		this.tracking.draw(x, y, 'o');
	    }
	}while (returnNumber != 1 && returnNumber != 0);
	
	Battleships.pressAnyKeyToContinue();
	return false;
    }
    public void printGrids(){
	System.out.println("  Primary			Tracking");
	System.out.println("  0 1 2 3 4 5 6 7 8 9       0 1 2 3 4 5 6 7 8 9");
	for (int i = 0; i < 10; i++){
	    System.out.print(i + ":");
	    for (int j = 0; j < 10; j++){
		char c = this.primary.getField(j, i);
		System.out.printf("%c ", c);
	    }
	    System.out.print("    ");
	    
	    System.out.print(i + ":");
	    for (int j = 0; j < 10; j++){
	        char c = this.tracking.getField(j, i);
	        System.out.printf("%c ", c);
	    }
	    System.out.println();
	}
	System.out.println();
    }
}