public class Human extends Player {
    public String toString() {
	String ret = "";
	for (String[] i:_grid) {
	    for (String str: i) {
		ret += str + " ";
	    }
	    ret += "\n";
	}
	ret += "=================================================================\n";
	for (String[] i:_oppGrid) {
	    for (String str: i) {
		ret += str + " ";
	    }
	    ret += "\n";
	}
	return ret;
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
