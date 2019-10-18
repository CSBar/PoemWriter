import java.util.*; // needed for ArrayList
public class PoemCreater {
    
    // the first String in the array is for the previous word
    // the second is for the new word
    public ArrayList<String[]> changingWords = new ArrayList<String[]>();
    
    private PoemFormatter formatter;
    
    public PoemCreater(PoemFormatter formatter) {
        this.formatter = formatter;
    }
    
    public String[] createPoem(WordProperties[] wordSet) {
        
        String[] foo = {" ", " "};
        return foo;
    }
    
    public String[] createPoem() {
        String [] poem = new String[formatter.lines.length];
        
        for (int i = 0; i < formatter.lines.length; i++) {
            LineOfWords line = formatter.lines[i];
            
            String newLine = "";
            for (int j = 0; j < line.words.length; j++) {
                newLine = newLine + getNewWord(line.words[j]) + " ";
            }
            
            poem[i] = newLine;
        }
        
        return poem;
    }
    
    /**
     * Gets the word best suited for this poem
     * 
     * @param WordProperties the word to be changed
     * 
     * @return String newWord
     */
    private String getNewWord(WordProperties newWordProperties) {
        String newWord = newWordProperties.word;
        
        if (getChangingWords(newWord) != null) {
            return getChangingWords(newWord);
        }        
        
        // checks to see if newWord is lowercased
        if (newWord.length() > 0)
        if (newWord.substring(0,1).equals(newWord.substring(0,1).toLowerCase())) {
            //if (newWordProperties.type != 't') {
                newWordProperties = SearchForWord.getBestWordPropertiesGivenWordProperties(newWordProperties);
                String[] newChangingWords = {newWord, newWordProperties.word};
                newWord = newWordProperties.word;
            //}
        }
                
        return newWord;
    }
    
    /**
     * You give the word from the poem in here and the output
     *      is the new changed word
     * 
     * @param String word form old poem
     * 
     * @return String newChangedWord
     * @return null
     */
    private String getChangingWords(String str) {
        for (String[] set: changingWords) {
            if (str.equals(set[0])) {
                return set[1];
            }
        }
        
        return null;
    }
}
