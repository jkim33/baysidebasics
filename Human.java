import cs1.Keyboard;
public class Human extends Player {
    
    public String toString() {
	String ret = "Your Grid: \n";
	for (String[] i:_grid) {
	    for (String str: i) {
		ret += str + " ";
	    }
	    ret += "\n";
	}
	ret += "============================\nOpponent's Grid: \n";
	for (String[] i:_oppGrid) {
	    for (String str: i) {
		ret += str + " ";
	    }
	    ret += "\n";
	}
	return ret;
    }

    public int LetterToInt() {
	String lower = "abcdefghij";
	System.out.print("Please enter the column you would like to place your ship in:");
	String let = Keyboard.readString();
        for (int x = 10; x > 0; x--) {
	    Boolean inRange = true;
	    if (let == lower.substring(x - 1, x)) {
		System.out.println("Please enter the column in CAPITAL letters");
		LettertoInt();
	    }
	    if (let == "A") {
		return 0;
	    }
	    if (let == "B") {
		return 1;
	    }
	    if (let == "C") {
		return 2;
	    }
	    if (let == "D") {
		return 3;
	    }
	    if (let == "E") {
		return 4;
	    }
	    if (let == "F") {
		return 5;
	    }
	    if (let == "G") {
		return 6;
	    }
	    if (let == "H") {
		return 7;
	    }
	    if (let == "I") {
		return 8;
	    }
	    if (let == "J") {
		return 9;
	    }
	}
	
    }
    // ====================  PLACE SHIP METHODS ===========================
    
    /*
      Regarding orientation, 1 is North, 2 is East, 3 is South, 4 is West
    */
    public void placeCarrier () { // essentially, the HP is the length
	System.out.print("Row: ");
	int row = Keyboard.readInt();
	System.out.print("Column: ");
	int col = Keyboard.readInt();
	System.out.print("Orientation: ");
	int orientation = Keyboard.readInt();
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
	int row = Keyboard.readInt();
	System.out.print("Column: ");
	int col = Keyboard.readInt();
	System.out.print("Orientation: ");
	int orientation = Keyboard.readInt();
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
	int row = Keyboard.readInt();
	System.out.print("Column: ");
	int col = Keyboard.readInt();
	System.out.print("Orientation: ");
	int orientation = Keyboard.readInt();
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
	int row = Keyboard.readInt();
	System.out.print("Column: ");
	int col = Keyboard.readInt();
	System.out.print("Orientation: ");
	int orientation = Keyboard.readInt();
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
	int row = Keyboard.readInt();
	System.out.print("Column: ");
	int col = Keyboard.readInt();
	System.out.print("Orientation: ");
	int orientation = Keyboard.readInt();
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
    
    public void attackOpponent (int row, int col, Player opponent) {
	if (opponent._grid[row][col] == "C" || opponent._grid[row][col] == "B" || opponent._grid[row][col] == "c" || opponent._grid[row][col] == "S" || opponent._grid[row][col] == "D") {
	    opponent._grid[row][col] = "H";
	    _oppGrid[row][col] = "H";
	}
	else {
	    opponent._grid[row][col] = "X";
	    _oppGrid[row][col] = "X";
	}
    }
    
    // ==================== END PLACE SHIP METHODS ==========================

}
