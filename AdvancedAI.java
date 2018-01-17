import java.util.ArrayList;

public class AdvancedAI extends Player {
    protected int oldRow, oldCol;
    protected int row, col;
    protected int rowAttempts = 0;
    protected int turnCount = 1;
    
    protected ArrayList <Integer> carrierCoorRow = new ArrayList <Integer> ();
    protected ArrayList <Integer> carrierCoorCol = new ArrayList <Integer> ();
    protected ArrayList <Integer> battleshipCoorRow = new ArrayList <Integer> ();
    protected ArrayList <Integer> battleshipCoorCol = new ArrayList <Integer> ();
    protected ArrayList <Integer> cruiserCoorRow = new ArrayList <Integer> ();
    protected ArrayList <Integer> cruiserCoorCol = new ArrayList <Integer> ();
    protected ArrayList <Integer> submarineCoorRow = new ArrayList <Integer> ();
    protected ArrayList <Integer> submarineCoorCol = new ArrayList <Integer> ();
    protected ArrayList <Integer> destroyerCoorRow = new ArrayList <Integer> ();
    protected ArrayList <Integer> destroyerCoorCol = new ArrayList <Integer> ();
    
    protected boolean currentlyFinishing = false;
    
    public void attackOpponent(Player opponent) { // more strategy!
	if (currentlyFinishing) { // if AI is currently finishing off a ship
	    try { // to prevent potential runtime errors
		coorForHit(); // refer to method
	    }
	    catch (Exception e) {
		rowChange(); // refer to method
	    }
	}
	else if (turnCount < 4) { // in the first 3 turns, perform centerCor()
	    centerCoor(); // refer to method
	}
	else { // starting from fourth turn
	    rowChange();
	    rowAttempts++;
	}
	if (opponent._grid[row][col] == "C") { // hit!
	    opponent._grid[row][col] = "H";
	    _oppGrid[row][col] = "H";
	    opponent.setCarrierHP(opponent.getCarrierHP() - 1); // reduce HP
	    _lastShipHit = "Carrier";
	    carrierCoorRow.add(row);
	    carrierCoorCol.add(col);
	    if (opponent.getCarrierHP() != 0) {
		System.out.println("Your Opponent has hit your Carrier!");
		currentlyFinishing = true; // starts finishing off carrier
	    }
	    else {
		System.out.println("Your Opponent has sunk your Carrier!");
		currentlyFinishing = false; // no longer finishing off any ships
	    }
	    oldRow = row;
	    oldCol = col;
	}
	else if (opponent._grid[row][col] == "B") { // hit!
	    opponent._grid[row][col] = "H";
	    _oppGrid[row][col] = "H";
	    opponent.setBattleshipHP(opponent.getBattleshipHP() - 1); // reduce HP
	    _lastShipHit = "Battleship";
	    battleshipCoorRow.add(row);
	    battleshipCoorCol.add(col);
	    if (opponent.getBattleshipHP() != 0) {
		System.out.println("Your Opponent has hit your Battleship!");
		currentlyFinishing = true; // starts finishing off battleship
	    }
	    else {
		System.out.println("Your Opponent has sunk your Battleship!");
		currentlyFinishing = false; // no longer finishing off any ships
	    }
	    oldRow = row;
	    oldCol = col;
	}
	else if (opponent._grid[row][col] == "c") { // hit!
	    opponent._grid[row][col] = "H";
	    _oppGrid[row][col] = "H";
	    opponent.setCruiserHP(opponent.getCruiserHP() - 1); // reduce HP
	    _lastShipHit = "Cruiser";
	    cruiserCoorRow.add(row);
	    cruiserCoorCol.add(col);
	    if (opponent.getCruiserHP() != 0) {
		System.out.println("Your Opponent has hit your Cruiser!");
		currentlyFinishing = true; // starts finishing off cruiser
	    }
	    else {
		System.out.println("Your Opponent has sunk your Cruiser!");
		currentlyFinishing = false; // no longer finishing off any ships
	    }
	    oldRow = row;
	    oldCol = col;
	}
	else if (opponent._grid[row][col] == "S") { // hit!
	    opponent._grid[row][col] = "H";
	    _oppGrid[row][col] = "H";
	    opponent.setSubmarineHP(opponent.getSubmarineHP() - 1); // reduce HP
	    _lastShipHit = "Submarine";
	    submarineCoorRow.add(row);
	    submarineCoorCol.add(col);
	    if (opponent.getSubmarineHP() != 0) {
		System.out.println("Your Opponent has hit your Submarine!");
		currentlyFinishing = true; // starts finishing off submarine
	    }
	    else {
		System.out.println("Your Opponent has sunk your Submarine!");
		currentlyFinishing = false; // no longer finishing off any ships
	    }
	    oldRow = row;
	    oldCol = col;
	}
	else if (opponent._grid[row][col] == "D") { // hit!
	    opponent._grid[row][col] = "H";
	    _oppGrid[row][col] = "H";
	    opponent.setDestroyerHP(opponent.getDestroyerHP() - 1); // reduce HP
	    _lastShipHit = "Destroyer";
	    destroyerCoorRow.add(row);
	    destroyerCoorCol.add(col);
	    if (opponent.getDestroyerHP() != 0) {
		System.out.println("Your Opponent has hit your Destroyer!");
		currentlyFinishing = true; // starts finishing off destroyer
	    }
	    else {
		System.out.println("Your Opponent has sunk your Destroyer!");
		currentlyFinishing = false; // no longer finishing off any ships
	    }
	    oldRow = row;
	    oldCol = col;
	}
	else {
	    opponent._grid[row][col] = "X";
	    _oppGrid[row][col] = "X";
	    System.out.println("Your Opponent has completely missed!");
	}
	turnCount+= 1;
	System.out.println("============================================");
    }

    public int evenOrOdd (int r) { // finds if input is even or odd and returns an int
	if (r%2 == 0) {
	    return 1;
	}
	return 2;
    }
    
    public void centerCoor() {
	row = (int) (Math.random() * 4) + 3; // 4x4 area in the center
	col = (int) (Math.random() * 4) + 3;
	if (evenOrOdd(row) != evenOrOdd(col)) { // if row is even but col is odd or vice versa
	    centerCoor(); // recall method
	    return;
	}
	if (_oppGrid[row][col] == "X" || _oppGrid[row][col] == "H") { // if the coordinate is already hit
	    centerCoor(); // recall method
	    return;
	}
    }

    public boolean fiveXH (int x) { // checks if there is a possibility for rowChange() to set coordinates
	int counter = 0;
        if (evenOrOdd(x) == 1) { // for an even input
	    for (int i = 0; i < 10; i+=2) { // starts at 0 and goes every other slot to check
		if (_oppGrid[x][i] == "X" || _oppGrid[x][i] == "H") {
		    counter++;
		}
	    }
	}
	else {
	    for (int i = 1; i < 10; i+=2) { // starts at 1 and goes every other slot to check
		if (_oppGrid[x][i] == "X" || _oppGrid[x][i] == "H") {
		    counter++;
		}
	    }
	}
	if (counter > 4) { // if there are 5 Xs and/or Hs in the row
	    return true;
	}
	return false;
    }

    public void rowChange() { 
	if (rowAttempts > 2) { // if there have been more than 2 rowAttempts
	    row = (int) (Math.random() * 10); // change row
	    rowAttempts = 0; // no row attempted
	}
        if (fiveXH(row)) { // if there have been 5 Xs and/or Hs in the row
	    rowAttempts = 0; // rowAttempts reset
	    row = (int) (Math.random() * 10); // change row
	    rowChange(); // recall
	    return;
	}
	col = (int) (Math.random() * 10); // random column
	if (evenOrOdd(row) != evenOrOdd(col)) { // if row is even and col is odd or vice versa
	    rowChange(); // recall 
	    return;
	}
	if (_oppGrid[row][col] == "X" || _oppGrid[row][col] == "H") { // if coordinate is already occupied
	    rowChange(); // recall 
	    return;
	}
    }

    public int coorForHitR () {
	if (_lastShipHit.equals("Carrier")) { // gives back a row where the Carrier was 
	    return carrierCoorRow.get((int) (Math.random() * carrierCoorRow.size()));
	}
	if (_lastShipHit.equals("Battleship")) { // gives back a row where the Battleship was 
	    return battleshipCoorRow.get((int) (Math.random() * battleshipCoorRow.size()));
	}
	if (_lastShipHit.equals("Cruiser")) { // gives back a row where the Cruiser was 
	    return cruiserCoorRow.get((int) (Math.random() * cruiserCoorRow.size()));
	}
	if (_lastShipHit.equals("Submarine")) { // gives back a row where the Submarine was 
	    return submarineCoorRow.get((int) (Math.random() * submarineCoorRow.size()));
	}
	if (_lastShipHit.equals("Destroyer")) { // gives back a row where the Destroyer was 
	    return destroyerCoorRow.get((int) (Math.random() * destroyerCoorRow.size()));
	}
	return oldRow;
    }

    public int coorForHitC () {
	if (_lastShipHit.equals("Carrier")) { // gives back a col where the Carrier was 
	    return carrierCoorCol.get((int) (Math.random() * carrierCoorRow.size()));
	}
	if (_lastShipHit.equals("Battleship")) { // gives back a col where the Battleship was 
	    return battleshipCoorCol.get((int) (Math.random() * battleshipCoorRow.size()));
	}
	if (_lastShipHit.equals("Cruiser")) { // gives back a col where the Cruiser was 
	    return cruiserCoorCol.get((int) (Math.random() * cruiserCoorRow.size()));
	}
	if (_lastShipHit.equals("Submarine")) { // gives back a col where the Submarine was
	    return submarineCoorCol.get((int) (Math.random() * submarineCoorRow.size()));
	}
	if (_lastShipHit.equals("Destroyer")) { // gives back a col where the Destroyer was
	    return destroyerCoorCol.get((int) (Math.random() * destroyerCoorRow.size()));
	}
	return oldCol;
    }
    
    public void coorForHit() { // when AI hits a user's ship, then it searches the premises for the other parts of the ship
	int random = (int) (Math.random() * 4);
	int row1 = coorForHitR();
	int col1 = coorForHitC();
	int dire = checkDirection();
	if (dire == 3) { // if only one point is known
	    // randomly choose one of the four sides
	    if (random == 0) {
		row1++; // one row down
	    }
	    else if (random == 1) {
		row1--; // one row up
	    }
	    else if (random == 2) {
		col1++; // one column to the right
	    }
	    else {
		col1--; // one column to the left
	    }
	}
	else if (dire == 2) { // same row
	    if (random == 0 || random == 1 ) { // 50-50 chance
		col1++; // one column to the right
	    }
	    else {
		col1--; // one column to the left
	    }
	}
	else if (dire == 1) { // same column
	    if (random == 2 || random == 3) { // 50-50 chance
		row1++; // one row down
	    }
	    else {
		row1--; // one row up
	    }
	}
	if (row1 < 0 || col1 < 0|| row1 > 9|| col1 > 9) { // if out of bounds
	    coorForHit(); // recall method
	    return;
	}
	if (_oppGrid[row1][col1] == "X" || _oppGrid[row1][col1] == "H") {
	    coorForHit();
	    return;
	}
	row = row1;
	col = col1;
    }

    public int checkDirection() {
	if (_lastShipHit.equals("Carrier")){
	    if (carrierCoorRow.size() > 1) { 
		if (carrierCoorRow.get(0) == carrierCoorRow.get(1)) { // if they are in the same row
		    return 2;
		}
		else { // if they are in the same column
		    return 1;
		}
	    }
	    else { // if only one point is known
		return 3;
	    }
	}
	if (_lastShipHit.equals("Battleship")){
	    if (battleshipCoorRow.size() > 1) {
		if (battleshipCoorRow.get(0) == battleshipCoorRow.get(1)) { // if they are in the same row
		    return 2;
		}
		else { // if they are in the same column
		    return 1;
		}
	    }
	    else { // if only one point is known
		return 3;
	    }
	}
	if (_lastShipHit.equals("Cruiser")){
	    if (cruiserCoorRow.size() > 1) {
		if (cruiserCoorRow.get(0) == cruiserCoorRow.get(1)) { // if they are in the same row
		    return 2;
		}
		else { // if they are in the same column
		    return 1;
		}
	    }
	    else { // if only one point is known
		return 3;
	    }
	}
	if (_lastShipHit.equals("Submarine")){
	    if (submarineCoorRow.size() > 1) {
		if (submarineCoorRow.get(0) == submarineCoorRow.get(1)) { // if they are in the same row
		    return 2;
		}
		else { // if they are in the same column
		    return 1;
		}
	    }
	    else { // if only one point is known
		return 3;
	    }
	}
	if (_lastShipHit.equals("Destroyer")){
	    if (destroyerCoorRow.size() > 1) {
		if (destroyerCoorRow.get(0) == destroyerCoorRow.get(1)) { // if they are in the same row
		    return 2;
		}
		else { // if they are in the same column
		    return 1;
		}
	    }
	    else { // if only one point is known
		return 3;
	    }
	}
	return 3;
    }
		    
    // ======================PLACE SHIPS METHODS======================
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
     // ======================END PLACE SHIPS METHODS======================
}
