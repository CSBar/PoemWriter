import java.io.*;
public class PoemFormatterTester {
    
    public static void main(String[] args) {
        
        String[] raven = readFile("Poem.txt");
        printShit(raven);
        PoemFormatter formatter = new PoemFormatter(raven);

        System.out.println(formatter);
    }
    
    public static String[] readFile(String fileName) {
        int fileLength = 0;
        
        try{

            //Create object of FileReader
            FileReader inputFile = new FileReader(fileName);

            //Instantiate the BufferedReader Class
            BufferedReader bufferReader = new BufferedReader(inputFile);

            //Variable to hold the one line data
            String line;

            // Read file line by line and print on the console
            while ((line = bufferReader.readLine()) != null)   {
                fileLength++;
            }
            
            //Close the buffer reader
            bufferReader.close();
        }catch(Exception e){
            System.out.println("Error while reading file line by line:" + e.getMessage());                      
        }
        
        fileLength = 10;
        
        String[] r = new String[fileLength];
        
        int count = 0;
        try{

            //Create object of FileReader
            FileReader inputFile = new FileReader(fileName);

            //Instantiate the BufferedReader Class
            BufferedReader bufferReader = new BufferedReader(inputFile);

            //Variable to hold the one line data
            String line;

            // Read file line by line and print on the console
            while ((line = bufferReader.readLine()) != null)   {
                r[count++] = line;
            }
            
            //Close the buffer reader
            bufferReader.close();
        }catch(Exception e){
            System.out.println("Error while reading file line by line:" + e.getMessage());                      
        }
        
        return r;
    }
    
    public static void printShit(String[] poem) {
        for (String line: poem) {
            System.out.println(line);
        }
    }
     
}
