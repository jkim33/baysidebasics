import java.util.ArrayList;

public class AdvancedAI extends Player {
    private int oldRow, oldCol;
    private int row, col;
    private int rowAttempts = 0;
    private int turnCount = 1;
    private int oppShipsAliveOld = 5;
    private int oppShipsAlive = 5;
    
    private ArrayList <Integer> carrierCoorRow = new ArrayList <Integer> ();
    private ArrayList <Integer> carrierCoorCol = new ArrayList <Integer> ();
    private ArrayList <Integer> battleshipCoorRow = new ArrayList <Integer> ();
    private ArrayList <Integer> battleshipCoorCol = new ArrayList <Integer> ();
    private ArrayList <Integer> cruiserCoorRow = new ArrayList <Integer> ();
    private ArrayList <Integer> cruiserCoorCol = new ArrayList <Integer> ();
    private ArrayList <Integer> submarineCoorRow = new ArrayList <Integer> ();
    private ArrayList <Integer> submarineCoorCol = new ArrayList <Integer> ();
    private ArrayList <Integer> destroyerCoorRow = new ArrayList <Integer> ();
    private ArrayList <Integer> destroyerCoorCol = new ArrayList <Integer> ();
    
    private boolean currentlyFinishing = false;
    
    public void attackOpponent(Player opponent) {
	if (currentlyFinishing) {
	    coorForHit();
	}
	else if (turnCount < 4) {
	    centerCor();
	}
	else {
	    rowChange();
	    rowAttempts++;
	}
	if (opponent._grid[row][col] == "C") {
	    opponent._grid[row][col] = "H";
	    _oppGrid[row][col] = "H";
	    opponent.setCarrierHP(opponent.getCarrierHP() - 1);
	    _lastShipHit = "Carrier";
	    carrierCoorRow.add(row);
	    carrierCoorCol.add(col);
	    if (opponent.getCarrierHP() != 0) {
		System.out.println("Your Opponent has hit your Carrier!");
		currentlyFinishing = true;
	    }
	    else {
		System.out.println("Your Opponent has sunk your Carrier!");
		currentlyFinishing = false;
	    }
	    oldRow = row;
	    oldCol = col;
	}
	else if (opponent._grid[row][col] == "B") {
	    opponent._grid[row][col] = "H";
	    _oppGrid[row][col] = "H";
	    opponent.setBattleshipHP(opponent.getBattleshipHP() - 1);
	    _lastShipHit = "Battleship";
	    battleshipCoorRow.add(row);
	    battleshipCoorCol.add(col);
	    if (opponent.getBattleshipHP() != 0) {
		System.out.println("Your Opponent has hit your Battleship!");
		currentlyFinishing = true;
	    }
	    else {
		System.out.println("Your Opponent has sunk your Battleship!");
		currentlyFinishing = false;
	    }
	    oldRow = row;
	    oldCol = col;
	}
	else if (opponent._grid[row][col] == "c") {
	    opponent._grid[row][col] = "H";
	    _oppGrid[row][col] = "H";
	    opponent.setCruiserHP(opponent.getCruiserHP() - 1);
	    _lastShipHit = "Cruiser";
	    cruiserCoorRow.add(row);
	    cruiserCoorCol.add(col);
	    if (opponent.getCruiserHP() != 0) {
		System.out.println("Your Opponent has hit your Cruiser!");
		currentlyFinishing = true;
	    }
	    else {
		System.out.println("Your Opponent has sunk your Cruiser!");
		currentlyFinishing = false;
	    }
	    oldRow = row;
	    oldCol = col;
	}
	else if (opponent._grid[row][col] == "S") {
	    opponent._grid[row][col] = "H";
	    _oppGrid[row][col] = "H";
	    opponent.setSubmarineHP(opponent.getSubmarineHP() - 1);
	    _lastShipHit = "Submarine";
	    submarineCoorRow.add(row);
	    submarineCoorCol.add(col);
	    if (opponent.getSubmarineHP() != 0) {
		System.out.println("Your Opponent has hit your Submarine!");
		currentlyFinishing = true;
	    }
	    else {
		System.out.println("Your Opponent has sunk your Submarine!");
		currentlyFinishing = false;
	    }
	    oldRow = row;
	    oldCol = col;
	}
	else if (opponent._grid[row][col] == "D") {
	    opponent._grid[row][col] = "H";
	    _oppGrid[row][col] = "H";
	    opponent.setDestroyerHP(opponent.getDestroyerHP() - 1);
	    _lastShipHit = "Destroyer";
	    destroyerCoorRow.add(row);
	    destroyerCoorCol.add(col);
	    if (opponent.getDestroyerHP() != 0) {
		System.out.println("Your Opponent has hit your Destroyer!");
		currentlyFinishing = true;
	    }
	    else {
		System.out.println("Your Opponent has sunk your Destroyer!");
		currentlyFinishing = false;
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
	System.out.println(turnCount);
	System.out.println(currentlyFinishing);
    }

    public int evenOrOdd (int r) {
	if (r%2 == 0) {
	    return 1;
	}
	return 2;
    }
    
    public void centerCor() {
	row = (int) (Math.random() * 4) + 3;
	col = (int) (Math.random() * 4) + 3;
	if (evenOrOdd(row) != evenOrOdd(col)) {
	    centerCor();
	    return;
	}
	if (_oppGrid[row][col] == "X" || _oppGrid[row][col] == "H") {
	    centerCor();
	    return;
	}
    }

    public boolean fiveXH (int x) {
	int counter = 0;
        if (evenOrOdd(x) == 1) {
	    for (int i = 0; i < 10; i+=2) {
		if (_oppGrid[x][i] == "X" || _oppGrid[x][i] == "H") {
		    counter++;
		}
	    }
	}
	else {
	    for (int i = 1; i < 10; i+=2) {
		if (_oppGrid[x][i] == "X" || _oppGrid[x][i] == "H") {
		    counter++;
		}
	    }
	}
	if (counter > 4) {
	    return true;
	}
	return false;
    }

    public void rowChange() {
	if (rowAttempts > 2) {
	    row = (int) (Math.random() * 10);
	    rowAttempts = 0;
	}
        if (fiveXH(row)) {
	    rowAttempts = 0;
	    row = (int) (Math.random() * 10);
	    rowChange();
	    return;
	}
	col = (int) (Math.random() * 10);
	if (evenOrOdd(row) != evenOrOdd(col)) {
	    rowChange();
	    return;
	}
	if (_oppGrid[row][col] == "X" || _oppGrid[row][col] == "H") {
	    rowChange();
	    return;
	}
    }

    public int coorForHitR () {
	if (_lastShipHit.equals("Carrier")){
	    return carrierCoorRow.get((int) (Math.random() * carrierCoorRow.size()));
	}
	if (_lastShipHit.equals("Battleship")){
	    return battleshipCoorRow.get((int) (Math.random() * battleshipCoorRow.size()));
	}
	if (_lastShipHit.equals("Cruiser")){
	    return cruiserCoorRow.get((int) (Math.random() * cruiserCoorRow.size()));
	}
	if (_lastShipHit.equals("Submarine")){
	    return submarineCoorRow.get((int) (Math.random() * submarineCoorRow.size()));
	}
	if (_lastShipHit.equals("Destroyer")){
	    return destroyerCoorRow.get((int) (Math.random() * destroyerCoorRow.size()));
	}
	return oldRow;
    }

    public int coorForHitC () {
	if (_lastShipHit.equals("Carrier")){
	    return carrierCoorCol.get((int) (Math.random() * carrierCoorRow.size()));
	}
	if (_lastShipHit.equals("Battleship")){
	    return battleshipCoorCol.get((int) (Math.random() * battleshipCoorRow.size()));
	}
	if (_lastShipHit.equals("Cruiser")){
	    return cruiserCoorCol.get((int) (Math.random() * cruiserCoorRow.size()));
	}
	if (_lastShipHit.equals("Submarine")){
	    return submarineCoorCol.get((int) (Math.random() * submarineCoorRow.size()));
	}
	if (_lastShipHit.equals("Destroyer")){
	    return destroyerCoorCol.get((int) (Math.random() * destroyerCoorRow.size()));
	}
	return oldCol;
    }
    
    public void coorForHit() {
	int random = (int) (Math.random() * 4);
	int row1 = coorForHitR();
	int col1 = coorForHitC();
	int dire = checkDirection();
	if (dire == 3) {
	    if (random == 0) {
		row1++;
	    }
	    if (random == 1) {
		row1--;
	    }
	    if (random == 2) {
		col1++;
	    }
	    else {
		col1--;
	    }
	}
	else if (dire == 2) {
	    if (random == 0 || random == 1 ) {
		col1++;
	    }
	    else {
		col1--;
	    }
	}
	else {
	    if (random == 0 || random == 1) {
		row1++;
	    }
	    else {
		row1--;
	    }
	}
	if (row1 < 0 || col1 < 0|| row1 > 9|| col1 > 9) {
	    coorForHit();
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
		if (carrierCoorRow.get(0) == carrierCoorRow.get(1)) {
		    return 2;
		}
		else {
		    return 1;
		}
	    }
	    else {
		return 3;
	    }
	}
	if (_lastShipHit.equals("Battleship")){
	    if (battleshipCoorRow.size() > 1) {
		if (battleshipCoorRow.get(0) == battleshipCoorRow.get(1)) {
		    return 2;
		}
		else {
		    return 1;
		}
	    }
	    else {
		return 3;
	    }
	}
	if (_lastShipHit.equals("Cruiser")){
	    if (cruiserCoorRow.size() > 1) {
		if (cruiserCoorRow.get(0) == cruiserCoorRow.get(1)) {
		    return 2;
		}
		else {
		    return 1;
		}
	    }
	    else {
		return 3;
	    }
	}
	if (_lastShipHit.equals("Submarine")){
	    if (submarineCoorRow.size() > 1) {
		if (submarineCoorRow.get(0) == submarineCoorRow.get(1)) {
		    return 2;
		}
		else {
		    return 1;
		}
	    }
	    else {
		return 3;
	    }
	}
	if (_lastShipHit.equals("Destroyer")){
	    if (destroyerCoorRow.size() > 1) {
		if (destroyerCoorRow.get(0) == destroyerCoorRow.get(1)) {
		    return 2;
		}
		else {
		    return 1;
		}
	    }
	    else {
		return 3;
	    }
	}
	return 3;
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
