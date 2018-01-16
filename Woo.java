import cs1.Keyboard;

public class Woo {

    static Player human;
    static Player AI;

    public static void start() {
	System.out.println("Welcome player.\n\nYou are about to embark in a naval war. Are you prepared for that?\nPlease enter Yes if you are, No if you are not.\n");
	String ans = Keyboard.readString();
	if (!(ans.equals("Yes")) && !(ans.equals("No"))) {
	    System.out.println ("Please enter a valid answer.\nIt is case-sensitive\n");
	    start();
	}
	else {
	    if (ans.equals("Yes")) {
		System.out.println ("\nThat is what we, the game developers, like to hear!! \nPrepare for war!\n");
	    }
	    if (ans.equals("No")) {
		System.out.println ("That is too bad. Prepare for war!\n");
	    }
	}
    }
    
    public static void main (String[]args) {
	human = new Human();
	AI = new BeginnerAI();
	Boolean a = true;

	start(); // begin!
	
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
	    human.attackOpponent(AI);
	    if (AI.check()) {
		System.out.println("You Win!");
		a=false;
	    }
	    else {
		AI.attackOpponent(human);
		if (human.check()) {
		    System.out.println("You Lose!");
		    a=false;
		}
	    }
	}
    }
}
