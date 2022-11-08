public class Test {
    public static void main(String[] args) {
        for(int h = 1;h < 1_000_000;h++) {
            for(int l = 1;l < 1_000_000;l++) {
                for(int k = 1;k < 1_000_000;k++) {
                    if(h*(Utils.TwoPow(k+l)-Utils.XPow(181, k)) == Utils.TwoPow(l)-1) System.out.println(h+" "+k+" "+l);
                }
            }
        }
    }
}
