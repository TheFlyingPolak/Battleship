/*
	Class Primary contains the primary grid of each player, where the player's own ships
	are stored.
*/
package battleship;

public class Primary extends Grid{
	/*	Constructor of the class Primary  */
	public Primary(){
		super();
	}
	
	/*  Method to check the grid to see if an attack is valid, if it was a hit or a miss  */
    public int checkAttack(int x, int y){
        if (grid[x][y] == 'H'){
            grid[x][y] = 'X';
            return 1;
        }
	else if (grid[x][y] == 'o' || grid[x][y] == 'X'){
	    return -1;
	}
        else{
	    grid[x][y] = 'o';
            return 0;
        }
    }
	
	/*  Method to place a ship on the grid during the set-up stage of the game.
        @param size: the size of the ship. size >= 2, size <= 5
        @param x, y: the x and y position of the rear end of the ship on the grid. x, y >= 0, x, y <= 9
        @param dir: direction of the ship
        @return true if ship placed successfully, false if cannot be placed
    */
    public boolean placeShip(int size, int x, int y, ShipDirection dir){
        switch(dir){
            case NORTH:
                if (y - (size - 1) < 0){    // 
                    return false;
                }
                else{
                    for (int Y = y; Y > y - size; Y--){
                        if (grid[x][Y] != ' '){
                            return false;
                        }
                    }
                }
                for (int Y = y; Y > y - size; Y--){
                    grid[x][Y] = 'H';
                }
                return true;
            case SOUTH:
                if (y + (size - 1) > 9){
                    return false;
                }
                else{
                    for (int Y = y; Y < y + size; Y++){
                        if (grid[x][Y] != ' '){
                            return false;
                        }
                    }
                }
                for (int Y = y; Y < y + size; Y++){
                    grid[x][Y] = 'H';
                }
                return true;
            case EAST:
                if (x + (size - 1) > 9){
                    return false;
                }
                else{
                    for (int X = x; X < x + size; X++){
                        if (grid[X][y] != ' '){
                            return false;
                        }
                    }
                }
                for (int X = x; X < x + size; X++){
                    grid[X][y] = 'H';
                }
                return true;
            case WEST:
                if (x - (size - 1) < 0){
                    return false;
                }
                else{
                    for (int X = x; X > x - size; X--){
                        if (grid[X][y] != ' '){
                            return false;
                        }
                    }
                }
                for (int X = x; X > x - size; X--){
                    grid[X][y] = 'H';
                }
                return true;
        }
        return false;
                
    }
    
    public int checkGrid(int x, int y){ 
        if (x < 0 || x > 9 || y < 0 || y > 9){
            System.out.println("Coordinate is outside the grid. Choose a different one!");
            return -1;
        }
        else if (grid[x][y] == 'X' || grid[x][y] == 'o'){
            System.out.println("You have already taken a shot at this coordinate. Choose a different one!");
            return -1;
        }
        else if (grid[x][y] == 'H'){
            System.out.println("You have scored a hit!");
            return 1;
        }
        else{
            System.out.println("You have missed!");
            return 0;
        }
    }
}
