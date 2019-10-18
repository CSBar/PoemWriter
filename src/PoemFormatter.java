public class PoemFormatter {
    
    public LineOfWords[] lines;
    
    public PoemFormatter(String[] poem) {
        lines = new LineOfWords[poem.length];
        
        for (int i = 0; i < poem.length; i++) {
            LineOfWords newLine = new LineOfWords(poem[i]);
            lines[i] = newLine;
        }
    }
    
    @Override
    public String toString() {
        String str = "";
        for (LineOfWords line: lines) {
            str = str + line + "\n";
        }
        
        return str;
    }

}
