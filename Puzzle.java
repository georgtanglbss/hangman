import java.util.ArrayList;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Puzzle{
    private String word;
    private String guess;
    private String guesses;
    private ArrayList<String> words;
    private boolean isUnsolved;

    public Puzzle() {
        words = new ArrayList<String>();
        guesses = "";
        isUnsolved = true;

        try {
            File file = new File("words.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String tempWord = scanner.next().toUpperCase();
                words.add(tempWord);
            }
            scanner.close();
            int pos = (int)(Math.random()*(words.size()-1));
            word = words.get(pos).toUpperCase();

            //ONCE THIS LINE OF CODE IS REACHED, YOUR words ArrayList
            //CONTAINS ALL THE WORDS IN words.txt
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean makeGuess(String guess) {
        guess = guess.toUpperCase();
        guesses += guess;
        isUnsolved = false;
        for(int i = 0;i < word.length();i++){
            String str = word.substring(i,i+1);
            if(guesses.indexOf(str) < 0){
                isUnsolved = true;
                break;
            }
        }
        if(word.indexOf(guess) >= 0){
            return true;
        }
        else{
            return false;
        }
    }  

    public void show(){
        System.out.print("Puzzle: ");
        for(int i = 0;i < word.length();i++){
            String str = word.substring(i,i+1);
            if(guesses.contains(str)){
                System.out.print(str+" ");
            }else{
                System.out.print("_ ");
            }
        }
        System.out.print("\n\nGuesses: ");
        String statement ="";
        for(int i = 0;i < guesses.length();i++){            
            String str = guesses.substring(i,i+1);
            if(statement == ""||statement.indexOf(str) < 0){
                statement += str;
                System.out.print(guesses.substring(i,i+1));
                if(i < guesses.length()-1){
                    System.out.print(", ");
                }
            }
        }
    }

    public boolean isUnsolved(){
        return isUnsolved;
    }

    public String getWord(){
        return word;
    }
}

