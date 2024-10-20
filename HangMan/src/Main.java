import java.util.*;
import java.io.*;

public class Main {
    public static void populate(ArrayList<String> words){
        try {
            Scanner infile = new Scanner(new File("data.txt"));
            String word;
            while (infile.hasNext()) {
                word = infile.next();
                words.add(word);

            }
            infile.close();
        }
        catch(Exception e){
            System.out.println("Problem reading in file");
            System.exit(-1);
        }

    }

    public static void playGame(String puzzleWord, String puzzleGuess){
        Scanner scan = new Scanner(System.in);
        boolean guessed = false;
        int ctr = 0;
        String guess;
        while(!guessed && ctr < 10){
            for(int i = 0; i < puzzleGuess.length(); i++)
                System.out.print(puzzleGuess.charAt(i) + " ");
            System.out.println();
            System.out.println("Enter a letter or guess the word: ");
            guess = scan.next();
            if(guess.length() == 1){
                puzzleGuess = checkLetter(guess.charAt(0), puzzleWord, puzzleGuess);
                if(puzzleGuess.equals(puzzleWord))
                    guessed = true;
            }
            else{
                if(guess.equals(puzzleWord))
                    guessed = true;
            }
            ctr++;
        }

        if(guessed)
            System.out.println("Congratulations! You win!");
        else
            System.out.println("You lose, better luck next time... \nThe word was " + puzzleWord );

    }

    public static String checkLetter(char guess, String puzzleWord, String puzzleGuess){
        String temp = "";
        for(int i = 0; i < puzzleWord.length(); i++){
            if(puzzleWord.charAt(i) == guess){
                temp += guess;
            }
            else{
                temp += puzzleGuess.charAt(i);
            }
        }
        return temp;
    }

    public static void main(String[] args){
        ArrayList<String> words = new ArrayList<>();
        populate(words);
        Random rand = new Random();
        int index = rand.nextInt(0, words.size() - 1);
        String puzzleWord = words.get(index);
        String puzzleGuess = "";
        for(int i = 0; i < puzzleWord.length(); i++)
            puzzleGuess += "_";
        playGame(puzzleWord, puzzleGuess);

    }
}