/*
	Class Tracking contains the tracking grid of each player, where the attack
	locations of the opponent's primary grid are shown.
*/
package battleship;

public class Tracking extends Grid{
	/*	Constructor of the class Tracking  */
	public Tracking(){
		super();
	}
	
	 public void draw(int x, int y, char c){
		this.grid[x][y] = c;
    }
}
