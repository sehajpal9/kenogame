import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class JavaFXTemplate extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@SuppressWarnings("static-access")
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		// game variables 
		keno kenogame = new keno();
		player player1 = new player();
		earnings earned = new earnings();
		
		
		// scenes
		BorderPane root = new BorderPane();
		Scene welcomescene = new Scene(root, 700,700);
		BorderPane root2 = new BorderPane();
		Scene gamescene = new Scene(root2, 700,700);
		BorderPane root3 = new BorderPane();
		Scene rulesscene = new Scene(root3, 700,700);
		BorderPane root4 = new BorderPane();
		Scene oddsscene = new Scene(root4, 700,700);
		BorderPane root5 = new BorderPane();
		Scene exitscene = new Scene(root5, 700,700);
		BorderPane root6 = new BorderPane();
		Scene newlookscene = new Scene(root6, 700,700);
		
		
		
		// ------------------------------- W E L C O M E   S C E N E --------------------------------
		//---------- Welcome screen that contains the play button and the menu bar ----------------
		primaryStage.setTitle("Keno");
		// welcome text
		Text welcomeTxt = new Text("Welcome!");
		
		// play button
		Button playBtn = new Button("Let's Play Keno");
		playBtn.setStyle("-fx-background-color: #D5F2E3; ");
		playBtn.setOnAction((playEvent) -> {
			// need to redirect to new scene with game board
        	System.out.print("OPENING KENO GAMEBOARD...");
        	primaryStage.setScene(gamescene);
        });
		
		// menu bar
		Button menu = new Button("Menu");
		menu.setStyle("-fx-background-color: #D5F2E3; ");
		menu.setOnAction((openMenuEvent) -> {
			// need to display a drop down menu when menu button is clicked
        	System.out.print("OPENING MENU DROP DOWN...");
        	VBox dropdown = new VBox();
        	Button rulesbtn = new Button("Rules");
        	rulesbtn.setStyle("-fx-background-color: #D5F2E3; ");
        	rulesbtn.setOnAction((rulesevent) -> {
        		primaryStage.setScene(rulesscene);
            });
        	Button oddsbtn = new Button("Odds");
        	oddsbtn.setStyle("-fx-background-color: #D5F2E3; ");
        	oddsbtn.setOnAction((oddsevent) -> {
        		primaryStage.setScene(oddsscene);
            });
        	Button exitbtn = new Button("Exit");
        	exitbtn.setStyle("-fx-background-color: #D5F2E3; ");
        	exitbtn.setOnAction((exitevent) -> {
        		primaryStage.setScene(exitscene);
            });
        	dropdown.getChildren().addAll(rulesbtn, oddsbtn, exitbtn);
        	root.setRight(dropdown);
        });
		
		// background and scene setup
	    root.setStyle("-fx-background-color: #73BA9B; ");
	    root.setCenter(welcomeTxt);
	    root.setBottom(playBtn);
	    root.setTop(menu);
		primaryStage.setScene(welcomescene);
		primaryStage.show();
		
		
		
		// ------------------------------- R U L E S   S C E N E --------------------------------
		// if the user clicks on the rules button then it opens the rules page
		Text rulesTitle = new Text("Rules");
		root3.setStyle("-fx-background-color: #73BA9B; ");
		root3.setTop(rulesTitle);
		
		Text howtoplay = new Text("You will start off by setting up your game, during "
				+ "the setup you will choose spots, drawings, and\nhow you want to pick. "
				+ "Spots indicates how many spots on the board you want to choose, the "
				+ "more\nspots you pick the higher the chances of finding a match. "
				+ "Drawings is how many times\nyou want want 20 spots to be chosen to compare "
				+ "to\nthe spots you have, its basically how many games you want to play. "
				+ "The last part is choosing how you\nwant to pick your spots. You can either"
				+ "select random generate which the\ncomputer will pick for you, or you can click"
				+ "on the numbers on the\nboard that align to the spots you initially declared you"
				+ "would choose and then press start.");
		root3.setCenter(howtoplay);
		
		// menu bar
		Button menu3 = new Button("Menu");
		menu3.setStyle("-fx-background-color: #D5F2E3; ");
		menu3.setOnAction((openMenuEvent) -> {
			// need to display a drop down menu when menu button is clicked
        	System.out.print("OPENING MENU DROP DOWN...");
        	VBox dropdown = new VBox();
        	Button rulesbtn = new Button("Rules");
        	rulesbtn.setStyle("-fx-background-color: #D5F2E3; ");
        	rulesbtn.setOnAction((rulesevent) -> {
        		primaryStage.setScene(rulesscene);
            });
        	Button oddsbtn = new Button("Odds");
        	oddsbtn.setStyle("-fx-background-color: #D5F2E3; ");
        	oddsbtn.setOnAction((oddsevent) -> {
        		primaryStage.setScene(oddsscene);
            });
        	Button exitbtn = new Button("Exit");
        	exitbtn.setStyle("-fx-background-color: #D5F2E3; ");
        	exitbtn.setOnAction((exitevent) -> {
        		primaryStage.setScene(exitscene);
            });
        	dropdown.getChildren().addAll(rulesbtn, oddsbtn, exitbtn);
        	root3.setRight(dropdown);
        });
		root3.setLeft(menu3);
		
		
		
		// ------------------------------------ O D D S   S C E N E -------------------------------------
		// if the user clicks on the odds button then it opens the odds page
		Text oddsTitle = new Text("Odds");
		root4.setStyle("-fx-background-color: #73BA9B; ");
		root4.setTop(oddsTitle);
		
		VBox spotsodds = new VBox();
		// 1 spot
		Text onespot = new Text("1 Spot:\n match 1 - prize $2\n\n");
		// 2 spot
		Text twospot = new Text("4 Spot:\n match 4 - prize $75,\n match 3 - prize $5,\n match 2 - prize $1\n\n");
		// 3 spot
		Text threespot = new Text("8 Spot:\n match 4 - prize $2,\n match 5 - prize $12,\n match 6 - prize $50,\n "
				+ "match 7 - prize $750,\n match 8 - prize $10,000\n\n");
		// 4 spot 
		Text fourspot = new Text("10 Spot:\n match 0 - prize $5,\n match 5 - prize $2,\n match 6 - prize $15,\n "
				+ "match 7 - prize $40,\n match 8 - prize $450,\n match 9 - prize $4250,\n match 10 - prize $100,000");
		spotsodds.getChildren().addAll(onespot, twospot, threespot, fourspot);
		root4.setCenter(spotsodds);
		
		// menu bar
		Button menu4 = new Button("Menu");
		menu4.setStyle("-fx-background-color: #D5F2E3; ");
		menu4.setOnAction((openMenuEvent) -> {
			// need to display a drop down menu when menu button is clicked
			System.out.print("OPENING MENU DROP DOWN...");
        	VBox dropdown = new VBox();
        	Button rulesbtn = new Button("Rules");
        	rulesbtn.setStyle("-fx-background-color: #D5F2E3; ");
        	rulesbtn.setOnAction((rulesevent) -> {
        		primaryStage.setScene(rulesscene);
            });
        	Button oddsbtn = new Button("Odds");
        	oddsbtn.setStyle("-fx-background-color: #D5F2E3; ");
        	oddsbtn.setOnAction((oddsevent) -> {
        		primaryStage.setScene(oddsscene);
            });
        	Button exitbtn = new Button("Exit");
        	exitbtn.setStyle("-fx-background-color: #D5F2E3; ");
        	exitbtn.setOnAction((exitevent) -> {
        		primaryStage.setScene(exitscene);
            });
        	dropdown.getChildren().addAll(rulesbtn, oddsbtn, exitbtn);
        	root4.setRight(dropdown);
        });
		root4.setLeft(menu4);
		
		
		
		// ------------------------------- E X I T   S C E N E --------------------------------
		// if the user clicks on the exit button then exits
		Text goodbyeText = new Text("Exiting Game... Goodbye :)");
		root5.setStyle("-fx-background-color: #73BA9B; ");
		root5.setCenter(goodbyeText);
		
		// menu bar
		Button menu5 = new Button("Menu");
		menu5.setStyle("-fx-background-color: #D5F2E3; ");
		menu5.setOnAction((openMenuEvent) -> {
			// need to display a drop down menu when menu button is clicked
        	System.out.print("OPENING MENU DROP DOWN...");
        	VBox dropdown = new VBox();
        	Button rulesbtn = new Button("Rules");
        	rulesbtn.setStyle("-fx-background-color: #D5F2E3; ");
        	rulesbtn.setOnAction((rulesevent) -> {
        		primaryStage.setScene(rulesscene);
            });
        	Button oddsbtn = new Button("Odds");
        	oddsbtn.setStyle("-fx-background-color: #D5F2E3; ");
        	oddsbtn.setOnAction((oddsevent) -> {
        		primaryStage.setScene(oddsscene);
            });
        	Button welcomebtn = new Button("Welcome");
        	welcomebtn.setStyle("-fx-background-color: #D5F2E3; ");
        	welcomebtn.setOnAction((welcomeevent) -> {
        		primaryStage.setScene(welcomescene);
            });
        	dropdown.getChildren().addAll(rulesbtn, oddsbtn, welcomebtn);
        	root5.setRight(dropdown);
        });
		root5.setLeft(menu5);
		
		
		
		// -------------------------------- G A M E   S C E N E ---------------------------------
		// the game board screen when the user selects the lets play keno button
		Text gameText = new Text("Keno");
		root2.setStyle("-fx-background-color: #73BA9B; ");
		root2.setCenter(gameText);
		
		// menu bar
		Button menu2 = new Button("Menu");
		menu2.setStyle("-fx-background-color: #D5F2E3; ");
		menu2.setOnAction((openMenuEvent) -> {
			// need to display a drop down menu when menu button is clicked
        	System.out.print("OPENING MENU DROP DOWN...");
        	VBox dropdown = new VBox();
        	Button rulesbtn = new Button("Rules");
        	rulesbtn.setStyle("-fx-background-color: #D5F2E3; ");
        	rulesbtn.setOnAction((rulesevent) -> {
        		primaryStage.setScene(rulesscene);
            });
        	Button oddsbtn = new Button("Odds");
        	oddsbtn.setStyle("-fx-background-color: #D5F2E3; ");
        	oddsbtn.setOnAction((oddsevent) -> {
        		primaryStage.setScene(oddsscene);
            });
        	Button exitbtn = new Button("Exit");
        	exitbtn.setStyle("-fx-background-color: #D5F2E3; ");
        	exitbtn.setOnAction((exitevent) -> {
        		primaryStage.setScene(exitscene);
            });
        	Button newlookbtn = new Button("New Look");
        	newlookbtn.setStyle("-fx-background-color: #D5F2E3; ");
        	newlookbtn.setOnAction((newlookevent) -> {
        		primaryStage.setScene(newlookscene);
            });
        	dropdown.getChildren().addAll(rulesbtn, oddsbtn, exitbtn, newlookbtn);
        	root2.setRight(dropdown);
        });
		root2.setRight(menu2);
		
		// 10x8 blank board 
		VBox boardandoutput = new VBox();
		GridPane betcard = new GridPane();
		int counter = 0;
		// make the grid of buttons
		for(int y = 0; y < 8; y++) {
			for(int x = 0; x < 10; x++) {
				counter++;
                // create a new button
                Button btn = new Button();
                btn.setStyle("-fx-background-color: #D5F2E3; ");
                btn.setId("btn"+counter);
                btn.setPrefHeight(50);
                btn.setPrefWidth(50);
                btn.setAlignment(Pos.CENTER);
                btn.setText(" " + counter + " ");

                // iterate
                betcard.setRowIndex(btn,y);
                betcard.setColumnIndex(btn,x);    
                betcard.getChildren().add(btn);
			}
		}
		boardandoutput.getChildren().add(betcard);
		boardandoutput.setDisable(true);
		root2.setCenter(boardandoutput);
		
		// area where we set everything up 
		VBox setup = new VBox();
		root2.setBottom(setup);
		
		// spots section
		Text spotstxt = new Text("Spots");
		HBox spotsbtns = new HBox();
		Button one = new Button("1");
		one.setStyle("-fx-background-color: #D5F2E3; ");
		Button four = new Button("4");
		four.setStyle("-fx-background-color: #D5F2E3; ");
		Button eight = new Button("8");
		eight.setStyle("-fx-background-color: #D5F2E3; ");
		Button ten = new Button("10");
		ten.setStyle("-fx-background-color: #D5F2E3; ");
		spotsbtns.getChildren().addAll(one, four, eight, ten);
		one.setOnAction((event1) -> {
			one.setId("spot1");
			kenogame.spots(one.getId());
			earnings.getgame(1);
			spotsbtns.setDisable(true);
		});
		four.setOnAction((event4) -> {
			four.setId("spot4");
			kenogame.spots(four.getId());
			earnings.getgame(4);
			spotsbtns.setDisable(true);
		});
		eight.setOnAction((event) -> {
			eight.setId("spot8");
			kenogame.spots(eight.getId());
			earnings.getgame(8);
			spotsbtns.setDisable(true);
		});
		ten.setOnAction((event) -> {
			ten.setId("spot10");
			kenogame.spots(ten.getId());
			earnings.getgame(10);
			spotsbtns.setDisable(true);
		});
		
		// drawings section
		Text drawingstxt = new Text("Drawings");
		HBox drawbtns = new HBox();
		Button one1 = new Button("1");
		one1.setStyle("-fx-background-color: #D5F2E3; ");
		Button two2 = new Button("2");
		two2.setStyle("-fx-background-color: #D5F2E3; ");
		Button three3 = new Button("3");
		three3.setStyle("-fx-background-color: #D5F2E3; ");
		Button four4 = new Button("4");
		four4.setStyle("-fx-background-color: #D5F2E3; ");
		drawbtns.getChildren().addAll(one1, two2, three3, four4);
		one1.setOnAction((eventone) -> {
			one1.setId("draw1");
			kenogame.drawings(one1.getId());
			drawbtns.setDisable(true);
			boardandoutput.setDisable(false);
		});
		two2.setOnAction((eventtwo) -> {
			two2.setId("draw2");
			kenogame.drawings(two2.getId());
			drawbtns.setDisable(true);
			boardandoutput.setDisable(false);
		});
		three3.setOnAction((eventthree) -> {
			three3.setId("draw3");
			kenogame.drawings(three3.getId());
			drawbtns.setDisable(true);
			boardandoutput.setDisable(false);
		});
		four4.setOnAction((eventfour) -> {
			four4.setId("draw4");
			kenogame.drawings(four4.getId());
			drawbtns.setDisable(true);
			boardandoutput.setDisable(false);
		});
		
		
		// event if any of the buttons are clicked
		List<String> btnidarr = new ArrayList<String>(kenogame.spots);
		betcard.getChildren().forEach(button -> {
			button.setOnMouseClicked((event) -> {
				// add the button id to an array
				btnidarr.add(button.getId());
			});
		});
		
		// random selection option
		Button start = new Button("Start");
		Button random = new Button("Randomly Select");
		random.setStyle("-fx-background-color: #D5F2E3; ");
		random.setOnAction((eventrand) -> {
			start.setDisable(true);
			random.setDisable(true);
			betcard.getChildren().forEach(button -> {
				button.setDisable(true);
			});
			
			kenogame.play();
			earnings.getmatches();
			earnings.allMatches();
			earnings.getEarnings();
			
			HBox displayplayerspots = new HBox();
			Text playerspotstitle = new Text("Player's Chosen Spots: ");
			displayplayerspots.getChildren().add(playerspotstitle);
			for(int i = 0; i < kenogame.spots; i++) {
				Text playerspots1 = new Text();
				playerspots1.setText(kenogame.userspotsarr[i] + " ");
				displayplayerspots.getChildren().add(playerspots1);
			}
			boardandoutput.getChildren().add(displayplayerspots);
			
			HBox displaychosenspots = new HBox();
			Text chosenspotststitle = new Text("Spots Selected: ");
			displaychosenspots.getChildren().add(chosenspotststitle);
			for(int i = 0; i < kenogame.drawings; i++) {
				for(int j = 0; j < 20; j++) {
					Text chosenspots = new Text();
					chosenspots.setText(kenogame.spotschosenarr[i][j] + " ");
					displaychosenspots.getChildren().add(chosenspots);
				}
				// in between each drawing there should be a continue button to show the next drawing
			}
			boardandoutput.getChildren().add(displaychosenspots);

			Text matchesfound = new Text("Matches found: " + earnings.match);
			boardandoutput.getChildren().add(matchesfound);
			
			// display all the matches
			HBox displaymatches = new HBox();
			Text allmatchesfound = new Text("Matches: ");
			displaymatches.getChildren().add(allmatchesfound);
			if(earnings.matches == null) {
				Text matchout = new Text(" ");
				displaymatches.getChildren().add(matchout);
			}
			else {
				for(int i = 0; i < earnings.match; i++) {
					Text matchout = new Text(earnings.matches[i] + " ");
					displaymatches.getChildren().add(matchout);
				}
			}
			boardandoutput.getChildren().add(displaymatches);
			
			Text playerearnings = new Text("Player Earnings: " + earnings.totalEarnings);
			boardandoutput.getChildren().add(playerearnings);
			
			// start over option
			Button startover = new Button("Start Over");
			startover.setOnAction((event) -> {
				primaryStage.setScene(welcomescene);
			});
			// exit option 
			Button exitfinal = new Button("EXIT");
			exitfinal.setOnAction((event) -> {
				primaryStage.setScene(exitscene);
			});
			boardandoutput.getChildren().addAll(startover, exitfinal);
		});
		
		// start button for manual selection- should not be clickable until everything is set up
		start.setStyle("-fx-background-color: #D5F2E3; ");
		start.setOnAction((event) -> {
			// TESTING
//			System.out.print("Contents of the button id array: ");
//			System.out.println(Arrays.toString(btnidarr.toArray()));
			boardandoutput.setDisable(true);
			start.setDisable(true);
			random.setDisable(true);
			
			kenogame.playManual(btnidarr);
			earnings.getmatches();
			earnings.allMatches();
			earnings.getEarnings();
			
			// display for the users chosen spots 
			HBox displayplayerspots = new HBox();
			Text playerspotstitle = new Text("Player's Chosen Spots: ");
			displayplayerspots.getChildren().add(playerspotstitle);
			for(int i = 0; i < kenogame.spots; i++) {
				Text playerspots1 = new Text();
				playerspots1.setText(kenogame.userspotsarr[i] + " ");
				displayplayerspots.getChildren().add(playerspots1);
			}
			boardandoutput.getChildren().add(displayplayerspots);
			
			// display for the spots picked on the board 
			HBox displaychosenspots = new HBox();
			Text chosenspotststitle = new Text("Spots Selected: ");
			displaychosenspots.getChildren().add(chosenspotststitle);
			// show the first drawing by default 
			for(int i = 0; i < kenogame.drawings; i++) {
				for(int j = 0; j < 20; j++) {
					Text chosenspots = new Text();
					chosenspots.setText(kenogame.spotschosenarr[i][j] + " ");
					displaychosenspots.getChildren().add(chosenspots);
				}
			}
			boardandoutput.getChildren().add(displaychosenspots);

			// display the number of matches found
			Text matchesfound = new Text("Matches found: " + earnings.match);
			boardandoutput.getChildren().add(matchesfound);
			
			// display all the matches
			HBox displaymatches = new HBox();
			Text allmatchesfound = new Text("Matches: ");
			displaymatches.getChildren().add(allmatchesfound);
			if(earnings.matches == null) {
				Text matchout = new Text(" ");
				displaymatches.getChildren().add(matchout);
			}
			else {
				for(int i = 0; i < earnings.match; i++) {
					Text matchout = new Text(earnings.matches[i] + " ");
					displaymatches.getChildren().add(matchout);
				}
			}
			boardandoutput.getChildren().add(displaymatches);
			
			// display the earnings 
			Text playerearnings = new Text("Player Earnings: " + earnings.totalEarnings);
			boardandoutput.getChildren().add(playerearnings);
			
			// start over option
			Button startover = new Button("Start Over");
			startover.setOnAction((event1) -> {
				primaryStage.setScene(welcomescene);
			});
			// exit option 
			Button exitfinal = new Button("EXIT");
			exitfinal.setOnAction((event2) -> {
				primaryStage.setScene(exitscene);
			});
			boardandoutput.getChildren().addAll(startover, exitfinal);
		});
		
		
		setup.getChildren().addAll(spotstxt, spotsbtns, drawingstxt, drawbtns, random, start);
		
		
		
		// -------------------------- N E W   L O O K   S C E N E ---------------------------
		// new ui when the user selects new look button from menu 
		Text newLookText = new Text("Keno");
		root6.setStyle("-fx-background-color: #BA2D0B; ");
		root6.setCenter(newLookText);
		// menu bar
		Button menu6 = new Button("Menu");
		menu6.setStyle("-fx-background-color: #D5F2E3; ");
		menu6.setOnAction((openMenuEvent) -> {
			// need to display a drop down menu when menu button is clicked
			System.out.print("OPENING MENU DROP DOWN...");
        	VBox dropdown = new VBox();
        	Button rulesbtn = new Button("Rules");
        	rulesbtn.setStyle("-fx-background-color: #D5F2E3; ");
        	rulesbtn.setOnAction((rulesevent) -> {
        		primaryStage.setScene(rulesscene);
            });
        	Button oddsbtn = new Button("Odds");
        	oddsbtn.setStyle("-fx-background-color: #D5F2E3; ");
        	oddsbtn.setOnAction((oddsevent) -> {
        		primaryStage.setScene(oddsscene);
            });
        	Button exitbtn = new Button("Exit");
        	exitbtn.setStyle("-fx-background-color: #D5F2E3; ");
        	exitbtn.setOnAction((exitevent) -> {
        		primaryStage.setScene(exitscene);
            });
        	dropdown.getChildren().addAll(rulesbtn, oddsbtn, exitbtn);
        	root6.setRight(dropdown);
        });
		root6.setRight(menu6);
		
		// 10x8 blank board 
		VBox nboardandoutput = new VBox();
		GridPane nbetcard = new GridPane();
		int ncounter = 0;
		// make the grid of buttons
		for(int y = 0; y < 8; y++) {
			for(int x = 0; x < 10; x++) {
				ncounter++;
                // create a new button
                Button btn = new Button();
                btn.setStyle("-fx-background-color: #D5F2E3; ");
                btn.setId("btn"+counter);
                btn.setPrefHeight(50);
                btn.setPrefWidth(50);
                btn.setAlignment(Pos.CENTER);
                btn.setText(" " + ncounter + " ");

                // iterate
                nbetcard.setRowIndex(btn,y);
                nbetcard.setColumnIndex(btn,x);    
                nbetcard.getChildren().add(btn);
			}
		}
		nboardandoutput.getChildren().add(nbetcard);
		nboardandoutput.setDisable(true);
		root6.setCenter(nboardandoutput);
		
		// area where we set everything up 
		VBox newsetup = new VBox();
		root6.setBottom(newsetup);
		
		// spots section
		Text nspotstxt = new Text("Spots");
		HBox nspotsbtns = new HBox();
		Button none = new Button("1");
		none.setStyle("-fx-background-color: #D5F2E3; ");
		Button nfour = new Button("4");
		nfour.setStyle("-fx-background-color: #D5F2E3; ");
		Button neight = new Button("8");
		neight.setStyle("-fx-background-color: #D5F2E3; ");
		Button nten = new Button("10");
		nten.setStyle("-fx-background-color: #D5F2E3; ");
		nspotsbtns.getChildren().addAll(none, nfour, neight, nten);
		none.setOnAction((event1) -> {
			none.setId("spot1");
			kenogame.spots(none.getId());
			earnings.getgame(1);
			nspotsbtns.setDisable(true);
		});
		nfour.setOnAction((event4) -> {
			nfour.setId("spot4");
			kenogame.spots(nfour.getId());
			earnings.getgame(4);
			nspotsbtns.setDisable(true);
		});
		neight.setOnAction((event) -> {
			neight.setId("spot8");
			kenogame.spots(neight.getId());
			earnings.getgame(8);
			nspotsbtns.setDisable(true);
		});
		nten.setOnAction((event) -> {
			nten.setId("spot10");
			kenogame.spots(nten.getId());
			earnings.getgame(10);
			nspotsbtns.setDisable(true);
		});
		
		// drawings section
		Text ndrawingstxt = new Text("Drawings");
		HBox ndrawbtns = new HBox();
		Button none1 = new Button("1");
		none1.setStyle("-fx-background-color: #D5F2E3; ");
		Button ntwo2 = new Button("2");
		ntwo2.setStyle("-fx-background-color: #D5F2E3; ");
		Button nthree3 = new Button("3");
		nthree3.setStyle("-fx-background-color: #D5F2E3; ");
		Button nfour4 = new Button("4");
		nfour4.setStyle("-fx-background-color: #D5F2E3; ");
		ndrawbtns.getChildren().addAll(none1, ntwo2, nthree3, nfour4);
		none1.setOnAction((eventone) -> {
			none1.setId("draw1");
			kenogame.drawings(none1.getId());
			ndrawbtns.setDisable(true);
			nboardandoutput.setDisable(false);
		});
		ntwo2.setOnAction((eventtwo) -> {
			ntwo2.setId("draw2");
			kenogame.drawings(ntwo2.getId());
			ndrawbtns.setDisable(true);
			nboardandoutput.setDisable(false);
		});
		nthree3.setOnAction((eventthree) -> {
			nthree3.setId("draw3");
			kenogame.drawings(nthree3.getId());
			ndrawbtns.setDisable(true);
			nboardandoutput.setDisable(false);
		});
		nfour4.setOnAction((eventfour) -> {
			nfour4.setId("draw4");
			kenogame.drawings(nfour4.getId());
			ndrawbtns.setDisable(true);
			nboardandoutput.setDisable(false);
		});
		
		// event if any of the buttons are clicked
		List<String> nbtnidarr = new ArrayList<String>(kenogame.spots);
		nbetcard.getChildren().forEach(button -> {
			button.setOnMouseClicked((event) -> {
				// add the button id to an array
				nbtnidarr.add(button.getId());
			});
		});
		
		// random selection option
		Button nstart = new Button("Start");
		Button nrandom = new Button("Randomly Select");
		nrandom.setStyle("-fx-background-color: #D5F2E3; ");
		nrandom.setOnAction((eventrand) -> {
			nstart.setDisable(true);
			nrandom.setDisable(true);
			nbetcard.getChildren().forEach(button -> {
				button.setDisable(true);
			});
			
			kenogame.play();
			earnings.getmatches();
			earnings.allMatches();
			earnings.getEarnings();
			
			HBox displayplayerspots = new HBox();
			Text playerspotstitle = new Text("Player's Chosen Spots: ");
			displayplayerspots.getChildren().add(playerspotstitle);
			for(int i = 0; i < kenogame.spots; i++) {
				Text playerspots1 = new Text();
				playerspots1.setText(kenogame.userspotsarr[i] + " ");
				displayplayerspots.getChildren().add(playerspots1);
			}
			nboardandoutput.getChildren().add(displayplayerspots);
			
			HBox displaychosenspots = new HBox();
			Text chosenspotststitle = new Text("Spots Selected: ");
			displaychosenspots.getChildren().add(chosenspotststitle);
			for(int i = 0; i < kenogame.drawings; i++) {
				for(int j = 0; j < 20; j++) {
					Text chosenspots = new Text();
					chosenspots.setText(kenogame.spotschosenarr[i][j] + " ");
					displaychosenspots.getChildren().add(chosenspots);
				}
				// in between each drawing there should be a continue button to show the next drawing
			}
			nboardandoutput.getChildren().add(displaychosenspots);

			Text matchesfound = new Text("Matches found: " + earnings.match);
			nboardandoutput.getChildren().add(matchesfound);
			
			// display all the matches
			HBox displaymatches = new HBox();
			Text allmatchesfound = new Text("Matches: ");
			displaymatches.getChildren().add(allmatchesfound);
			if(earnings.matches == null) {
				Text matchout = new Text(" ");
				displaymatches.getChildren().add(matchout);
			}
			else {
				for(int i = 0; i < earnings.match; i++) {
					Text matchout = new Text(earnings.matches[i] + " ");
					displaymatches.getChildren().add(matchout);
				}
			}
			nboardandoutput.getChildren().add(displaymatches);
			
			Text playerearnings = new Text("Player Earnings: " + earnings.totalEarnings);
			nboardandoutput.getChildren().add(playerearnings);
			
			// start over option
			Button startover = new Button("Start Over");
			startover.setOnAction((event) -> {
				primaryStage.setScene(welcomescene);
			});
			// exit option 
			Button exitfinal = new Button("EXIT");
			exitfinal.setOnAction((event) -> {
				primaryStage.setScene(exitscene);
			});
			nboardandoutput.getChildren().addAll(startover, exitfinal);
		});
		
		
		// start button for manual selection- should not be clickable until everything is set up
		nstart.setStyle("-fx-background-color: #D5F2E3; ");
		nstart.setOnAction((event) -> {
			// TESTING
//					System.out.print("Contents of the button id array: ");
//					System.out.println(Arrays.toString(btnidarr.toArray()));
			nboardandoutput.setDisable(true);
			nstart.setDisable(true);
			nrandom.setDisable(true);
			
			kenogame.playManual(nbtnidarr);
			earnings.getmatches();
			earnings.allMatches();
			earnings.getEarnings();
			
			// display for the users chosen spots 
			HBox displayplayerspots = new HBox();
			Text playerspotstitle = new Text("Player's Chosen Spots: ");
			displayplayerspots.getChildren().add(playerspotstitle);
			for(int i = 0; i < kenogame.spots; i++) {
				Text playerspots1 = new Text();
				playerspots1.setText(kenogame.userspotsarr[i] + " ");
				displayplayerspots.getChildren().add(playerspots1);
			}
			nboardandoutput.getChildren().add(displayplayerspots);
			
			// display for the spots picked on the board 
			HBox displaychosenspots = new HBox();
			Text chosenspotststitle = new Text("Spots Selected: ");
			displaychosenspots.getChildren().add(chosenspotststitle);
			// show the first drawing by default 
			for(int i = 0; i < kenogame.drawings; i++) {
				for(int j = 0; j < 20; j++) {
					Text chosenspots = new Text();
					chosenspots.setText(kenogame.spotschosenarr[i][j] + " ");
					displaychosenspots.getChildren().add(chosenspots);
				}
			}
			nboardandoutput.getChildren().add(displaychosenspots);

			// display the number of matches found
			Text matchesfound = new Text("Matches found: " + earnings.match);
			nboardandoutput.getChildren().add(matchesfound);
			
			// display all the matches
			HBox displaymatches = new HBox();
			Text allmatchesfound = new Text("Matches: ");
			displaymatches.getChildren().add(allmatchesfound);
			if(earnings.matches == null) {
				Text matchout = new Text(" ");
				displaymatches.getChildren().add(matchout);
			}
			else {
				for(int i = 0; i < earnings.match; i++) {
					Text matchout = new Text(earnings.matches[i] + " ");
					displaymatches.getChildren().add(matchout);
				}
			}
			nboardandoutput.getChildren().add(displaymatches);
			
			// display the earnings 
			Text playerearnings = new Text("Player Earnings: " + earnings.totalEarnings);
			nboardandoutput.getChildren().add(playerearnings);
			
			// start over option
			Button startover = new Button("Start Over");
			startover.setOnAction((event1) -> {
				primaryStage.setScene(welcomescene);
			});
			// exit option 
			Button exitfinal = new Button("EXIT");
			exitfinal.setOnAction((event2) -> {
				primaryStage.setScene(exitscene);
			});
			nboardandoutput.getChildren().addAll(startover, exitfinal);
		});
		
		
		newsetup.getChildren().addAll(nspotstxt, nspotsbtns, ndrawingstxt, ndrawbtns, nrandom, nstart);
		
		
	}

}
