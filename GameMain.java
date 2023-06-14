import java.util.Scanner;

public class GameMain
{
	public static void main(String[] args) 
   {
		String name1;  // player 1 name
		String name2;  // player 2 name
		String input;  // user input for yes/no

		Scanner scan = new Scanner(System.in);
   
      //prompt user to enter their name
		do 
      {
			System.out.println("Welcome to the Dandy Die Game!\n" + 
                              "This game requires 2 players.\n");

			System.out.print("Enter the name of player 1: ");
			name1 = scan.nextLine();

			System.out.print("Enter the name of player 2: ");
			name2 = scan.nextLine();
			System.out.println();
         
         //create game object
			Game game = new Game(name1, name2);
      			
			game.playGame();

         //ask user if they want to play again
			System.out.println("Would you like to play again?: yes/no");
			input = scan.nextLine();
         
         //input validation for yes/no
			while (!input.equals("no") && !input.equals("yes"))
         {
				System.out.print("Invalid input, enter yes/no: ");
				input = scan.nextLine();
			}

		} while (input.equals("yes"));

		System.out.println("Thanks for playing. ^-^");
	}
}

