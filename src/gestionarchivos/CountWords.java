package gestionarchivos;

// Counts the number of words in Hamlet.
import java.io.*;
import java.util.*;

public class CountWords {

    public static void main(String[] args)
            throws FileNotFoundException {
        Scanner input = null;
        try{
                input = new Scanner(new File("xxx.txt"));
        
            
        int count = 0;
        while (input.hasNext()) {
            String word = input.next();
            count++;
        }
        System.out.println("total words = " + count);
        }catch(FileNotFoundException e){
            System.out.println("No se encuentra el archivo");
        }
    }
}

