import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.print.PrintException;
public class day_2 {
    /**
     * @param args
     * @throws FileNotFoundException
     */
    
    public static void main(String args[]){
        try{ 
            File file = new File("elves");              //
            Scanner reader = new Scanner(file);         //
                                                        // Initializes an array list to go thru all the calories within the file
            ArrayList<String> cals = new ArrayList<>(); //
            while(reader.hasNextLine()){                //
                String item = reader.nextLine();        //
                cals.add(item);
            }
            reader.close();

            int count = 0;
            int max = 0;
            for(String s : cals){
                try{int num = Integer.parseInt(s);
                    count += num;
                    if(count > max) max = count;}
                catch(NumberFormatException ex){count=0; continue;}
            }
            
            ArrayList<Integer> elves = new ArrayList<>();
            int CurrentElf = 0;
            
            for(String s : cals){
                try{
                    CurrentElf += Integer.parseInt(s);
                }catch(NumberFormatException ex){
                    elves.add(CurrentElf);
                    CurrentElf = 0;
                    continue;
                }
            }
            System.out.println(elves);
        }catch(FileNotFoundException e) {System.out.println(e);}
    }
} 