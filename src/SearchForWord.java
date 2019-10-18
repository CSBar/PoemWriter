/**
 * Searches for word in dictionary
 */
import java.io.*;
public class SearchForWord {
    
    private static char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    
    public SearchForWord () {
    
    }
    
    public static WordProperties getWordPropertiesGivenWord(String word) {
        word = word + " ";
        String line = getDictionaryLineFromWord(word);
        if (line.equals(word)) {
            return null;
        }
        WordProperties wordProperty = new WordProperties(line);
        return wordProperty;
    }
    
    public static WordProperties[] getWordPropertiesGivenSetOfWordsInDefinition(String[] words) {
        String[] lines = getDictionaryLinesFromWordsInDefinition(words);
        WordProperties[] wordProperties = new WordProperties[lines.length];
        
        for (int i = 0; i < wordProperties.length; i++) {
            wordProperties[i] = new WordProperties(lines[i]);   
        }
        
        return wordProperties;
    }
    
    public static WordProperties getBestWordPropertiesGivenWordProperties(WordProperties word) {
        WordProperties[] wordProperties = getWordPropertiesGivenType(word.type);
        
        if (wordProperties == null) {
            return word;   
        }
        
        // returns word if they is nothing inside of wordProperties
        if (wordProperties.length == 0) {
            return word;
        }
        
        WordProperties bestWord = wordProperties[0];
        int closeNess = 0;
        
        for (int i = 0; i < wordProperties.length; i++) {
            int newCloseness = 0;
            
            // checks to see if they start with same letter
            if (wordProperties[i].word.substring(0,1).equalsIgnoreCase(word.word.substring(0,1))) {
                newCloseness = 4;
            }
            
            for (int j = 0; j < word.word.length() && j < wordProperties[i].word.length(); j++) {
                if (word.word.substring(word.word.length() - j - 1, word.word.length() - j).equals(wordProperties[i].word.substring(wordProperties[i].word.length() - j - 1, wordProperties[i].word.length() - j))) {
                    newCloseness++;
                }
                else {
                    break;
                }
            }
            
            if (newCloseness > closeNess) {
                if (!wordProperties[i].word.equals(word.word)) {
                    closeNess = newCloseness;
                    bestWord = wordProperties[i];
                }
            }
        }
        
        return bestWord;
    }
    
    public static WordProperties[] getWordPropertiesGivenType(char type) {
        int amountOfType = 0;
        
        for (char letter: alphabet) {
            String fileName = "ListOf" + letter + "Words.txt";
            
            try{

                //Create object of FileReader
                FileReader inputFile = new FileReader(fileName);

                //Instantiate the BufferedReader Class
                BufferedReader bufferReader = new BufferedReader(inputFile);

                //Variable to hold the one line data
                String line;

                // Read file line by line and print on the console
                while ((line = bufferReader.readLine()) != null)   {
                    int index = line.indexOf(" ") + 1;
                    if (index > 0) {
                        if (line.substring(index).charAt(0) == type) {
                            amountOfType++;
                        }
                    }
                }
            
                //Close the buffer reader
                bufferReader.close();
            }catch(Exception e){
                System.out.println("Error while reading file line by line:" + e.getMessage());                      
            }
        } 
        
        int count = 0;
        WordProperties[] words = new WordProperties[amountOfType];
        
        for (char letter: alphabet) {
            String fileName = "ListOf" + letter + "Words.txt";
            
            try{

                //Create object of FileReader
                FileReader inputFile = new FileReader(fileName);

                //Instantiate the BufferedReader Class
                BufferedReader bufferReader = new BufferedReader(inputFile);

                //Variable to hold the one line data
                String line;

                // Read file line by line and print on the console
                while ((line = bufferReader.readLine()) != null)   {
                    int index = line.indexOf(" ") + 1;
                    if (index > 0) {
                        if (line.substring(index).charAt(0) == type) {
                            words[count++] = new WordProperties(line);
                        }
                    }
                }
            
                //Close the buffer reader
                bufferReader.close();
            }catch(Exception e){
                System.out.println("Error while reading file line by line:" + e.getMessage());                      
            }
        } 
        
        return words;
    }
    
    private static String getDictionaryLineFromWord(String word) {
        String fileName = "ListOf" + word.toUpperCase().charAt(0) + "Words.txt";
    
        int length = word.length();
    
        try{

            //Create object of FileReader
            FileReader inputFile = new FileReader(fileName);

            //Instantiate the BufferedReader Class
            BufferedReader bufferReader = new BufferedReader(inputFile);

            //Variable to hold the one line data
            String line;

            // Read file line by line and print on the console
            while ((line = bufferReader.readLine()) != null)   {
                if (line.length() > length) {
                    if (line.substring(0, length).equalsIgnoreCase(word)) {
                        return line;
                    }
                }
            }
            
            //Close the buffer reader
            bufferReader.close();
        }catch(Exception e){
            System.out.println("Error while reading file line by line:" + e.getMessage());                      
        }

        return word;
    }
    
    private static String[] getDictionaryLinesFromWordsInDefinition(String[] words) {
        
        for (char letter: alphabet) {
            String fileName = "../Dictionary/ListOf" + letter + "Words.txt";
            
        }        
        
        return words;
    }
    
    private static boolean isEachWordInString(String[] words, String str) {
        for (String w: words) {
            if (str.indexOf(w) == -1) { // might have to change it to str.indexOf(" " + w + " ")
                return false;
            }
        }
        
        return true;
    }
}
