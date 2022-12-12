import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class day_2 {
    /**
     * @param args
     * @throws FileNotFoundException
     */
    
    public static void main(String args[]){
        try{ 
            File file = new File("elves");
            Scanner reader = new Scanner(file);         //
                                                        // Initializes an array list to go thru all the calories within the file
            ArrayList<String> cals = new ArrayList<>(); //
            while(reader.hasNextLine()){                //
                String item = reader.nextLine();        //
                cals.add(item);
            }
            reader.close();
            
            ArrayList<Integer> elves = new ArrayList<>();
            int CurrentElf = 0;
            
            //gets the amount of calories every elf has
            for(String s : cals){
                try{
                    CurrentElf += Integer.parseInt(s);
                }catch(NumberFormatException ex){
                    elves.add(CurrentElf);
                    CurrentElf = 0;
                    continue;
                }
            }
            Collections.sort(elves);
            List<Integer> Top3elves = new ArrayList<Integer>((elves.subList(elves.size()-3,elves.size())));
            System.out.println(Top3elves);
        }catch(FileNotFoundException e) {System.out.println(e);}
    }
} 