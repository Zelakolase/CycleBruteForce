public class LimitTest {
    public static void main(String[] args) {
        double x = 2e100 + 1;
        for(int q = 1;q < 9;q += 2) {
            double A = Math.log((x*(q)+1)/(x)) / Utils.log2;
            if(A>=1)System.out.println("There exists "+Math.ceil(A)+" Solutions for "+q);
        }
    }
}
