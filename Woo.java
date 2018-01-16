import cs1.Keyboard;

public class Woo {

    static Player human;
    static Player AI;
    
    public static void main (String[]args) {
	human = new Human();
	AI = new BeginnerAI();
	Boolean a = true;
	int row;
	int col;
	
	human.setGrid();
	System.out.println("Time to place ships!");
	
	System.out.println(human);
	System.out.println("Please place your Carrier");
	human.placeCarrier();

	System.out.println(human);
	System.out.println("Please place your Battleship");
	human.placeBattleship();

	System.out.println(human);
	System.out.println("Please place your Cruiser");
	human.placeCruiser();

	System.out.println(human);
	System.out.println("Please place your Submarine");
	human.placeSubmarine();

	System.out.println(human);
	System.out.println("Please place your Destroyer");
	human.placeDestroyer();
	human.setPlaying(true);

	AI.setGrid();
	AI.placeShip();
	while (a) {
	    System.out.println(human);
	    System.out.print("Row: ");
	    row = Keyboard.readInt();
	    System.out.print("Col: ");
	    col = Keyboard.readInt();
	    human.attackOpponent(row,col, AI);
	    if (AI.check()) {
		System.out.println("You Win!");
		a=false;
	    }
	    else {
		AI.attackOpponent(0,0,human);
		if (human.check()) {
		    System.out.println("You Lose!");
		    a=false;
		}
	    }
	}
    }
}
