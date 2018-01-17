import cs1.Keyboard;
public class Human extends Player {
    
    public String toString() { // makes grid
	if (_playing == false) {
	    String ret = "\nYour Current Grid: \n";
	    ret += "    A B C D E F G H I J\n"; // shows the letters of the columns on the top
	    ret += "-----------------------\n";
	    int counter = 1;
	    for (String[] i:_grid) {
		if (counter == 10) {
		    ret += counter + " |";
		}
		else {
		    ret += counter + "  |";
		}
		for (String str: i) {
		    ret += str + " ";
		}
		ret += "\n";
		counter++;
	    }
	    ret += "========================================================================\n";
	    ret += "Row: Can be any Integer between 1 - 10\n";
	    ret += "Column: Can be any CAPITAL Letter between A - J\n";
	    ret += "Orientation: Any Integer between 1 - 4.\n             1 is North, 2 is East, 3 is South, 4 is West.\n";
	    ret += "========================================================================\n";
	    return ret;
	}
	String ret = "\nYour Info:                  Opponent's Info:\n";
	ret+= "    A B C D E F G H I J         A B C D E F G H I J\n";
	ret+= "---------------------------------------------------\n";
	for (int i = 0; i < 10; i++) {
	    if (i == 9) {
		ret += "10 |";
	    }
	    else {
		ret += (i+1) + "  |";
	    }
	    for (String str: _grid[i]) {
		ret += str + " ";
	    }
	    ret += "    ";
	    if (i == 9) {
		ret += "10 |";
	    }
	    else {
		ret += (i+1) + "  |";
	    }
	    for (String str: _oppGrid[i]) {
		ret += str + " ";
	    }
	    ret += "\n";
	}
	return ret;
    }

    public int letterToInt(String let) { // changes the column input into a integer 
	if (let.equals("A")) {
	    return 0; // because arrays start at index 0
	}
	if (let.equals("B")) {
	    return 1;
	}
	if (let.equals("C")) {
	    return 2;
	}
	if (let.equals("D")) {
	    return 3;
	}
	if (let.equals("E")) {
	    return 4;
	}
	if (let.equals("F")) {
	    return 5;
	}
	if (let.equals("G")) {
	    return 6;
	}
	if (let.equals("H")) {
	    return 7;
	}
	if (let.equals("I")) {
	    return 8;
	}
	if (let.equals("J")) {
	    return 9;
	}
	return 10; // this makes the coordinate invalid
    }
	
// ====================  PLACE SHIP METHODS ===========================
    
    /*
      Regarding orientation, 1 is North, 2 is East, 3 is South, 4 is West
    */
    public void placeCarrier () { // essentially, the HP is the length
	System.out.print("Row: ");
	int row = Keyboard.readInt() - 1; // because array index starts at 0
	System.out.print("Column: ");
	int col = letterToInt(Keyboard.readString()); // takes a string input and converts it to an integer using the letterToInt() helper method
	if (row > 9 || col > 9 || row < 0 || col < 0) { // if out of bounds
	    System.out.println("NO! Those coordinates are not valid!");
	    placeCarrier(); // go back to the method
	    return;
	}
	System.out.print("Orientation: ");
	int orientation = Keyboard.readInt();
	if (orientation < 1 || orientation > 4) { // if out of bounds
	    System.out.println("NO! That Orientation is invalid. Read the instructions!");
	    placeCarrier();
	    return;
	}
	int holder = 4; // because starting index is 0 and the size of the ship is 5.

	if (orientation == 1) {
	    if (row < holder) { // if the ship goes out of the grid boundaries
		System.out.println("NO! The ship doesn't fit!");
		placeCarrier();
		return;
	    }
	    while (holder > -1) {
		if (_grid[row - holder][col] != "O") { // if the ship goes out of the grid boundaries
		    System.out.println("NO! The ship cannot be placed that way!");
		    placeCarrier();
		    return;
		}
		holder--;
	    }
	}
	
	if (orientation == 2) {
	    if (col > 9 - holder) { // if the ship goes out of the grid boundaries
		System.out.println("NO! The ship doesn't fit!");
		placeCarrier();
		return;
	    }
	    while (holder > -1) {
		if (_grid[row][col + holder] != "O") { // if the ship goes out of the grid boundaries
		    System.out.println("NO! The ship cannot be placed that way!");
		    placeCarrier();
		    return;
		}
		holder--;
	    }
	}
	
	if (orientation == 3) {
	    if (row > 9 - holder) { // if the ship goes out of the grid boundaries
		System.out.println("NO! The ship doesn't fit!");
		placeCarrier();
		return;
	    }
	    while (holder > -1) {
		if (_grid[row + holder][col] != "O") { // if the ship goes out of the grid boundaries
		    System.out.println("NO! The ship cannot be placed that way!");
		    placeCarrier();
		    return;
		}
		holder--;
	    }
	}
	
	if (orientation == 4) {
	    if (col < holder) { // if the ship goes out of the grid boundaries
		System.out.println("NO! The ship doesn't fit!");
		placeCarrier();
		return;
	    } 
	    while (holder > -1) {
		if (_grid[row][col - holder] != "O") { // if the ship goes out of the grid boundaries
		    System.out.println("NO! The ship cannot be placed that way!");
		    placeCarrier();
		    return;
		}
		holder--;
	    }
	}

	holder = 4;
	if (orientation == 1) {
	    while (holder > -1) { // if the ship goes out of the grid boundaries
		_grid[row - holder][col] = "C";
		holder--;
	    }
	}
	if (orientation == 2) {
	    while (holder > -1) { // if the ship goes out of the grid boundaries
		_grid[row][col + holder] = "C";
		holder--;
	    }
	}
	if (orientation == 3) {
	    while (holder > -1) { // if the ship goes out of the grid boundaries
		_grid[row + holder][col] = "C";
		holder--;
	    }
	}
	if (orientation == 4) {
	    while (holder > -1) { // if the ship goes out of the grid boundaries
		_grid[row][col - holder] = "C";
		holder--;
	    }
	}
    }

    public void placeBattleship () { // essentially, the HP is the length
	System.out.print("Row: ");
	int row = Keyboard.readInt() - 1; // because array index starts at 0
	System.out.print("Column: ");
	int col = letterToInt(Keyboard.readString()); // takes a string input and converts it to an integer using the letterToInt() helper method
	if (row > 9 || col > 9) { // if out of bounds
	    System.out.println("NO! Those coordinates are not valid!");
	    placeBattleship();
	    return;
	}
	System.out.print("Orientation: ");
	int orientation = Keyboard.readInt();
	if (orientation < 1 || orientation > 4) {
	    System.out.println("NO! That Orientation is invalid. Read the instructions!");
	    placeBattleship();
	    return;
	}
	int holder = 3; // because starting index is 0 and the size of the ship is 4

	if (orientation == 1) {
	    if (row < holder) {
		System.out.println("NO! The ships doesn't fit!");
		placeBattleship();
		return;
	    }
	    while (holder > -1) {
		if (_grid[row - holder][col] != "O") {
		    System.out.println("NO! The ship cannot be placed that way!");
		    placeBattleship();
		    return;
		}
		holder--;
	    }
	}
	
	if (orientation == 2) {
	    if (col > 9 - holder) {
		System.out.println("NO! The ships doesn't fit!");
		placeBattleship();
		return;
	    }
	    while (holder > -1) {
		if (_grid[row][col + holder] != "O") {
		    System.out.println("NO! The ship cannot be placed that way!");
		    placeBattleship();
		    return;
		}
		holder--;
	    }
	}
	
	if (orientation == 3) {
	    if (row > 9 - holder) {
		System.out.println("NO! The ships doesn't fit!");
		placeBattleship();
		return;
	    }
	    while (holder > -1) {
		if (_grid[row + holder][col] != "O") {
		    System.out.println("NO! The ship cannot be placed that way!");
		    placeBattleship();
		    return;
		}
		holder--;
	    }
	}
	
	if (orientation == 4) {
	    if (col < holder) {
		System.out.println("NO! The ships doesn't fit!");
		placeBattleship();
		return;
	    } 
	    while (holder > -1) {
		if (_grid[row][col - holder] != "O") {
		    System.out.println("NO! The ship cannot be placed that way!");
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

    public void placeCruiser () { // essentially, the HP is the length
	System.out.print("Row: ");
	int row = Keyboard.readInt() - 1; // because starting index is 0
	System.out.print("Column: ");
	int col = letterToInt(Keyboard.readString()); // takes a string input and converts it to an integer using the letterToInt() helper method
	if (row > 9 || col > 9) { // if out of bounds
	    System.out.println("NO! Those coordinates are not valid!");
	    placeCruiser();
	    return;
	}
	System.out.print("Orientation: ");
	int orientation = Keyboard.readInt();
	if (orientation < 1 || orientation > 4) {
	    System.out.println("NO! That Orientation is invalid. Read the instructions!");
	    placeCruiser();
	    return;
	}
	int holder = 2; // because starting index is 0 and the size of the ship is 3

	if (orientation == 1) {
	    if (row < holder) {
		System.out.println("NO! The ships doesn't fit!");
		placeCruiser();
		return;
	    }
	    while (holder > -1) {
		if (_grid[row - holder][col] != "O") {
		    System.out.println("NO! The ship cannot be placed that way!");
		    placeCruiser();
		    return;
		}
		holder--;
	    }
	}
	
	if (orientation == 2) {
	    if (col > 9 - holder) {
		System.out.println("NO! The ships doesn't fit!");
		placeCruiser();
		return;
	    }
	    while (holder > -1) {
		if (_grid[row][col + holder] != "O") {
		    System.out.println("NO! The ship cannot be placed that way!");
		    placeCruiser();
		    return;
		}
		holder--;
	    }
	}
	
	if (orientation == 3) {
	    if (row > 9 - holder) {
		System.out.println("NO! The ships doesn't fit!");
		placeCruiser();
		return;
	    }
	    while (holder > -1) {
		if (_grid[row + holder][col] != "O") {
		    System.out.println("NO! The ship cannot be placed that way!");
		    placeCruiser();
		    return;
		}
		holder--;
	    }
	}
	
	if (orientation == 4) {
	    if (col < holder) {
		System.out.println("NO! The ships doesn't fit!");
		placeCruiser();
		return;
	    } 
	    while (holder > -1) {
		if (_grid[row][col - holder] != "O") {
		    System.out.println("NO! The ship cannot be placed that way!");
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

    public void placeSubmarine () { // essentially, the HP is the length
	System.out.print("Row: ");
	int row = Keyboard.readInt() - 1;
	System.out.print("Column: ");
	int col = letterToInt(Keyboard.readString()); // takes a string input and converts it to an integer using the letterToInt() helper method
	if (row > 9 || col > 9) { // if out of bounds
	    System.out.println("NO! Those coordinates are not valid!");
	    placeSubmarine();
	    return;
	}
	System.out.print("Orientation: ");
	int orientation = Keyboard.readInt();
	if (orientation < 1 || orientation > 4) {
	    System.out.println("NO! That Orientation is invalid. Read the instructions!");
	    placeSubmarine();
	    return;
	}
	int holder = 2; // because starting index is 0 and the size of the ship is 3

	if (orientation == 1) {
	    if (row < holder) {
		System.out.println("NO! The ships doesn't fit!");
		placeSubmarine();
		return;
	    }
	    while (holder > -1) {
		if (_grid[row - holder][col] != "O") {
		    System.out.println("NO! The ship cannot be placed that way!");
		    placeSubmarine();
		    return;
		}
		holder--;
	    }
	}
	
	if (orientation == 2) {
	    if (col > 9 - holder) {
		System.out.println("NO! The ships doesn't fit!");
		placeSubmarine();
		return;
	    }
	    while (holder > -1) {
		if (_grid[row][col + holder] != "O") {
		    System.out.println("NO! The ship cannot be placed that way!");
		    placeSubmarine();
		    return;
		}
		holder--;
	    }
	}
	
	if (orientation == 3) {
	    if (row > 9 - holder) {
		System.out.println("NO! The ships doesn't fit!");
		placeSubmarine();
		return;
	    }
	    while (holder > -1) {
		if (_grid[row + holder][col] != "O") {
		    System.out.println("NO! The ship cannot be placed that way!");
		    placeSubmarine();
		    return;
		}
		holder--;
	    }
	}
	
	if (orientation == 4) {
	    if (col < holder) {
		System.out.println("NO! The ships doesn't fit!");
		placeSubmarine();
		return;
	    } 
	    while (holder > -1) {
		if (_grid[row][col - holder] != "O") {
		    System.out.println("NO! The ship cannot be placed that way!");
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

    public void placeDestroyer () { // essentially, the HP is the length
	System.out.print("Row: ");
	int row = Keyboard.readInt() - 1;
	System.out.print("Column: ");
	int col = letterToInt(Keyboard.readString()); // takes a string input and converts it to an integer using the letterToInt() helper method
	if (row > 9 || col > 9) { // if out of bounds
	    System.out.println("NO! Those coordinates are not valid!");
	    placeDestroyer();
	    return;
	}
	System.out.print("Orientation: ");
	int orientation = Keyboard.readInt();
	if (orientation < 1 || orientation > 4) {
	    System.out.println("NO! That Orientation is invalid. Read the instructions!");
	    placeDestroyer();
	    return;
	}
	int holder = 1; // because starting index is 0 and the size of the ship is 2

	if (orientation == 1) {
	    if (row < holder) {
		System.out.println("NO! The ship doesn't fit!");
		placeDestroyer();
		return;
	    }
	    while (holder > -1) {
		if (_grid[row - holder][col] != "O") {
		    System.out.println("NO! The ship cannot be placed that way!");
		    placeDestroyer();
		    return;
		}
		holder--;
	    }
	}
	
	if (orientation == 2) {
	    if (col > 9 - holder) {
		System.out.println("NO! The ships doesn't fit!");
		placeDestroyer();
		return;
	    }
	    while (holder > -1) {
		if (_grid[row][col + holder] != "O") {
		    System.out.println("NO! The ship cannot be placed that way!");
		    placeDestroyer();
		    return;
		}
		holder--;
	    }
	}
	
	if (orientation == 3) {
	    if (row > 9 - holder) {
		System.out.println("NO! The ship doesn't fit!");
		placeDestroyer();
		return;
	    }
	    while (holder > -1) {
		if (_grid[row + holder][col] != "O") {
		    System.out.println("NO! The ship cannot be placed that way!");
		    placeDestroyer();
		    return;
		}
		holder--;
	    }
	}
	
	if (orientation == 4) {
	    if (col < holder) {
		System.out.println("NO! The ships doesn't fit!");
		placeDestroyer();
		return;
	    } 
	    while (holder > -1) {
		if (_grid[row][col - holder] != "O") {
		    System.out.println("NO! The ship cannot be placed that way!");
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

    // ==================== END PLACE SHIP METHODS ==========================
    
    public void attackOpponent (Player opponent) {
        System.out.print("Row: "); // takes coordinate inputs
	int row = Keyboard.readInt() - 1;
	System.out.print("Column: ");
	int col = letterToInt(Keyboard.readString());
	if (row > 9 || col > 9) { // if out of bounds
	    System.out.println("NO! Those coordinates are not valid!");
	    attackOpponent(opponent); // recalls the method after saying that it is invalid
	    return;
	}
	System.out.println("\n==========What Happened That Turn?=========="); // recaps what happened during that turn
	if (opponent._grid[row][col] == "C") { // if user hits the AI's carrier
	    opponent._grid[row][col] = "H";
	    _oppGrid[row][col] = "H";
	    opponent.setCarrierHP(opponent.getCarrierHP() - 1);
	    _lastShipHit = "Carrier";
	    if (opponent.getCarrierHP() != 0) { // if user did not sink the opponenet's ship yet
		System.out.println("You have hit the opponent's Carrier!");
	    }
	    else { // if user sinks ship
		System.out.println("You have sunk your opponent's Carrier!");
	    }
	}
	else if (opponent._grid[row][col] == "B") { // if user hits the AI's battleship
	    opponent._grid[row][col] = "H";
	    _oppGrid[row][col] = "H";
	    opponent.setBattleshipHP(opponent.getBattleshipHP() - 1);
	    _lastShipHit = "Battleship";
	    if (opponent.getBattleshipHP() != 0) { // if user did not sink the opponenet's ship yet
		System.out.println("You have hit the opponent's Battleship!");
	    }
	    else { // if user sinks ship
		System.out.println("You have sunk your opponent's Battleship!");
	    }
	}
	else if (opponent._grid[row][col] == "c") { // if user hits the AI's cruiser
	    opponent._grid[row][col] = "H";
	    _oppGrid[row][col] = "H";
	    opponent.setCruiserHP(opponent.getCruiserHP() - 1);
	    _lastShipHit = "Cruiser";
	    if (opponent.getCruiserHP() != 0) { // if user did not sink the opponenet's ship yet
		System.out.println("You have hit the opponent's Cruiser!");
	    }
	    else { // if user sinks ship
		System.out.println("You have sunk your opponent's Cruiser!");
	    }
	}
	else if (opponent._grid[row][col] == "S") { // if user hits the AI's submarine
	    opponent._grid[row][col] = "H";
	    _oppGrid[row][col] = "H";
	    opponent.setSubmarineHP(opponent.getSubmarineHP() - 1);
	    _lastShipHit = "Submarine";
	    if (opponent.getSubmarineHP() != 0) { // if user did not sink the opponenet's ship yet
		System.out.println("You have hit the opponent's Submarine!");
	    }
	    else { // if user sinks ship
		System.out.println("You have sunk your opponent's Submarine!");
	    }
	}
	else if (opponent._grid[row][col] == "D") { // if user hits the AI's destroyer
	    opponent._grid[row][col] = "H";
	    _oppGrid[row][col] = "H";
	    opponent.setDestroyerHP(opponent.getDestroyerHP() - 1);
	    _lastShipHit = "Destroyer";
	    if (opponent.getDestroyerHP() != 0) { // if user did not sink the opponenet's ship yet
		System.out.println("You have hit the opponent's Destroyer!");
	    }
	    else { // if user sinks ship
		System.out.println("You have sunk your opponent's Destroyer!");
	    }
	}
	else if (opponent._grid[row][col] == "X" || opponent._grid[row][col] == "H") { // if the user has already attacked that coordinate before
	    System.out.println("We suggest you to hit somewhere else!");
	    attackOpponent (opponent);
	    return;
	}
	else {
	    opponent._grid[row][col] = "X";
	    _oppGrid[row][col] = "X";
	    System.out.println("You have completely missed!");
	}
    }

}
