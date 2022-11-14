public class RunnableWrappers {
    public static class L0 implements Runnable {

        @Override
        public void run() {
            LimitTest.main(new String[] {});
        }

    }
    public static class L1 implements Runnable {

        @Override
        public void run() {
            LimitTestLvl1.main(new String[] {});
        }

    }
    public static class L2 implements Runnable {

        @Override
        public void run() {
            LimitTestLvl2.main(new String[] {});
        }

    }
    public static class L3 implements Runnable {

        @Override
        public void run() {
            LimitTestLvl3.main(new String[] {});
        }

    }
    public static class L4 implements Runnable {

        @Override
        public void run() {
            LimitTestLvl4.main(new String[] {});
        }

    }
    public static class L5 implements Runnable {

        @Override
        public void run() {
            LimitTestLvl5.main(new String[] {});
        }

    }
    public static class L6 implements Runnable {

        @Override
        public void run() {
            LimitTestLvl6.main(new String[] {});
        }

    }
}
