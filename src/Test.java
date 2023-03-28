import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the dataset: ");
        String[] in = s.nextLine().toLowerCase().split("\\s+");
        double zero = 0;
        HashMap<String, Double> Occurences = new HashMap<>() {{
            put("a", zero);
            put("b", zero);
            put("c", zero);
            put("d", zero);
            put("e", zero);
            put("f", zero);
            put("g", zero);
            put("h", zero);
            put("i", zero);
            put("j", zero);
            put("k", zero);
            put("l", zero);
            put("m", zero);
            put("n", zero);
            put("o", zero);
            put("p", zero);
            put("q", zero);
            put("r", zero);
            put("s", zero);
            put("t", zero);
            put("u", zero);
            put("v", zero);
            put("w", zero);
            put("x", zero);
            put("y", zero);
            put("z", zero);
        }};
        int totalNumofLetters = 0;

        for(String name : in) {
            totalNumofLetters += name.length();
            String[] letters = name.split("");
            for(String letter : letters) {
                Occurences.replace(letter, Occurences.get(letter)+1);
            }
        }

        double avgScorePerLetter = 0;
        for(Map.Entry<String, Double> e : Occurences.entrySet()) {
            Occurences.replace(e.getKey(), e.getValue()/totalNumofLetters);
            // System.out.println(e.getKey()+" "+ e.getValue());
        }
        for(String name : in) {
            avgScorePerLetter += (getScore(Occurences, name) / name.length());
        }
        avgScorePerLetter /= in.length;
        System.out.println("Average score per letter: "+avgScorePerLetter);
        
        // Checker
       while(true) {
        System.out.print("Enter the test name : ");
        String test = s.nextLine();
        double testScore = (getScore(Occurences, test) / test.length());
        System.out.println((avgScorePerLetter*0.70) <= testScore ? "It is a real name." : "It is not a real name.");
        System.out.println("Score : "+testScore);
       }
    }

    public static double getScore(HashMap<String, Double> occ, String in) {
        double res = 0;
        String[] letters = in.toLowerCase().replaceAll("\\s+", "").split("");
        for(String letter : letters) {
            res += occ.get(letter);
        }
        return res;
    }
}
