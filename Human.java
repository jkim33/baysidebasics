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

    /*
     Regarding orientation, 1 is North, 2 is East, 3 is South, 4 is West
     */
    public void PlaceShip(int length, int row, int col, int orientation) { // essentially, the HP is the length
	
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
}
