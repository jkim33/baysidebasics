public class AdvancedAI extends Player {
    int row, col;
    public void attackOpponent(int r, int c, Player opponent) {
	row = (int) (_grid[0].length/2); // starts at center
	col = (int) (_grid[0].length/2);
	if (opponent._grid[row][col] == "C" || opponent._grid[row][col] == "B" || opponent._grid[row][col] == "c" || opponent._grid[row][col] == "S" || opponent._grid[row][col] == "D") {
	    opponent._grid[row][col] = "H";
	    _oppGrid[row][col] = "H";
	}
	else {
	    opponent._grid[row][col] = "X";
	    _oppGrid[row][col] = "X";
	}
    }

	

    public void placeCarrier() {
	int row = (int) (Math.random() * 10);
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
	
	int row = (int) (Math.random() * 10);
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
	
	int row = (int) (Math.random() * 10);
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
	
	
	int row = (int) (Math.random() * 10);
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
	
	int row = (int) (Math.random() * 10);
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
