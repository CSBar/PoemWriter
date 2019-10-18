public class SearchForWordTester {
    
    public static void main(String[] args) {
        
        String foo = "Baconian adj. Of or pertaining to Lord Bacon or his system of philosophy.";
        WordProperties w = new WordProperties(foo);
        
        System.out.println(w);
        
        WordProperties word = SearchForWord.getWordPropertiesGivenWord("accouter");
        
        System.out.println(word);
        
    }
    
}
