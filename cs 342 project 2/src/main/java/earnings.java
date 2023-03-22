public class earnings extends keno{
	
	static double totalEarnings;
	static int whichgame;
	static int match = 0;
	static int[] matches;
	
	// get which spot game the user selects 
	public static void getgame(int num) {
		whichgame = num;
		// TESTING
		//System.out.print("getgame() called: " + whichgame + " returned\n");
	}
	
	// gets the number of matches from the array of user spots and the matrix of the 
	// spots randomly chosen on the board for each drawing
	public static void getmatches() {
		int counter = 0;
		
		while(counter < spots) {
			
			for(int i = 0; i < drawings; i++) {
				for(int j = 0; j < 20; j++) {
					if(userspotsarr[counter] == spotschosenarr[i][j]) {
						match++;
					}
				}
			}
			counter++;
		}
		// TESTING
		System.out.print("MATCHES FOUND: " + match + "\n");
	}
	
	public static void allMatches() {
		matches = new int[match];
		
		int counter = 0;
		int matchcount = 0;
		// TESTING
		System.out.print("MATCHES: ");
		
		while(counter < spots) {
			
			for(int i = 0; i < drawings; i++) {
				for(int j = 0; j < 20; j++) {
					if(userspotsarr[counter] == spotschosenarr[i][j]) {
						matches[matchcount] = userspotsarr[counter];
						System.out.print("MATCHES: " + matches[matchcount] + "\n");
						matchcount++;
					}
				}
			}
			counter++;
		}
		System.out.print("\n");
		
	}
	
	// calculate the earnings based on which game the user is playing
	public static void getEarnings() {
		
		// one spot
		if(whichgame == 1) {
			onespot();
		}
		// four spot
		else if(whichgame == 4) {
			fourspot();
		}
		// eight spot
		else if(whichgame == 8) {
			eightspot();
		}
		// ten spot
		else if(whichgame == 10) {
			tenspot();
		}
		// TESTING
		System.out.print("PLAYER EARNINGS: " + totalEarnings + "\n");
		
	}
	
	// all the different types of games and their prizes associated 
	static void onespot() {
		if(match == 1) {
			totalEarnings = 1;
		}
	}
	static void fourspot() {
		if(match == 2) {
			totalEarnings = 1;
		}
		else if(match == 3) {
			totalEarnings = 5;
		}
		else if(match == 4) {
			totalEarnings = 75;
		}
	}
	static void eightspot() {
		if(match == 4) {
			totalEarnings = 2;
		}
		else if(match == 5) {
			totalEarnings = 12;
		}
		else if(match == 6) {
			totalEarnings = 50;
		}
		else if(match == 7) {
			totalEarnings = 750;
		}
		else if(match == 8) {
			totalEarnings = 10000;
		}
	}
	static void tenspot() {
		if(match == 0) {
			totalEarnings = 5;
		}
		else if(match == 5) {
			totalEarnings = 2;
		}
		else if(match == 6) {
			totalEarnings = 15;
		}
		else if(match == 7) {
			totalEarnings = 40;
		}
		else if(match == 8) {
			totalEarnings = 450;
		}
		else if(match == 9) {
			totalEarnings = 4250;
		}
		else if(match == 10) {
			totalEarnings = 100000;
		}
	}
	
	
}