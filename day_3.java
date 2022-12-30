import java.util.*;
import java.io.*;
public class day_3 {
    public static int prioritySum(String file){
        Integer sum = 0;
        try{
            Scanner scan = new Scanner(new FileReader(file));
            String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            while(scan.hasNextLine()){
                HashMap<String,String> uniques = new HashMap<>();
                String temp = scan.nextLine().toString();
                String row = ""+temp;
                String left = row.substring(0,row.length()/2);
                String right = row.substring(row.length()/2, row.length());
                for(int i = 0; i < left.length(); i++){
                    for(int j = 0; j < right.length(); j++){
                        if(left.charAt(i) == right.charAt(j)){
                            String temp1 = "" + left.charAt(i);
                            uniques.put(temp1, String.valueOf(alphabet.indexOf(temp1)+1));
                        }
                    }
                }
                for(Map.Entry<String,String> key: uniques.entrySet()){
                    sum += Integer.valueOf(key.getValue());
                }
                uniques.clear();
            }
            scan.close();
        }catch(FileNotFoundException ex){
            System.out.println(ex);
        }
        return sum;
    } 
    public static void main(String[] args) {
        System.out.println(prioritySum("rucksacks"));
    }
    
}
