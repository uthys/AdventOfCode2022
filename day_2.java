import java.io.*;
import java.util.*;
public class day_2 {
    final static int rock = 1;
    final static int paper = 2;
    final static int scissors = 3;

    final static int lose = 0;
    final static int draw = 3;
    final static int win = 6;

    public static int challengeTwo(String file){
        int rigScore = 0;
        try{
            Scanner scan  = new Scanner(new File(file));
            while(scan.hasNextLine()){
                String[] row = scan.nextLine().strip().split(" ");
                String left = row[0];
                String right = row[1];
                switch(left){
                    case "A":
                        if(Objects.equals(right, "Y")) rigScore += 3+1;
                        else if (Objects.equals(right, "X")) rigScore += 3;
                        else rigScore += 6+2;
                        break;
                    case "B":
                        if(Objects.equals(right, "Z")) rigScore += 6+3;
                        else if (Objects.equals(right, "Y")) rigScore += 3+2;
                        else rigScore += 1;
                        break;
                    
                    case "C":
                        if(Objects.equals(right, "X")) rigScore += 2;
                        else if (Objects.equals(right, "Z")) rigScore += 6+1;
                        else rigScore += 3+3;
                        break;
                    default:
                        break;
                }
            }
            return rigScore;
        }catch(Exception ex){
            System.out.println(ex);
            return 0;
        }
    }



    public static int challengeOne(String file){
        int score = 0;
        try{
            Scanner scan  = new Scanner(new FileReader(file));
            while(scan.hasNextLine()){
                String[] row = scan.nextLine().strip().split(" ");
                String left = row[0];
                String right = row[1];
                if(left.equals("A")){//rock
                    if(right.equals("X")) {score += 3+1;}
                    else if(right.equals("Y")) {score += 6 + 2;}
                    else if(right.equals("Z")) {score += 3;}
                    
                }
                if(left.equals("B")){//paper
                    if(right.equals("X")) {score += 1;  }
                    else if(right.equals("Y")) {score += 3+2;}
                    else if(right.equals("Z")) {score += 6+3;}
                    
                }
                if(left.equals("C")){//scissors
                    if(right.equals("X")){score += 6+1;}
                    else if(right.equals("Y")) {score += 2;}
                    else if(right.equals("Z")) {score += 3+3;}
                }
            }
            return score;
        }catch(Exception ex){
            System.out.println(ex);
            return 0;
        }
    }
    public static void main(String args[]){
        String file = "elves_bets";
        System.out.println("Challenge One: "+challengeOne(file));
        System.out.println("Challenge Two: "+challengeTwo(file));
    }
    
}
