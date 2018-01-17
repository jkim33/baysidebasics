public abstract class Player {

    //instance variables
    protected String[][] _grid = new String[10][10];
    protected String[][] _oppGrid = new String[10][10];
    protected int _shipsAlive = 5;
    protected int _carrierHP = 5;
    protected int _battleshipHP = 4;
    protected int _cruiserHP = 3;
    protected int _submarineHP = 3;
    protected int _destroyerHP = 2;
    protected Boolean _playing = false;
    protected String _lastShipHit = "";

    //mutators and accesors
    public int getCarrierHP() { // gives access to Carrier HP
	return _carrierHP;
    }
    public int getBattleshipHP() { // gives access to Battleship HP
	return _battleshipHP;
    }
    public int getCruiserHP() { // gives access to Cruiser HP
	return _cruiserHP;
    }
    public int getSubmarineHP() { // gives access to Submarine HP
	return _submarineHP;
    }
    public int getDestroyerHP() { // gives access to Destroyer HP
	return _destroyerHP;
    }
    public int getShipsAlive() { // gives access to number of ships alive
	return _shipsAlive;
    }
    public int setCarrierHP(int newHP) { // changes the Carrier HP
	int old = _carrierHP;
	_carrierHP = newHP;
	return old;
    }
    public int setBattleshipHP(int newHP) { // changes the Battleship HP
	int old = _battleshipHP;
	_battleshipHP = newHP;
	return old;
    }
    public int setCruiserHP(int newHP) { // changes the Cruiser HP
	int old = _cruiserHP;
	_cruiserHP = newHP;
	return old;
    }
    public int setSubmarineHP(int newHP) { // changes the Submarine HP
	int old = _submarineHP;
	_submarineHP = newHP;
	return old;
    }
    public int setDestroyerHP(int newHP) { // changes the Destroyer HP
	int old = _destroyerHP;
	_destroyerHP = newHP;
 	return old;
    }
    public int setShipsAlive(int newNum) { // changes the number of ships alive
	int old = _shipsAlive;
	_shipsAlive = newNum;
	return old;
    }
    public Boolean setPlaying(boolean boo) { // 
	Boolean old = _playing;
	_playing = boo;
	return old;
    }

    //methods
    public void setGrid() { // "O" is the default symbol
	for (int row = 0; row < 10; row++) {
	    for (int col = 0; col < 10; col++) {
		_grid[row][col] = "O";
	    }
	}
	for (int row = 0; row < 10; row++) {
	    for (int col = 0; col < 10; col++) {
		_oppGrid[row][col] = "O";
	    }
	}
    }

    public boolean check() { //for each time a ship's HP is not 0, then the counter, which displays the number of ships alive, would go up by 1.
        int counter = 0;
	if (_carrierHP != 0) {
	    counter++;
	}
	if (_battleshipHP != 0) {
	    counter++;
	}
	if (_cruiserHP != 0) {
	    counter++;
	}
	if (_submarineHP != 0) {
	    counter++;
	}
	if (_destroyerHP != 0) {
	    counter++;
	}
	setShipsAlive(counter); // shipsAlive = counter
	if (_shipsAlive == 0){ // if no ships are alive...
	    return true; // its true that all the ships are gone
 	}
	return false;
    }

    //abstract methods
    public abstract void attackOpponent(Player opp);
    public abstract void placeCarrier();
    public abstract void placeDestroyer();
    public abstract void placeBattleship();
    public abstract void placeCruiser();
    public abstract void placeSubmarine();
}
