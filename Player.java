public abstract class Player {

    //instance variables
    public String[][] _grid = new String[10][10];
    public String[][] _oppGrid = new String[10][10];
    public int _missleCOunt = 0;
    public int _shipsAlive = 5;
    public int _carrierHP = 5;
    public int _battleshipHP = 4;
    public int _cruiserHP = 3;
    public int _submarineHP = 3;
    public int _destroyerHP = 2;
    public Boolean _playing = true;
    public String _lastShipHit = "";

    //mutators and accesors
    public int getCarrierHP() {
	return _carrierHP;
    }
    public int getBattleshipHP() {
	return _battleshipHP;
    }
    public int getCruiserHP() {
	return _cruiserHP;
    }
    public int getSubmarineHP() {
	return _submarineHP;
    }
    public int getDestroyerHP() {
	return _destroyerHP;
    }
    public int getShipsAlive() {
	return _shipsAlive;
    }
    public int setCarrierHP(int newHP) {
	int old = _carrierHP;
	_carrierHP = newHP;
	return old;
    }
    public int setBattleshipHP(int newHP) {
	int old = _battleshipHP;
	_battleshipHP = newHP;
	return old;
    }
    public int setCruiserHP(int newHP) {
	int old = _cruiserHP;
	_cruiserHP = newHP;
	return old;
    }
    public int setSubmarineHP(int newHP) {
	int old = _submarineHP;
	_submarineHP = newHP;
	return old;
    }
    public int setDestroyerHP(int newHP) {
	int old = _destroyerHP;
	_destroyerHP = newHP;
 	return old;
    }
    public int setShipsAlive(int newNum) {
	int old = _shipsAlive;
	_shipsAlive = newNum;
	return old;
    }

    //methods
    public void setGrid() {
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

    public void placeShip() { //temp
        for (int col = 0; col < 5; col++) {
	    _grid[0][col] = "C";
	}
	for (int col = 0; col < 4; col++) {
	    _grid[2][col] = "B";
	}
	for (int col = 0; col < 3; col++) {
	    _grid[4][col] = "c";
	}
	for (int col = 0; col < 3; col++) {
	    _grid[6][col] = "S";
	}
	for (int col = 0; col < 2; col++) {
	    _grid[8][col] = "D";
	}
    }

    public boolean check() {
	for (String[] i: _grid) {
	    for (String s: i){
		if (s != "O" || s!= "H" || s != "X") {
		    return false;
		}
	    }
	}
	return true;
    }

    //abstract methods
    public abstract void attackOpponent(int r, int c, Player opp);
    public abstract void placeCarrier();
    public abstract void placeDestroyer();
    public abstract void placeBattleship();
    public abstract void placeCruiser();
    public abstract void placeSubmarine();
}
