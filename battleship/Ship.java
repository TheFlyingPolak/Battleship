package battleship;

public class Ship {
    private int size;	    // Size of the ship
    private int health;	    // Remaining squares on the ship
    private int x, y;       // Coordinates of stern of ship
    private ShipDirection direction;
    private ShipType type;
    
    /*	Constructor of the class Ship  */
    public Ship(ShipType typ){
        type = typ;
        switch(type){
            case DESTROYER:
                size = 2;
                health = 2;
                break;
            case CRUISER:
                size = 3;
                health = 3;
                break;
            case BATTLESHIP:
                size = 4;
                health = 4;
                break;
            case CARRIER:
                size = 5;
                health = 5;
                break;
        }
        
    }
    public void setDirection(ShipDirection direction){
	this.direction = direction;
    }
    public void setPosition(int x, int y){
	this.x = x;
	this.y = y;
    }
    /*	This method takes the coordinates of an attack and checks if the given ship has been hit  */
    public boolean verifyPosition(int x, int y){
	switch (direction){
	    case NORTH:
		for (int i = 0; i < size; i++){
		    if (this.x == x && this.y - i == y){
			return true;
		    }
		}
		break;
	    case SOUTH:
		for (int i = 0; i < size; i++){
		    if (this.x == x && this.y + i == y){
			return true;
		    }
		}
		break;
	    case EAST:
		for (int i = 0; i < size; i++){
		    if (this.x + i == x && this.y == y){
			return true;
		    }
		}
		break;
	    case WEST:
		for (int i = 0; i < size; i++){
		    if (this.x - i == x && this.y == y){
			return true;
		    }
		}
		break;
	    default:
		return false;
	}
	return false;
    }
    /*	Method returns true if health reaches 0  */
    public boolean decrementHealth(){
	return --health == 0;
    }
    
    public int getSize(){
        return size;
    }
    
    public int getHealth(){
        return health;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public  ShipDirection getDirection(){
        return direction;
    }
    
    public ShipType getType(){
        return type;
    }
    
    
}
