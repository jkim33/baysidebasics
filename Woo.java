import cs1.Keyboard;

public class Woo {
    public static Boolean check(Human h, BeginnerAI ai) {
	for (String[] i: h._grid) {
	    for (String s: i){
		if (s != "O" || s!= "H" || s != "X") {
		    return true;
		}
	    }
	}
	for (String[] i: ai._grid) {
	    for (String s: i){
		if (s != "O" || s!= "H" || s != "X") {
		    return true;
		}
	    }
	}
	return false;
    }
    
    public static void main (String[]args) {
	Human human = new Human();
	BeginnerAI AI = new BeginnerAI();
	Boolean a = true;
	int row = 0;
	int col = 0;
	human.setGrid();
	human.placeShip();
	AI.setGrid();
	AI.placeShip();
	while (a) {
	    System.out.println(human);
	    System.out.print("Row: ");
	    row = Keyboard.readInt();
	    System.out.print("Col: ");
	    col = Keyboard.readInt();
	    human.attackOpponent(row,col, AI);
	    AI.attackOpponent(human);
	    a = check(human, AI);
	}
    }
}
