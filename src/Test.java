public class Test {
    public static void main(String[] args) {
        System.out.println("q,x");
        (new Thread() {{LimitTest.main(args);}}).start();
        (new Thread() {{LimitTestLvl1.main(args);}}).start();
        (new Thread() {{LimitTestLvl2.main(args);}}).start();
        (new Thread() {{LimitTestLvl3.main(args);}}).start();
        (new Thread() {{LimitTestLvl4.main(args);}}).start();
        (new Thread() {{LimitTestLvl5.main(args);}}).start();
        (new Thread() {{LimitTestLvl6.main(args);}}).start();
    }
}