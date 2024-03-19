  //Programmer: Ryan Seefeldt 
  //Class: CS& 141
  //Date:7/6/2023
  //Purpose: This is a guessing game to guess a number from 1 to x 
  //    where x is a class constant. This will allow you to enter 
  //    as many guess as you like up to 9999. After each guess 
  //    you will be told if the number is higher or lower than 
  //    your guess. Once the number is guessed correctly the 
  //    program will print the number of guess and you will be 
  //    asked if you would like to play another game. you can enter 
  //    any string beginning in Y,y,N,n and only the first 
  //    character will be used to determine if you will play on. 
  //    After you enter n or N as the first character the game 
  //    will end and print out statustics for the game. 
  //    Statistics printed: Total games played, total number 
  //    of guesses, average number of guess for the games played, 
  //    and lowest number of guesses used in all games played 
  //    that session.
  
  //Extra Credit: none
  
  //Issues in the code:


  import java.util.*;


public class RSGuessGame {
    static final int MAX=100;  //declaring constant 

     public static void main(String[] args) {

     Random rand = new Random();  //declaring random object 
     boolean guessOn = true; 
     boolean gameOn = true;
     int UserGuess = 0;
     Scanner in = new Scanner(System.in); 
     Scanner intext = new Scanner(System.in); 
     int guessCount = 0;
     int bestnumguess = 9999;
     int totalguesscount = 0;
     int totalnumgames = 0;

     InstructionToUser();
      
     while(gameOn) {
     
         System.out.println("I'm thinking of a number...");
         
         int number = rand.nextInt(MAX)+1;  //generating random number
 
//         System.out.println(number);
     
         guessCount = 0;
         totalnumgames = totalnumgames + 1;
         while(guessOn) {
              System.out.print("Your guess? "); //taking user number 
              UserGuess = in.nextInt();
              guessCount = guessCount + 1;
              if(UserGuess>number){ //if user enteres greater ,than show 
                                    //user to enter lower number
                   System.out.println("It's lower");
                   }
                  else {
                      if(UserGuess < number){  //if user enteres lesser ,than show 
                                               //user to enter greater number
                           System.out.println("It's higher");
                      }
                      else { //when user enter correct number
                           System.out.println("You got it right in "+guessCount+" guesses\n");
                           guessOn = false;
                           if (guessCount < bestnumguess) {
                                bestnumguess = guessCount;
                           }
                           totalguesscount = totalguesscount + guessCount;     
                      }
                  }     

                  gameOn = false;
                  if (guessCount >= 9999) {
                      System.out.println("Guess Count Exceeded");  
                      guessOn = false;
                  }    
 
        }
        
        boolean entryerror = true;
        // This loop makes sure that if the user wants to play the next 
        // game the answer starts with Y,y,N,n
        while(entryerror) {
             
            System.out.print("Do you want to play again? ");
      
            String play = intext.nextLine(); //input string for playing another game
            
            System.out.println();
      
            // if the first character of the string is Y or y set up to play another game.      
            if ((play.charAt(0)=='Y') || (play.charAt(0)=='y')) {
      
                gameOn = true; 
                guessOn = true;
                entryerror = false; //entry was valid
          
         
          }
            // if the first character of the string is n or N exit that 
            // game session and print statistics   
            else {
                if ((play.charAt(0)=='N') || (play.charAt(0)=='n')) {
      
                    gameOn=false;
                    entryerror=false; // entry was valid
                  
                }
                else {
                  entryerror=true;
                  System.out.println("Invalid Answer"); // entry was invalid reenter data
                }       
      
            }
        }        

        
     }

     OverAllResults (totalnumgames,totalguesscount,bestnumguess);

     }
     
//methods   

  //method for instructions
   public static void InstructionToUser(){
       System.out.println("    Instructions to User   ");
       System.out.println("You are given a random number, You need to guess that number ");
       System.out.print("If you enter number greater than random number you will see");
       System.out.println(" 'Lower' message");
       System.out.print("If you enter number Less than random number you will see");
       System.out.println(" 'Greater' message");
   }   
  
     //method for OverAllResults
   public static void OverAllResults(int UserPlayeGame,int  TotalUserGuess,int best){
      System.out.println("Overall results:");
      System.out.printf("total games = %d%n", UserPlayeGame);
      System.out.printf("total guesses = %d%n", TotalUserGuess);
      System.out.printf("guesses/game = %.1f %n", (double)TotalUserGuess/ UserPlayeGame);
      System.out.printf("best number of guesses = %d%n", best);
   }

  
}     