import java.util.Arrays;

import lib.Clock;

public class Test {
    public static void main(String[] args) {
        Clock c = new lib.Clock(10, 5);
        for(int i = 0;i < 10; i++) {
            c.add();
            System.out.println(Arrays.toString(c.Clock));
        }
    }
}
