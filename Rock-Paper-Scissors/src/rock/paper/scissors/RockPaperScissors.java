package rock.paper.scissors;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    // Random object for computer moves
    static Random random = new Random();

    // Scanner object for user input
    static Scanner scanner = new Scanner(System.in);

    // Available game choices
    static String[] options = {"rock", "paper", "scissors"};

    // Score variables
    static int playerScore = 0;
    static int computerScore = 0;

    // Method to start the game
    static void playGame() {

        String continueGame = "yes";

        // Welcome message
        System.out.println("======================================");
        System.out.println("ROCK ======== PAPER ======== SCISSORS");
        System.out.println("======================================");

        // Main game loop
        do {

            System.out.println();

            // Get player choice
            System.out.print("Player Choose Your Weapon (Rock/Paper/Scissors): ");
            String playerChoice = scanner.nextLine().toLowerCase();

            // Validate input
            if (!playerChoice.equals("rock")
                    && !playerChoice.equals("paper")
                    && !playerChoice.equals("scissors")) {

                System.out.println("==========================");
                System.out.println("Invalid Option!! Try Again");
                System.out.println("==========================");

                continue;
            }

            // Generate random computer choice
            String computerChoice = options[random.nextInt(options.length)];

            // Display computer choice
            System.out.println("Computer Weapon: " + computerChoice);

            System.out.println();

            // Tie condition
            if (playerChoice.equals(computerChoice)) {

                System.out.println("====================");
                System.out.println("It's A TIE!");
                System.out.println("No Points Rewarded");
                System.out.println("====================");
            }

            // Player wins
            else if (
                    (playerChoice.equals("rock") && computerChoice.equals("scissors"))
                    || (playerChoice.equals("paper") && computerChoice.equals("rock"))
                    || (playerChoice.equals("scissors") && computerChoice.equals("paper"))
            ) {

                System.out.println("=========");
                System.out.println(" You WIN!");
                System.out.println("=========");

                playerScore++;
            }

            // Computer wins
            else {

                System.out.println("===========");
                System.out.println(" You LOSE!");
                System.out.println("===========");

                computerScore++;
            }

            // Display scoreboard
            System.out.println();
            System.out.println("=============== SCORE BOARD ===============");
            System.out.println("Player Score   : " + playerScore);
            System.out.println("Computer Score : " + computerScore);
            System.out.println("===========================================");

            System.out.println();

            // Ask player to continue
            System.out.print("Do You Wish To Continue? (YES/NO): ");
            continueGame = scanner.nextLine();

        } while (continueGame.equalsIgnoreCase("yes"));

        // Final results
        System.out.println();
        System.out.println("=============== FINAL RESULTS ===============");

        if (playerScore > computerScore) {

            System.out.println("Overall Winner : PLAYER");

        } else if (computerScore > playerScore) {

            System.out.println("Overall Winner : COMPUTER");

        } else {

            System.out.println("The Game Ended In A DRAW!");
        }

        System.out.println("Player Score   : " + playerScore);
        System.out.println("Computer Score : " + computerScore);

        System.out.println("=============================================");

        // Goodbye message
        System.out.println();
        System.out.println("======================================");
        System.out.println("Thanks For Playing! See You Next Time");
        System.out.println("======================================");

        // Close scanner
        scanner.close();
    }

    
    public static void main(String[] args) {

        playGame();
    }
}