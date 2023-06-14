import java.util.Scanner;

public class Game 
{
   private Player player1;
   private Player player2;

	/**
	   constructor with 2 string arguments
	*/
   public Game(String name1, String name2)
   {
      player1 = new Player(name1);
      player2 = new Player(name2);
   }

	/**
	   deep copy constructor 
	   @param game, copy game object
	*/
   public Game(Game game) 
   {
      player1 = new Player(game.player1);
      player2 = new Player(game.player2);
   }
   
   /**
      playGame method to control rounds of game
   */
   public void playGame()
   {
   	// controls the rounds of the game.
   	// calls gameWon() to determine when game is over
   	// calls determineWinner() to display info about winner when game over.     
      // repeat until player gets score >= 50
      
      do 
      {
         playerTurn(player1);
         playerTurn(player2);
         System.out.println(toString());
         System.out.println();
      
      }while (gameWon() == false);
   
      determineWinner();
   }
   
   /**
      toString method
      @return - return both player names and scores
   */
   public String toString() 
   {
      return player1 + ": " + player1.getScore() +  "  " +
             player2 + ": " + player2.getScore();
   }
   
   /**
      playerTurn method
      @param player
      passing in player as argument
   */
   private void playerTurn(Player player) 
   {
      String predictions;              //players predictions
      int value;                       //value of dice
   
      Scanner scan = new Scanner(System.in);
   
   	// ask user to input their prediction
      System.out.print(player + ", Enter your prediction (even/odd): ");
      predictions = scan.nextLine();
   
   	// Validate the input
      while (!predictions.equals("even") && !predictions.equals("odd"))
      {
         System.out.print("Invalid input. Enter even or odd: ");
         predictions = scan.nextLine();
      }
   
   	// pass in how many dices you are rolling
      value = Dice.rollDice(1);
   
   	// display rolled die
      System.out.println("A " + value + " was rolled");
     
      //check if rolled die is even 
      if (predictions.equals("even")) 
      {
         if (value % 2 == 0) 
         {
            System.out.println("Adding " + value + " to your score!");
            player.updateScore(value);
         }
         else
            System.out.println("Better luck next time!");
      }
      
      //check if rolled die is odd
      else if (predictions.equals("odd"))
      {
         if (value % 2 != 0) 
         {
            System.out.println("Adding " + value + " to your score!");
            player.updateScore(value);
         } 
         else
            System.out.println("Better luck next time!");
      }
   }

   /**
      gameWon method
      @return - true or false
      if player score is >= 50
   */
   private boolean gameWon() 
   {
   	// to determine when game is over
   	// determines when there is a winner
   	// checks if one of the player's score is 50 or greater
   
      if (player1.getScore() >= 10 || player2.getScore() >= 10) 
         return true;
      else 
         return false;
   }

   /**
      determineWinner method displays the winner name
   */
   private void determineWinner() 
   {
   	// determines who the winner is and displays the name.
   	// and tie if there's a tie.
   	// if score 10 or greater, wins
   
      if (player1.getScore() > player2.getScore())
         System.out.println("****************************\n" +
                            "   The Winner Is " + player1 + "!\n" +
                            "****************************");
      
      else if (player2.getScore() > player1.getScore())
         System.out.println("****************************\n" +
                            "   The Winner Is " + player2 + "!\n" +
                            "****************************");
      
      else if (player1.getScore() == player2.getScore())
         System.out.println("It's a tie");
   }
}
