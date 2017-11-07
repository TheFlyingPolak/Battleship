/*
    Class Grid contains a 10x10 array to store positions of ships. This class is the
	superclass of Primary and Tracking.
*/

package battleship;

public class Grid {
    protected char[][] grid;  // 10x10 array where ships, hits and misses are stored
    
    /*  Constructor for class grid  */
    public Grid(){
        grid = new char[10][10];    // Instantiate the 10x10 array
        /*  Loop to set the array to an initial state, where all blank fields are marked with the character '.'  */
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                grid[i][j] = ' ';
            }
        }
    }
    
    public char getField(int x, int y){
		return grid[x][y];
    }
}