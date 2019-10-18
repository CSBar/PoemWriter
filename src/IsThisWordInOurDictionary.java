import java.util.*;
public class IsThisWordInOurDictionary {
    
    public static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        askForAnotherWord();
    }
    
    public static void askForAnotherWord() {
        System.out.print("Type a word (leave blank to exit): ");
        String response = scanner.nextLine();
        
        if (!response.equals(" ")) {
            searchWord(response);
            
            askForAnotherWord();
        }
    }
    
    public static void searchWord(String word) {
        WordProperties wordProp = SearchForWord.getWordPropertiesGivenWord(word);
        
        System.out.println(wordProp);
    }
    
}
