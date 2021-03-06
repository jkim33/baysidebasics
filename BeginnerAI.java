public class BeginnerAI extends Player {
    
    public void attackOpponent (Player opponent) {
	int row = (int) (Math.random() * 10); // randomly chooses coordinates to shoot
	int col = (int) (Math.random() * 10);
	if (opponent._grid[row][col] == "C") { // if hits a carrier
	    opponent._grid[row][col] = "H"; // signifies hit
	    _oppGrid[row][col] = "H";
	    opponent.setCarrierHP(opponent.getCarrierHP() - 1); // reduce HP
	    _lastShipHit = "Carrier";
	    if (opponent.getCarrierHP() != 0) { // carrier not dead
		System.out.println("Your Opponent has hit your Carrier!");
	    }
	    else { // carrier dead
		System.out.println("Your Opponent has sunk your Carrier!");
	    }
	}
	else if (opponent._grid[row][col] == "B") { // if hits a battleship
	    opponent._grid[row][col] = "H"; // signifies hit
	    _oppGrid[row][col] = "H";
	    opponent.setBattleshipHP(opponent.getBattleshipHP() - 1); // reduce HP
	    _lastShipHit = "Battleship";
	    if (opponent.getBattleshipHP() != 0) { // battleship not dead
		System.out.println("Your Opponent has hit your Battleship!");
	    }
	    else { // battleship dead
		System.out.println("Your Opponent has sunk your Battleship!");
	    }
	}
	else if (opponent._grid[row][col] == "c") { // if hits a cruiser
	    opponent._grid[row][col] = "H"; // signifies hit
	    _oppGrid[row][col] = "H";
	    opponent.setCruiserHP(opponent.getCruiserHP() - 1); // reduce HP
	    _lastShipHit = "Cruiser";
	    if (opponent.getCruiserHP() != 0) { // cruiser not dead
		System.out.println("Your Opponent has hit your Cruiser!");
	    }
	    else { // cruiser dead
		System.out.println("Your Opponent has sunk your Cruiser!");
	    }
	}
	else if (opponent._grid[row][col] == "S") { // if hits a submarine
	    opponent._grid[row][col] = "H"; // signifies hit
	    _oppGrid[row][col] = "H";
	    opponent.setSubmarineHP(opponent.getSubmarineHP() - 1); // reduce HP
	    _lastShipHit = "Submarine";
	    if (opponent.getSubmarineHP() != 0) { // submarine not dead
		System.out.println("Your Opponent has hit your Submarine!");
	    }
	    else { // submarine dead
		System.out.println("Your Opponent has sunk your Submarine!");
	    }
	}
	else if (opponent._grid[row][col] == "D") { // if hits a destroyer
	    opponent._grid[row][col] = "H"; // signifies hit
	    _oppGrid[row][col] = "H";
	    opponent.setDestroyerHP(opponent.getDestroyerHP() - 1); // reduce HP
	    _lastShipHit = "Destroyer";
	    if (opponent.getDestroyerHP() != 0) { // destroyer not dead
		System.out.println("Your Opponent has hit your Destroyer!");
	    }
	    else { // destroyer dead
		System.out.println("Your Opponent has sunk your Destroyer!");
	    }
	}
	else {
	    opponent._grid[row][col] = "X";
	    _oppGrid[row][col] = "X";
	    System.out.println("Your Opponent has completely missed!");
	}
	System.out.println("============================================");
    }

    public void placeCarrier() {
	int row = (int) (Math.random() * 10); // randomly places ship
	int col = (int) (Math.random() * 10);
	int orientation = (int) (Math.random() * 4) + 1;
	int holder = 4; // because starting index is 0

	if (orientation == 1) {
	    if (row < holder) {
		placeCarrier();
		return;
	    }
	    while (holder > -1) {
		if (_grid[row - holder][col] != "O") {
		    placeCarrier();
		    return;
		}
		holder--;
	    }
	}
	
	if (orientation == 2) {
	    if (col > 9 - holder) {
		placeCarrier();
		return;
	    }
	    while (holder > -1) {
		if (_grid[row][col + holder] != "O") {
		    placeCarrier();
		    return;
		}
		holder--;
	    }
	}
	
	if (orientation == 3) {
	    if (row > 9 - holder) {
		placeCarrier();
		return;
	    }
	    while (holder > -1) {
		if (_grid[row + holder][col] != "O") {
		    placeCarrier();
		    return;
		}
		holder--;
	    }
	}
	
	if (orientation == 4) {
	    if (col < holder) {
		placeCarrier();
		return;
	    } 
	    while (holder > -1) {
		if (_grid[row][col - holder] != "O") {
		    placeCarrier();
		    return;
		}
		holder--;
	    }
	}

	holder = 4;
	if (orientation == 1) {
	    while (holder > -1) {
		_grid[row - holder][col] = "C";
		holder--;
	    }
	}
	if (orientation == 2) {
	    while (holder > -1) {
		_grid[row][col + holder] = "C";
		holder--;
	    }
	}
	if (orientation == 3) {
	    while (holder > -1) {
		_grid[row + holder][col] = "C";
		holder--;
	    }
	}
	if (orientation == 4) {
	    while (holder > -1) {
		_grid[row][col - holder] = "C";
		holder--;
	    }
	}
    }
    public void placeBattleship() {
	
	int row = (int) (Math.random() * 10); // randomly places ship
	int col = (int) (Math.random() * 10);
	int orientation = (int) (Math.random() * 4) + 1;
	int holder = 3; // because starting index is 0

	if (orientation == 1) {
	    if (row < holder) {
		placeBattleship();
		return;
	    }
	    while (holder > -1) {
		if (_grid[row - holder][col] != "O") {
		    placeBattleship();
		    return;
		}
		holder--;
	    }
	}
	
	if (orientation == 2) {
	    if (col > 9 - holder) {
		placeBattleship();
		return;
	    }
	    while (holder > -1) {
		if (_grid[row][col + holder] != "O") {
		    placeBattleship();
		    return;
		}
		holder--;
	    }
	}
	
	if (orientation == 3) {
	    if (row > 9 - holder) {
		placeBattleship();
		return;
	    }
	    while (holder > -1) {
		if (_grid[row + holder][col] != "O") {
		    placeBattleship();
		    return;
		}
		holder--;
	    }
	}
	
	if (orientation == 4) {
	    if (col < holder) {
		placeBattleship();
		return;
	    } 
	    while (holder > -1) {
		if (_grid[row][col - holder] != "O") {
		    placeBattleship();
		    return;
		}
		holder--;
	    }
	}

	holder = 3;
	if (orientation == 1) {
	    while (holder > -1) {
		_grid[row - holder][col] = "B";
		holder--;
	    }
	}
	if (orientation == 2) {
	    while (holder > -1) {
		_grid[row][col + holder] = "B";
		holder--;
	    }
	}
	if (orientation == 3) {
	    while (holder > -1) {
		_grid[row + holder][col] = "B";
		holder--;
	    }
	}
	if (orientation == 4) {
	    while (holder > -1) {
		_grid[row][col - holder] = "B";
		holder--;
	    }
	}
    }
    public void placeCruiser() {
	
	int row = (int) (Math.random() * 10); // randomly places ship
	int col = (int) (Math.random() * 10);
	int orientation = (int) (Math.random() * 4) + 1;
	int holder = 2; // because starting index is 0

	if (orientation == 1) {
	    if (row < holder) {
		placeCruiser();
		return;
	    }
	    while (holder > -1) {
		if (_grid[row - holder][col] != "O") {
		    placeCruiser();
		    return;
		}
		holder--;
	    }
	}
	
	if (orientation == 2) {
	    if (col > 9 - holder) {
		placeCruiser();
		return;
	    }
	    while (holder > -1) {
		if (_grid[row][col + holder] != "O") {
		    placeCruiser();
		    return;
		}
		holder--;
	    }
	}
	
	if (orientation == 3) {
	    if (row > 9 - holder) {
		placeCruiser();
		return;
	    }
	    while (holder > -1) {
		if (_grid[row + holder][col] != "O") {
		    placeCruiser();
		    return;
		}
		holder--;
	    }
	}
	
	if (orientation == 4) {
	    if (col < holder) {
		placeCruiser();
		return;
	    } 
	    while (holder > -1) {
		if (_grid[row][col - holder] != "O") {
		    placeCruiser();
		    return;
		}
		holder--;
	    }
	}

	holder = 2;
	if (orientation == 1) {
	    while (holder > -1) {
		_grid[row - holder][col] = "c";
		holder--;
	    }
	}
	if (orientation == 2) {
	    while (holder > -1) {
		_grid[row][col + holder] = "c";
		holder--;
	    }
	}
	if (orientation == 3) {
	    while (holder > -1) {
		_grid[row + holder][col] = "c";
		holder--;
	    }
	}
	if (orientation == 4) {
	    while (holder > -1) {
		_grid[row][col - holder] = "c";
		holder--;
	    }
	}
    }

    
    public void placeSubmarine() {
	
	
	int row = (int) (Math.random() * 10); // randomly places ship
	int col = (int) (Math.random() * 10);
	int orientation = (int) (Math.random() * 4) + 1;
	int holder = 2; // because starting index is 0

	if (orientation == 1) {
	    if (row < holder) {
		placeSubmarine();
		return;
	    }
	    while (holder > -1) {
		if (_grid[row - holder][col] != "O") {
		    placeSubmarine();
		    return;
		}
		holder--;
	    }
	}
	
	if (orientation == 2) {
	    if (col > 9 - holder) {
	        placeSubmarine();
		return;
	    }
	    while (holder > -1) {
		if (_grid[row][col + holder] != "O") {
		    placeSubmarine();
		    return;
		}
		holder--;
	    }
	}
	
	if (orientation == 3) {
	    if (row > 9 - holder) {
		placeSubmarine();
		return;
	    }
	    while (holder > -1) {
		if (_grid[row + holder][col] != "O") {
		    placeSubmarine();
		    return;
		}
		holder--;
	    }
	}
	
	if (orientation == 4) {
	    if (col < holder) {
		placeSubmarine();
		return;
	    } 
	    while (holder > -1) {
		if (_grid[row][col - holder] != "O") {
		 placeSubmarine();
		    return;
		}
		holder--;
	    }
	}

	holder = 2;
	if (orientation == 1) {
	    while (holder > -1) {
		_grid[row - holder][col] = "S";
		holder--;
	    }
	}
	if (orientation == 2) {
	    while (holder > -1) {
		_grid[row][col + holder] = "S";
		holder--;
	    }
	}
	if (orientation == 3) {
	    while (holder > -1) {
		_grid[row + holder][col] = "S";
		holder--;
	    }
	}
	if (orientation == 4) {
	    while (holder > -1) {
		_grid[row][col - holder] = "S";
		holder--;
	    }
	}
    }

    
    public void placeDestroyer() {
	
	int row = (int) (Math.random() * 10); // randomly places ship
	int col = (int) (Math.random() * 10);
	int orientation = (int) (Math.random() * 4) + 1;
	int holder = 1; // because starting index is 0

	if (orientation == 1) {
	    if (row < holder) {
		placeDestroyer();
		return;
	    }
	    while (holder > -1) {
		if (_grid[row - holder][col] != "O") {
		    placeDestroyer();
		    return;
		}
		holder--;
	    }
	}
	
	if (orientation == 2) {
	    if (col > 9 - holder) {
		placeDestroyer();
		return;
	    }
	    while (holder > -1) {
		if (_grid[row][col + holder] != "O") {
		    placeDestroyer();
		    return;
		}
		holder--;
	    }
	}
	
	if (orientation == 3) {
	    if (row > 9 - holder) {
		placeDestroyer();
		return;
	    }
	    while (holder > -1) {
		if (_grid[row + holder][col] != "O") {
		    placeDestroyer();
		    return;
		}
		holder--;
	    }
	}
	
	if (orientation == 4) {
	    if (col < holder) {
		placeDestroyer();
		return;
	    } 
	    while (holder > -1) {
		if (_grid[row][col - holder] != "O") {
		    placeDestroyer();
		    return;
		}
		holder--;
	    }
	}

	holder = 1;
	if (orientation == 1) {
	    while (holder > -1) {
		_grid[row - holder][col] = "D";
		holder--;
	    }
	}
	if (orientation == 2) {
	    while (holder > -1) {
		_grid[row][col + holder] = "D";
		holder--;
	    }
	}
	if (orientation == 3) {
	    while (holder > -1) {
		_grid[row + holder][col] = "D";
		holder--;
	    }
	}
	if (orientation == 4) {
	    while (holder > -1) {
		_grid[row][col - holder] = "D";
		holder--;
	    }
	}
    }
}
