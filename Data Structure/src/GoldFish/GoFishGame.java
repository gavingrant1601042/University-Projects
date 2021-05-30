package GoldFish;

import java.util.Random;
import java.util.Scanner;

public class GoFishGame {

	public static Scanner input = new Scanner(System.in);
	private Deck stock, pack;
	private Deck userHand;
	private Deck computerHand;;
	private boolean win, turn;
	private int userTrophy, computerTrophy;

	public GoFishGame() {
		stock = new Deck();
		pack = new Deck();

		pack.fillDeck();

		for (int i = 0; i < pack.getSize(); i++) {
			stock.push(pack.deleteAnyCard());
		}

		userHand = new Deck();
		computerHand = new Deck();
		win = false;
		turn = false;
		userTrophy = computerTrophy = 0;
	}

	public void lobby() {
		boolean repProgram = true;
		System.out.println("LETS PLAY GOLDFISH GOOOO!");
		System.out.println("\n'1' Play Go Fish\n '2' Rules of Go Fish\n '3' Exit");
		int lobby = input.nextInt();

		do {
			while (lobby > 3 || lobby < 1) {
				System.out.println("Invalid input, 1, 2 or 3 Only!\nTry Again.");
				lobby = input.nextInt();
			}

			switch (lobby) {
			case 1:
				playGoFish();
				break;

			case 2:
				System.out.println("\n\nRULES:\n" + "The User and the Computer both start with"
						+ " 4 cards the max, the can start with more depending on the amount of players"
						+ ". The user will request for a Card by entering the amount the want"
						+ " Ace is 1 and Jack,\nQueen,King are 11,12,13." + "If the card requested is within th deck "
						+ " the opponent will give it to you however if there is no card with the players.\n"
						+ "they will have to draw it from the deck, and the player drawing from the deck will play again."
						+ "The game ends\nif either the Table Deck, User Hand, or Computer"
						+ " Hand are empty. The \nplayer with the most Trophy, which are 2 cards"
						+ " of the same value, wins \nthe game.\n\t\tPress Enter to start the Game");

				input.nextLine();
				playGoFish();
				break;

			case 3:
				repProgram = false;
				break;
			}

		} while (repProgram);
		System.out.println("Goodbye!");
	}

	public void playGoFish() {
		// Random coinToss = new Random();

		System.out.println("Enter 0 for Heads or 1 for Tails.");
		int choice = input.nextInt();
		int ran = (int) (Math.random() * 2);
		System.out.println(ran);

		if (choice == ran) {
			System.out.println("You won the toss");
			System.out.println("Enter 1 if you would like to go first");
			System.out.println("Enter 2 if you would like the computer to go first");
			choice = input.nextInt();

			if (choice == 1)
				turn = true;
			else {

				System.out.println("Computer goes first");
				turn = false;
			}
		}

		initializeHands();
		checking();

		do {
			if (turn) {
				userPlay();
				turn = false;
				checkForGameOver();
			} else {
				computerMove();
				turn = true;
				checkForGameOver();
			}

		} while (!win);

		System.out.println("-Game Over :(-");
		displayWinner();
	}

	public void initializeHands() {
		for (int i = 0; i < 4; i++) {

			userHand.push(stock.pop());
			computerHand.push(stock.pop());
		}
	}

	public void checking() {
		int userBegDeal = userHand.checkstock();
		if (userBegDeal != 0) {
			System.out.println("Wow! You got extremely lucky and got a pair " + "on the deal of the value "
					+ userBegDeal + "\nThat puts you at 1 Pair already!");
			pause();
			userTrophy++;
		}

		int cpBegDeal = computerHand.checkstock();
		if (cpBegDeal != 0) {
			System.out.println("Wow! The computer got extremely lucky and got a " + "pair on the deal of the value "
					+ cpBegDeal + "\nThat puts the computer at 1 Pair already!");
			pause();
			computerTrophy++;
		}
	}

	public void userPlay() {
		boolean retryUser = false;
		do {
			retryUser = false;
			if (!win) {
				Card drawnCard = null;
				System.out.println(userHand);
				System.out.println("Which value would you like to ask for?");

				int value = input.nextInt();
				while (userHand.getCount(value) == 0) {
					System.out
							.println("That Value isnt already contained in your deck, " + "Please enter another value");
					value = input.nextInt();
				}

				int hits = computerHand.getCount(value);
				if (hits == 0) {
					System.out.println("Go Fish!");
					drawnCard = stock.pop();
					if (drawnCard.getValue() == value) {
						userHand.push(drawnCard);
						retryUser = true;
						System.out.println("Drawn Card: " + drawnCard);
						System.out.println("Lucky Draw! Go again.");
						pause();
					} else {
						System.out.println("Drawn Card: " + drawnCard);
						userHand.push(drawnCard);
						pause();
					}

					int countAfterGoFish = userHand.getCount(drawnCard.getValue());
					if (countAfterGoFish == 2) {
						userTrophy++;
						System.out.println("With that Go Fish draw you've just completed a Trophy" + " with the value "
								+ drawnCard.getValue() + "\n" + "You now have : " + userTrophy + " Trophy\n"
								+ "And the computer has : " + computerTrophy + " Trophy");
						pause();
						for (int i = 0; i < 2; i++) {
							userHand.removecard(drawnCard.getValue());
						}
					}

					if (retryUser) {
						checkForGameOver();
					}

				} else if (!retryUser && hits >= 1) {
					for (int i = 0; i < hits; i++) {
						userHand.push(computerHand.removecard(value));
					}

					System.out.println("The Computer had " + hits + " of those cards");
					retryUser = false;
					pause();

					int countAfterSteal = userHand.getCount(value);
					if (countAfterSteal == 2) {
						userTrophy++;
						System.out.println("You just got a trophy from stealing the computer's card(s)" + " Value= "
								+ value + "\n" + "You now have : " + userTrophy + " Trophy\n"
								+ "The computer currently has : " + computerTrophy + " Trophy");
						pause();

						for (int i = 0; i < 2; i++) {
							userHand.removecard(value);
						}
					}
				}
			}

		} while (retryUser);
	}

	public void computerMove() {
		boolean retryComp = false;
		do {
			retryComp = false;

			if (!win) {
				Card drawnCardCp = null;
				Card random = computerHand.deleteAnyCard();
				computerHand.push(random);
				int Value = random.getValue();
				int cpHits = userHand.getCount(Value);

				if (cpHits == 0) {
					drawnCardCp = stock.pop();
					if (drawnCardCp.getValue() == Value) {
						computerHand.push(drawnCardCp);
						retryComp = true;
						System.out.println("Lucky draw for the computer!\n" + "They go again.");
						pause();
					} else {
						System.out.println("The computer guessed Wrong..\n" + "Your turn.");
						computerHand.push(drawnCardCp);
						pause();
					}

					int cpCountAfterGoFish = computerHand.getCount(drawnCardCp.getValue());
					if (cpCountAfterGoFish == 2) {
						computerTrophy++;
						System.out.println("The computer just got a Trophy off a Go Fish draw" + " with the value "
								+ drawnCardCp.getValue() + "\n" + "The computer now has : " + computerTrophy
								+ " Trophy\n" + "You currently have : " + userTrophy + " Trophy");
						pause();
						for (int i = 0; i < 2; i++) {
							computerHand.removecard(drawnCardCp.getValue());
						}
					}

					if (retryComp) {
						checkForGameOver();
					}
				} else if (!retryComp && cpHits >= 1) {
					for (int i = 0; i < cpHits; i++) {
						computerHand.push(userHand.removecard(Value));
					}

					System.out.println("The computer took " + cpHits + " of your cards!");
					retryComp = false;
					pause();

					int cpCountAfterSteal = computerHand.getCount(Value);
					if (cpCountAfterSteal == 2) {
						computerTrophy++;
						System.out.println("The computer just got a Trophy from stealing your card(s)"
								+ " with the value " + Value + "\n" + "The computer now has : " + computerTrophy
								+ " Trophy\n" + "You currently have : " + userTrophy + " Trophy");
						pause();
						for (int i = 0; i < 2; i++) {
							computerHand.removecard(Value);
						}
					}
				}
			}

		} while (retryComp);
	}

	public void checkForGameOver() {
		win = (stock.getSize() == 0 || userHand.getSize() == 0 || computerHand.getSize() == 0);
	}

	public void displayWinner() {
		if (computerTrophy > userTrophy) {
			System.out.println(
					"The computer Won!\n" + "Computer Trophy : " + computerTrophy + "\nUser Trophy : " + userTrophy);
		} else if (userTrophy > computerTrophy) {
			System.out.println(
					"Congrats YOU Won!\n" + "User Trophy : " + userTrophy + "\nComputer Trophy : " + computerTrophy);
		} else if (userTrophy == computerTrophy) {
			System.out.println("The game was a tie!\n" + "You both had " + userTrophy + " Trophy.");
		}
	}

	public static Scanner pauseSystem = new Scanner(System.in);

	public void pause() {
		System.out.println("Press Enter to continue..");
		pauseSystem.nextLine();
	}

}