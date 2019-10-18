public class LineOfWords {
    
    public final WordProperties[] words;
    
    public LineOfWords(String line) {
        String[] wordsAsString = getWords(line);
        words = new WordProperties[wordsAsString.length];
        
        for (int i = 0; i < words.length; i++) {
            words[i] = new WordProperties(wordsAsString[i]);
        }
    }
    
    private String[] getWords(String str) {
        String[] r = new String[howManyWords(str)];
        
        int index = -1;
        for (int i = 0; i < r.length; i++) {
            index++;
            int newIndex = str.indexOf(" ", index);
            if (newIndex == -1) newIndex = str.length();
            String newWord = str.substring(index, newIndex);
            r[i] = newWord;
            index = newIndex;
        }
        
        return r;
    }
    
    private int howManyWords(String line) {
        int count = 0;
        int index = 0;
        
        while (line.indexOf(" ", index) != -1) {
            index = line.indexOf(" ", index) + 1;
            
            count++;
        }
        
        if (line.length() > 0) {
            count++;
        }
        
        return count;
    }
    
    @Override
    public String toString() {
        String str = "";
        for (WordProperties word: words) {
            str = str + word + "\n";
        }
        
        return str;
    }
}
