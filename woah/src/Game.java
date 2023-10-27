import java.util.ArrayList;
import java.util.Scanner;
public class Game {
    Scanner scanner = new Scanner(System.in);
    String word;
    String guess = "";
    boolean playing = true;
    int fails = 0;
    ArrayList<String> guessed = new ArrayList<String>();
    public void start_game(){
        System.out.println("Player 1 enter a word: ");
        word = scanner.next();
        for(int i =0;i<word.length();i++){
            guess += "_";
        }
    }
    public void guess_letter(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Player 2 guess a letter: ");
        System.out.println("Incorrect guesses left: " + (10-fails));
        System.out.println("Letters guessed: " + guessed);
        System.out.println(guess);
        String letter = scanner.next();
        if(!guessed.contains(letter)) guessed.add(letter);
        String updated_guess = "";
        for(int i =0;i<word.length();i++){
            if(word.charAt(i) == letter.charAt(0)){
                updated_guess += letter;
            }
            else {
                updated_guess += guess.charAt(i);
            }
        }
        guess = updated_guess;
        if (!word.contains(letter))fails++;
        if(fails >= 10){
            guesser_loses();
        }
        else if(word.equals(guess)){
            guesser_wins();
        }
    }
    private void guesser_wins(){
        playing = false;
        System.out.println(guess);
        System.out.println("Player 1 wins!");
    }
    private void guesser_loses(){
        playing = false;
        System.out.println("Player 2 wins!");
        System.out.println("The word was: " + word);
    }
}
