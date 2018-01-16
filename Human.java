import cs1.Keyboard;
public class Human extends Player {
    
    public String toString() {
	if (_playing == false) {
	    String ret = "\nYour Current Grid: \n";
	    ret += "    A B C D E F G H I J\n";
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
/*
    public void start() {
	System.out.println("Welcome player.\n You are about to embark in a naval war. Are you prepared for that? Please enter Yes if you are, No if you are not.");
	String ans = Keyboard.readString();
	if (ans != "Yes" && ans != "No") {
	    System.out.println ("Please enter a valid answer.\nIt is case-sensitive");
	}
	else {
	    if (ans == "Yes") {
		System.out.println ("That is what we, the game developers like to hear!! Prepare for war!");
	    }
	    if (ans == "No") {
		System.out.println ("That is too bad. Prepare for war!");
	    }
	}
    }
    */
    public int letterToInt(String let) {
	if (let.equals("A")) {
	    return 0;
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
	return 10;
    }
	
// ====================  PLACE SHIP METHODS ===========================
    
    /*
      Regarding orientation, 1 is North, 2 is East, 3 is South, 4 is West
    */
    public void placeCarrier () { // essentially, the HP is the length
	System.out.print("Row: ");
	int row = Keyboard.readInt() - 1;
	System.out.print("Column: ");
	int col = letterToInt(Keyboard.readString());
	if (row > 9 || col > 9 || row < 0 || col < 0) {
	    System.out.println("NO! Those coordinates are not valid!");
	    placeCarrier();
	    return;
	}
	System.out.print("Orientation: ");
	int orientation = Keyboard.readInt();
	if (orientation < 1 || orientation > 4) {
	    System.out.println("NO! That Orientation is invalid. Read the instructions!");
	    placeCarrier();
	    return;
	}
	int holder = 4; // because starting index is 0

	if (orientation == 1) {
	    if (row < holder) {
		System.out.println("NO! The ships doesn't fit!");
		placeCarrier();
		return;
	    }
	    while (holder > -1) {
		if (_grid[row - holder][col] != "O") {
		    System.out.println("NO! The ship cannot be placed that way!");
		    placeCarrier();
		    return;
		}
		holder--;
	    }
	}
	
	if (orientation == 2) {
	    if (col > 9 - holder) {
		System.out.println("NO! The ships doesn't fit!");
		placeCarrier();
		return;
	    }
	    while (holder > -1) {
		if (_grid[row][col + holder] != "O") {
		    System.out.println("NO! The ship cannot be placed that way!");
		    placeCarrier();
		    return;
		}
		holder--;
	    }
	}
	
	if (orientation == 3) {
	    if (row > 9 - holder) {
		System.out.println("NO! The ships doesn't fit!");
		placeCarrier();
		return;
	    }
	    while (holder > -1) {
		if (_grid[row + holder][col] != "O") {
		    System.out.println("NO! The ship cannot be placed that way!");
		    placeCarrier();
		    return;
		}
		holder--;
	    }
	}
	
	if (orientation == 4) {
	    if (col < holder) {
		System.out.println("NO! The ships doesn't fit!");
		placeCarrier();
		return;
	    } 
	    while (holder > -1) {
		if (_grid[row][col - holder] != "O") {
		    System.out.println("NO! The ship cannot be placed that way!");
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

    public void placeBattleship () { // essentially, the HP is the length
	System.out.print("Row: ");
	int row = Keyboard.readInt() - 1;
	System.out.print("Column: ");
	int col = letterToInt(Keyboard.readString());
	if (row > 9 || col > 9) {
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
	int holder = 3; // because starting index is 0

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
	int row = Keyboard.readInt() - 1;
	System.out.print("Column: ");
	int col = letterToInt(Keyboard.readString());
	if (row > 9 || col > 9) {
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
	int holder = 2; // because starting index is 0

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
	int col = letterToInt(Keyboard.readString());
	if (row > 9 || col > 9) {
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
	int holder = 2; // because starting index is 0

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
	int col = letterToInt(Keyboard.readString());
	if (row > 9 || col > 9) {
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
	int holder = 1; // because starting index is 0

	if (orientation == 1) {
	    if (row < holder) {
		System.out.println("NO! The ships doesn't fit!");
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
		System.out.println("NO! The ships doesn't fit!");
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
    
    public void attackOpponent (int row, int col, Player opponent) {
	if (opponent._grid[row][col] == "C") {
	    opponent._grid[row][col] = "H";
	    _oppGrid[row][col] = "H";
	    opponent.setCarrierHP(opponent.getCarrierHP() - 1);
	    lastShipHit = "Carrier";
	}
	else if (opponent._grid[row][col] == "B") {
	    opponent._grid[row][col] = "H";
	    _oppGrid[row][col] = "H";
	    opponent.setBattleshipHP(opponent.getBattleshipHP() - 1);
	    lastShipHit = "Battleship";
	}
	else if (opponent._grid[row][col] == "c") {
	    opponent._grid[row][col] = "H";
	    _oppGrid[row][col] = "H";
	    opponent.setCruiserHP(opponent.getCruiserHP() - 1);
	    lastShipHit = "Cruiser";
	}
	else if (opponent._grid[row][col] == "S") {
	    opponent._grid[row][col] = "H";
	    _oppGrid[row][col] = "H";
	    opponent.setSubmarineHP(opponent.getSubmarineHP() - 1);
	    lastShipHit = "Submarine";
	}
	else if (opponent._grid[row][col] == "D") {
	    opponent._grid[row][col] = "H";
	    _oppGrid[row][col] = "H";
	    opponent.setDestroyerHP(opponent.getDestroyerHP() - 1);
	    lastShipHit = "Destroyer";
	}
	else {
	    opponent._grid[row][col] = "X";
	    _oppGrid[row][col] = "X";
	}
    }

}
