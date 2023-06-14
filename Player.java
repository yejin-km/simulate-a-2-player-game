public class Player 
{
   private String name;
   private int score;

	/**
       constructor
   	 @param name - the name of player
   */
   public Player(String name) 
   {
      this.name = name;
      this.score = 0;
   }

	/**
	   copy constructor
	   @param player, copy of player object
	*/
   public Player(Player player) 
   {
      this.name = player.name;
      this.score = 0;
   }

	/**
      getScore method
	   @return, returns players score
	*/
   public int getScore() 
   {
      return score;
   }

	/**
      updateScore method
	   @param score, increases score by argument value
	*/
   public void updateScore(int score)
   {
      // increase score by argument value
      this.score += score;
   }

	/**
      toString method
	   @retrun name, returns players name
	*/
   public String toString() 
   {
      return name;
   }
}