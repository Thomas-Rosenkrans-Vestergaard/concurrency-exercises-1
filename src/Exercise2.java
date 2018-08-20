public class Exercise2
{

    public static void main(String[] args)
    {
        nThreads(5);
    }

    public static void nThreads(int n)
    {

        if (n < 0)
            throw new IllegalArgumentException();

        for (int x = 1; x <= n; x++) {
            Printer printer = new Printer("Thread" + x);
            Thread  thread  = new Thread(printer);
            thread.start();
        }
    }

    static class Printer implements Runnable
    {
        private String identifier;

        public Printer(String identifier)
        {
            this.identifier = identifier;
        }

        @Override public void run()
        {
            for (int x = 1; x <= 100; x++) {
                System.out.println(identifier + ": " + x);
            }
        }
    }
}
