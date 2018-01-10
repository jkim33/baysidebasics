public class BeginnerAI extends Player {
    public void attackOpponent (int r, int c, Player opponent) {
	int row = (int) (Math.random()*10);
	int col = (int) (Math.random()*10);
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
