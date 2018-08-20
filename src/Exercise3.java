public class Exercise3
{

    public static void main(String[] args)
    {
        Even even = new Even();

        Runnable runnable = () -> {
            for (int x = 0; x < 100000; x++) // Change number of iterations to produce race condition
                if (even.next() % 2 != 0)
                    System.out.println("Race condition");
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();
    }

    private static class Even
    {
        private int n = 0;

        public /*synchronized*/ int next()
        {
            // synchronized (this) {
                n++;
                n++;
                return n;
            // }
        }
    }
}
