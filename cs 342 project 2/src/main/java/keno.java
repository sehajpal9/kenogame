import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class keno{
	
	static int spots;
	static int spotschosenarr[][];
	static int drawings;
	static int userspotsarr[];
	double earnings;
	static boolean done;
	
	// get spots helper function
	public void spots(String spotid) {
		if(spotid == "spot1") {
			spots = 1;
			System.out.print("YAY SPOT 1 BUTTON WAS CHOSEN!!!\n");
		}
		else if(spotid == "spot4") {
			spots = 4;
			System.out.print("YAY SPOT 4 BUTTON WAS CHOSEN!!!\n");
		}
		else if(spotid == "spot8") {
			spots = 8;
			System.out.print("YAY SPOT 8 BUTTON WAS CHOSEN!!!\n");
		}
		else if(spotid == "spot10") {
			spots = 10;
			System.out.print("YAY SPOT 10 BUTTON WAS CHOSEN!!!\n");
		}
		else {
			System.out.print("ERROR: COULD NOT GET CORRECT SPOT...\n");
			spots = 0;
		}
	}
	// get drawings helper function
	public void drawings(String drawid) {
		if(drawid == "draw1") {
			drawings = 1;
			System.out.print("YAY DRAWING 1 BUTTON WAS CHOSEN!!!\n");
		}
		else if(drawid == "draw2") {
			drawings = 2;
			System.out.print("YAY DRAWING 2 BUTTON WAS CHOSEN!!!\n");
		}
		else if(drawid == "draw3") {
			drawings = 3;
			System.out.print("YAY DRAWING 3 BUTTON WAS CHOSEN!!!\n");
		}
		else if(drawid == "draw4") {
			drawings = 4;
			System.out.print("YAY DRAWING 4 BUTTON WAS CHOSEN!!!\n");
		}
		else {
			System.out.print("ERROR: COULD NOT GET CORRECT DRAWINGS...\n");
			drawings = 0;
		}
	}
	
	// play the game if the user chooses random automatic selection
	public void play() {
		
		done = false;
		
		// keeping track of the drawings 
		int drawingscount = 0;
		spotschosenarr = new int[drawings][20];
		// keeping track of the spots 
		int spotscount = 0;
		userspotsarr = new int[spots];

		while(spotscount < spots) {
			userspotsarr[spotscount] = randomGeneration();
			while(drawingscount < drawings) {
				chooseSpots(spotschosenarr, drawingscount);
				drawingscount++;
			}
			spotscount++;
		}
		
		// TESTING
		System.out.print("PRINTING THE USER SPOTS CHOSEN: ");
		for(int i = 0; i < spots; i++) {
			System.out.print(userspotsarr[i] + " ");
		}
		System.out.print("\n");
		System.out.print("PRINTING THE SPOTS CHOSEN: \n");
		for(int i = 0; i < drawings; i++) {
			for(int j = 0; j < 20; j++) {
				System.out.print(spotschosenarr[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
		
		done = true;
	}
	
	// play the game if the user chooses to manually select
	public void playManual(List<String> list) {
		done = false;
		
		// keeping track of the drawings 
		int drawingscount = 0;
		spotschosenarr = new int[drawings][20];
		// keeping track of the spots 
		int spotscount = 0;
		userspotsarr = new int[spots];


		while(spotscount < spots) {
			userspotsarr[spotscount] = manualSelection(list.get(spotscount));
			spotscount++;
		}
		while(drawingscount < drawings) {
			chooseSpots(spotschosenarr, drawingscount);
			drawingscount++;
		}
		
		
		// TESTING
		System.out.print("PRINTING THE USER SPOTS CHOSEN: ");
		for(int i = 0; i < spots; i++) {
			System.out.print(userspotsarr[i] + " ");
		}
		System.out.print("\n");
		System.out.print("PRINTING THE SPOTS CHOSEN: \n");
		for(int i = 0; i < drawings; i++) {
			for(int j = 0; j < 20; j++) {
				System.out.print(spotschosenarr[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
		
		done = true;
	}
	
	// function for the board to randomly select 20 spots from the board
	public void chooseSpots(int[][] array, int counter) {
		
		ArrayList<Integer> board = new ArrayList<Integer>();
		for(int i = 0; i < 80; i++) {
			board.add(i+1);
		}

		for(int i = 0; i < 20; i++) {
			Collections.shuffle(board);
			array[counter][i] = board.remove(0);
		}

	}
	
	// function to randomly generate numbers when the random generation button is clicked
	// for the amount of spots that the user chose
	public int randomGeneration() {
		
		ArrayList<Integer> board = new ArrayList<Integer>();
		for(int i = 0; i < 80; i++) {
			board.add(i+1);
		}
		Collections.shuffle(board);
		int spot = board.remove(0);

		return spot;
	}
	
	public int manualSelection(String buttonid) {
		int counter = 0;
		int buttonnum = 0;
		// get which number button was chosen
		for(int i = 0; i < 80; i++) {
			counter++;
			String compare = "btn" + counter;
			if(compare.equals(buttonid) == true) {
				buttonnum = counter;
				return buttonnum;
			}
		}
		return buttonnum;
	}
	
//	public static void exitgame() {
//		// TESTING
//		if(done = true) {
//			System.out.print("DRAWINGS FINISHED\n");
//		}
//		else {
//			System.out.print("SOMETHING IS WRONG, DONE NOT SET TO TRUE\n");
//		}
//		System.exit(0);
//	}
	
}