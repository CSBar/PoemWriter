import java.io.*;
public class MainOfPoemWriter {
    
    public static void main(String[] args) {
        
        String [] poem = getTextFile("Poem.txt"); /*{
            "Once upon a midnight dreary, while I pondered, weak and weary,",
            "Over many a quaint and curious volume of forgotten lore—", 
            "While I nodded, nearly napping, suddenly there came a tapping",
            "As of some one gently rapping, rapping at my chamber door.",
            "“’Tis some visitor,” I muttered, “tapping at my chamber door—",
            "Only this and nothing more.”"
        };
        */
        PoemFormatter formatter = new PoemFormatter(poem);
        
        //System.out.println(formatter);
        
        PoemCreater creater = new PoemCreater(formatter);
        
        String[] newPoem = creater.createPoem();
        
        //printPoem(poem);
        
        printPoem(newPoem);
        
        System.out.println(creater.changingWords);
    }
    
    public static void printPoem(String[] poem) {
        for (String line: poem) {
            System.out.println(line);
        }
    }
    
    
    public static String[] getTextFile(String fileName) {
        int amountOfType = 0;

            
            try{

                //Create object of FileReader
                FileReader inputFile = new FileReader(fileName);

                //Instantiate the BufferedReader Class
                BufferedReader bufferReader = new BufferedReader(inputFile);

                //Variable to hold the one line data
                String line;

                // Read file line by line and print on the console
                while ((line = bufferReader.readLine()) != null)   {
                    amountOfType++;
                }
            
                //Close the buffer reader
                bufferReader.close();
            }catch(Exception e){
                System.out.println("Error while reading file line by line:" + e.getMessage());                      
            }
        
        int count = 0;
        String[] words = new String[amountOfType];
        
            
            try{

                //Create object of FileReader
                FileReader inputFile = new FileReader(fileName);

                //Instantiate the BufferedReader Class
                BufferedReader bufferReader = new BufferedReader(inputFile);

                //Variable to hold the one line data
                String line;

                // Read file line by line and print on the console
                while ((line = bufferReader.readLine()) != null)   {
                    words[count++] = line;
                }
            
                //Close the buffer reader
                bufferReader.close();
            }catch(Exception e){
                System.out.println("Error while reading file line by line:" + e.getMessage());                      
            }   
        return words;
    }   
}
