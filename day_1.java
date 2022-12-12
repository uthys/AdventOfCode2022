import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class day_1 {
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
            //
            //
            //PART 1
            ArrayList<Integer> elves = new ArrayList<>();
            int CurrentElf = 0;
            int count = 0;
            int max = 0;
            for(String s : cals){
                try{
                    int num = Integer.parseInt(s);
                    count += num;
                    if(count > max) max = count;}
                catch(NumberFormatException ex){count=0; continue;}
            }
            //
            //
            //PART 2
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
            int sum = 0;
            for(int i=elves.size()-3; i < elves.size(); i++){
                sum += elves.get(i);
            }
            System.out.println(sum);
        
        }catch(FileNotFoundException e) {System.out.println(e);}
        
    }
} 